
package si.fri.prpo.models;

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
    "Language",
    "ModifiedTime",
    "IsModified",
    "ContentName",
    "Expires",
    "ETag",
    "Data"
})
public class Content {

    @JsonProperty("Language")
    private String language;
    @JsonProperty("ModifiedTime")
    private String modifiedTime;
    @JsonProperty("IsModified")
    private Boolean isModified;
    @JsonProperty("ContentName")
    private String contentName;
    @JsonProperty("Expires")
    private String expires;
    @JsonProperty("ETag")
    private String eTag;
    @JsonProperty("Data")
    private Data data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("Language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("ModifiedTime")
    public String getModifiedTime() {
        return modifiedTime;
    }

    @JsonProperty("ModifiedTime")
    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @JsonProperty("IsModified")
    public Boolean getIsModified() {
        return isModified;
    }

    @JsonProperty("IsModified")
    public void setIsModified(Boolean isModified) {
        this.isModified = isModified;
    }

    @JsonProperty("ContentName")
    public String getContentName() {
        return contentName;
    }

    @JsonProperty("ContentName")
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    @JsonProperty("Expires")
    public String getExpires() {
        return expires;
    }

    @JsonProperty("Expires")
    public void setExpires(String expires) {
        this.expires = expires;
    }

    @JsonProperty("ETag")
    public String getETag() {
        return eTag;
    }

    @JsonProperty("ETag")
    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    @JsonProperty("Data")
    public Data getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(Data data) {
        this.data = data;
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
