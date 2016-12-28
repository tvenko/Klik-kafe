package si.fri.prpo.zrna;

import java.util.List;

import javax.ejb.Remote;

import si.fri.prpo.vaje.entitete.Uporabnik;

@Remote
public interface UpravljalecUporabnikovSBRemote {
	public String getResponse();
	public List<Uporabnik> oddaljenoVrni();
}
