package si.fri.prpo.zrna;

import javax.ejb.Local;

@Local
public interface UpravljalecUporabnikovSBLocal {
	
	void dodajUporabnika(String username, String name, String surname, String email, int id);
	void odstraniUporabnika(int id);

}
