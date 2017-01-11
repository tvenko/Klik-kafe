package si.fri.prpo.soap.v1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaRequest;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaResponse;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikeRequest;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikeResponse;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2017-01-11T15:49:31+01:00
 * Generated source version: 3.1.6
 * 
 */
@WebService(targetNamespace = "http://prpo.fri.si/storitve/uporabniki/v1", name = "UporabnikiPort")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UporabnikiPort {

    @WebMethod(action = "http://prpo.fri.si/storitve/uporabniki/v1")
    @WebResult(name = "vrniUporabnikeResponse", targetNamespace = "http://prpo.fri.si/storitve/uporabniki/v1", partName = "parameters")
    public VrniUporabnikeResponse vrniUporabnike(
        @WebParam(partName = "parameters", name = "vrniUporabnikeRequest", targetNamespace = "http://prpo.fri.si/storitve/uporabniki/v1")
        VrniUporabnikeRequest parameters
    );

    @WebMethod(action = "http://prpo.fri.si/storitve/uporabniki/v1")
    @WebResult(name = "vrniUporabnikaResponse", targetNamespace = "http://prpo.fri.si/storitve/uporabniki/v1", partName = "parameters")
    public VrniUporabnikaResponse vrniUporabnika(
        @WebParam(partName = "parameters", name = "vrniUporabnikaRequest", targetNamespace = "http://prpo.fri.si/storitve/uporabniki/v1")
        VrniUporabnikaRequest parameters
    );
}