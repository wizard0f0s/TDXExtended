package TeamDynamix.Api.Apps;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AppID",
        "Name",
        "Description",
        "Type",
        "AppClass",
        "ExternalUrl",
        "Purpose",
        "Active",
        "PartialUrl"
})

public class OrgApplication {

    @JsonProperty("AppID")
    private Integer appID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("AppClass")
    private String appClass;
    @JsonProperty("ExternalUrl")
    private String externalUrl;
    @JsonProperty("Purpose")
    private String purpose;
    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("PartialUrl")
    private String partialUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("AppID")
    public Integer getAppID() {
        return appID;
    }

    @JsonProperty("AppID")
    public void setAppID(Integer appID) {
        this.appID = appID;
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

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("AppClass")
    public String getAppClass() {
        return appClass;
    }

    @JsonProperty("AppClass")
    public void setAppClass(String appClass) {
        this.appClass = appClass;
    }

    @JsonProperty("ExternalUrl")
    public String getExternalUrl() {
        return externalUrl;
    }

    @JsonProperty("ExternalUrl")
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @JsonProperty("Purpose")
    public String getPurpose() {
        return purpose;
    }

    @JsonProperty("Purpose")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @JsonProperty("Active")
    public boolean isActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(boolean active) {
        this.active = active;
    }

    @JsonProperty("PartialUrl")
    public String getPartialUrl() {
        return partialUrl;
    }

    @JsonProperty("PartialUrl")
    public void setPartialUrl(String partialUrl) {
        this.partialUrl = partialUrl;
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
