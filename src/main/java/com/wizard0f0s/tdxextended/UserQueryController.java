package com.wizard0f0s.tdxextended;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class UserQueryController {

    @FXML
    public ComboBox isActiveComboBox;
    @FXML
    public ComboBox isConfidentialComboBox;
    @FXML
    public ComboBox isEmployeeComboBox;
    @FXML
    public ComboBox employeeTypeComboBox;
    private ObservableList<String> isActiveList;
    private ObservableList<String> isConfidentialList;
    private ObservableList<String> isEmployeeList;
    private ObservableList<String> employeeTypeList;

    public void initialize() {

        isActiveList = FXCollections.observableArrayList();
        isConfidentialList = FXCollections.observableArrayList();
        isEmployeeList = FXCollections.observableArrayList();
        employeeTypeList = FXCollections.observableArrayList();

        isActiveList.add("N/A");
        isActiveList.add("Active Users");
        isActiveList.add("NOT Active Users");
        isActiveComboBox.setItems(isActiveList);
        isActiveComboBox.getSelectionModel().selectFirst();

        isConfidentialList.add("N/A");
        isConfidentialList.add("Confidential Users");
        isConfidentialList.add("NOT Confidential Users");
        isConfidentialComboBox.setItems(isConfidentialList);
        isConfidentialComboBox.getSelectionModel().selectFirst();

        isEmployeeList.add("N/A");
        isEmployeeList.add("Employees");
        isEmployeeList.add("NON-Employees");
        isEmployeeComboBox.setItems(isEmployeeList);
        isEmployeeComboBox.getSelectionModel().selectFirst();

        employeeTypeList.add("None / All User Types");
        employeeTypeList.add("Standard User");
        employeeTypeList.add("Customer");
        employeeTypeList.add("Resource Placeholder");
        employeeTypeList.add("Service Account");
        employeeTypeComboBox.setItems(employeeTypeList);
        employeeTypeComboBox.getSelectionModel().selectFirst();


    }
}
