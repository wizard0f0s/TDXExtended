package TeamDynamix.Api.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginParameters {

    @JsonProperty("UserName")
    private String username;
    @JsonProperty("Password")
    private String password;


    @JsonProperty("UserName")
    public String getUsername() {
        return username;
    }

    @JsonProperty("UserName")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("Password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("Password")
    public void setPassword(String password) {
        this.password = password;
    }

}
