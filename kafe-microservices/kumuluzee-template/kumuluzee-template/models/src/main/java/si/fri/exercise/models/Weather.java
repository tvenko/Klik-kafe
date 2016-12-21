
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
    "status",
    "copyright",
    "lon",
    "forecast",
    "radar",
    "lat",
    "hailprob"
})
public class Weather {

    @JsonProperty("status")
    private String status;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("forecast")
    private Forecast forecast;
    @JsonProperty("radar")
    private Radar radar;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("hailprob")
    private Hailprob hailprob;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The copyright
     */
    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    /**
     * 
     * @param copyright
     *     The copyright
     */
    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * 
     * @return
     *     The lon
     */
    @JsonProperty("lon")
    public String getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    @JsonProperty("lon")
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The forecast
     */
    @JsonProperty("forecast")
    public Forecast getForecast() {
        return forecast;
    }

    /**
     * 
     * @param forecast
     *     The forecast
     */
    @JsonProperty("forecast")
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    /**
     * 
     * @return
     *     The radar
     */
    @JsonProperty("radar")
    public Radar getRadar() {
        return radar;
    }

    /**
     * 
     * @param radar
     *     The radar
     */
    @JsonProperty("radar")
    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    /**
     * 
     * @return
     *     The lat
     */
    @JsonProperty("lat")
    public String getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    @JsonProperty("lat")
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The hailprob
     */
    @JsonProperty("hailprob")
    public Hailprob getHailprob() {
        return hailprob;
    }

    /**
     * 
     * @param hailprob
     *     The hailprob
     */
    @JsonProperty("hailprob")
    public void setHailprob(Hailprob hailprob) {
        this.hailprob = hailprob;
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
