package com.wizard0f0s.tdxextended;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ServerData {

    private static ServerData instance = new ServerData();
    private ObservableList<ServerItem> serverList;
    private String filename = "serverList.txt";

    private ServerData() {
        //implement constructor here if needed
    }

    public static ServerData getInstance() {
        return instance;
    }

    public ObservableList<ServerItem> getServerList() {
        return serverList;
    }

    public void addServer(ServerItem server) {
        serverList.add(server);
    }

    public void removeServer(ServerItem server) {
        serverList.remove(server);
    }

    public void loadServers() throws IOException {
        //load the server list from the file
        serverList = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        String input;
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                while ((input = reader.readLine()) != null) {
                    String[] pieces = input.split("\t");
                    String name = pieces[0];
                    String baseSite = pieces[1];
                    String username = pieces[2];
                    String password = pieces[3];
                    boolean isAdmin = pieces[4].equalsIgnoreCase("true");
                    boolean isActive = pieces[5].equalsIgnoreCase("true");

                    ServerItem server = new ServerItem(name, baseSite, username, password, isAdmin, isActive);
                    serverList.add(server);
                }
            }
        }
    }

    public void saveServers() throws IOException {
        //write the server list to the file
        Path path = Paths.get(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            Iterator<ServerItem> iter = serverList.listIterator();
            while (iter.hasNext()) {
                ServerItem server = iter.next();
                writer.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",
                        server.getName(),
                        server.getBaseSite(),
                        server.getUsername(),
                        server.getPassword(),
                        server.isAdmin(),
                        server.isActive()));
                writer.newLine();
            }
        }
    }
}
