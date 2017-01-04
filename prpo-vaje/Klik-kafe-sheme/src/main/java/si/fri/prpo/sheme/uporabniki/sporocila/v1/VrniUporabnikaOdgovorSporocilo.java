
package si.fri.prpo.sheme.uporabniki.sporocila.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import si.fri.prpo.sheme.uporabniki.v1.UporabnikType;


/**
 * <p>Java class for VrniUporabnikaOdgovorSporocilo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VrniUporabnikaOdgovorSporocilo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="uporabnik" type="{http://prpo.fri.si/sheme/uporabniki/v1}UporabnikType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VrniUporabnikaOdgovorSporocilo", namespace = "http://prpo.fri.si/sheme/uporabniki/sporocila/v1", propOrder = {
    "uporabnik"
})
public class VrniUporabnikaOdgovorSporocilo {

    protected UporabnikType uporabnik;

    /**
     * Gets the value of the uporabnik property.
     * 
     * @return
     *     possible object is
     *     {@link UporabnikType }
     *     
     */
    public UporabnikType getUporabnik() {
        return uporabnik;
    }

    /**
     * Sets the value of the uporabnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link UporabnikType }
     *     
     */
    public void setUporabnik(UporabnikType value) {
        this.uporabnik = value;
    }

}
