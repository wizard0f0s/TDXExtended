package TeamDynamix.Api.CustomAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "Name",
        "Order",
        "Description",
        "SectionID",
        "SectionName",
        "FieldType",
        "DataType",
        "Choices",
        "IsRequired",
        "IsUpdatable",
        "Value",
        "ValueText",
        "ChoicesText",
        "AssociatedItemIDs"
})

public class CustomAttribute {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Order")
    private Integer order;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("SectionID")
    private Integer sectionId;

    @JsonProperty("SectionName")
    private String sectionName;

    @JsonProperty("FieldType")
    private String fieldType;

    @JsonProperty("DataType")
    private String dataType;

    @JsonProperty("Choices")
    private List<CustomAttributeChoice> choices = null;

    @JsonProperty("IsRequired")
    private boolean isRequired;

    @JsonProperty("IsUpdatable")
    private boolean isUpdatable;

    @JsonProperty("Value")
    private String value;

    @JsonProperty("ValueText")
    private String valueText;

    @JsonProperty("ChoicesText")
    private String choicesText;

    @JsonProperty("AssociatedItemIDs")
    private List<Integer> associatedItemIds = null;

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

    @JsonProperty("Order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("Order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("SectionID")
    public Integer getSectionId() {
        return sectionId;
    }

    @JsonProperty("SectionID")
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @JsonProperty("SectionName")
    public String getSectionName() {
        return sectionName;
    }

    @JsonProperty("SectionName")
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @JsonProperty("FieldType")
    public String getFieldType() {
        return fieldType;
    }

    @JsonProperty("FieldType")
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    @JsonProperty("DataType")
    public String getDataType() {
        return dataType;
    }

    @JsonProperty("DataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @JsonProperty("Choices")
    public List<CustomAttributeChoice> getChoices() {
        return choices;
    }

    @JsonProperty("Choices")
    public void setChoices(List<CustomAttributeChoice> choices) {
        this.choices = choices;
    }

    @JsonProperty("IsRequired")
    public boolean getIsRequired() {
        return isRequired;
    }

    @JsonProperty("IsRequired")
    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    @JsonProperty("IsUpdatable")
    public boolean getIsUpdatable() {
        return isUpdatable;
    }

    @JsonProperty("IsUpdatable")
    public void setIsUpdatable(boolean isUpdatable) {
        this.isUpdatable = isUpdatable;
    }

    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("ValueText")
    public String getValueText() {
        return valueText;
    }

    @JsonProperty("ValueText")
    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    @JsonProperty("ChoicesText")
    public String getChoicesText() {
        return choicesText;
    }

    @JsonProperty("ChoicesText")
    public void setChoicesText(String choicesText) {
        this.choicesText = choicesText;
    }

    @JsonProperty("AssociatedItemIDs")
    public List<Integer> getAssociatedItemIds() {
        return associatedItemIds;
    }

    @JsonProperty("AssociatedItemIDs")
    public void setAssociatedItemIds(List<Integer> associatedItemIds) {
        this.associatedItemIds = associatedItemIds;
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
