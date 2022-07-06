package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Utils.QueryStrings;
import TeamDynamix.Utils.TDXProcessData;
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

    @Override
    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Active Users: " + isActive + "\n");
        sb.append("Confidential Users: " + isConfidential + "\n");
        sb.append("Employees: " + isEmployee + "\n");
        sb.append("User type: ");

        switch (userType) {
            case 0 :
                sb.append("None / All User Types\n");
                break;
            case 1 :
                sb.append("Standard User\n");
                break;
            case 2 :
                sb.append("Customer\n");
                break;
            case 8 :
                sb.append("Resource Placeholder\n");
                break;
            case 9 :
                sb.append("Service Account\n");
                break;
        }
        sb.append("\n");

        return sb.toString();
    }

    public String returnOutput() {
        return queryString;
    }

    @Override
    public void displayOptions(BorderPane mainBorderPane) {

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
            String isActive = "";
            String isConfidential = "";
            String isEmployee = "";
            int userType = 0;

            switch (controller.isActiveComboBox.getValue().toString()) {
                case "Active Users" :
                    isActive = "true";
                    this.isActive = true;
                    break;
                case "NOT Active Users" :
                    isActive = "false";
                    this.isActive = false;
                    break;
                default :
                    break;
            }

            switch (controller.isConfidentialComboBox.getValue().toString()) {
                case "Confidential Users" :
                    isConfidential = "true";
                    this.isConfidential = true;
                    break;
                case "NOT Confidential Users" :
                    isConfidential = "false";
                    this.isConfidential = false;
                    break;
                default :
                    break;
            }

            switch (controller.isEmployeeComboBox.getValue().toString()) {
                case "Employees" :
                    isEmployee = "true";
                    this.isEmployee = true;
                    break;
                case "NON-Employees" :
                    isEmployee = "false";
                    this.isEmployee = false;
                    break;
                default :
                    break;
            }

            switch (controller.employeeTypeComboBox.getValue().toString()) {
                case "None / All User Types" :
                    userType = 0;
                    this.userType = 0;
                    break;
                case "Standard User" :
                    userType = 1;
                    this.userType = 1;
                    break;
                case "Customer" :
                    userType = 2;
                    this.userType = 2;
                    break;
                case "Resource Placeholder" :
                    userType = 8;
                    this.userType = 8;
                    break;
                case "Service Account" :
                    userType = 9;
                    this.userType = 9;
                    break;
                default :
                    break;
            }

            String userQuery = QueryStrings.BuildUserListQuery(isActive, isConfidential, isEmployee, userType);

            TDXProcessData.getInstance().getCurrentProcess().saveTaskOutput("UserQueryBuild", userQuery);
            executed = true;
            status = true;

        }

    }
}
