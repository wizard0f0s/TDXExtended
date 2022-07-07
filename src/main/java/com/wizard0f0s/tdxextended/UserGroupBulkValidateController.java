package com.wizard0f0s.tdxextended;

import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.TDXTask;
import TeamDynamix.Utils.UserTasks.GetUserListTask;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;

public class UserGroupBulkValidateController {

    @FXML
    private TextArea userSearchTextArea;
    @FXML
    private TextArea groupSearchTextArea;
    @FXML
    public ToggleButton removeGroupsToggleButton;

    public void initialize() {
        TDXTask userSearch = null;
        TDXTask groupSearch = null;

        for (TDXTask task : TDXProcessData.getInstance().getCurrentProcess().getTasks()) {
            if (task.getName().equalsIgnoreCase("UserSearch")) {
                userSearch = task;
            }
            if (task.getName().equalsIgnoreCase("GroupSearch")) {
                groupSearch = task;
            }
        }

        if (userSearch != null) {
            userSearchTextArea.setText(userSearch.getResultString());
        }

        if (groupSearch != null) {
            groupSearchTextArea.setText(groupSearch.getResultString());
        }

        removeGroupsToggleButton.selectedProperty().addListener((((observableValue, oldValue, newValue) -> {
            String newText = "";
            if (newValue) {
                newText = "Selected - Remove Current Groups";
            } else {
                newText = "Unselected - KEEP Current Groups";
            }
            removeGroupsToggleButton.setText(newText);
        })));

    }

}
