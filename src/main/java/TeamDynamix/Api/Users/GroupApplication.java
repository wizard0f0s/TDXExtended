package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "GroupID",
        "AppID",
        "AppName",
        "AppDescription",
        "AppClass"
})

public class GroupApplication {

    @JsonProperty("GroupID")
    private Integer groupId;
    @JsonProperty("AppID")
    private Integer appId;
    @JsonProperty("AppName")
    private String appName;
    @JsonProperty("AppDescription")
    private String appDescription;
    @JsonProperty("AppClass")
    private String appClass;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("GroupID")
    public Integer getGroupId() {
        return groupId;
    }

    @JsonProperty("GroupID")
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("AppID")
    public Integer getAppId() {
        return appId;
    }

    @JsonProperty("AppID")
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    @JsonProperty("AppName")
    public String getAppName() {
        return appName;
    }

    @JsonProperty("AppName")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @JsonProperty("AppDescription")
    public String getAppDescription() {
        return appDescription;
    }

    @JsonProperty("AppDescription")
    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    @JsonProperty("AppClass")
    public String getAppClass() {
        return appClass;
    }

    @JsonProperty("AppClass")
    public void setAppClass(String appClass) {
        this.appClass = appClass;
    }
}
