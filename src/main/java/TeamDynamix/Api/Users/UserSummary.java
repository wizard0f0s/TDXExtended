package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UID",
        "ReferenceID",
        "FullName",
        "FirstName",
        "LastName",
        "ProfileImageFileName",
        "AlertEmail"
})

public class UserSummary {

    @JsonProperty("UID")
    private String uID;
    @JsonProperty("ReferenceID")
    private Integer referenceID;
    @JsonProperty("FullName")
    private String fullName;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("ProfileImageFileName")
    private String profileImageFileName;
    @JsonProperty("AlertEmail")
    private String alertEmail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();


    @JsonProperty("UID")
    public String getuID() {
        return uID;
    }

    @JsonProperty("UID")
    public void setuID(String uID) {
        this.uID = uID;
    }

    @JsonProperty("ReferenceID")
    public Integer getReferenceID() {
        return referenceID;
    }

    @JsonProperty("ReferenceID")
    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    @JsonProperty("FullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("FullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @JsonProperty("ProfileImageFileName")
    public String getProfileImageFileName() {
        return profileImageFileName;
    }

    @JsonProperty("ProfileImageFileName")
    public void setProfileImageFileName(String profileImageFileName) {
        this.profileImageFileName = profileImageFileName;
    }

    @JsonProperty("AlertEmail")
    public String getAlertEmail() {
        return alertEmail;
    }

    @JsonProperty("AlertEmail")
    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
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
