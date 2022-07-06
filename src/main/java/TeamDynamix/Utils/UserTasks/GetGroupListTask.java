package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Api.Users.Group;
import TeamDynamix.Api.Users.GroupSearch;
import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.TDXTask;
import TeamDynamix.Utils.TDX_Authentication;
import com.wizard0f0s.tdxextended.GetGroupListController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetGroupListTask implements TDXTask {

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
    private GroupSearch searchQuery;
    private ObservableList<Group> groupList;

    public GetGroupListTask(int order, String name, String buttonLabel, String description) {
        this.order = order;
        this.name = name;
        this.buttonLabel = buttonLabel;
        this.description = description;
        groupList = FXCollections.observableArrayList();
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
    public void execute() {
        //implement execute here

    }

    @Override
    public String getStatusDescription() {
        return statusDescription;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = FXCollections.observableList(groupList);
    }

    public void loadInputs(TDX_Authentication tdxAuth, HttpURLConnection connection, String baseSite, String apiPath, String method, GroupSearch searchQuery) {
        this.tdxAuth = tdxAuth;
        this.connection = connection;
        this.baseSite = baseSite;
        this.apiPath = apiPath;
        this.method = method;
        this.searchQuery = searchQuery;
    }

    @Override
    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(groupList.size() + " groups selected:\n\n");

        for (Group group : groupList) {
            sb.append("\t" + group.getId() + " : " + group.getName() + "\n");
        }
        sb.append("\n");

        return sb.toString();
    }


    @Override
    public void displayOptions(BorderPane mainBorderPane) {

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Search Results / Select Groups");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("getGroupListView.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            GetGroupListController controller = fxmlLoader.getController();

            List<Group> groupList = new ArrayList<>(controller.groupTableView.getSelectionModel().getSelectedItems());

            for (Group group : groupList) {
                System.out.println(group.getId() + " " + group.getName());
            }

            this.groupList = FXCollections.observableList(groupList);

            TDXProcessData.getInstance().getCurrentProcess().saveTaskOutput("GetGroupList", groupList);

            if (groupList.size() > 0) {
                status = true;
            } else {
                status = false;
            }

            executed = true;
        }

    }

}

