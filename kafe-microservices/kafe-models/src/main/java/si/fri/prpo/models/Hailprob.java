
package si.fri.prpo.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "y",
    "updated_text",
    "updated",
    "hail_level",
    "x"
})
public class Hailprob {

    @JsonProperty("y")
    private Integer y;
    @JsonProperty("updated_text")
    private String updatedText;
    @JsonProperty("updated")
    private Integer updated;
    @JsonProperty("hail_level")
    private Integer hailLevel;
    @JsonProperty("x")
    private Integer x;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The y
     */
    @JsonProperty("y")
    public Integer getY() {
        return y;
    }

    /**
     * 
     * @param y
     *     The y
     */
    @JsonProperty("y")
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * 
     * @return
     *     The updatedText
     */
    @JsonProperty("updated_text")
    public String getUpdatedText() {
        return updatedText;
    }

    /**
     * 
     * @param updatedText
     *     The updated_text
     */
    @JsonProperty("updated_text")
    public void setUpdatedText(String updatedText) {
        this.updatedText = updatedText;
    }

    /**
     * 
     * @return
     *     The updated
     */
    @JsonProperty("updated")
    public Integer getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *     The updated
     */
    @JsonProperty("updated")
    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    /**
     * 
     * @return
     *     The hailLevel
     */
    @JsonProperty("hail_level")
    public Integer getHailLevel() {
        return hailLevel;
    }

    /**
     * 
     * @param hailLevel
     *     The hail_level
     */
    @JsonProperty("hail_level")
    public void setHailLevel(Integer hailLevel) {
        this.hailLevel = hailLevel;
    }

    /**
     * 
     * @return
     *     The x
     */
    @JsonProperty("x")
    public Integer getX() {
        return x;
    }

    /**
     * 
     * @param x
     *     The x
     */
    @JsonProperty("x")
    public void setX(Integer x) {
        this.x = x;
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
