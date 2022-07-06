package com.wizard0f0s.tdxextended;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GroupSearchQueryController {

    @FXML
    public ComboBox isActiveComboBox;
    @FXML
    public TextField nameLikeTextField;
    @FXML
    public TextField hasAppIDTextField;
    @FXML
    public TextField hasSystemAppNameTextField;
    @FXML
    public TextField associatedAppIDTextField;
    private ObservableList<String> isActiveList;


    public void initialize() {
        isActiveList = FXCollections.observableArrayList();

        isActiveList.add("Active Groups");
        isActiveList.add("NOT Active Groups");
        isActiveComboBox.setItems(isActiveList);

        hasAppIDTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    hasAppIDTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        associatedAppIDTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    associatedAppIDTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }
}
