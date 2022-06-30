package com.wizard0f0s.tdxextended;

import TeamDynamix.Utils.TDXProcess;
import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.TDXTask;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Comparator;
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
    private Button taskOptionsButton;
    @FXML
    private Label taskStatusLabel;


    public void initialize() {
        // More code to come ...

        taskOptionsButton.setDisable(true);

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
                    SortedList<TDXTask> taskSortedList = new SortedList<>(process.getTasks(),
                            new Comparator<TDXTask>() {
                                @Override
                                public int compare(TDXTask o1, TDXTask o2) {
                                    return Integer.compare(o1.getOrder(), o2.getOrder());
                                }
                            });

                    taskListView.setItems(taskSortedList);
                    taskListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    taskListView.getSelectionModel().selectFirst();
                }
            }
        });

        taskListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TDXTask>() {
            @Override
            public void changed(ObservableValue<? extends TDXTask> observableValue, TDXTask tdxTask, TDXTask t1) {
                if (t1 != null) {
                    TDXTask task = taskListView.getSelectionModel().getSelectedItem();
                    taskDescriptionTextArea.setText(task.getDescription());
                    taskResultsTextArea.setText(task.getStatusDescription());
                    taskStatusLabel.setText(task.getStatus());
                    taskOptionsButton.setDisable(false);
                    taskOptionsButton.setText(task.getButtonLabel());
                }
            }
        });

        SortedList<TDXProcess> processSortedList = new SortedList<>(TDXProcessData.getInstance().getProcessList(),
                new Comparator<TDXProcess>() {
                    @Override
                    public int compare(TDXProcess o1, TDXProcess o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });

        processListView.setItems(processSortedList);
        processListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        processListView.getSelectionModel().selectFirst();
        taskListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        taskListView.getSelectionModel().selectFirst();

        processListView.setCellFactory(new Callback<ListView<TDXProcess>, ListCell<TDXProcess>>() {
            @Override
            public ListCell<TDXProcess> call(ListView<TDXProcess> tdxProcessListView) {
                ListCell<TDXProcess> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(TDXProcess tdxProcess, boolean empty) {
                        super.updateItem(tdxProcess, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(tdxProcess.getName());
                        }
                    }
                };
                return cell;
            }
        });

        taskListView.setCellFactory(new Callback<ListView<TDXTask>, ListCell<TDXTask>>() {
            @Override
            public ListCell<TDXTask> call(ListView<TDXTask> tdxTaskListView) {
                ListCell<TDXTask> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(TDXTask tdxTask, boolean empty) {
                        super.updateItem(tdxTask, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(tdxTask.getOrder() + ": " + tdxTask.getName());
                        }
                    }
                };
                return cell;
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
    public void handleDisplayOptionsButtonPress() {
        taskListView.getSelectionModel().getSelectedItem().displayOptions(mainBorderPane);
    }

    @FXML
    public void handleExecuteButtonPress() {
        taskListView.getSelectionModel().getSelectedItem().execute();
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}