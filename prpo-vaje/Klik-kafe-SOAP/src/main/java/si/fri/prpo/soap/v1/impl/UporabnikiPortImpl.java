package si.fri.prpo.soap.v1.impl;


import javax.ejb.EJB;
import javax.jws.WebService;

import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaOdgovorSporocilo;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaRequest;
import si.fri.prpo.sheme.uporabniki.sporocila.v1.VrniUporabnikaResponse;
import si.fri.prpo.sheme.uporabniki.v1.UporabnikType;
import si.fri.prpo.soap.UporabnikiPort;
import si.fri.prpo.vaje.entitete.Uporabnik;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;

@WebService(serviceName = "Uporabniki", endpointInterface = "si.fri.prpo.soap.v1.UporabnikiPort", targetNamespace = "http://prpo.fri.si/storitve/uporabniki/v1")
public class UporabnikiPortImpl implements UporabnikiPort {
	
	@EJB
	private UpravljalecUporabnikovSBLocal uu;
	
	public VrniUporabnikaResponse vrniUporabnika(VrniUporabnikaRequest parameters) {
		VrniUporabnikaResponse uporabnik = new VrniUporabnikaResponse();
		VrniUporabnikaOdgovorSporocilo sporocilo = new VrniUporabnikaOdgovorSporocilo();
		UporabnikType vrni = new UporabnikType();
		Uporabnik u = uu.getUser(parameters.getInput().getId());
		vrni.setId(u.getId());
		vrni.setIme(u.getName());
		vrni.setPriimek(u.getSurname());
		vrni.setEmail(u.getEmail());
		vrni.setUsername(u.getUsername());
		vrni.setLatitude(u.getLatitude());
		vrni.setLongitude(u.getLongitude());
		sporocilo.setUporabnik(vrni);
		uporabnik.setOutput(sporocilo);
		return uporabnik;
	}
}