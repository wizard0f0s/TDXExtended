package TeamDynamix.Api.Apps;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Anchor",
        "Href",
        "Icon",
        "BaseURL",
        "Component"
})

public class NavItem {

    @JsonProperty("Anchor")
    private String anchor;
    @JsonProperty("Href")
    private String href;
    @JsonProperty("Icon")
    private String icon;
    @JsonProperty("BaseURL")
    private String baseURL;
    @JsonProperty("Component")
    private String component;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("Anchor")
    public String getAnchor() {
        return anchor;
    }

    @JsonProperty("Anchor")
    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    @JsonProperty("Href")
    public String getHref() {
        return href;
    }

    @JsonProperty("Href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("Icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("Icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("BaseURL")
    public String getBaseURL() {
        return baseURL;
    }

    @JsonProperty("BaseURL")
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @JsonProperty("Component")
    public String getComponent() {
        return component;
    }

    @JsonProperty("Component")
    public void setComponent(String component) {
        this.component = component;
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
