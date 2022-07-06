package TeamDynamix.Utils;

import TeamDynamix.Api.Users.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wizard0f0s.tdxextended.ServerItem;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UserTools {

    private static final int GET_CURRENT_USER_MAX_CALLS = 60;
    private static final int GET_CURRENT_USER_TIME_PERIOD = 60;
    private final static TDX_ApiRateLimit getCurrentUserRateLimit = new TDX_ApiRateLimit(GET_CURRENT_USER_MAX_CALLS, GET_CURRENT_USER_TIME_PERIOD);

    private static final int GET_USER_LIST_MAX_CALLS = 1;
    private static final int GET_USER_LIST_TIME_PERIOD = 60;
    private final static TDX_ApiRateLimit getUserListRateLimit = new TDX_ApiRateLimit(GET_USER_LIST_MAX_CALLS, GET_USER_LIST_TIME_PERIOD);

    private static final int GET_GROUP_LIST_MAX_CALLS = 60;
    private static final int GET_GROUP_LIST_TIME_PERIOD = 60;
    private static final TDX_ApiRateLimit getGroupListRateLimit = new TDX_ApiRateLimit(GET_GROUP_LIST_MAX_CALLS, GET_GROUP_LIST_TIME_PERIOD);
    private static final int SET_USER_GROUP_BULK_MANAGEMENT_MAX_CALLS = 1;
    private static final int SET_USER_GROUP_BULK_MANAGEMENT_TIME_PERIOD = 120;
    private static final TDX_ApiRateLimit setUserGroupBulkManagementRateLimit = new TDX_ApiRateLimit(SET_USER_GROUP_BULK_MANAGEMENT_MAX_CALLS, SET_USER_GROUP_BULK_MANAGEMENT_TIME_PERIOD);


    public static boolean Login(HttpURLConnection connection, ServerItem server, String path, String method) throws IOException {
        URL url = new URL(server.getBaseSite() + path);
        TDX_Authentication.getInstance().setupConnection(server.getBaseSite(), server.getUsername(), server.getPassword(), server.isAdmin());
        connection = UserTools.BuildConnection(url, method);
        if (connection == null) {
            System.out.println("Connection failed and returned null");
            return false;
        } else {
            String bearerToken = TDX_Authentication.getInstance().tdxLogin(connection);
            if (!bearerToken.equalsIgnoreCase("Invalid username or password.")) {
                return true;
            }
        }
        return false;
    }

    public static HttpURLConnection BuildConnection(URL url, String requestMethod) {
        try {
            //Setup connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Content-Type", "application/json");
            if (!TDX_Authentication.getInstance().getBearerToken().isEmpty()) {
                connection.setRequestProperty("Authorization", "Bearer " + TDX_Authentication.getInstance().getBearerToken());
            }
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(120000);
            connection.setReadTimeout(120000);

            return connection;

        } catch (MalformedURLException mue) {
            System.out.println("URL Error:\n" + mue);
        } catch (IOException ioe) {
            System.out.println("IO Error:\n" + ioe);
        }
        return null;
    }

    public static TeamDynamix.Api.Users.User getCurrentUser(HttpURLConnection connection) throws JsonProcessingException {
        boolean rateLimited = true;
        String jsonString = "";

        while (rateLimited) {
            getCurrentUserRateLimit.CheckRateLimit();
            try {
                jsonString = JsonUtils.jsonGet(connection);
//                System.out.println("jsonString = " + jsonString);
//                System.out.println("ResponseCode = " + connection.getResponseCode());
//                System.out.println("ResponseMessage = " + connection.getResponseMessage());
                if ((connection.getResponseCode() == 429) || (connection.getResponseCode() == 401)) {
                    rateLimited = true;
                    getCurrentUserRateLimit.forceCheck();
                    connection = BuildConnection(connection.getURL(), connection.getRequestMethod());
                } else {
                    rateLimited = false;
                }
            } catch (IOException ioe) {
                System.out.println("UserTools:getCurrentUser: IO Error:\n");
                ioe.printStackTrace();
            }

        }

        //Convert responseBody JSON to POJO
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        if (!jsonString.isEmpty()) {
            return mapper.readValue(jsonString, User.class);
        }
        return null;
    }

    public static List<UserListing> getUserList(HttpURLConnection connection) throws JsonProcessingException {
        boolean rateLimited = true;
        String jsonString = "";

        while (rateLimited) {
            getUserListRateLimit.CheckRateLimit();

            try {
                jsonString = JsonUtils.jsonGet(connection);
//                System.out.println("jsonString = " + jsonString);
//                System.out.println("ResponseCode = " + connection.getResponseCode());
//                System.out.println("ResponseMessage = " + connection.getResponseMessage());
                if ((connection.getResponseCode() == 429) || (connection.getResponseCode() == 401)) {
                    rateLimited = true;
                    getUserListRateLimit.forceCheck();
                    connection = BuildConnection(connection.getURL(), connection.getRequestMethod());
                } else {
                    rateLimited = false;
                }
            } catch (IOException e) {
                System.out.println("UserTools:getUserList: IO Error:\n");
                e.printStackTrace();
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        if (!jsonString.isEmpty()) {
            return mapper.readValue(jsonString, new TypeReference<List<UserListing>>() {});
        }
        return null;
    }

    public static List<Group> getGroupList(HttpURLConnection connection, GroupSearch query) throws JsonProcessingException {
        boolean rateLimited = true;
        String jsonString = "";

        while (rateLimited) {
            getGroupListRateLimit.CheckRateLimit();

            try {
                ObjectMapper makeJson = new ObjectMapper();
                JsonUtils.jsonPost(connection, makeJson.writeValueAsString(query));
                jsonString = JsonUtils.jsonGet(connection);
//                System.out.println("jsonString = " + jsonString);
//                System.out.println("ResponseCode = " + connection.getResponseCode());
//                System.out.println("ResponseMessage = " + connection.getResponseMessage());
                if ((connection.getResponseCode() == 429) || (connection.getResponseCode() == 401)) {
                    rateLimited = true;
                    getGroupListRateLimit.forceCheck();
                    connection = BuildConnection(connection.getURL(), connection.getRequestMethod());
                } else {
                    rateLimited = false;
                }
            } catch (IOException e) {
                System.out.println("UserTools:getGroupList: IO Error:\n");
                e.printStackTrace();
            }
        }

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        if (!jsonString.isEmpty()) {
            return mapper.readValue(jsonString, new TypeReference<List<Group>>() {});
        }
        return null;
    }

    public static void setBulkGroups(HttpURLConnection connection, UserGroupsBulkManagement bulkManageGroupParams) throws JsonProcessingException {
        boolean rateLimited = true;
        String jsonString = "";

        while (rateLimited) {
            setUserGroupBulkManagementRateLimit.CheckRateLimit();

            try {
                ObjectMapper makeJson = new ObjectMapper();
                JsonUtils.jsonPost(connection, makeJson.writeValueAsString(bulkManageGroupParams));
                jsonString = JsonUtils.jsonGet(connection);
                System.out.println("jsonString = " + jsonString);
                System.out.println("ResponseCode = " + connection.getResponseCode());
                System.out.println("ResponseMessage = " + connection.getResponseMessage());
                if ((connection.getResponseCode() == 429) || (connection.getResponseCode() == 401)) {
                    rateLimited = true;
                    getGroupListRateLimit.forceCheck();
                    connection = BuildConnection(connection.getURL(), connection.getRequestMethod());
                } else {
                    rateLimited = false;
                }
            } catch (IOException e) {
                System.out.println("UserTools:setBulkGroups: IO Error:\n");
                e.printStackTrace();
            }
        }
    }

    public static void autoResizeColumns(TableView<?> table) {
        //Set the right policy
        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        table.getColumns().stream().forEach((column) ->
        {
            //Minimal width = columnheader
            Text t = new Text(column.getText());
            double max = t.getLayoutBounds().getWidth();
            for (int i = 0; i < table.getItems().size(); i++) {
                //cell must not be empty
                if (column.getCellData(i) != null) {
                    t = new Text(column.getCellData(i).toString());
                    double calcwidth = t.getLayoutBounds().getWidth();
                    //remember new max-width
                    if (calcwidth > max) {
                        max = calcwidth;
                    }
                }
            }
            //set the new max-width with some extra space
            column.setPrefWidth(max + 30.0d);
        });
    }
}
