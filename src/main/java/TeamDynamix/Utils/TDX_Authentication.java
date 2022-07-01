package TeamDynamix.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.http.*;


public class TDX_Authentication {

    private String bearerToken;
    private String website;
    private String tdxBeid;
    private String tdxWebServicesKey;
    private boolean isAdmin;
    private static final int LOGIN_ADMIN_MAX_CALLS = 60;
    private static final int LOGIN_ADMIN_TIME_PERIOD = 60;
    private final TDX_ApiRateLimit loginAdminRateLimit = new TDX_ApiRateLimit(LOGIN_ADMIN_MAX_CALLS, LOGIN_ADMIN_TIME_PERIOD);
    private TeamDynamix.Api.Auth.AdminTokenParameters adminAuth;
    private TeamDynamix.Api.Auth.LoginParameters userAuth;
    private static TDX_Authentication instance = new TDX_Authentication();


    private TDX_Authentication() {

    }

    public void setupConnection(String website, String tdxBeid, String tdxWebServicesKey, boolean isAdmin) {
        this.website = website;
        this.isAdmin = isAdmin;
        this.bearerToken = "";
        if (isAdmin) {
            this.tdxBeid = tdxBeid;
            this.tdxWebServicesKey = tdxWebServicesKey;
            this.adminAuth = new TeamDynamix.Api.Auth.AdminTokenParameters();
            this.adminAuth.setBeid(tdxBeid);
            this.adminAuth.setWebServicesKey(tdxWebServicesKey);

        } else {
            this.userAuth = new TeamDynamix.Api.Auth.LoginParameters();
            this.userAuth.setUsername(tdxBeid);
            this.userAuth.setPassword(tdxWebServicesKey);
        }
    }

    public String tdxLogin(HttpURLConnection connection) {

        loginAdminRateLimit.CheckRateLimit();

        try {
            //Setup JSON string
            //Convert this.tdxAdmin to a serialized JSON string
            ObjectMapper mapper = new ObjectMapper();
            String jsonString;
            if (isAdmin) {
                jsonString = mapper.writeValueAsString(this.adminAuth);
            } else {
                jsonString = mapper.writeValueAsString(this.userAuth);
            }
            JsonUtils.jsonPost(connection, jsonString);
            System.out.println(connection.getResponseCode());
            System.out.println(connection.getResponseMessage());
            this.bearerToken = JsonUtils.jsonGet(connection);
        } catch (MalformedURLException mue) {
            System.out.println("URL Error:\n" + mue);
        } catch (IOException ioe) {
            System.out.println("IO Error:\n" + ioe);
        }

        //returns "Invalid username or password" on login failure
        return this.bearerToken;
    }

    public String getBearerToken() {
        return bearerToken;
    }

    public static TDX_Authentication getInstance() {
        return instance;
    }
}
