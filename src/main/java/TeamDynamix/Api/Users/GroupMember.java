package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IsPrimaryGroup",
        "IsGroupManager",
        "IsGroupNotified",
        "AddedToGroupDate"
})

public class GroupMember {

    @JsonProperty("IsPrimaryGroup")
    private Boolean isPrimaryGroup;
    @JsonProperty("IsGroupManager")
    private Boolean isGroupManager;
    @JsonProperty("IsGroupNotified")
    private Boolean isGroupNotified;
    @JsonProperty("AddedToGroupDate")
    private LocalDate addedToGroupDate;
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

    @JsonProperty("IsPrimaryGroup")
    public Boolean isPrimaryGroup() {
        return isPrimaryGroup;
    }

    @JsonProperty("IsPrimaryGroup")
    public void setPrimaryGroup(Boolean primaryGroup) {
        isPrimaryGroup = primaryGroup;
    }

    @JsonProperty("IsGroupManager")
    public Boolean isGroupManager() {
        return isGroupManager;
    }

    @JsonProperty("IsGroupManager")
    public void setGroupManager(Boolean groupManager) {
        isGroupManager = groupManager;
    }

    @JsonProperty("IsGroupNotified")
    public Boolean isGroupNotified() {
        return isGroupNotified;
    }

    @JsonProperty("IsGroupNotified")
    public void setGroupNotified(Boolean groupNotified) {
        isGroupNotified = groupNotified;
    }

    @JsonProperty("AddedToGroupDate")
    public LocalDate getAddedToGroupDate() {
        return addedToGroupDate;
    }

    @JsonProperty("AddedToGroupDate")
    public void setAddedToGroupDate(LocalDate addedToGroupDate) {
        this.addedToGroupDate = addedToGroupDate;
    }
}
