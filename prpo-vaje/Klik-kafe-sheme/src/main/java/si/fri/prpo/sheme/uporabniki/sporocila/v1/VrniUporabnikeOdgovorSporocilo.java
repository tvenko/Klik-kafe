
package si.fri.prpo.sheme.uporabniki.sporocila.v1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import si.fri.prpo.sheme.uporabniki.v1.UporabnikType;


/**
 * <p>Java class for VrniUporabnikeOdgovorSporocilo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VrniUporabnikeOdgovorSporocilo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="uporabnik" type="{http://prpo.fri.si/sheme/uporabniki/v1}UporabnikType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VrniUporabnikeOdgovorSporocilo", namespace = "http://prpo.fri.si/sheme/uporabniki/sporocila/v1", propOrder = {
    "uporabnik"
})
public class VrniUporabnikeOdgovorSporocilo {

    protected List<UporabnikType> uporabnik;

    /**
     * Gets the value of the uporabnik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uporabnik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUporabnik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UporabnikType }
     * 
     * 
     */
    public List<UporabnikType> getUporabnik() {
        if (uporabnik == null) {
            uporabnik = new ArrayList<UporabnikType>();
        }
        return this.uporabnik;
    }

}
