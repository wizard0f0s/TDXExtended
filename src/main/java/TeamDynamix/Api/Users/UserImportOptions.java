package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AllowIsActiveChanges",
        "AllowSecurityRoleChanges",
        "AllowApplicationChanges",
        "NotifyEmailAddresses"
})

public class UserImportOptions {

    @JsonProperty("AllowIsActiveChanges")
    private boolean allowIsActiveChanges;
    @JsonProperty("AllowSecurityRoleChanges")
    private boolean allowSecurityRoleChanges;
    @JsonProperty("AllowApplicationChanges")
    private boolean allowApplicationChanges;
    @JsonProperty("NotifyEmailAddresses")
    private String notifyEmailAddresses;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();


    @JsonProperty("AllowIsActiveChanges")
    public boolean isAllowIsActiveChanges() {
        return allowIsActiveChanges;
    }

    @JsonProperty("AllowIsActiveChanges")
    public void setAllowIsActiveChanges(boolean allowIsActiveChanges) {
        this.allowIsActiveChanges = allowIsActiveChanges;
    }

    @JsonProperty("AllowSecurityRoleChanges")
    public boolean isAllowSecurityRoleChanges() {
        return allowSecurityRoleChanges;
    }

    @JsonProperty("AllowSecurityRoleChanges")
    public void setAllowSecurityRoleChanges(boolean allowSecurityRoleChanges) {
        this.allowSecurityRoleChanges = allowSecurityRoleChanges;
    }

    @JsonProperty("AllowApplicationChanges")
    public boolean isAllowApplicationChanges() {
        return allowApplicationChanges;
    }

    @JsonProperty("AllowApplicationChanges")
    public void setAllowApplicationChanges(boolean allowApplicationChanges) {
        this.allowApplicationChanges = allowApplicationChanges;
    }

    @JsonProperty("NotifyEmailAddresses")
    public String getNotifyEmailAddresses() {
        return notifyEmailAddresses;
    }

    @JsonProperty("NotifyEmailAddresses")
    public void setNotifyEmailAddresses(String notifyEmailAddresses) {
        this.notifyEmailAddresses = notifyEmailAddresses;
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
