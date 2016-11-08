

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;
import si.fri.prpo.zrna.*;
=======
import si.fri.prpo.vaje.narocanje.entitete.Uporabnik;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;
>>>>>>> 0cd93d5725ad1821aea93d6b4119dfecc771e841

/**
 * Servlet implementation class TestSBServlet
 */


public class TestSBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
<<<<<<< HEAD
	private UpravljalecUporabnikovSBLocal upravljalecUporabnikov;
	private UpravljalecUporabnikovSB uu;
=======
	private UpravljalecUporabnikovSBLocal upravlalecUporabnikov;
>>>>>>> 0cd93d5725ad1821aea93d6b4119dfecc771e841
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		response.getWriter().append("Served at: ").append(request.getContextPath());
		uu.returnAll(response);
		uu.addUser("hudogriz", "Blaz", "Vrhovsek", "blaz.vrhovske@gmail.com", 3);
		uu.returnAll(response);
=======
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n\nUporabniki v bazi:\n");
		upravlalecUporabnikov.returnAll(response);
		response.getWriter().append("\n");
		
		response.getWriter().append("\nDodajam uporabnika Blaz\n");
		upravlalecUporabnikov.addUser("hudogriz", "Blaz", "Vrhovsek", "mail@vrhi.si", 24.3532, 25.6432 );
		upravlalecUporabnikov.returnAll(response);
		response.getWriter().append("\n");

		response.getWriter().append("Brisem uporabnika z imenom \"Blaz\"\n");
		upravlalecUporabnikov.deleteUser("Blaz");
		upravlalecUporabnikov.returnAll(response);
>>>>>>> 0cd93d5725ad1821aea93d6b4119dfecc771e841
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
