package TeamDynamix.Api.Accounts;

import TeamDynamix.Api.CustomAttributes.CustomAttribute;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "SearchText",
        "ManagerUids",
        "CustomAttributes",
        "IsActive",
        "MaxResults",
        "ParentAccountID",
        "ParentAccountName"
})

public class AccountSearch {

    @JsonProperty("SearchText")
    private String searchText;
    @JsonProperty("ManagerUids")
    private List<String> managerUids;
    @JsonProperty("CustomAttributes")
    private List<TeamDynamix.Api.CustomAttributes.CustomAttribute> customAttributes;
    @JsonProperty("IsActive")
    private boolean isActive;
    @JsonProperty("MaxResults")
    private Integer maxResults;
    @JsonProperty("ParentAccountID")
    private Integer parentAccountID;
    @JsonProperty("ParentAccountName")
    private String parentAccountName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("SearchText")
    public String getSearchText() {
        return searchText;
    }

    @JsonProperty("SearchText")
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @JsonProperty("ManagerUids")
    public List<String> getManagerUids() {
        return managerUids;
    }

    @JsonProperty("ManagerUids")
    public void setManagerUids(List<String> managerUids) {
        this.managerUids = managerUids;
    }

    @JsonProperty("CustomAttributes")
    public List<CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    @JsonProperty("CustomAttributes")
    public void setCustomAttributes(List<CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
    }

    @JsonProperty("IsActive")
    public boolean isActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setActive(boolean active) {
        isActive = active;
    }

    @JsonProperty("MaxResults")
    public Integer getMaxResults() {
        return maxResults;
    }

    @JsonProperty("MaxResults")
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    @JsonProperty("ParentAccountID")
    public Integer getParentAccountID() {
        return parentAccountID;
    }

    @JsonProperty("ParentAccountID")
    public void setParentAccountID(Integer parentAccountID) {
        this.parentAccountID = parentAccountID;
    }

    @JsonProperty("ParentAccountName")
    public String getParentAccountName() {
        return parentAccountName;
    }

    @JsonProperty("ParentAccountName")
    public void setParentAccountName(String parentAccountName) {
        this.parentAccountName = parentAccountName;
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
