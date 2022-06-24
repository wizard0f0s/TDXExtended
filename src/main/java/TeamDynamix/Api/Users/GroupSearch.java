package TeamDynamix.Api.Users;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IsActive",
        "NameLike",
        "HasAppID",
        "HasSystemAppName",
        "AssociatedAppID"
})


public class GroupSearch {
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("NameLike")
    private String nameLike;
    @JsonProperty("HasAppID")
    private Integer hasAppId;
    @JsonProperty("HasSystemAppName")
    private String hasSystemAppName;
    @JsonProperty("AssociatedAppID")
    private Integer associatedAppId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("IsActive")
    public Boolean isActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setActive(Boolean active) {
        isActive = active;
    }

    @JsonProperty("NameLike")
    public String getNameLike() {
        return nameLike;
    }

    @JsonProperty("NameLike")
    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    @JsonProperty("HasAppID")
    public Integer getHasAppId() {
        return hasAppId;
    }

    @JsonProperty("HasAppID")
    public void setHasAppId(Integer hasAppId) {
        this.hasAppId = hasAppId;
    }

    @JsonProperty("HasSystemAppName")
    public String getHasSystemAppName() {
        return hasSystemAppName;
    }

    @JsonProperty("HasSystemAppName")
    public void setHasSystemAppName(String hasSystemAppName) {
        this.hasSystemAppName = hasSystemAppName;
    }

    @JsonProperty("AssociatedAppID")
    public Integer getAssociatedAppId() {
        return associatedAppId;
    }

    @JsonProperty("AssociatedAppID")
    public void setAssociatedAppId(Integer associatedAppId) {
        this.associatedAppId = associatedAppId;
    }
}
