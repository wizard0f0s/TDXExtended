package com.wizard0f0s.tdxextended;

import TeamDynamix.Utils.TDX_Authentication;
import TeamDynamix.Utils.UserTools;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

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
    @FXML
    private Button testServerButton;
    @FXML
    private Button saveServerButton;
    @FXML
    private Label saveServerErrorLabel;
    @FXML
    private Label testServerLabel;
    private ServerItem currentServer;

    private TDX_Authentication tdxAuth;

    public void initialize() {
        System.out.println("Server list has " + ServerData.getInstance().getServerList().size() + " objects");
        testServerLabel.setVisible(false);
        saveServerErrorLabel.setVisible(false);
        if (ServerData.getInstance().getServerList().size() == 0) {
            serverNameField.setText("empty list");
            serverAddressField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            isAdminCheckBox.setSelected(false);
            isActiveCheckBox.setSelected(true);
        } else {
            serverNameField.setText(ServerData.getInstance().getServerList().get(0).getName());
            serverAddressField.setText(ServerData.getInstance().getServerList().get(0).getBaseSite());
            usernameField.setText(ServerData.getInstance().getServerList().get(0).getUsername());
            passwordField.setText(ServerData.getInstance().getServerList().get(0).getPassword());
            isAdminCheckBox.setSelected(ServerData.getInstance().getServerList().get(0).isAdmin());
            isActiveCheckBox.setSelected(ServerData.getInstance().getServerList().get(0).isActive());
        }
    }

    @FXML
    public void handleSaveServer() {
        ServerItem item = new ServerItem(serverNameField.getText(), serverAddressField.getText(), usernameField.getText(), passwordField.getText(), isAdminCheckBox.isSelected(), isActiveCheckBox.isSelected());
        if (!ServerData.getInstance().getServerList().contains(item)) {
            ServerData.getInstance().addServer(item);
            saveServerErrorLabel.setText("SUCCESS: Server added successfully!");
            saveServerErrorLabel.setVisible(true);
        } else {
            saveServerErrorLabel.setText("ERROR: Server already exists in list!");
            saveServerErrorLabel.setVisible(true);
        }
    }

    @FXML
    public void handleTestServer() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                //will want to move the declaration of tdxAuth to an object so it can be referenced later
                try {
                    currentServer = new ServerItem(serverNameField.getText(), serverAddressField.getText(), usernameField.getText(), passwordField.getText(), isAdminCheckBox.isSelected(), isActiveCheckBox.isSelected());
                    URL url = new URL(currentServer.getBaseSite());
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    String path;
                    if (currentServer.isAdmin()) {
                        path = "api/auth/loginadmin";
                    } else {
                        path = "api/auth/login";
                    }
                    tdxAuth = UserTools.Login(connection, currentServer, path, "POST");

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (!tdxAuth.getBearerToken().isEmpty()) {
                                testServerLabel.setText("SERVER CONNECTION SUCCESSFUL!");
                            } else {
                                testServerLabel.setText("SERVER CONNECTION FAILED!");
                            }
                        }
                    });
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        };

        testServerLabel.setText("Testing login ...");
        testServerLabel.setVisible(true);
        new Thread(task).start();
    }
}
