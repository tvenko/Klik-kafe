

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import si.fri.prpo.vaje.narocanje.entitete.Uporabnik;


/**
 * Servlet implementation class TestJPAServlet
 */

public class TestJPAServlet extends HttpServlet {
	
	@Resource
	UserTransaction tx;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJPAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Klik-kafe-JPA");
		EntityManager em = emf.createEntityManager();
		Uporabnik u = new Uporabnik();
		//EntityManager em = Persistence.createEntityManagerFactory("Klik-kafe-JPA").createEntityManager();
		u = em.find(Uporabnik.class, 1);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(u.getName());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
