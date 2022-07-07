package TeamDynamix.Utils.Processes;

import TeamDynamix.Api.Users.Group;
import TeamDynamix.Api.Users.UserGroupsBulkManagement;
import TeamDynamix.Api.Users.UserListing;
import TeamDynamix.Utils.TDXProcess;
import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.UserTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wizard0f0s.tdxextended.ServerData;
import com.wizard0f0s.tdxextended.ServerItem;
import com.wizard0f0s.tdxextended.UserGroupBulkValidateController;
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

public class UserGroupBulkProcess extends TDXProcess {

    private boolean validated = false;
    private boolean removeCurrentGroups = false;
    private static final String USER_QUERY_HASH_KEY = "UserQueryBuild";
    private static final String GET_USER_LIST_HASH_KEY = "GetUserList";
    private static final String GROUP_QUERY_HASH_KEY = "GroupSearchQueryBuild";
    private static final String GET_GROUP_LIST_HASH_KEY = "GetGroupList";


    public UserGroupBulkProcess(String name, String description) {
        super(name, description);
    }

    @Override
    public void saveTaskOutput(String key, Object obj) {
        super.getTaskOutputs().put(key, obj);
    }

    @Override
    public Object processTask(int taskIndex) {

        //potential future use
        switch (taskIndex) {
            case 0:
                //nothing to do here
                break;
            case 1:
                // pass in the query string from step 1 (index 0)
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return null;
    }

    @Override
    public void validateInput(BorderPane mainBorderPane) {
        //validate the saved process options

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Validate Options");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("userGroupBulkValidateView.fxml"));
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
            UserGroupBulkValidateController controller = fxmlLoader.getController();
            if (controller.removeGroupsToggleButton.isSelected()) {
                removeCurrentGroups = true;
            } else {
                removeCurrentGroups = false;
            }
            validated = true;

        } else {
            validated = false;
        }

    }

    @Override
    public boolean getValidated() {
        return validated;
    }

    @Override
    public void execute() {

        //implement the final execution of the process here
        System.out.println("Selected Users: " + ((List<UserListing>) super.getTaskOutputs().get(GET_USER_LIST_HASH_KEY)).size() + " accounts.");
        System.out.println("Selected Groups: " + ((List<Group>) super.getTaskOutputs().get(GET_GROUP_LIST_HASH_KEY)).size() + " groups.");
        System.out.println("Remove current groups = " + removeCurrentGroups);

        try {
            ServerItem currentServer = ServerData.getInstance().getActiveServer();

            URL url = new URL(currentServer.getBaseSite());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String path;
            if (currentServer.isAdmin()) {
                path = "api/auth/loginadmin";
            } else {
                path = "api/auth/login";
            }
            UserTools.Login(connection, currentServer, path, "POST");

            List<String> userGUIDs = new ArrayList<>();
            List<Integer> groupIDs = new ArrayList<>();

            for (UserListing user : (List<UserListing>) TDXProcessData.getInstance().getCurrentProcess().getTaskOutputs().get(GET_USER_LIST_HASH_KEY)) {
                userGUIDs.add(user.getUid());
            }

            for (Group group : (List<Group>) TDXProcessData.getInstance().getCurrentProcess().getTaskOutputs().get(GET_GROUP_LIST_HASH_KEY)) {
                groupIDs.add(group.getId());
            }

            System.out.println("userGUIDs: " + userGUIDs.size());
            System.out.println("groupIDs: " + groupIDs.size());

            UserGroupsBulkManagement userGroupsBulkManagementParams = new UserGroupsBulkManagement();
            userGroupsBulkManagementParams.setUserUIDs(userGUIDs);
            userGroupsBulkManagementParams.setGroupIDs(groupIDs);
            userGroupsBulkManagementParams.setRemoveOtherGroups(removeCurrentGroups);

            url = new URL(currentServer.getBaseSite() + "api/people/bulk/managegroups");
            connection = UserTools.BuildConnection(url, "POST");

            try {
                boolean status = UserTools.setBulkGroups(connection, userGroupsBulkManagementParams);
                if (status) {
                    System.out.println("Success!");
                } else {
                    System.out.println("Failure!");
                }
            } catch (JsonProcessingException jpe) {
                System.out.println("JsonProcessing Exception: \n");
                jpe.printStackTrace();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
