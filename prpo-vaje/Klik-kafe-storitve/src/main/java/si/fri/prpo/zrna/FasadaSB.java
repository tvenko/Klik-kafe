package si.fri.prpo.zrna;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;

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
		uu.returnAll(response);
		response.getWriter().append("\n");
	}

	@Override
	public void removeUser(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Brisem uporabnika z imenom \"Blaz\"\n");
		uu.deleteUser("Blaz");
		uu.returnAll(response);
	}

	@Override
	public void finadAllUsers(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("\n\nUporabniki v bazi:\n");
		uu.returnAll(response);
		response.getWriter().append("\n");
	}

	@Override
	public void addOrder(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("\nDodajam napitek kapucino\n");
		un.addOrder(1, 1, 1, "waiting", "in progress", "120s", "kapucino");
		un.returnAll(response);
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

}
