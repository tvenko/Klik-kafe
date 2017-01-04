
package si.fri.prpo.soap;

import javax.xml.bind.annotation.XmlRegistry;

import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaOdgovorSporocilo;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaRequest;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaResponse;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaZahtevaSporocilo;
import si.fri.prpo.sheme.uporabniki.v1.UporabnikType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the si.fri.prpo.soap.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: si.fri.prpo.soap.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VrniUporabnikaZahtevaSporocilo }
     * 
     */
    public VrniUporabnikaZahtevaSporocilo createVrniUporabnikaZahtevaSporocilo() {
        return new VrniUporabnikaZahtevaSporocilo();
    }

    /**
     * Create an instance of {@link VrniUporabnikaOdgovorSporocilo }
     * 
     */
    public VrniUporabnikaOdgovorSporocilo createVrniUporabnikaOdgovorSporocilo() {
        return new VrniUporabnikaOdgovorSporocilo();
    }

    /**
     * Create an instance of {@link UporabnikType }
     * 
     */
    public UporabnikType createUporabnikType() {
        return new UporabnikType();
    }

    /**
     * Create an instance of {@link VrniUporabnikaRequest }
     * 
     */
    public VrniUporabnikaRequest createVrniUporabnikaRequest() {
        return new VrniUporabnikaRequest();
    }

    /**
     * Create an instance of {@link VrniUporabnikaResponse }
     * 
     */
    public VrniUporabnikaResponse createVrniUporabnikaResponse() {
        return new VrniUporabnikaResponse();
    }

}
