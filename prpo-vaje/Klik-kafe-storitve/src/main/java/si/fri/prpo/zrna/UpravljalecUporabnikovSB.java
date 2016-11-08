package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import si.fri.prpo.vaje.narocanje.entitete.Uporabnik;

/**
 * Session Bean implementation class UpravljalecUporabnikovSB
 */

@Stateless
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBRemote, UpravljalecUporabnikovSBLocal {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Klik-kafe-JPA");
	EntityManager em = emf.createEntityManager();
	
	/**
     * Default constructor. 
     */
    public UpravljalecUporabnikovSB() {
        // TODO Auto-generated constructor stub
    }

	public void addUser(String username, String name, String surname, String email, Double latit, Double longit) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("INSERT INTO public.\"Uporabnik\" (username, email, surname, name, latitude, longitude) VALUES (:username, :email, :surname, :name, :latit, :longit)");
		q.setParameter("username", username);
		q.setParameter("email", email);
		q.setParameter("surname", surname);
		q.setParameter("name", name);
		q.setParameter("latit", latit);
		q.setParameter("longit", longit);
		q.executeUpdate();
	}

	public void deleteUser(String name) {
		// TODO Auto-generated method stub
		try {
			Query q = em.createNamedQuery("Uporabnik.delete");
			q.setParameter("name", name);
			q.executeUpdate();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void returnAll(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Query q1 = em.createNamedQuery("Uporabnik.findAll");
		ArrayList<Uporabnik> uList = (ArrayList<Uporabnik>) q1.getResultList();
		boolean prazna = true;
		
		for (Uporabnik usr : uList) {
			prazna = false;
			response.getWriter().append(usr.getName() + " " + usr.getSurname() + ", " + usr.getEmail() + ", @(" + Double.toString(usr.getLatitude()) + ""
					+ " lat, " + Double.toString(usr.getLongitude()) + " long)\n");
		}
		
		if (prazna)
			response.getWriter().append("Zgleda da ni nobenga ...");
	}

	public void getLocation() {
		// TODO Auto-generated method stub
		
	}

}
