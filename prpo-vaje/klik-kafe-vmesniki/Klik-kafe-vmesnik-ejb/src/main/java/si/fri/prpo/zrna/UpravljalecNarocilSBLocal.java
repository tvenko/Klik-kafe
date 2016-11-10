package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.vaje.narocanje.entitete.Napitek;

@Local
public interface UpravljalecNarocilSBLocal {
	
	void addOrder(int idUser, int idUporabnik, int idNapitek, String payment, String prepStatus, String prepTime, String item);
	void cancelOrder();
	void returnAll(HttpServletResponse response) throws IOException;
	void returnOrderId(int id, HttpServletResponse response) throws IOException;
	int getPrepTime(int[] ids);
	double getTotalPrice(int[] ids);
	int[] getNapitekIds(String[] napitki, String size);
	int getIdKavarna(String name);
}
