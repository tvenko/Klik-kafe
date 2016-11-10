package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.vaje.entitete.Napitek;

@Local
public interface UpravljalecNarocilSBLocal {
	
	void addOrder(int idUporabnik, int idKavarna, int prepTime, String prepStatus, String paymentStatus, double totalPrice);
	void addDrinks(int idNarocila, int[] idsNapitka);
	void cancelOrder();
	void returnAll(HttpServletResponse response) throws IOException;
	void returnOrderId(int id, HttpServletResponse response) throws IOException;
	int getPrepTime(int[] ids);
	double getTotalPrice(int[] ids);
	int[] getNapitekIds(String[] napitki, String size);
	int getIdKavarna(String name);
}
