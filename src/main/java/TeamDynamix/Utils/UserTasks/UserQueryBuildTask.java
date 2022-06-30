package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Utils.TDXTask;
import com.wizard0f0s.tdxextended.ServerData;
import com.wizard0f0s.tdxextended.ServerItem;
import com.wizard0f0s.tdxextended.ServersController;
import com.wizard0f0s.tdxextended.UserQueryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class UserQueryBuildTask implements TDXTask {
    private String name;
    private int order;
    private String buttonLabel;
    private String description;
    private boolean status = false;
    private boolean executed = false;
    private String statusDescription = "";
    private boolean isActive;
    private boolean isConfidential;
    private boolean isEmployee;
    private int userType = 0;
    private String queryString = "ERROR";

    public UserQueryBuildTask(int order, String name, String buttonLabel, String description) {
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
        System.out.println("UserQueryBuild: Need to build the execute function.");
    }

    public void loadInputs(boolean isActive, boolean isConfidential, boolean isEmployee, int userType) {
        this.isActive = isActive;
        this.isConfidential = isConfidential;
        this.isEmployee = isEmployee;
        this.userType = userType;
    }

    public String returnOutput() {
        return queryString;
    }

    @Override
    public void displayOptions(BorderPane mainBorderPane) {
        System.out.println("UserQueryBuildTask: Can we display from here?");

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Set User Search Options");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("userQueryView.fxml"));
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
            UserQueryController controller = fxmlLoader.getController();
        }

    }
}
