package TeamDynamix.Api.Users;


import TeamDynamix.Api.Apps.UserApplication;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UserUids",
        "OrgApplications",
        "ReplaceExistingOrgApplications"
})

public class UserOrgApplicationsBulkManagementParameters {

    @JsonProperty("UserUids")
    private List<String> userUids;
    @JsonProperty("OrgApplications")
    private List<TeamDynamix.Api.Apps.UserApplication> orgApplications;
    @JsonProperty("ReplaceExistingOrgApplications")
    private boolean replaceExistingOrgApplications;
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

    @JsonProperty("OrgApplications")
    public List<UserApplication> getOrgApplications() {
        return orgApplications;
    }

    @JsonProperty("OrgApplications")
    public void setOrgApplications(List<UserApplication> orgApplications) {
        this.orgApplications = orgApplications;
    }

    @JsonProperty("ReplaceExistingOrgApplications")
    public boolean isReplaceExistingOrgApplications() {
        return replaceExistingOrgApplications;
    }

    @JsonProperty("ReplaceExistingOrgApplications")
    public void setReplaceExistingOrgApplications(boolean replaceExistingOrgApplications) {
        this.replaceExistingOrgApplications = replaceExistingOrgApplications;
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
