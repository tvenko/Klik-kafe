

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
  	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Klik-kafe-JPA");
		EntityManager em = emf.createEntityManager();
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
		izpisiVse(em, response);
		response.getWriter().append("\n\nDodajam uporabnika Pepeja: ");
		Uporabnik u = new Uporabnik();
		u.setEmail("pepe@mail.si");
		u.setLatitude(44.5677);
		u.setLongitude(56.77889);
		u.setName("Pepa");
		u.setSurname("Jeans");
		u.setUsername("PepaJeans");		
		try {
			tx.begin();
			//INSERT new user
			em.persist(u);
			em.flush();
			izpisiVse(em, response);
			
			//UPDATE the new user
			int id = u.getId();
			response.getWriter().append("\n\nSpreminjam uporabnika Pepeja: ");
			u.setName("Papa");
			em.merge(u);
			izpisiVse(em, response);
			
			//DELETE the new user
			response.getWriter().append("\n\nBrisem uporabnika Pepeja: ");
			Query q = em.createNamedQuery("Uporabnik.idDelete");
			q.setParameter("userid", id);
			int deletedRows = q.executeUpdate();
			response.getWriter().append(deletedRows + " vrstica spremenjena.");
			
			//CRITERIA api
			response.getWriter().append("\n\nPovprasujem s CriteriaAPI: ");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Uporabnik> c = cb.createQuery(Uporabnik.class);
			Root<Uporabnik> critUporabnik = c.from(Uporabnik.class);
			//predikati za povprasevanje
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(cb.like(critUporabnik.get("name"), "David"));
			predicates.add(cb.like(critUporabnik.get("surname"), "Rubin"));
			c.select(critUporabnik).where(predicates.toArray(new Predicate[]{}));
			ArrayList<Uporabnik> rezultati = (ArrayList<Uporabnik>)em.createQuery(c).getResultList();
			for (Uporabnik n : rezultati) {
				response.getWriter().append(n.getName() + " " + n.getSurname() + 
						", " + n.getEmail() + ", @(" + n.getLatitude() + ", " 
						+ n.getLongitude() + ")");
			}
			response.getWriter().append("\n\n");
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
		}
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