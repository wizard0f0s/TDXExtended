package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "Name",
        "Description",
        "IsActive",
        "ExternalID",
        "CreatedDate",
        "ModifiedDate",
        "PlatformApplications"
})

public class Group {

    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("ExternalID")
    private String externalID;
    @JsonProperty("CreatedDate")
    private LocalDate createdDate;
    @JsonProperty("ModifiedDate")
    private LocalDate modifiedDate;
    @JsonProperty("PlatformApplications")
    private List<GroupApplication> platformApplications;
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

    @JsonProperty("IsActive")
    public Boolean isActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setActive(Boolean active) {
        isActive = active;
    }

    @JsonProperty("ExternalID")
    public String getExternalID() {
        return externalID;
    }

    @JsonProperty("ExternalID")
    public void setExternalID(String externalID) {
        this.externalID = externalID;
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

    @JsonProperty("PlatformApplications")
    public List<GroupApplication> getPlatformApplications() {
        return platformApplications;
    }

    @JsonProperty("PlatformApplications")
    public void setPlatformApplications(List<GroupApplication> platformApplications) {
        this.platformApplications = platformApplications;
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
