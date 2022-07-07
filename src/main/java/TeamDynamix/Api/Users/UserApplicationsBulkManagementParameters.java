package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UserUids",
        "ApplicationNames",
        "ReplaceExistingApplications"
})

public class UserApplicationsBulkManagementParameters {

    @JsonProperty("UserUids")
    private List<String> userUids;
    @JsonProperty("ApplicationNames")
    private List<String> applicationNames;
    @JsonProperty("ReplaceExistingApplications")
    private boolean replaceExistingApplications;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("UserUids")
    public List<String> getUserUids() {
        return userUids;
    }

    @JsonProperty("UserUids")
    public void setUserUids(List<String> userUids) {
        this.userUids = userUids;
    }

    @JsonProperty("ApplicationNames")
    public List<String> getApplicationNames() {
        return applicationNames;
    }

    @JsonProperty("ApplicationNames")
    public void setApplicationNames(List<String> applicationNames) {
        this.applicationNames = applicationNames;
    }

    @JsonProperty("ReplaceExistingApplications")
    public boolean isReplaceExistingApplications() {
        return replaceExistingApplications;
    }

    @JsonProperty("ReplaceExistingApplications")
    public void setReplaceExistingApplications(boolean replaceExistingApplications) {
        this.replaceExistingApplications = replaceExistingApplications;
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
