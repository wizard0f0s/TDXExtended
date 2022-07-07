package TeamDynamix.Api.Users;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "GroupID",
        "GroupName",
        "IsPrimary",
        "IsManager",
        "IsNotified"
})

public class UserGroup {

    @JsonProperty("GroupID")
    private Integer groupID;
    @JsonProperty("GroupName")
    private String groupName;
    @JsonProperty("IsPrimary")
    private boolean isPrimary;
    @JsonProperty("IsManager")
    private boolean isManager;
    @JsonProperty("IsNotified")
    private boolean isNotified;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("GroupID")
    public Integer getGroupID() {
        return groupID;
    }

    @JsonProperty("GroupID")
    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    @JsonProperty("GroupName")
    public String getGroupName() {
        return groupName;
    }

    @JsonProperty("GroupName")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @JsonProperty("IsPrimary")
    public boolean isPrimary() {
        return isPrimary;
    }

    @JsonProperty("IsPrimary")
    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    @JsonProperty("IsManager")
    public boolean isManager() {
        return isManager;
    }

    @JsonProperty("IsManager")
    public void setManager(boolean manager) {
        isManager = manager;
    }

    @JsonProperty("IsNotified")
    public boolean isNotified() {
        return isNotified;
    }

    @JsonProperty("IsNotified")
    public void setNotified(boolean notified) {
        isNotified = notified;
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
