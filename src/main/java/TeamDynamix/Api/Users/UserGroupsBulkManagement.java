package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder ({
        "UserUIDs",
        "GroupIDs",
        "RemoveOtherGroups"
})

public class UserGroupsBulkManagement {

    @JsonProperty("UserUIDs")
    private List<String> userUIDs;
    @JsonProperty("GroupIDs")
    private List<Integer> groupIDs;
    @JsonProperty("RemoveOtherGroups")
    private boolean removeOtherGroups;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();


    @JsonProperty("UserUIDs")
    public List<String> getUserUIDs() {
        return userUIDs;
    }

    @JsonProperty("UserUIDs")
    public void setUserUIDs(List<String> userUIDs) {
        this.userUIDs = userUIDs;
    }

    @JsonProperty("GroupIDs")
    public List<Integer> getGroupIDs() {
        return groupIDs;
    }

    @JsonProperty("GroupIDs")
    public void setGroupIDs(List<Integer> groupIDs) {
        this.groupIDs = groupIDs;
    }

    @JsonProperty("RemoveOtherGroups")
    public boolean isRemoveOtherGroups() {
        return removeOtherGroups;
    }

    @JsonProperty("RemoveOtherGroups")
    public void setRemoveOtherGroups(boolean removeOtherGroups) {
        this.removeOtherGroups = removeOtherGroups;
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
