

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UporabaJDBC
 */
public class UporabaJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UporabaJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
		Connection povezava = null;
		Random rnd = new Random();
		UporabnikDaolmpl dao = new UporabnikDaolmpl();
		boolean napaka = true;
		String n = request.getParameter("napaka");
		if (n != null) {
			if (n.equals("false"))
				napaka = false;
		}
		try {
			int key1 = rnd.nextInt(10000-1000) + 1000;
			int key2 = rnd.nextInt(10000-1000) + 1000;
			UporabnikJDBC u1 = new UporabnikJDBC(key1, "DaneBanane", "Danko", "Bananko", "dane@banane.si", 45.677, 34.859);
			UporabnikJDBC u2 = new UporabnikJDBC(key2, "SladkaSliva", "Rozalija", "Ocvirek", "roza@ocvirki.si", 42.687, 50.849);
			response.getWriter().append("Vstavljam uporabnika: " + u1.getUsername() + " in " + u2.getUsername()).append("\n");
			
			povezava = dao.getConnection();
			povezava.setAutoCommit(false);
			int u1Vstavljen = dao.vstavi(u1, povezava);
			int u2Vstavljen = dao.vstavi(u2, povezava);
			
			// OPA, ali je pri drugem Uporabniku prislo do napake?			
			if (napaka) {
				povezava.rollback();
				response.getWriter().append("Prislo je do napake in uporabnika nista uspesno vstavljena!\n");
			} else {
				povezava.commit();
				response.getWriter().append("Uporabnika uspesno vstavljena\n");
			}
			
			povezava.close();
		} catch (SQLException e) {
			// TODO: handle exception
			response.getWriter().append("Prislo do napake pri povezavi.");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
