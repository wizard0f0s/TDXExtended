package TeamDynamix.Api.Apps;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "Name",
        "Description",
        "SystemClass",
        "IsDefault",
        "IsActive"
})

public class Application {

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
    public boolean isDefault() {
        return isDefault;
    }

    @JsonProperty("IsDefault")
    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @JsonProperty("IsActive")
    public boolean isActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setActive(boolean active) {
        isActive = active;
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
