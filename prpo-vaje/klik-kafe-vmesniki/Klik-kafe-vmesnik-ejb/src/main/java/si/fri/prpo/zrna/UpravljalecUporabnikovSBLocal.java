package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.vaje.entitete.Napitek;
import si.fri.prpo.vaje.entitete.Uporabnik;

@Local
public interface UpravljalecUporabnikovSBLocal {
	
	void addUser(String username, String name, String surname, String email, Double latit, Double longit);
	void deleteUser(String name);
	ArrayList<Uporabnik> returnAll();
	void getLocation();
	int getUserId(String name);
	Uporabnik getUser(int id);
}
