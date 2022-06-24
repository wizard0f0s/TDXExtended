package TeamDynamix.Api.Apps;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "SecurityRoleId",
        "SecurityRoleName",
        "IsAdministrator",
        "ID",
        "Name",
        "Description",
        "SystemClass",
        "IsDefault",
        "IsActive"
})

public class UserApplication {

    @JsonProperty("SecurityRoleId")
    private String securityRoleId;
    @JsonProperty("SecurityRoleName")
    private String securityRoleName;
    @JsonProperty("IsAdministrator")
    private boolean isAdministrator;
    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("SystemClass")
    private String systemClass;
    @JsonProperty("IsDefault")
    private boolean isDefault;
    @JsonProperty("IsActive")
    private boolean isActive;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("SecurityRoleId")
    public String getSecurityRoleId() {
        return securityRoleId;
    }

    @JsonProperty("SecurityRoleId")
    public void setSecurityRoleId(String securityRoleId) {
        this.securityRoleId = securityRoleId;
    }

    @JsonProperty("SecurityRoleName")
    public String getSecurityRoleName() {
        return securityRoleName;
    }

    @JsonProperty("SecurityRoleName")
    public void setSecurityRoleName(String securityRoleName) {
        this.securityRoleName = securityRoleName;
    }

    @JsonProperty("IsAdministrator")
    public boolean getIsAdministrator() {
        return isAdministrator;
    }

    @JsonProperty("IsAdministrator")
    public void setIsAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

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

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("SystemClass")
    public String getSystemClass() {
        return systemClass;
    }

    @JsonProperty("SystemClass")
    public void setSystemClass(String systemClass) {
        this.systemClass = systemClass;
    }

    @JsonProperty("IsDefault")
    public boolean getIsDefault() {
        return isDefault;
    }

    @JsonProperty("IsDefault")
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @JsonProperty("IsActive")
    public boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
