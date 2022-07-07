package TeamDynamix.Api.Users;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UserUids",
        "AccountIDs",
        "ReplaceExistingAccounts"
})

public class UserAccountsBulkManagementParameters {

    @JsonProperty("UserUids")
    private List<String> userUids;

    @JsonProperty("AccountIDs")
    private List<Integer> accountIDs;

    @JsonProperty("ReplaceExistingAccounts")
    private boolean replaceExistingAccounts;

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

    @JsonProperty("AccountIDs")
    public List<Integer> getAccountIDs() {
        return accountIDs;
    }

    @JsonProperty("AccountIDs")
    public void setAccountIDs(List<Integer> accountIDs) {
        this.accountIDs = accountIDs;
    }

    @JsonProperty("ReplaceExistingAccounts")
    public boolean isReplaceExistingAccounts() {
        return replaceExistingAccounts;
    }

    @JsonProperty("ReplaceExistingAccounts")
    public void setReplaceExistingAccounts(boolean replaceExistingAccounts) {
        this.replaceExistingAccounts = replaceExistingAccounts;
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
