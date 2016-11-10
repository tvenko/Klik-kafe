

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import si.fri.prpo.vaje.entitete.Uporabnik;


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
		 
		//EntityManager em = Persistence.createEntityManagerFactory("Klik-kafe-JPA").createEntityManager();
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
		/*izpisiVse(em, response);

		Uporabnik u = em.find(Uporabnik.class, 1);
		u.setName("Blazzzz");
		em.merge(u);
		izpisiVse(em, response);
		
		try {
			tx.begin();
			Query q = em.createNamedQuery("Uporabnik.delete");
			q.setParameter("userid", 1);
			q.executeUpdate();
			tx.commit();
			izpisiVse(em, response);
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/	
	}
	
	protected void izpisiVse(EntityManager em, HttpServletResponse response) throws IOException {
		Query q1 = em.createNamedQuery("Uporabnik.findAll");
		ArrayList<Uporabnik> uList = (ArrayList<Uporabnik>) q1.getResultList();
		response.getWriter().append("Uporabniki: \n");
		
		for (Uporabnik usr : uList) {
			response.getWriter().append(usr.getName() + " " + usr.getSurname() + ", " + usr.getEmail() + ", @(" + Double.toString(usr.getLatitude()) + ""
					+ " lat, " + Double.toString(usr.getLongitude()) + " long)\n");
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
