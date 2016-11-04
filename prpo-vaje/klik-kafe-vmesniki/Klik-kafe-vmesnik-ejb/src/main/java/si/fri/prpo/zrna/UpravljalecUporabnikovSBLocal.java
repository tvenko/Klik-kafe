package si.fri.prpo.zrna;

import java.io.IOException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

@Local
public interface UpravljalecUporabnikovSBLocal {
	
	void addUser(String username, String name, String surname, String email, int id);
	void deleteUser(int id);
	void returnAll(HttpServletResponse response) throws IOException;
	void getLocation();

}
