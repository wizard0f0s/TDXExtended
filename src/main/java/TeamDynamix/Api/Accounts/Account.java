package TeamDynamix.Api.Accounts;

import TeamDynamix.Api.CustomAttributes.CustomAttribute;
import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "Name",
        "ParentID",
        "ParentName",
        "IsActive",
        "Address1",
        "Address2",
        "Address3",
        "Address4",
        "City",
        "StateName",
        "StateAbbr",
        "PostalCode",
        "Country",
        "Phone",
        "Fax",
        "Url",
        "Notes",
        "CreatedDate",
        "ModifiedDate",
        "Code",
        "IndustryID",
        "IndustryName",
        "ManagerUID",
        "ManagerFullName",
        "Attributes"
})

public class Account {

    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ParentID")
    private Integer parentID;
    @JsonProperty("ParentName")
    private String parentName;
    @JsonProperty("IsActive")
    private boolean isActive;
    @JsonProperty("Address1")
    private String address1;
    @JsonProperty("Address2")
    private String address2;
    @JsonProperty("Address3")
    private String address3;
    @JsonProperty("Address4")
    private String address4;
    @JsonProperty("City")
    private String city;
    @JsonProperty("StateName")
    private String stateName;
    @JsonProperty("StateAbbr")
    private String stateAbbr;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("Fax")
    private String fax;
    @JsonProperty("Url")
    private String url;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("CreatedDate")
    private LocalDate createdDate;
    @JsonProperty("ModifiedDate")
    private LocalDate modifiedDate;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("IndustryID")
    private Integer industryID;
    @JsonProperty("IndustryName")
    private String industryName;
    @JsonProperty("ManagerUID")
    private String managerUID;
    @JsonProperty("ManagerFullName")
    private String managerFullName;
    @JsonProperty("Attributes")
    private List<CustomAttribute> attributes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("ID")
    public Integer getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ParentID")
    public Integer getParentID() {
        return parentID;
    }

    @JsonProperty("ParentID")
    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    @JsonProperty("ParentName")
    public String getParentName() {
        return parentName;
    }

    @JsonProperty("ParentName")
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @JsonProperty("IsActive")
    public boolean isActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setActive(boolean active) {
        isActive = active;
    }

    @JsonProperty("Address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("Address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("Address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("Address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("Address3")
    public String getAddress3() {
        return address3;
    }

    @JsonProperty("Address3")
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @JsonProperty("Address4")
    public String getAddress4() {
        return address4;
    }

    @JsonProperty("Address4")
    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("StateName")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty("StateName")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("StateAbbr")
    public String getStateAbbr() {
        return stateAbbr;
    }

    @JsonProperty("StateAbbr")
    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("Phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("Fax")
    public String getFax() {
        return fax;
    }

    @JsonProperty("Fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("Url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("Url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("Notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("Notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("CreatedDate")
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("CreatedDate")
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("ModifiedDate")
    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("ModifiedDate")
    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("IndustryID")
    public Integer getIndustryID() {
        return industryID;
    }

    @JsonProperty("IndustryID")
    public void setIndustryID(Integer industryID) {
        this.industryID = industryID;
    }

    @JsonProperty("IndustryName")
    public String getIndustryName() {
        return industryName;
    }

    @JsonProperty("IndustryName")
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    @JsonProperty("ManagerUID")
    public String getManagerUID() {
        return managerUID;
    }

    @JsonProperty("ManagerUID")
    public void setManagerUID(String managerUID) {
        this.managerUID = managerUID;
    }

    @JsonProperty("ManagerFullName")
    public String getManagerFullName() {
        return managerFullName;
    }

    @JsonProperty("ManagerFullName")
    public void setManagerFullName(String managerFullName) {
        this.managerFullName = managerFullName;
    }

    @JsonProperty("Attributes")
    public List<CustomAttribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("Attributes")
    public void setAttributes(List<CustomAttribute> attributes) {
        this.attributes = attributes;
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
