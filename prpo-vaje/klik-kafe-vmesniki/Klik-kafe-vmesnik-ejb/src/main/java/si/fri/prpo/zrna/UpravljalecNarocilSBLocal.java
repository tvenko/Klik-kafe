package si.fri.prpo.zrna;

import java.io.IOException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

@Local
public interface UpravljalecNarocilSBLocal {
	
	void addOrder(int idUser, int idUporabnik, int idNapitek, String payment, String prepStatus, String prepTime, String item);
	void cancelOrder();
	void returnAll(HttpServletResponse response) throws IOException;
}
