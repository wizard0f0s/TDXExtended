package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder ({
        "UID",
        "ReferenceID",
        "UserName",
        "FirstName",
        "LastName",
        "FullName",
        "PrimaryEmail",
        "AlertEmail",
        "AuthenticationUserName",
        "ExternalID",
        "AlternateID",
        "IsEmployee",
        "IsActive",
        "IsConfidential",
        "TypeID",
        "DefaultAccountID"
})

public class UserListing {

    @JsonProperty("UID")
    private String uid;
    @JsonProperty("ReferenceID")
    private Integer referenceID;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("FullName")
    private String fullName;
    @JsonProperty("PrimaryEmail")
    private String primaryEmail;
    @JsonProperty("AlertEmail")
    private String alertEmail;
    @JsonProperty("AuthenticationUserName")
    private String authenticationUserName;
    @JsonProperty("ExternalID")
    private String externalID;
    @JsonProperty("AlternateID")
    private String alternateID;
    @JsonProperty("IsEmployee")
    private Boolean isEmployee;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("IsConfidential")
    private Boolean isConfidential;
    @JsonProperty("TypeID")
    private Integer typeID;
    @JsonProperty("DefaultAccountID")
    private Integer defaultAccountID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("UID")
    public String getUid() {
        return uid;
    }

    @JsonProperty("UID")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("ReferenceID")
    public Integer getReferenceID() {
        return referenceID;
    }

    @JsonProperty("ReferenceID")
    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    @JsonProperty("UserName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("UserName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("FirstName")
   public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("FullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("FullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("PrimaryEmail")
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    @JsonProperty("PrimaryEmail")
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @JsonProperty("AlertEmail")
    public String getAlertEmail() {
        return alertEmail;
    }

    @JsonProperty("AlertEmail")
    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }

    @JsonProperty("AuthenticationUserName")
    public String getAuthenticationUserName() {
        return authenticationUserName;
    }

    @JsonProperty("AuthenticationUserName")
    public void setAuthenticationUserName(String authenticationUserName) {
        this.authenticationUserName = authenticationUserName;
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

    @JsonProperty("IsEmployee")
    public Boolean getEmployee() {
        return isEmployee;
    }

    @JsonProperty("IsEmployee")
    public void setEmployee(Boolean employee) {
        isEmployee = employee;
    }

    @JsonProperty("IsActive")
    public Boolean getActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setActive(Boolean active) {
        isActive = active;
    }

    @JsonProperty("IsConfidential")
    public Boolean getConfidential() {
        return isConfidential;
    }

    @JsonProperty("IsConfidential")
    public void setConfidential(Boolean confidential) {
        isConfidential = confidential;
    }

    @JsonProperty("TypeID")
    public Integer getTypeID() {
        return typeID;
    }

    @JsonProperty("TypeID")
    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    @JsonProperty("DefaultAccountID")
    public Integer getDefaultAccountID() {
        return defaultAccountID;
    }

    @JsonProperty("DefaultAccountID")
    public void setDefaultAccountID(Integer defaultAccountID) {
        this.defaultAccountID = defaultAccountID;
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
