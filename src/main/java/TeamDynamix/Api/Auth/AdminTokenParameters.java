package TeamDynamix.Api.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminTokenParameters {

    @JsonProperty("BEID")
    private String beid;
    @JsonProperty("WebServicesKey")
    private String webServicesKey;


    @JsonProperty("BEID")
    public String getBeid() {
        return beid;
    }

    @JsonProperty("BEID")
    public void setBeid(String beid) {
        this.beid = beid;
    }

    @JsonProperty("WebServicesKey")
    public String getWebServicesKey() {
        return webServicesKey;
    }

    @JsonProperty("WebServicesKey")
    public void setWebServicesKey(String webServicesKey) {
        this.webServicesKey = webServicesKey;
    }

}
