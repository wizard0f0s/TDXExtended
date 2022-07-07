package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "SearchText",
        "IsActive",
        "IsEmployee",
        "AppName",
        "AccountIDs",
        "MaxResults",
        "ReferenceIDs",
        "ExternalID",
        "AlternateID",
        "UserName",
        "SecurityRoleID",
        "IsConfidential"
})

public class UserSearch {

    @JsonProperty("SearchText")
    private String searchText;
    @JsonProperty("IsActive")
    private boolean isActive;
    @JsonProperty("IsEmployee")
    private boolean isEmployee;
    @JsonProperty("AppName")
    private String appName;
    @JsonProperty("AccountIDs")
    private List<Integer> accountIDs;
    @JsonProperty("MaxResults")
    private Integer maxResults;
    @JsonProperty("ReferenceIDs")
    private List<Integer> referenceIDs;
    @JsonProperty("ExternalID")
    private String externalID;
    @JsonProperty("AlternateID")
    private String alternateID;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("SecurityRoleID")
    private String securityRoleID;
    @JsonProperty("IsConfidential")
    private boolean isConfidential;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();


    @JsonProperty("SearchText")
    public String getSearchText() {
        return searchText;
    }

    @JsonProperty("SearchText")
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @JsonProperty("IsActive")
    public boolean isActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setActive(boolean active) {
        isActive = active;
    }

    @JsonProperty("IsEmployee")
    public boolean isEmployee() {
        return isEmployee;
    }

    @JsonProperty("IsEmployee")
    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    @JsonProperty("AppName")
    public String getAppName() {
        return appName;
    }

    @JsonProperty("AppName")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @JsonProperty("AccountIDs")
    public List<Integer> getAccountIDs() {
        return accountIDs;
    }

    @JsonProperty("AccountIDs")
    public void setAccountIDs(List<Integer> accountIDs) {
        this.accountIDs = accountIDs;
    }

    @JsonProperty("MaxResults")
    public Integer getMaxResults() {
        return maxResults;
    }

    @JsonProperty("MaxResults")
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    @JsonProperty("ReferenceIDs")
    public List<Integer> getReferenceIDs() {
        return referenceIDs;
    }

    @JsonProperty("ReferenceIDs")
    public void setReferenceIDs(List<Integer> referenceIDs) {
        this.referenceIDs = referenceIDs;
    }

    @JsonProperty("ExternalID")
    public String getExternalID() {
        return externalID;
    }

    @JsonProperty("ExternalID")
    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    @JsonProperty("AlternateID")
    public String getAlternateID() {
        return alternateID;
    }

    @JsonProperty("AlternateID")
    public void setAlternateID(String alternateID) {
        this.alternateID = alternateID;
    }

    @JsonProperty("UserName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("UserName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("SecurityRoleID")
    public String getSecurityRoleID() {
        return securityRoleID;
    }

    @JsonProperty("SecurityRoleID")
    public void setSecurityRoleID(String securityRoleID) {
        this.securityRoleID = securityRoleID;
    }

    @JsonProperty("IsConfidential")
    public boolean isConfidential() {
        return isConfidential;
    }

    @JsonProperty("IsConfidential")
    public void setConfidential(boolean confidential) {
        isConfidential = confidential;
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
