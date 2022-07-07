package TeamDynamix.Api.Users;

import TeamDynamix.Api.Apps.UserApplication;
import TeamDynamix.Api.CustomAttributes.CustomAttribute;
import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UID",
        "ReferenceID",
        "BEID",
        "BEIDInt",
        "IsActive",
        "IsConfidential",
        "UserName",
        "FullName",
        "FirstName",
        "LastName",
        "MiddleName",
        "Salutation",
        "Nickname",
        "DefaultAccountID",
        "DefaultAccountName",
        "PrimaryEmail",
        "AlternateEmail",
        "ExternalID",
        "AlternateID",
        "Applications",
        "SecurityRoleName",
        "SecurityRoleID",
        "Permissions",
        "OrgApplications",
        "PrimaryClientPortalApplicationID",
        "GroupIDs",
        "AlertEmail",
        "ProfileImageFileName",
        "Company",
        "Title",
        "HomePhone",
        "PrimaryPhone",
        "WorkPhone",
        "Pager",
        "OtherPhone",
        "MobilePhone",
        "Fax",
        "DefaultPriorityID",
        "DefaultPriorityName",
        "AboutMe",
        "WorkAddress",
        "WorkCity",
        "WorkState",
        "WorkZip",
        "WorkCountry",
        "HomeAddress",
        "HomeCity",
        "HomeState",
        "HomeZip",
        "HomeCountry",
        "LocationID",
        "LocationName",
        "LocationRoomID",
        "LocationRoomName",
        "DefaultRate",
        "CostRate",
        "IsEmployee",
        "WorkableHours",
        "IsCapacityManaged",
        "ReportTimeAfterDate",
        "EndDate",
        "ShouldReportTime",
        "ReportsToUID",
        "ReportsToFullName",
        "ResourcePoolID",
        "ResourcePoolName",
        "TZID",
        "TZName",
        "TypeID",
        "AuthenticationUserName",
        "AuthenticationProviderID",
        "Attributes",
        "IMProvider",
        "IMHandle"
})
@Generated("jsonschema2pojo")
public class User {
    @JsonProperty("UID")
    private String uid;
    @JsonProperty("ReferenceID")
    private Integer referenceID;
    @JsonProperty("BEID")
    private String beid;
    @JsonProperty("BEIDInt")
    private Integer bEIDInt;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("IsConfidential")
    private Boolean isConfidential;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("FullName")
    private String fullName;
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
    @JsonProperty("DefaultAccountID")
    private Integer defaultAccountID;
    @JsonProperty("DefaultAccountName")
    private String defaultAccountName;
    @JsonProperty("PrimaryEmail")
    private String primaryEmail;
    @JsonProperty("AlternateEmail")
    private String alternateEmail;
    @JsonProperty("ExternalID")
    private String externalID;
    @JsonProperty("AlternateID")
    private String alternateID;
    @JsonProperty("Applications")
    private List<String> applications = null;
    @JsonProperty("SecurityRoleName")
    private String securityRoleName;
    @JsonProperty("SecurityRoleID")
    private String securityRoleID;
    @JsonProperty("Permissions")
    private List<String> permissions = null;

    @JsonProperty("OrgApplications")
    private List<UserApplication> orgApplications = null;
    @JsonProperty("PrimaryClientPortalApplicationID")
    private Integer primaryClientPortalApplicationID;
    @JsonProperty("GroupIDs")
    private List<Integer> groupIDs = null;
    @JsonProperty("AlertEmail")
    private String alertEmail;
    @JsonProperty("ProfileImageFileName")
    private String profileImageFileName;
    @JsonProperty("Company")
    private String company;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("HomePhone")
    private String homePhone;
    @JsonProperty("PrimaryPhone")
    private String primaryPhone;
    @JsonProperty("WorkPhone")
    private String workPhone;
    @JsonProperty("Pager")
    private String pager;
    @JsonProperty("OtherPhone")
    private String otherPhone;
    @JsonProperty("MobilePhone")
    private String mobilePhone;
    @JsonProperty("Fax")
    private String fax;
    @JsonProperty("DefaultPriorityID")
    private Integer defaultPriorityID;
    @JsonProperty("DefaultPriorityName")
    private String defaultPriorityName;
    @JsonProperty("AboutMe")
    private String aboutMe;
    @JsonProperty("WorkAddress")
    private String workAddress;
    @JsonProperty("WorkCity")
    private String workCity;
    @JsonProperty("WorkState")
    private String workState;
    @JsonProperty("WorkZip")
    private String workZip;
    @JsonProperty("WorkCountry")
    private String workCountry;
    @JsonProperty("HomeAddress")
    private String homeAddress;
    @JsonProperty("HomeCity")
    private String homeCity;
    @JsonProperty("HomeState")
    private String homeState;
    @JsonProperty("HomeZip")
    private String homeZip;
    @JsonProperty("HomeCountry")
    private String homeCountry;
    @JsonProperty("LocationID")
    private Integer locationID;
    @JsonProperty("LocationName")
    private String locationName;
    @JsonProperty("LocationRoomID")
    private Integer locationRoomID;
    @JsonProperty("LocationRoomName")
    private String locationRoomName;
    @JsonProperty("DefaultRate")
    private Double defaultRate;
    @JsonProperty("CostRate")
    private Double costRate;
    @JsonProperty("IsEmployee")
    private Boolean isEmployee;
    @JsonProperty("WorkableHours")
    private Double workableHours;
    @JsonProperty("IsCapacityManaged")
    private Boolean isCapacityManaged;
    @JsonProperty("ReportTimeAfterDate")
    private LocalDate reportTimeAfterDate;
    @JsonProperty("EndDate")
    private LocalDate endDate;
    @JsonProperty("ShouldReportTime")
    private Boolean shouldReportTime;
    @JsonProperty("ReportsToUID")
    private String reportsToUID;
    @JsonProperty("ReportsToFullName")
    private String reportsToFullName;
    @JsonProperty("ResourcePoolID")
    private Integer resourcePoolID;
    @JsonProperty("ResourcePoolName")
    private String resourcePoolName;
    @JsonProperty("TZID")
    private Integer tzid;
    @JsonProperty("TZName")
    private String tZName;

    //This type should be UserType once that is built
    /*
     * None = 0
     * User = 1
     * Customer = 2
     * ResourcePlaceholder = 8
     * ServiceAccount = 9
     */
    @JsonProperty("TypeID")
    private Integer typeID;
    @JsonProperty("AuthenticationUserName")
    private String authenticationUserName;
    @JsonProperty("AuthenticationProviderID")
    private Integer authenticationProviderID;

    @JsonProperty("Attributes")
    private List<CustomAttribute> attributes = null;
    @JsonProperty("IMProvider")
    private String iMProvider;
    @JsonProperty("IMHandle")
    private String iMHandle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("BEID")
    public String getBeid() {
        return beid;
    }

    @JsonProperty("BEID")
    public void setBeid(String beid) {
        this.beid = beid;
    }

    @JsonProperty("BEIDInt")
    public Integer getBEIDInt() {
        return bEIDInt;
    }

    @JsonProperty("BEIDInt")
    public void setBEIDInt(Integer bEIDInt) {
        this.bEIDInt = bEIDInt;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("IsConfidential")
    public Boolean getIsConfidential() {
        return isConfidential;
    }

    @JsonProperty("IsConfidential")
    public void setIsConfidential(Boolean isConfidential) {
        this.isConfidential = isConfidential;
    }

    @JsonProperty("UserName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("UserName")
    public void setUserName(String userName) {
        this.userName = userName;
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

    @JsonProperty("Applications")
    public List<String> getApplications() {
        return applications;
    }

    @JsonProperty("Applications")
    public void setApplications(List<String> applications) {
        this.applications = applications;
    }

    @JsonProperty("SecurityRoleName")
    public String getSecurityRoleName() {
        return securityRoleName;
    }

    @JsonProperty("SecurityRoleName")
    public void setSecurityRoleName(String securityRoleName) {
        this.securityRoleName = securityRoleName;
    }

    @JsonProperty("SecurityRoleID")
    public String getSecurityRoleID() {
        return securityRoleID;
    }

    @JsonProperty("SecurityRoleID")
    public void setSecurityRoleID(String securityRoleID) {
        this.securityRoleID = securityRoleID;
    }

    @JsonProperty("Permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    @JsonProperty("Permissions")
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @JsonProperty("OrgApplications")
    public List<UserApplication> getOrgApplications() {
        return orgApplications;
    }

    @JsonProperty("OrgApplications")
    public void setOrgApplications(List<UserApplication> orgApplications) {
        this.orgApplications = orgApplications;
    }

    @JsonProperty("PrimaryClientPortalApplicationID")
    public Integer getPrimaryClientPortalApplicationID() {
        return primaryClientPortalApplicationID;
    }

    @JsonProperty("PrimaryClientPortalApplicationID")
    public void setPrimaryClientPortalApplicationID(Integer primaryClientPortalApplicationID) {
        this.primaryClientPortalApplicationID = primaryClientPortalApplicationID;
    }

    @JsonProperty("GroupIDs")
    public List<Integer> getGroupIDs() {
        return groupIDs;
    }

    @JsonProperty("GroupIDs")
    public void setGroupIDs(List<Integer> groupIDs) {
        this.groupIDs = groupIDs;
    }

    @JsonProperty("AlertEmail")
    public String getAlertEmail() {
        return alertEmail;
    }

    @JsonProperty("AlertEmail")
    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }

    @JsonProperty("ProfileImageFileName")
    public String getProfileImageFileName() {
        return profileImageFileName;
    }

    @JsonProperty("ProfileImageFileName")
    public void setProfileImageFileName(String profileImageFileName) {
        this.profileImageFileName = profileImageFileName;
    }

    @JsonProperty("Company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("Company")
    public void setCompany(String company) {
        this.company = company;
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

    @JsonProperty("AboutMe")
    public String getAboutMe() {
        return aboutMe;
    }

    @JsonProperty("AboutMe")
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
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

    @JsonProperty("WorkZip")
    public String getWorkZip() {
        return workZip;
    }

    @JsonProperty("WorkZip")
    public void setWorkZip(String workZip) {
        this.workZip = workZip;
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

    @JsonProperty("HomeZip")
    public String getHomeZip() {
        return homeZip;
    }

    @JsonProperty("HomeZip")
    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    @JsonProperty("HomeCountry")
    public String getHomeCountry() {
        return homeCountry;
    }

    @JsonProperty("HomeCountry")
    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    @JsonProperty("LocationID")
    public Integer getLocationID() {
        return locationID;
    }

    @JsonProperty("LocationID")
    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    @JsonProperty("LocationName")
    public String getLocationName() {
        return locationName;
    }

    @JsonProperty("LocationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @JsonProperty("LocationRoomID")
    public Integer getLocationRoomID() {
        return locationRoomID;
    }

    @JsonProperty("LocationRoomID")
    public void setLocationRoomID(Integer locationRoomID) {
        this.locationRoomID = locationRoomID;
    }

    @JsonProperty("LocationRoomName")
    public String getLocationRoomName() {
        return locationRoomName;
    }

    @JsonProperty("LocationRoomName")
    public void setLocationRoomName(String locationRoomName) {
        this.locationRoomName = locationRoomName;
    }

    @JsonProperty("DefaultRate")
    public Double getDefaultRate() {
        return defaultRate;
    }

    @JsonProperty("DefaultRate")
    public void setDefaultRate(Double defaultRate) {
        this.defaultRate = defaultRate;
    }

    @JsonProperty("CostRate")
    public Double getCostRate() {
        return costRate;
    }

    @JsonProperty("CostRate")
    public void setCostRate(Double costRate) {
        this.costRate = costRate;
    }

    @JsonProperty("IsEmployee")
    public Boolean getIsEmployee() {
        return isEmployee;
    }

    @JsonProperty("IsEmployee")
    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    @JsonProperty("WorkableHours")
    public Double getWorkableHours() {
        return workableHours;
    }

    @JsonProperty("WorkableHours")
    public void setWorkableHours(Double workableHours) {
        this.workableHours = workableHours;
    }

    @JsonProperty("IsCapacityManaged")
    public Boolean getIsCapacityManaged() {
        return isCapacityManaged;
    }

    @JsonProperty("IsCapacityManaged")
    public void setIsCapacityManaged(Boolean isCapacityManaged) {
        this.isCapacityManaged = isCapacityManaged;
    }

    @JsonProperty("ReportTimeAfterDate")
    public LocalDate getReportTimeAfterDate() {
        return reportTimeAfterDate;
    }

    @JsonProperty("ReportTimeAfterDate")
    public void setReportTimeAfterDate(LocalDate reportTimeAfterDate) {
        this.reportTimeAfterDate = reportTimeAfterDate;
    }

    @JsonProperty("EndDate")
    public LocalDate getEndDate() {
        return endDate;
    }

    @JsonProperty("EndDate")
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("ShouldReportTime")
    public Boolean getShouldReportTime() {
        return shouldReportTime;
    }

    @JsonProperty("ShouldReportTime")
    public void setShouldReportTime(Boolean shouldReportTime) {
        this.shouldReportTime = shouldReportTime;
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

    @JsonProperty("TZID")
    public Integer getTzid() {
        return tzid;
    }

    @JsonProperty("TZID")
    public void setTzid(Integer tzid) {
        this.tzid = tzid;
    }

    @JsonProperty("TZName")
    public String getTZName() {
        return tZName;
    }

    @JsonProperty("TZName")
    public void setTZName(String tZName) {
        this.tZName = tZName;
    }

    @JsonProperty("TypeID")
    public Integer getTypeID() {
        return typeID;
    }

    @JsonProperty("TypeID")
    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    @JsonProperty("AuthenticationUserName")
    public String getAuthenticationUserName() {
        return authenticationUserName;
    }

    @JsonProperty("AuthenticationUserName")
    public void setAuthenticationUserName(String authenticationUserName) {
        this.authenticationUserName = authenticationUserName;
    }

    @JsonProperty("AuthenticationProviderID")
    public Integer getAuthenticationProviderID() {
        return authenticationProviderID;
    }

    @JsonProperty("AuthenticationProviderID")
    public void setAuthenticationProviderID(Integer authenticationProviderID) {
        this.authenticationProviderID = authenticationProviderID;
    }

    @JsonProperty("Attributes")
    public List<CustomAttribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("Attributes")
    public void setAttributes(List<CustomAttribute> attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("IMProvider")
    public String getIMProvider() {
        return iMProvider;
    }

    @JsonProperty("IMProvider")
    public void setIMProvider(String iMProvider) {
        this.iMProvider = iMProvider;
    }

    @JsonProperty("IMHandle")
    public String getIMHandle() {
        return iMHandle;
    }

    @JsonProperty("IMHandle")
    public void setIMHandle(String iMHandle) {
        this.iMHandle = iMHandle;
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
