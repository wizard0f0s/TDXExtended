package com.wizard0f0s.tdxextended;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ServersController {

    @FXML
    private TextField serverNameField;
    @FXML
    private TextField serverAddressField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private CheckBox isAdminCheckBox;
    @FXML
    private CheckBox isActiveCheckBox;

    public void initialize() {
        System.out.println("Server list has " + ServerData.getInstance().getServerList().size() + " objects");
        if (ServerData.getInstance().getServerList().size() == 0) {
            serverNameField.setText("empty list");
            serverAddressField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            isAdminCheckBox.setSelected(false);
            isActiveCheckBox.setSelected(true);
        }
    }
}
