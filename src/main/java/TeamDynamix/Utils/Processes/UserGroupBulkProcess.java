package TeamDynamix.Utils.Processes;

import TeamDynamix.Utils.TDXProcess;
import com.wizard0f0s.tdxextended.GetGroupListController;
import com.wizard0f0s.tdxextended.UserGroupBulkValidateController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class UserGroupBulkProcess extends TDXProcess {

    private boolean validated = false;


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
    }

}
