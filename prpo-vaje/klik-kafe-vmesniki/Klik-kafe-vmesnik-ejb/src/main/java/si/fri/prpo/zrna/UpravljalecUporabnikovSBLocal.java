package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

import si.fri.prpo.vaje.entitete.Napitek;
import si.fri.prpo.vaje.entitete.Uporabnik;

@Local
public interface UpravljalecUporabnikovSBLocal {
	
	void addUser(String username, String name, String surname, String email, Double latit, Double longit);
	void deleteUser(String name);
	void getLocation();
	int getUserId(String name);
	
	Uporabnik getUser(int id);
	int addUser(Uporabnik newUser);
	int deleteUser(int id);
	int updateUser(int id, HttpHeaders headers);
	ArrayList<Uporabnik> returnAll();
	
}
