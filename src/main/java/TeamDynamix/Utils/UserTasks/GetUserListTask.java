package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Api.Users.UserListing;
import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.TDXTask;
import TeamDynamix.Utils.TDX_Authentication;
import TeamDynamix.Utils.UserTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wizard0f0s.tdxextended.GetUserListController;
import com.wizard0f0s.tdxextended.ServerData;
import com.wizard0f0s.tdxextended.ServerItem;
import com.wizard0f0s.tdxextended.UserQueryController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static TeamDynamix.Utils.UserTools.getUserList;

public class GetUserListTask implements TDXTask {

    private String name;
    private int order;
    private String buttonLabel;
    private String description;
    private boolean status = false;
    private boolean executed = false;
    private String statusDescription = "";
    private TDX_Authentication tdxAuth;
    private HttpURLConnection connection;
    private String baseSite;
    private String apiPath;
    private String method;
    private ObservableList<UserListing> userList;

    public GetUserListTask(int order, String name, String buttonLabel, String description) {
        this.order = order;
        this.name = name;
        this.buttonLabel = buttonLabel;
        this.description = description;
        userList = FXCollections.observableArrayList();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getButtonLabel() {
        return buttonLabel;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getStatus() {
        if (executed && status) {
            return "SUCCESS";
        } else if (executed && !status) {
            return "ERROR";
        } else {
            return "NOT ATTEMPTED";
        }
    }

    @Override
    public String getStatusDescription() {
        return statusDescription;
    }

    public List<UserListing> getUserList() {
        return userList;
    }

    public void setUserList(List<UserListing> userList) {
        this.userList = FXCollections.observableList(userList);
    }

    @Override
    public void execute() {

        ServerItem currentServer = ServerData.getInstance().getActiveServer();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(currentServer.getBaseSite());
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    String path;
                    if (currentServer.isAdmin()) {
                        path = "api/auth/loginadmin";
                    } else {
                        path = "api/auth/login";
                    }
                    UserTools.Login(connection, currentServer, path, "POST");
                    System.out.println(TDX_Authentication.getInstance().getBearerToken());

                    String queryString = (String) TDXProcessData.getInstance().getCurrentProcess().getTaskOutputs().get(0);

                    url = new URL(currentServer.getBaseSite() + "api/people/userlist?" + queryString);
                    connection = UserTools.BuildConnection(url, "GET");
//                    userList = new ObservableList<UserListing>();

                    try {
                        userList = FXCollections.observableList(UserTools.getUserList(connection));
                        if (userList != null) {
                            System.out.println("Found " + userList.size() + " users!");
                        } else {
                            System.out.println("Userlist is null!");
                        }
                    } catch (JsonProcessingException jpe) {
                        System.out.println("JsonProcessing Exception: \n");
                        jpe.printStackTrace();
                    }

//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            if (!TDX_Authentication.getInstance().getBearerToken().isEmpty()) {
//                                responseLabel.setText("SERVER CONNECTION SUCCESSFUL!");
//                            } else {
//                                responseLabel.setText("SERVER CONNECTION FAILED!");
//                            }
//                        }
//                    });
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        };

        new Thread(task).start();

        executed = true;
        System.out.println("GetUserList: Need to build the execute function.");
    }

    public void loadInputs(TDX_Authentication tdxAuth, HttpURLConnection connection, String baseSite, String apiPath, String method) {
        this.tdxAuth = tdxAuth;
        this.connection = connection;
        this.baseSite = baseSite;
        this.apiPath = apiPath;
        this.method = method;
    }

    @Override
    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(userList.size() + " users found.");

        sb.append("\n");

        return sb.toString();
    }


    public List<UserListing> returnOutput() {
        return userList;
    }

    @Override
    public void displayOptions(BorderPane mainBorderPane) {
        System.out.println("GetUserListTask: Can we display from here?");

        //execute the search here first as a threaded object
//        execute();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Search Results / Select Users");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("getUserListView.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            GetUserListController controller = fxmlLoader.getController();

            TDXProcessData.getInstance().getCurrentProcess().saveTaskOutput("GetUserList", userList);

            status = true;
            executed = true;
        }

    }

}
