package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UID",
        "ReferenceID",
        "TypeID",
        "IsActive",
        "FirstName",
        "LastName",
        "MiddleName",
        "Salutation",
        "Nickname",
        "PrimaryEmail",
        "AlternateEmail",
        "OrganizationalID",
        "AlternateID",
        "Organization",
        "Title",
        "PrimaryPhone",
        "WorkPhone",
        "HomePhone",
        "MobilePhone",
        "OtherPhone",
        "Pager",
        "Fax",
        "WorkAddress",
        "WorkCity",
        "WorkState",
        "WorkPostalCode",
        "WorkCountry",
        "HomeAddress",
        "HomeCity",
        "HomeState",
        "HomePostalCode",
        "HomeCountry",
        "ResourcePoolID",
        "ResourcePoolName",
        "ReportsToUid",
        "ReportsToFullName",
        "TimeZoneID",
        "TimeZoneName",
        "DefaultAccountID",
        "DefaultAccountName",
        "DefaultPriorityID",
        "DefaultPriorityName"
})

public class Person {
    @JsonProperty("UID")
    private String uid;
    @JsonProperty("ReferenceID")
    private Integer referenceID;
    @JsonProperty("TypeID")
    private Integer typeID;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("Salutation")
    private String salutation;
    @JsonProperty("Nickname")
    private String nickname;
    @JsonProperty("PrimaryEmail")
    private String primaryEmail;
    @JsonProperty("AlternateEmail")
    private String alternateEmail;
    @JsonProperty("AlertEmail")
    private String alertEmail;
    @JsonProperty("OrganizationalID")
    private String organizationalID;
    @JsonProperty("AlternateID")
    private String alternateID;
    @JsonProperty("Organization")
    private String organization;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("PrimaryPhone")
    private String primaryPhone;
    @JsonProperty("WorkPhone")
    private String workPhone;
    @JsonProperty("HomePhone")
    private String homePhone;
    @JsonProperty("MobilePhone")
    private String mobilePhone;
    @JsonProperty("OtherPhone")
    private String otherPhone;
    @JsonProperty("Pager")
    private String pager;
    @JsonProperty("Fax")
    private String fax;
    @JsonProperty("WorkAddress")
    private String workAddress;
    @JsonProperty("WorkCity")
    private String workCity;
    @JsonProperty("WorkState")
    private String workState;
    @JsonProperty("WorkPostalCode")
    private String workPostalCode;
    @JsonProperty("WorkCountry")
    private String workCountry;
    @JsonProperty("HomeAddress")
    private String homeAddress;
    @JsonProperty("HomeCity")
    private String homeCity;
    @JsonProperty("HomeState")
    private String homeState;
    @JsonProperty("HomePostalCode")
    private String homePostalCode;
    @JsonProperty("HomeCountry")
    private String homeCountry;
    @JsonProperty("ResourcePoolID")
    private Integer resourcePoolID;
    @JsonProperty("ResourcePoolName")
    private String resourcePoolName;
    @JsonProperty("ReportsToUID")
    private String reportsToUID;
    @JsonProperty("ReportsToFullName")
    private String reportsToFullName;
    @JsonProperty("TimeZoneID")
    private Integer timeZoneID;
    @JsonProperty("TimeZoneName")
    private String timeZoneName;
    @JsonProperty("DefaultAccountID")
    private Integer defaultAccountID;
    @JsonProperty("DefaultAccountName")
    private String defaultAccountName;
    @JsonProperty("DefaultPriorityID")
    private Integer defaultPriorityID;
    @JsonProperty("DefaultPriorityName")
    private String defaultPriorityName;
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

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    @JsonProperty("MiddleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("MiddleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("Salutation")
    public String getSalutation() {
        return salutation;
    }

    @JsonProperty("Salutation")
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @JsonProperty("Nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("Nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("DefaultAccountID")
    public Integer getDefaultAccountID() {
        return defaultAccountID;
    }

    @JsonProperty("DefaultAccountID")
    public void setDefaultAccountID(Integer defaultAccountID) {
        this.defaultAccountID = defaultAccountID;
    }

    @JsonProperty("DefaultAccountName")
    public String getDefaultAccountName() {
        return defaultAccountName;
    }

    @JsonProperty("DefaultAccountName")
    public void setDefaultAccountName(String defaultAccountName) {
        this.defaultAccountName = defaultAccountName;
    }

    @JsonProperty("PrimaryEmail")
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    @JsonProperty("PrimaryEmail")
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @JsonProperty("AlternateEmail")
    public String getAlternateEmail() {
        return alternateEmail;
    }

    @JsonProperty("AlternateEmail")
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    @JsonProperty("OrganizationalID")
    public String getOrganizationalID() {
        return organizationalID;
    }

    @JsonProperty("OrganizationalID")
    public void setOrganizationalID(String organizationalID) {
        this.organizationalID = organizationalID;
    }

    @JsonProperty("AlternateID")
    public String getAlternateID() {
        return alternateID;
    }

    @JsonProperty("AlternateID")
    public void setAlternateID(String alternateID) {
        this.alternateID = alternateID;
    }

    @JsonProperty("Organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("Organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("AlertEmail")
    public String getAlertEmail() {
        return alertEmail;
    }

    @JsonProperty("AlertEmail")
    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("HomePhone")
    public String getHomePhone() {
        return homePhone;
    }

    @JsonProperty("HomePhone")
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @JsonProperty("PrimaryPhone")
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    @JsonProperty("PrimaryPhone")
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    @JsonProperty("WorkPhone")
    public String getWorkPhone() {
        return workPhone;
    }

    @JsonProperty("WorkPhone")
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    @JsonProperty("Pager")
    public String getPager() {
        return pager;
    }

    @JsonProperty("Pager")
    public void setPager(String pager) {
        this.pager = pager;
    }

    @JsonProperty("OtherPhone")
    public String getOtherPhone() {
        return otherPhone;
    }

    @JsonProperty("OtherPhone")
    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    @JsonProperty("MobilePhone")
    public String getMobilePhone() {
        return mobilePhone;
    }

    @JsonProperty("MobilePhone")
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @JsonProperty("Fax")
    public String getFax() {
        return fax;
    }

    @JsonProperty("Fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("DefaultPriorityID")
    public Integer getDefaultPriorityID() {
        return defaultPriorityID;
    }

    @JsonProperty("DefaultPriorityID")
    public void setDefaultPriorityID(Integer defaultPriorityID) {
        this.defaultPriorityID = defaultPriorityID;
    }

    @JsonProperty("DefaultPriorityName")
    public String getDefaultPriorityName() {
        return defaultPriorityName;
    }

    @JsonProperty("DefaultPriorityName")
    public void setDefaultPriorityName(String defaultPriorityName) {
        this.defaultPriorityName = defaultPriorityName;
    }

    @JsonProperty("WorkAddress")
    public String getWorkAddress() {
        return workAddress;
    }

    @JsonProperty("WorkAddress")
    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    @JsonProperty("WorkCity")
    public String getWorkCity() {
        return workCity;
    }

    @JsonProperty("WorkCity")
    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    @JsonProperty("WorkState")
    public String getWorkState() {
        return workState;
    }

    @JsonProperty("WorkState")
    public void setWorkState(String workState) {
        this.workState = workState;
    }

    @JsonProperty("WorkPostalCode")
    public String getWorkPostalCode() {
        return workPostalCode;
    }

    @JsonProperty("WorkPostalCode")
    public void setWorkPostalCode(String workPostalCode) {
        this.workPostalCode = workPostalCode;
    }

    @JsonProperty("WorkCountry")
    public String getWorkCountry() {
        return workCountry;
    }

    @JsonProperty("WorkCountry")
    public void setWorkCountry(String workCountry) {
        this.workCountry = workCountry;
    }

    @JsonProperty("HomeAddress")
    public String getHomeAddress() {
        return homeAddress;
    }

    @JsonProperty("HomeAddress")
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @JsonProperty("HomeCity")
    public String getHomeCity() {
        return homeCity;
    }

    @JsonProperty("HomeCity")
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    @JsonProperty("HomeState")
    public String getHomeState() {
        return homeState;
    }

    @JsonProperty("HomeState")
    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    @JsonProperty("HomePostalCode")
    public String getHomePostalCode() {
        return homePostalCode;
    }

    @JsonProperty("HomePostalCode")
    public void setHomePostalCode(String homePostalCode) {
        this.homePostalCode = homePostalCode;
    }

    @JsonProperty("HomeCountry")
    public String getHomeCountry() {
        return homeCountry;
    }

    @JsonProperty("HomeCountry")
    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    @JsonProperty("ReportsToUID")
    public String getReportsToUID() {
        return reportsToUID;
    }

    @JsonProperty("ReportsToUID")
    public void setReportsToUID(String reportsToUID) {
        this.reportsToUID = reportsToUID;
    }

    @JsonProperty("ReportsToFullName")
    public String getReportsToFullName() {
        return reportsToFullName;
    }

    @JsonProperty("ReportsToFullName")
    public void setReportsToFullName(String reportsToFullName) {
        this.reportsToFullName = reportsToFullName;
    }

    @JsonProperty("ResourcePoolID")
    public Integer getResourcePoolID() {
        return resourcePoolID;
    }

    @JsonProperty("ResourcePoolID")
    public void setResourcePoolID(Integer resourcePoolID) {
        this.resourcePoolID = resourcePoolID;
    }

    @JsonProperty("ResourcePoolName")
    public String getResourcePoolName() {
        return resourcePoolName;
    }

    @JsonProperty("ResourcePoolName")
    public void setResourcePoolName(String resourcePoolName) {
        this.resourcePoolName = resourcePoolName;
    }

    @JsonProperty("TimeZoneID")
    public Integer getTimeZoneID() {
        return timeZoneID;
    }

    @JsonProperty("TimeZoneID")
    public void setTimeZoneID(Integer timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    @JsonProperty("TimeZoneName")
    public String getTimeZoneName() {
        return timeZoneName;
    }

    @JsonProperty("TimeZoneName")
    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    @JsonProperty("TypeID")
    public Integer getTypeID() {
        return typeID;
    }

    @JsonProperty("TypeID")
    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
