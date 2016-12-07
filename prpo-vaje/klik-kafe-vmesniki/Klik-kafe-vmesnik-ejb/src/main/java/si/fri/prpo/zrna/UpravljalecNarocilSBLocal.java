package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.vaje.entitete.Narocilo;

@Local
public interface UpravljalecNarocilSBLocal {
	
	int addOrder(int idUporabnik, int idKavarna, int prepTime, String prepStatus, String paymentStatus, double totalPrice);
	void addDrinks(int idNarocila, int[] idsNapitka);
	void cancelOrder();
	ArrayList<Narocilo> returnAll();
	void returnOrderId(int id, HttpServletResponse response) throws IOException;
	int getPrepTime(int[] ids);
	double getTotalPrice(int[] ids);
	int[] getNapitekIds(String[] napitki, String size);
	int getIdKavarna(String name);
	Narocilo returnNarociloById(int id);
	String returnText();
}
