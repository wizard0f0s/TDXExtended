package com.wizard0f0s.tdxextended;

import TeamDynamix.Utils.TDXProcessData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("TeamDynamix Extender");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        try {
            ServerData.getInstance().saveServers();
            TDXProcessData.getInstance().saveProcesses();
            super.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {
        try {
            ServerData.getInstance().loadServers();
            TDXProcessData.getInstance().loadProcesses();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}