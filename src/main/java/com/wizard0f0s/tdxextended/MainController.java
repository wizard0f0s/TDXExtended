package com.wizard0f0s.tdxextended;

import TeamDynamix.Utils.TDXProcess;
import TeamDynamix.Utils.TDXTask;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MainController {

    @FXML
    private Label serverLabel;
    @FXML
    private Label accountLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ListView<TDXProcess> processListView;
    private ServerItem selectedServer = new ServerItem();
    @FXML
    private ListView<TDXTask> taskListView;
    @FXML
    private TextArea taskDescriptionTextArea;
    @FXML
    private TextArea taskResultsTextArea;
    @FXML
    private Button executeButton;
    @FXML
    private Label taskStatusLabel;


    public void initialize() {
        // More code to come ...
        if (ServerData.getInstance().getServerList().size() > 0) {
            boolean activeServer = false;
            for (int lcv = 0; lcv < ServerData.getInstance().getServerList().size(); lcv++) {
                if (ServerData.getInstance().getServerList().get(lcv).isActive()) {
                    selectedServer.copy(ServerData.getInstance().getServerList().get(lcv));
                    serverLabel.setText(selectedServer.getBaseSite());
                    accountLabel.setText(selectedServer.getUsername());
                    activeServer = true;
                }
            }
            if (!activeServer) {
                serverLabel.setText("No server selected!");
                accountLabel.setText("");
            }
        } else {
            serverLabel.setText("No server selected!");
            accountLabel.setText("");
        }

        //implement the listener for the second taskview

        processListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TDXProcess>() {
            @Override
            public void changed(ObservableValue<? extends TDXProcess> observableValue, TDXProcess tdxProcess, TDXProcess t1) {
                if (t1 != null) {
                    TDXProcess process = processListView.getSelectionModel().getSelectedItem();
                    // implement loading the second taskview
                }
            }
        });

    }

    @FXML
    public void showNewServerDialog() {
        //Add server dialog code here
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add and Select a Server");
        dialog.setHeaderText("Add or select a server connection.");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("serversView.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
//        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            ServersController controller = fxmlLoader.getController();
            if (ServerData.getInstance().getServerList().size() > 0) {
                boolean activeServer = false;
                for (ServerItem server : ServerData.getInstance().getServerList()) {
                    if (server.isActive()) {
                        selectedServer.copy(server);
                        activeServer = true;
                        serverLabel.setText(selectedServer.getBaseSite());
                        accountLabel.setText(selectedServer.getUsername());
                    }
                }
                if (!activeServer) {
                    serverLabel.setText("No server selected!");
                    accountLabel.setText("");
                }
            } else {
                serverLabel.setText("No server selected!");
                accountLabel.setText("");
            }
//            ServerItem newItem = controller.processResults();
//            todoListView.getSelectionModel().select(newItem);
        }

    }

    @FXML
    public void handleKeyPress(KeyEvent keyEvent) {

    }

    @FXML
    public void bulkAssignUserGroups() {
        //Bulk Assign Users to Groups here
        // 1) Login with the set server account
        // 2) Display and build the User Query options
        // 3) Get and display the list of users
        // 4) Display and build the Group Search query
        // 5) Get and display the list of groups
        // 6) Display and build the Bulk Management Options
        // 7) Run the User Group Bulk Management Operation
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}