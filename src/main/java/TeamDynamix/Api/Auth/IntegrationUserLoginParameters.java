package TeamDynamix.Api.Auth;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IntegrationTypeID",
        "IntegrationExternalID",
        "UserIntegrationSettingsExternalID"
})

public class IntegrationUserLoginParameters {

    @JsonProperty("IntegrationTypeID")
    private Integer integrationTypeID;
    @JsonProperty("IntegrationExternalID")
    private String integrationExternalID;
    @JsonProperty("UserIntegrationSettingsExternalID")
    private String userIntegrationSettingsExternalID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("IntegrationTypeID")
    public Integer getIntegrationTypeID() {
        return integrationTypeID;
    }

    @JsonProperty("IntegrationTypeID")
    public void setIntegrationTypeID(Integer integrationTypeID) {
        this.integrationTypeID = integrationTypeID;
    }

    @JsonProperty("IntegrationExternalID")
    public String getIntegrationExternalID() {
        return integrationExternalID;
    }

    @JsonProperty("IntegrationExternalID")
    public void setIntegrationExternalID(String integrationExternalID) {
        this.integrationExternalID = integrationExternalID;
    }

    @JsonProperty("UserIntegrationSettingsExternalID")
    public String getUserIntegrationSettingsExternalID() {
        return userIntegrationSettingsExternalID;
    }

    @JsonProperty("UserIntegrationSettingsExternalID")
    public void setUserIntegrationSettingsExternalID(String userIntegrationSettingsExternalID) {
        this.userIntegrationSettingsExternalID = userIntegrationSettingsExternalID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
