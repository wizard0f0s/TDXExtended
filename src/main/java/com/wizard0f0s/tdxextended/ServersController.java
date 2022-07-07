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
    private Button editServerButton;
    @FXML
    private Button deleteServerButton;
    @FXML
    private Button newServerButton;
    @FXML
    private Label responseLabel;
    @FXML
    private Button leftServerButton;
    @FXML
    private Button rightServerButton;
    @FXML
    private Label servOfServLabel;
    private ServerItem currentServer;
    private ServerItem tempServer;

    public void initialize() {
        System.out.println("Server list has " + ServerData.getInstance().getServerList().size() + " objects");
        responseLabel.setVisible(false);
        if (ServerData.getInstance().getServerList().size() == 0) {
            serverNameField.setText("empty list");
            serverAddressField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            isAdminCheckBox.setSelected(false);
            isActiveCheckBox.setSelected(true);

            serverNameField.setDisable(false);
            serverAddressField.setDisable(false);
            usernameField.setDisable(false);
            passwordField.setDisable(false);
            isAdminCheckBox.setDisable(false);
            isActiveCheckBox.setDisable(false);

            editServerButton.setDisable(true);
            deleteServerButton.setDisable(true);
            newServerButton.setText("New Server");
            testServerButton.setDisable(true);
            leftServerButton.setDisable(true);
            rightServerButton.setDisable(true);
            servOfServLabel.setText("0 of " + ServerData.getInstance().getServerList().size() + " Servers");
        } else {
            int index = 0;
            for (ServerItem server : ServerData.getInstance().getServerList()) {
                if (server.isActive()) {
                    index = ServerData.getInstance().getServerList().indexOf(server);
                }
            }
            serverNameField.setText(ServerData.getInstance().getServerList().get(index).getName());
            serverAddressField.setText(ServerData.getInstance().getServerList().get(index).getBaseSite());
            usernameField.setText(ServerData.getInstance().getServerList().get(index).getUsername());
            passwordField.setText(ServerData.getInstance().getServerList().get(index).getPassword());
            isAdminCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isAdmin());
            isActiveCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isActive());
            serverNameField.setDisable(true);
            serverAddressField.setDisable(true);
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            isAdminCheckBox.setDisable(true);
            isActiveCheckBox.setDisable(true);
            if (index == 0) {
                leftServerButton.setDisable(true);
            } else {
                leftServerButton.setDisable(false);
            }
            if (index == ServerData.getInstance().getServerList().size() - 1) {
                rightServerButton.setDisable(true);
            } else {
                rightServerButton.setDisable(false);
            }
            servOfServLabel.setText(index+1 + " of " + ServerData.getInstance().getServerList().size() + " Servers");
        }
    }

    @FXML
    public void handleSaveServer() {
        ServerItem item = new ServerItem(serverNameField.getText(), serverAddressField.getText(), usernameField.getText(), passwordField.getText(), isAdminCheckBox.isSelected(), isActiveCheckBox.isSelected());
        if (tempServer != null) {
            ServerData.getInstance().updateServer(item);
            responseLabel.setText("SUCCESS: Server updated successfully!");
            responseLabel.setVisible(true);
        } else if (!ServerData.getInstance().getServerList().contains(item)) {
            ServerData.getInstance().addServer(item);
            responseLabel.setText("SUCCESS: Server added successfully!");
            responseLabel.setVisible(true);
        } else {
            responseLabel.setText("ERROR: Server update failed!");
            responseLabel.setVisible(true);
        }
        serverNameField.setDisable(true);
        serverAddressField.setDisable(true);
        usernameField.setDisable(true);
        passwordField.setDisable(true);
        isAdminCheckBox.setDisable(true);
        isActiveCheckBox.setDisable(true);
        editServerButton.setText("Edit Server");
        editServerButton.setDisable(false);
        deleteServerButton.setDisable(false);
        newServerButton.setText("New Server");
        testServerButton.setDisable(false);
        newServerButton.setDisable(false);
        int index = ServerData.getInstance().getServerList().indexOf(item);
        if (index == 0) {
            leftServerButton.setDisable(true);
        } else {
            leftServerButton.setDisable(false);
        }
        if (index == ServerData.getInstance().getServerList().size() - 1) {
            rightServerButton.setDisable(true);
        } else {
            rightServerButton.setDisable(false);
        }
        servOfServLabel.setText(index+1 + " of " + ServerData.getInstance().getServerList().size() + " Servers");
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
                    UserTools.Login(connection, currentServer, path, "POST");
                    System.out.println(TDX_Authentication.getInstance().getBearerToken());

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (!TDX_Authentication.getInstance().getBearerToken().isEmpty()) {
                                responseLabel.setText("SERVER CONNECTION SUCCESSFUL!");
                            } else {
                                responseLabel.setText("SERVER CONNECTION FAILED!");
                            }
                        }
                    });
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    responseLabel.setText("SERVER CONNECTION FAILED!");
                }
            }
        };

        responseLabel.setText("Testing login ...");
        responseLabel.setVisible(true);
        new Thread(task).start();
    }

    public void handleEditServer() {
        if (editServerButton.getText().equalsIgnoreCase("Edit Server")) {
            tempServer = new ServerItem(serverNameField.getText(),
                    serverAddressField.getText(),
                    usernameField.getText(),
                    passwordField.getText(),
                    isAdminCheckBox.isSelected(),
                    isActiveCheckBox.isSelected());

            serverNameField.setDisable(false);
            serverAddressField.setDisable(false);
            usernameField.setDisable(false);
            passwordField.setDisable(false);
            isAdminCheckBox.setDisable(false);
            isActiveCheckBox.setDisable(false);

            editServerButton.setText("Cancel Edit");
            editServerButton.setDisable(false);
            deleteServerButton.setDisable(true);
            newServerButton.setText("New Server");
            testServerButton.setDisable(true);
            newServerButton.setDisable(true);

        } else {
            editServerButton.setText("Edit Server");
            serverNameField.setText(tempServer.getName());
            serverAddressField.setText(tempServer.getBaseSite());
            usernameField.setText(tempServer.getUsername());
            passwordField.setText(tempServer.getPassword());
            isAdminCheckBox.setSelected(tempServer.isAdmin());
            isActiveCheckBox.setSelected(tempServer.isActive());

            serverNameField.setDisable(true);
            serverAddressField.setDisable(true);
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            isAdminCheckBox.setDisable(true);
            isActiveCheckBox.setDisable(true);

            editServerButton.setDisable(false);
            deleteServerButton.setDisable(false);
            newServerButton.setText("New Server");
            testServerButton.setDisable(false);
            newServerButton.setDisable(false);

            tempServer = null;
        }
    }

    public void handleNewServer() {
        if (newServerButton.getText().equalsIgnoreCase("New Server")) {
            serverNameField.setText("");
            serverAddressField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            isAdminCheckBox.setSelected(false);
            isActiveCheckBox.setSelected(false);

            serverNameField.setDisable(false);
            serverAddressField.setDisable(false);
            usernameField.setDisable(false);
            passwordField.setDisable(false);
            isAdminCheckBox.setDisable(false);
            isActiveCheckBox.setDisable(false);

            editServerButton.setDisable(true);
            deleteServerButton.setDisable(true);
            newServerButton.setText("Cancel New");
            testServerButton.setDisable(true);
        } else {
            serverNameField.setText(ServerData.getInstance().getServerList().get(0).getName());
            serverAddressField.setText(ServerData.getInstance().getServerList().get(0).getBaseSite());
            usernameField.setText(ServerData.getInstance().getServerList().get(0).getUsername());
            passwordField.setText(ServerData.getInstance().getServerList().get(0).getPassword());
            isAdminCheckBox.setSelected(ServerData.getInstance().getServerList().get(0).isAdmin());
            isActiveCheckBox.setSelected(ServerData.getInstance().getServerList().get(0).isActive());
            serverNameField.setDisable(true);
            serverAddressField.setDisable(true);
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            isAdminCheckBox.setDisable(true);
            isActiveCheckBox.setDisable(true);

            editServerButton.setDisable(false);
            deleteServerButton.setDisable(false);
            newServerButton.setText("New Server");
            testServerButton.setDisable(false);
            leftServerButton.setDisable(true);
            if (ServerData.getInstance().getServerList().size() - 1 == 0) {
                rightServerButton.setDisable(true);
            } else {
                rightServerButton.setDisable(false);
            }
            servOfServLabel.setText("1 of " + ServerData.getInstance().getServerList().size() + " Servers");

        }
    }

    public void handleDeleteServer() {
        ServerItem item = new ServerItem(serverNameField.getText(),
                serverAddressField.getText(),
                usernameField.getText(),
                passwordField.getText(),
                isAdminCheckBox.isSelected(),
                isActiveCheckBox.isSelected());
        int index = ServerData.getInstance().getServerList().indexOf(item);
        if (index > 0) {
            index--;
        }
        ServerData.getInstance().getServerList().remove(item);

        if (ServerData.getInstance().getServerList().size() > 0) {
            serverNameField.setText(ServerData.getInstance().getServerList().get(index).getName());
            serverAddressField.setText(ServerData.getInstance().getServerList().get(index).getBaseSite());
            usernameField.setText(ServerData.getInstance().getServerList().get(index).getUsername());
            passwordField.setText(ServerData.getInstance().getServerList().get(index).getPassword());
            isAdminCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isAdmin());
            isActiveCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isActive());
            serverNameField.setDisable(true);
            serverAddressField.setDisable(true);
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            isAdminCheckBox.setDisable(true);
            isActiveCheckBox.setDisable(true);

            editServerButton.setDisable(false);
            deleteServerButton.setDisable(false);
            newServerButton.setText("New Server");
            testServerButton.setDisable(false);

            if (index == 0) {
                leftServerButton.setDisable(true);
            } else {
                leftServerButton.setDisable(false);
            }
            if (index == ServerData.getInstance().getServerList().size() - 1) {
                rightServerButton.setDisable(true);
            } else {
                rightServerButton.setDisable(false);
            }
            servOfServLabel.setText(index+1 + " of " + ServerData.getInstance().getServerList().size() + " Servers");

        } else {
            serverNameField.setText("empty list");
            serverAddressField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            isAdminCheckBox.setSelected(false);
            isActiveCheckBox.setSelected(true);

            serverNameField.setDisable(false);
            serverAddressField.setDisable(false);
            usernameField.setDisable(false);
            passwordField.setDisable(false);
            isAdminCheckBox.setDisable(false);
            isActiveCheckBox.setDisable(false);

            editServerButton.setDisable(true);
            deleteServerButton.setDisable(true);
            newServerButton.setText("New Server");
            testServerButton.setDisable(true);
        }
    }

    public void handleLeftServerDisplay() {
        ServerItem item = new ServerItem(serverNameField.getText(),
                serverAddressField.getText(),
                usernameField.getText(),
                passwordField.getText(),
                isAdminCheckBox.isSelected(),
                isActiveCheckBox.isSelected());

        int index = ServerData.getInstance().getServerList().indexOf(item);
        if (index > 0) {
            index--;
        }
        System.out.println("index = " + index);
        serverNameField.setText(ServerData.getInstance().getServerList().get(index).getName());
        serverAddressField.setText(ServerData.getInstance().getServerList().get(index).getBaseSite());
        usernameField.setText(ServerData.getInstance().getServerList().get(index).getUsername());
        passwordField.setText(ServerData.getInstance().getServerList().get(index).getPassword());
        isAdminCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isAdmin());
        isActiveCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isActive());

        if (index == 0) {
            leftServerButton.setDisable(true);
        } else {
            leftServerButton.setDisable(false);
        }

        if (index == ServerData.getInstance().getServerList().size() - 1) {
            rightServerButton.setDisable(true);
        } else {
            rightServerButton.setDisable(false);
        }
        servOfServLabel.setText(index+1 + " of " + ServerData.getInstance().getServerList().size() + " Servers");
    }

    public void handleRightServerDisplay() {
        ServerItem item = new ServerItem(serverNameField.getText(),
                serverAddressField.getText(),
                usernameField.getText(),
                passwordField.getText(),
                isAdminCheckBox.isSelected(),
                isActiveCheckBox.isSelected());

        int index = ServerData.getInstance().getServerList().indexOf(item);
        System.out.println("index = " + index);
        if (index < ServerData.getInstance().getServerList().size()-1) {
            index++;
        }
        serverNameField.setText(ServerData.getInstance().getServerList().get(index).getName());
        serverAddressField.setText(ServerData.getInstance().getServerList().get(index).getBaseSite());
        usernameField.setText(ServerData.getInstance().getServerList().get(index).getUsername());
        passwordField.setText(ServerData.getInstance().getServerList().get(index).getPassword());
        isAdminCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isAdmin());
        isActiveCheckBox.setSelected(ServerData.getInstance().getServerList().get(index).isActive());

        if (index == 0) {
            leftServerButton.setDisable(true);
        } else {
            leftServerButton.setDisable(false);
        }

        if (index == ServerData.getInstance().getServerList().size() - 1) {
            rightServerButton.setDisable(true);
        } else {
            rightServerButton.setDisable(false);
        }

        servOfServLabel.setText(index+1 + " of " + ServerData.getInstance().getServerList().size() + " Servers");
    }
}
