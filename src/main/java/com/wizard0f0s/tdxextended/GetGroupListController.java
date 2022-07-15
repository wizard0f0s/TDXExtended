package com.wizard0f0s.tdxextended;

import TeamDynamix.Api.Users.Group;
import TeamDynamix.Api.Users.GroupSearch;
import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.UserTasks.GetGroupListTask;
import TeamDynamix.Utils.UserTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static TeamDynamix.Utils.UserTools.autoResizeColumns;

/**
 * JavaFX Controller
 */
public class GetGroupListController {

    @FXML
    public Label numFoundLabel;
    @FXML
    public TableView<Group> groupTableView;
    public Label tablePlaceHolder = new Label();


    public void initialize() {
        TableColumn<Group, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Group, String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Group, String> column3 = new TableColumn<>("Description");
        column3.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Group, String> column4 = new TableColumn<>("Is Active?");
        column4.setCellValueFactory(new PropertyValueFactory<>("active"));

        TableColumn<Group, String> column5 = new TableColumn<>("Created Date");
        column5.setCellValueFactory(new PropertyValueFactory<>("createdDate"));

        TableColumn<Group, String> column6 = new TableColumn<>("Modified Date");
        column6.setCellValueFactory(new PropertyValueFactory<>("modifiedDate"));

        tablePlaceHolder.setText("Searching for groups ...");
        groupTableView.setPlaceholder(tablePlaceHolder);

        groupTableView.getColumns().add(column1);
        groupTableView.getColumns().add(column2);
        groupTableView.getColumns().add(column4);
        groupTableView.getColumns().add(column5);
        groupTableView.getColumns().add(column6);
        groupTableView.getColumns().add(column3);

        groupTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ServerItem currentServer = ServerData.getInstance().getActiveServer();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(currentServer.getBaseSite());
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    String path;
                    if (currentServer.isAdmin()) {
                        path = "api/auth/loginadmin";
                    } else {
                        path = "api/auth/login";
                    }
                    UserTools.Login(connection, currentServer, path, "POST");

                    GroupSearch groupQuery = (GroupSearch) TDXProcessData.getInstance().getCurrentProcess().getTaskOutputs().get("GroupSearchQueryBuild");

                    url = new URL(currentServer.getBaseSite() + "api/groups/search");
                    connection = UserTools.BuildConnection(url, "POST");

                    try {
                        List<Group> groupList = UserTools.getGroupList(connection, groupQuery);
                        if (groupList != null) {
                            System.out.println("Found " + groupList.size() + " groups!");
                            ((GetGroupListTask) (TDXProcessData.getInstance().getCurrentProcess().getCurrentTask())).setGroupList(FXCollections.observableList(groupList));
                        } else {
                            System.out.println("Group list is null!");
                        }
                    } catch (JsonProcessingException jpe) {
                        System.out.println("JsonProcessing Exception: \n");
                        jpe.printStackTrace();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            List<Group> groupList = ((GetGroupListTask) TDXProcessData.getInstance().getCurrentProcess().getCurrentTask()).getGroupList();

                            numFoundLabel.setText(String.valueOf(groupList.size()));
                            if (groupList.size() == 0) {
                                tablePlaceHolder.setText("No groups found!");
                                groupTableView.setPlaceholder(tablePlaceHolder);
                            } else {
                                for (Group group : groupList) {
                                    groupTableView.getItems().add(group);
                                }

                            }
                            autoResizeColumns(groupTableView);

                        }
                    });
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        };

        new Thread(task).start();
    }
}
