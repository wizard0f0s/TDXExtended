package TeamDynamix.Api.CustomAttributes;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "Name",
        "IsActive",
        "DateCreated",
        "DateModified",
        "Order"
})

public class CustomAttributeChoice {

    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("IsActive")
    private boolean isActive;
    @JsonProperty("DateCreated")
    private LocalDate dateCreated;
    @JsonProperty("DateModified")
    private LocalDate dateModified;
    @JsonProperty("Order")
    private Integer order;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("IsActive")
    public boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("DateCreated")
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("DateCreated")
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("DateModified")
    public LocalDate getDateModified() {
        return dateModified;
    }

    @JsonProperty("DateModified")
    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    @JsonProperty("Order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("Order")
    public void setOrder(Integer order) {
        this.order = order;
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
