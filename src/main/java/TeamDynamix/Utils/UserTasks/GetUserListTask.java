package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Api.Users.UserListing;
import TeamDynamix.Utils.TDXTask;
import TeamDynamix.Utils.TDX_Authentication;
import com.wizard0f0s.tdxextended.GetUserListController;
import com.wizard0f0s.tdxextended.UserQueryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;

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
    private List<UserListing> userList;

    public GetUserListTask(int order, String name, String buttonLabel, String description) {
        this.order = order;
        this.name = name;
        this.buttonLabel = buttonLabel;
        this.description = description;
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

    @Override
    public void execute() {
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

    public List<UserListing> returnOutput() {
        return userList;
    }

    @Override
    public void displayOptions(BorderPane mainBorderPane) {
        System.out.println("GetUserListTask: Can we display from here?");

        //execute the search here first as a threaded object

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
        }

    }

}
