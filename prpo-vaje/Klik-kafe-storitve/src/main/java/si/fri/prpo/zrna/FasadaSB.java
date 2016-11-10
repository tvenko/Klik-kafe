package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.vaje.entitete.Uporabnik;

/**
 * Session Bean implementation class FasadaSB
 */
@Stateless
@LocalBean
public class FasadaSB implements FasadaSBRemote, FasadaSBLocal {
	@EJB
	private UpravljalecUporabnikovSBLocal uu;
	@EJB
	private UpravljalecNarocilSBLocal un;
	@EJB
	private UpravljalecObvsetilSBLocal uo;
    /**
     * Default constructor. 
     */
	
    public FasadaSB() {
        // TODO Auto-generated constructor stub
    	//this.response = response;
    }

	@Override
	public void addUser(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("\nDodajam uporabnika Blaz\n");
		uu.addUser("hudogriz", "Blaz", "Vrhovsek", "mail@vrhi.si", 24.3532, 25.6432 );
		//uu.returnAll(response);
		response.getWriter().append("\n");
	}

	@Override
	public void removeUser(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Brisem uporabnika z imenom \"Blaz\"\n");
		uu.deleteUser("Blaz");
		//uu.returnAll(response);
	}

	@Override
	public void finadAllUsers(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("\n\nUporabniki v bazi:\n");
		//uu.returnAll(response);
		response.getWriter().append("\n");
	}


	@Override
	public void findAllOrders(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBill(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("\nRacun za narocilo\n");
		uo.createBill(1, response);
		response.getWriter().append("\n");
	}

	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		if (username != null) {
			ArrayList<Uporabnik> users = uu.returnAll();
			for (Uporabnik u : users) {
				if (u.getUsername().equals(username))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean submitOrder(String username, String kavarna, String size, String[] napitki, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int idKavarna = un.getIdKavarna(kavarna);
		int[] napitkiIds = un.getNapitekIds(napitki, size);
		int idNarocila = 1;
		if(checkUsername(username) && idKavarna > 0) {
			if (validateIds(napitkiIds)) {
				int idUporabnik = uu.getUserId(username);
				int prepTime = un.getPrepTime(napitkiIds);
				double totalPrice = un.getTotalPrice(napitkiIds);
				un.addOrder(idUporabnik, idKavarna, prepTime, "pending", "paid", totalPrice);
				un.addDrinks(idNarocila, napitkiIds);
				return true;
			}
		}
		return false;
	}
	
	public boolean validateIds(int[] ids) {
		for (int id : ids) {
			if (id <=0)
				return false;
		}
		return true;
	}
}
