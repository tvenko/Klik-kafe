

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;
import si.fri.prpo.zrna.UpravljalecNarocilSBLocal;

/**
 * Servlet implementation class TestSBServlet
 */


public class TestSBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UpravljalecUporabnikovSBLocal uu;
	@EJB
	private UpravljalecNarocilSBLocal un;
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

		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n\nUporabniki v bazi:\n");
		uu.returnAll(response);
		response.getWriter().append("\n");
		
		response.getWriter().append("\nDodajam uporabnika Blaz\n");
		uu.addUser("hudogriz", "Blaz", "Vrhovsek", "mail@vrhi.si", 24.3532, 25.6432 );
		uu.returnAll(response);
		response.getWriter().append("\n");

		response.getWriter().append("Brisem uporabnika z imenom \"Blaz\"\n");
		uu.deleteUser("Blaz");
		uu.returnAll(response);
		
		response.getWriter().append("\nDodajam napitek kapucino\n");
		un.sprejmiNarocilo(1, 1, 1, "waiting", "in progress", "120s", "kapucino");
		un.returnAll(response);
		response.getWriter().append("\n");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
