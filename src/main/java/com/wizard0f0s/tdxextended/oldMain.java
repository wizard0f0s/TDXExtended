package com.wizard0f0s.tdxextended;

import TeamDynamix.Api.Users.Group;
import TeamDynamix.Api.Users.GroupSearch;
import TeamDynamix.Api.Users.UserGroupsBulkManagement;
import TeamDynamix.Api.Users.UserListing;
import TeamDynamix.Utils.QueryStrings;
import TeamDynamix.Utils.TDX_Authentication;
import TeamDynamix.Utils.UserTools;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class oldMain {

    private static String bearerToken = "";

    public static void main(String[] args) {
//        System.out.println("The TDX Test site is: https://services.tctc.edu/SBTDWebApi/");
        //Scanner scanner = new Scanner(System.in);
        //Sandbox
//        String site = "https://services.tctc.edu/SBTDWebApi";
        //Production
        String site = "https://services.tctc.edu/TDWebApi/";

//        System.out.println("Enter the site to connect to: ");
        //site = scanner.nextLine();
        System.out.println("The site is: " + site);

        boolean success = true;

        try {
            URL url = new URL(site);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //login with a service account
            //Sandbox
//            TDX_Authentication tdxAuth = login(connection, site, "api/auth/loginadmin", "POST", "FFAB90E6-5500-4E59-8E5F-62EBAEB2BA85", "774D7EF1-DA0C-4BC3-B269-0681092B8BB1", true);
            //Production
            TDX_Authentication tdxAuth = login(connection, site, "api/auth/loginadmin", "POST", "FFAB90E6-5500-4E59-8E5F-62EBAEB2BA85", "03DCF2CE-1682-4C24-8C38-59DD35708B83", true);
            if (tdxAuth != null) {
                testGetCurrentUser(tdxAuth, connection, site, "api/auth/getuser", "GET");
            } else {
                System.out.println("Failed login attempt");
            }

            //Query list of users
            String queryString = QueryStrings.BuildUserListQuery(true, true, true, 1);
            List<UserListing> tdxUserList = testGetUserList(tdxAuth, connection, site, "api/people/userlist?" + queryString, "GET");

            List<String> userGuids = new ArrayList<>();

            for (UserListing user : tdxUserList) {
                userGuids.add(user.getUid());
            }

//            for (String guid : userGuids) {
//                System.out.println(guid);
//            }

            GroupSearch groupSearchQuery = new GroupSearch();
            groupSearchQuery.setActive(true);
            groupSearchQuery.setNameLike("");
            groupSearchQuery.setHasAppId(0);
            groupSearchQuery.setHasSystemAppName("");
            groupSearchQuery.setAssociatedAppId(0);

            List<Group> tdxGroupList = testGetGroupList(tdxAuth, connection, site, "api/groups/search", "POST", groupSearchQuery);

            List<Integer> groupIDs = new ArrayList<>();
            Integer employeesGroupID = -1;

            for (Group group : tdxGroupList) {
                System.out.println("\t" + group.getId() + ": " + group.getName());
                if (group.getName().equalsIgnoreCase("Employees")) {
                    employeesGroupID = group.getId();
                    groupIDs.add(group.getId());
                }
            }

            System.out.println("\nEmployees group ID = " + employeesGroupID);

            UserGroupsBulkManagement userGroupsBulkManagementParams = new UserGroupsBulkManagement();
            userGroupsBulkManagementParams.setUserUIDs(userGuids);
            userGroupsBulkManagementParams.setGroupIDs(groupIDs);
            userGroupsBulkManagementParams.setRemoveOtherGroups(false);

            testManageGroups(tdxAuth, connection, site, "api/people/bulk/managegroups", "POST", userGroupsBulkManagementParams);

//            if (login(connection, site, "api/auth/login", "POST", "jtest@tctc.edu", "#Reset123#", false)) {
//                testGetCurrentUser(connection, site, "api/auth/getuser", "GET");
//            } else {
//                System.out.println("Failed login attempt");
//            }

            connection.disconnect();

        } catch (MalformedURLException mue) {
            System.out.println("Malformed URL exception:\n");
            mue.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("IOException error:\n");
            ioe.printStackTrace();
        }

        //scanner.close();
    }

    private static TDX_Authentication login(HttpURLConnection connection, String site, String path, String method, String user, String password, boolean isAdmin) throws IOException {
        URL url = new URL(site + path);
        TDX_Authentication tdxAuth = new TDX_Authentication(site, user, password, isAdmin);
        connection = UserTools.BuildConnection(tdxAuth, url, method);
        if (connection == null) {
            System.out.println("Connection failed and returned null");
            return null;
        } else {
            bearerToken = tdxAuth.tdxLogin(connection);
            if (!bearerToken.equalsIgnoreCase("Invalid username or password.")) {
                return tdxAuth;
            }
        }
        return null;
    }

    private static void testGetCurrentUser(TDX_Authentication tdxAuth, HttpURLConnection connection, String site, String path, String method) throws IOException {
        URL url = new URL(site + path);
        connection = UserTools.BuildConnection(tdxAuth, url, method);
        TeamDynamix.Api.Users.User currentUser;

        try {
            currentUser = UserTools.getCurrentUser(tdxAuth, connection);
            if (currentUser != null) {
//                System.out.println("Current User is: " + currentUser.getFullName());
//                System.out.println("Current username is: " + currentUser.getUserName());
//                System.out.println(currentUser.getReportTimeAfterDate());
                return;
            }
        } catch (JsonProcessingException jpe) {
            System.out.println("JsonProcessing Exception: \n");
            jpe.printStackTrace();
        }

        if(connection != null) {
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Message: " + connection.getResponseMessage());
        }
        System.out.println("IOException returning response code and message.");
    }


    private static List<UserListing> testGetUserList(TDX_Authentication tdxAuth, HttpURLConnection connection, String site, String path, String method) throws IOException {
        URL url = new URL(site + path);
        connection = UserTools.BuildConnection(tdxAuth, url, method);
        List<UserListing> userList = new ArrayList<UserListing>();

        try {
            userList = UserTools.getUserList(tdxAuth, connection);
            if (userList != null) {
                System.out.println("Found " + userList.size() + " users!");
//                System.out.println("First User is: " + userList.get(0).getFullName());
//                System.out.println("First username is: " + userList.get(0).getUserName());
                return userList;
            }
        } catch (JsonProcessingException jpe) {
            System.out.println("JsonProcessing Exception: \n");
            jpe.printStackTrace();
        }

        if(connection != null) {
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Message: " + connection.getResponseMessage());
        }
        System.out.println("Main:testGetUserList: IOException returning response code and message.");

        return null;
    }

    private static List<Group> testGetGroupList(TDX_Authentication tdxAuth, HttpURLConnection connection, String site, String path, String method, GroupSearch query) throws IOException {
        URL url = new URL(site + path);
        connection = UserTools.BuildConnection(tdxAuth, url, method);
        List<Group> groups = new ArrayList<>();

        try {
            groups = UserTools.getGroupList(tdxAuth, connection, query);
            if (groups != null) {
                System.out.println("Found " + groups.size() + " groups!");
                return groups;
            }
        } catch (JsonProcessingException jpe) {
            System.out.println("testGetGroupList: JsonProcessing Exception: \n");
            jpe.printStackTrace();
        }

        if(connection != null) {
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Message: " + connection.getResponseMessage());
        }
        System.out.println("Main:testGetUserList: IOException returning response code and message.");

        return null;
    }

    private static void testManageGroups(TDX_Authentication tdxAuth, HttpURLConnection connection, String site, String path, String method, UserGroupsBulkManagement bulkManageGroupParams) throws IOException {
        URL url = new URL(site + path);
        connection = UserTools.BuildConnection(tdxAuth, url, method);
        List<Group> groups = new ArrayList<>();

        try {
            UserTools.setBulkGroups(tdxAuth, connection, bulkManageGroupParams);
            return;
        } catch (JsonProcessingException jpe) {
            System.out.println("testManageGroups: JsonProcessing Exception: \n");
            jpe.printStackTrace();
        }

        if(connection != null) {
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Message: " + connection.getResponseMessage());
        }
        System.out.println("Main:testManageGroups: IOException returning response code and message.");

        return;
    }

}