package com.wizard0f0s.tdxextended;

import TeamDynamix.Api.Users.UserListing;
import TeamDynamix.Utils.TDXProcess;
import TeamDynamix.Utils.TDXProcessData;
import TeamDynamix.Utils.TDX_Authentication;
import TeamDynamix.Utils.UserTasks.GetUserListTask;
import TeamDynamix.Utils.UserTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.TableViewSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.text.Text;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static TeamDynamix.Utils.UserTools.autoResizeColumns;

public class GetUserListController {


    @FXML
    public Label numFoundLabel;
    @FXML
    public TableView<UserListing> accountTableView;
    public Label tablePlaceHolder = new Label();


    public void initialize() {

        TableColumn<UserListing, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<UserListing, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<UserListing, String> column3 = new TableColumn<>("Primary Email");
        column3.setCellValueFactory(new PropertyValueFactory<>("primaryEmail"));

        TableColumn<UserListing, String> column4 = new TableColumn<>("Username");
        column4.setCellValueFactory(new PropertyValueFactory<>("userName"));

        TableColumn<UserListing, String> column5 = new TableColumn<>("Employee");
        column5.setCellValueFactory(new PropertyValueFactory<>("employee"));

        TableColumn<UserListing, String> column6 = new TableColumn<>("Active Account");
        column6.setCellValueFactory(new PropertyValueFactory<>("active"));

        TableColumn<UserListing, String> column7 = new TableColumn<>("Confidential");
        column7.setCellValueFactory(new PropertyValueFactory<>("confidential"));

        TableColumn<UserListing, String> column8 = new TableColumn<>("Account Type");
        column8.setCellValueFactory(new PropertyValueFactory<>("typeID"));

        tablePlaceHolder.setText("Searching for accounts ...");
        accountTableView.setPlaceholder(tablePlaceHolder);

        accountTableView.getColumns().add(column1);
        accountTableView.getColumns().add(column2);
        accountTableView.getColumns().add(column3);
        accountTableView.getColumns().add(column4);
        accountTableView.getColumns().add(column5);
        accountTableView.getColumns().add(column6);
        accountTableView.getColumns().add(column7);
        accountTableView.getColumns().add(column8);

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
                    System.out.println(TDX_Authentication.getInstance().getBearerToken());

                    String queryString = (String) TDXProcessData.getInstance().getCurrentProcess().getTaskOutputs().get("UserQueryBuild");
                    System.out.println(queryString);

                    url = new URL(currentServer.getBaseSite() + "api/people/userlist?" + queryString);
                    connection = UserTools.BuildConnection(url, "GET");
//                    userList = new ObservableList<UserListing>();

                    try {
                        List<UserListing> userList = UserTools.getUserList(connection);
                        if (userList != null) {
                            System.out.println("Found " + userList.size() + " users!");
                            ((GetUserListTask) (TDXProcessData.getInstance().getCurrentProcess().getCurrentTask())).setUserList(FXCollections.observableList(userList));
                        } else {
                            System.out.println("Userlist is null!");
                        }
                    } catch (JsonProcessingException jpe) {
                        System.out.println("JsonProcessing Exception: \n");
                        jpe.printStackTrace();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            List<UserListing> userList = ((GetUserListTask) TDXProcessData.getInstance().getCurrentProcess().getCurrentTask()).getUserList();

                            numFoundLabel.setText(String.valueOf(userList.size()));
                            if (userList.size() == 0) {
                                tablePlaceHolder.setText("No accounts found!");
                                accountTableView.setPlaceholder(tablePlaceHolder);
                            } else {
                                for (UserListing user : userList) {
                                    accountTableView.getItems().add(user);
                                }

                            }
                            autoResizeColumns(accountTableView);

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
