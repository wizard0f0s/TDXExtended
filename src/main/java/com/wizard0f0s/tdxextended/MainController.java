package com.wizard0f0s.tdxextended;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class MainController {

    @FXML
    private Label serverLabel;
    @FXML
    private Label accountLabel;
    @FXML
    private BorderPane mainBorderPane;


    public void initialize() {
        // More code to come ...
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
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            ServersController controller = fxmlLoader.getController();
//            ServerItem newItem = controller.processResults();
//            todoListView.getSelectionModel().select(newItem);
        }

    }

    @FXML
    public void bulkAssignUsersToGroups() {
        //Bulk Assign Users to Groups here
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}