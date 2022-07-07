package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Api.Users.GroupSearch;
import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.TDXTask;
import com.wizard0f0s.tdxextended.GroupSearchQueryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class GroupSearchQueryBuildTask implements TDXTask {

    private String name;
    private int order;
    private String buttonLabel;
    private String description;
    private boolean status = false;
    private boolean executed = false;
    private String statusDescription = "";
    private boolean isActive;
    private String nameLike;
    private int hasAppID;
    private String hasSystemAppName;
    private int associatedAppID;
    private String queryString = "ERROR";
    private static final String GROUP_QUERY_HASH_KEY = "GroupSearchQueryBuild";


    public GroupSearchQueryBuildTask(int order, String name, String buttonLabel, String description) {
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
    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Active Groups: " + isActive + "\n");
        sb.append("Name Like: " + nameLike + "\n");
        sb.append("Has App ID: " + hasAppID + "\n");
        sb.append("Has System App Name: " + hasSystemAppName + "\n");
        sb.append("Associated App ID: " + associatedAppID + "\n");

        sb.append("\n");

        return sb.toString();
    }

        @Override
    public void execute() {
        //implement execution code here

    }

    @Override
    public String getStatusDescription() {
        return statusDescription;
    }

    public void loadInputs(boolean isActive, String nameLike, int hasAppID, String hasSystemAppName, int associatedAppID) {
        this.isActive = isActive;
        this.nameLike = nameLike;
        this.hasAppID = hasAppID;
        this.hasSystemAppName = hasSystemAppName;
        this.associatedAppID = associatedAppID;
    }

    @Override
    public void displayOptions(BorderPane mainBorderPane) {
        //implement display of the options here

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Set User Search Options");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("groupSearchQueryView.fxml"));
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
            GroupSearchQueryController controller = fxmlLoader.getController();

            switch (controller.isActiveComboBox.getValue().toString()) {
                case "Active Groups":
                    isActive = true;
                    break;
                case "NOT Active Groups":
                    isActive = false;
                    break;
                default:
                    break;
            }

            nameLike = controller.nameLikeTextField.getText();
            if (controller.hasAppIDTextField.getText().length() > 0) {
                hasAppID = Integer.parseInt(controller.hasAppIDTextField.getText());
            } else {
                hasAppID = 0;
            }
            hasSystemAppName = controller.hasSystemAppNameTextField.getText();
            if (controller.associatedAppIDTextField.getText().length() > 0) {
                associatedAppID = Integer.parseInt(controller.associatedAppIDTextField.getText());
            } else {
                associatedAppID = 0;
            }

            GroupSearch groupSearchQuery = new GroupSearch();
            groupSearchQuery.setActive(isActive);
            groupSearchQuery.setNameLike(nameLike);
            groupSearchQuery.setHasAppId(hasAppID);
            groupSearchQuery.setHasSystemAppName(hasSystemAppName);
            groupSearchQuery.setAssociatedAppId(associatedAppID);

            TDXProcessData.getInstance().getCurrentProcess().saveTaskOutput(GROUP_QUERY_HASH_KEY, groupSearchQuery);
            executed = true;
            status = true;

        } else {
            status = false;
            executed = false;
        }
    }
}
