
package si.fri.exercise.models;

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
    "updated",
    "rain_level",
    "rain_mmph",
    "updated_text",
    "y",
    "x"
})
public class Radar {

    @JsonProperty("updated")
    private Integer updated;
    @JsonProperty("rain_level")
    private Integer rainLevel;
    @JsonProperty("rain_mmph")
    private Integer rainMmph;
    @JsonProperty("updated_text")
    private String updatedText;
    @JsonProperty("y")
    private Integer y;
    @JsonProperty("x")
    private Integer x;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The rainLevel
     */
    @JsonProperty("rain_level")
    public Integer getRainLevel() {
        return rainLevel;
    }

    /**
     * 
     * @param rainLevel
     *     The rain_level
     */
    @JsonProperty("rain_level")
    public void setRainLevel(Integer rainLevel) {
        this.rainLevel = rainLevel;
    }

    /**
     * 
     * @return
     *     The rainMmph
     */
    @JsonProperty("rain_mmph")
    public Integer getRainMmph() {
        return rainMmph;
    }

    /**
     * 
     * @param rainMmph
     *     The rain_mmph
     */
    @JsonProperty("rain_mmph")
    public void setRainMmph(Integer rainMmph) {
        this.rainMmph = rainMmph;
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
