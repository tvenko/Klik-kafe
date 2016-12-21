
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
    "Prioriteta",
    "y_wgs",
    "Title",
    "CrsId",
    "isMejniPrehod",
    "Cesta",
    "Updated",
    "IconW",
    "Description",
    "ContentName",
    "IsRoadClosed",
    "Stacionaza",
    "Odsek",
    "IconH",
    "Icon",
    "x_wgs",
    "SmerStacionaza",
    "PrioritetaCeste",
    "VeljavnostOd",
    "Y",
    "X",
    "SideContent",
    "Kategorija",
    "VeljavnostDo",
    "Id"
})
public class Item {

    @JsonProperty("Prioriteta")
    private Integer prioriteta;
    @JsonProperty("y_wgs")
    private Double yWgs;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("CrsId")
    private String crsId;
    @JsonProperty("isMejniPrehod")
    private Boolean isMejniPrehod;
    @JsonProperty("Cesta")
    private String cesta;
    @JsonProperty("Updated")
    private String updated;
    @JsonProperty("IconW")
    private Integer iconW;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ContentName")
    private String contentName;
    @JsonProperty("IsRoadClosed")
    private Boolean isRoadClosed;
    @JsonProperty("Stacionaza")
    private Double stacionaza;
    @JsonProperty("Odsek")
    private String odsek;
    @JsonProperty("IconH")
    private Integer iconH;
    @JsonProperty("Icon")
    private String icon;
    @JsonProperty("x_wgs")
    private Double xWgs;
    @JsonProperty("SmerStacionaza")
    private Integer smerStacionaza;
    @JsonProperty("PrioritetaCeste")
    private Integer prioritetaCeste;
    @JsonProperty("VeljavnostOd")
    private String veljavnostOd;
    @JsonProperty("Y")
    private Double y;
    @JsonProperty("X")
    private Double x;
    @JsonProperty("SideContent")
    private String sideContent;
    @JsonProperty("Kategorija")
    private String kategorija;
    @JsonProperty("VeljavnostDo")
    private String veljavnostDo;
    @JsonProperty("Id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Prioriteta")
    public Integer getPrioriteta() {
        return prioriteta;
    }

    @JsonProperty("Prioriteta")
    public void setPrioriteta(Integer prioriteta) {
        this.prioriteta = prioriteta;
    }

    @JsonProperty("y_wgs")
    public Double getYWgs() {
        return yWgs;
    }

    @JsonProperty("y_wgs")
    public void setYWgs(Double yWgs) {
        this.yWgs = yWgs;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("CrsId")
    public String getCrsId() {
        return crsId;
    }

    @JsonProperty("CrsId")
    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @JsonProperty("isMejniPrehod")
    public Boolean getIsMejniPrehod() {
        return isMejniPrehod;
    }

    @JsonProperty("isMejniPrehod")
    public void setIsMejniPrehod(Boolean isMejniPrehod) {
        this.isMejniPrehod = isMejniPrehod;
    }

    @JsonProperty("Cesta")
    public String getCesta() {
        return cesta;
    }

    @JsonProperty("Cesta")
    public void setCesta(String cesta) {
        this.cesta = cesta;
    }

    @JsonProperty("Updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("Updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("IconW")
    public Integer getIconW() {
        return iconW;
    }

    @JsonProperty("IconW")
    public void setIconW(Integer iconW) {
        this.iconW = iconW;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("ContentName")
    public String getContentName() {
        return contentName;
    }

    @JsonProperty("ContentName")
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    @JsonProperty("IsRoadClosed")
    public Boolean getIsRoadClosed() {
        return isRoadClosed;
    }

    @JsonProperty("IsRoadClosed")
    public void setIsRoadClosed(Boolean isRoadClosed) {
        this.isRoadClosed = isRoadClosed;
    }

    @JsonProperty("Stacionaza")
    public Double getStacionaza() {
        return stacionaza;
    }

    @JsonProperty("Stacionaza")
    public void setStacionaza(Double stacionaza) {
        this.stacionaza = stacionaza;
    }

    @JsonProperty("Odsek")
    public String getOdsek() {
        return odsek;
    }

    @JsonProperty("Odsek")
    public void setOdsek(String odsek) {
        this.odsek = odsek;
    }

    @JsonProperty("IconH")
    public Integer getIconH() {
        return iconH;
    }

    @JsonProperty("IconH")
    public void setIconH(Integer iconH) {
        this.iconH = iconH;
    }

    @JsonProperty("Icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("Icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("x_wgs")
    public Double getXWgs() {
        return xWgs;
    }

    @JsonProperty("x_wgs")
    public void setXWgs(Double xWgs) {
        this.xWgs = xWgs;
    }

    @JsonProperty("SmerStacionaza")
    public Integer getSmerStacionaza() {
        return smerStacionaza;
    }

    @JsonProperty("SmerStacionaza")
    public void setSmerStacionaza(Integer smerStacionaza) {
        this.smerStacionaza = smerStacionaza;
    }

    @JsonProperty("PrioritetaCeste")
    public Integer getPrioritetaCeste() {
        return prioritetaCeste;
    }

    @JsonProperty("PrioritetaCeste")
    public void setPrioritetaCeste(Integer prioritetaCeste) {
        this.prioritetaCeste = prioritetaCeste;
    }

    @JsonProperty("VeljavnostOd")
    public String getVeljavnostOd() {
        return veljavnostOd;
    }

    @JsonProperty("VeljavnostOd")
    public void setVeljavnostOd(String veljavnostOd) {
        this.veljavnostOd = veljavnostOd;
    }

    @JsonProperty("Y")
    public Double getY() {
        return y;
    }

    @JsonProperty("Y")
    public void setY(Double y) {
        this.y = y;
    }

    @JsonProperty("X")
    public Double getX() {
        return x;
    }

    @JsonProperty("X")
    public void setX(Double x) {
        this.x = x;
    }

    @JsonProperty("SideContent")
    public String getSideContent() {
        return sideContent;
    }

    @JsonProperty("SideContent")
    public void setSideContent(String sideContent) {
        this.sideContent = sideContent;
    }

    @JsonProperty("Kategorija")
    public String getKategorija() {
        return kategorija;
    }

    @JsonProperty("Kategorija")
    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    @JsonProperty("VeljavnostDo")
    public String getVeljavnostDo() {
        return veljavnostDo;
    }

    @JsonProperty("VeljavnostDo")
    public void setVeljavnostDo(String veljavnostDo) {
        this.veljavnostDo = veljavnostDo;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
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
