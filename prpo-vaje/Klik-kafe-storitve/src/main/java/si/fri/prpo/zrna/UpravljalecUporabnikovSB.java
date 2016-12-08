package si.fri.prpo.zrna;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import si.fri.prpo.vaje.entitete.Uporabnik;

/**
 * Session Bean implementation class UpravljalecUporabnikovSB
 */

@Stateless
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBRemote, UpravljalecUporabnikovSBLocal {
	
	@PersistenceContext(unitName="Klik-kafe-JPA")
	private EntityManager em;
	
	/**
     * Default constructor. 
     */
    public UpravljalecUporabnikovSB() {
        // TODO Auto-generated constructor stub
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
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

	public ArrayList returnAll() {
		// TODO Auto-generated method stub
		Query q1 = em.createNamedQuery("Uporabnik.findAll");
		return (ArrayList<Uporabnik>) q1.getResultList();
	}

	public void getLocation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getUserId(String username) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Uporabnik.findName");
		q.setParameter("username", username);
		Uporabnik u = (Uporabnik) q.getSingleResult();
		return u.getId();
	}

	@Override
	public Uporabnik getUser(int id) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Uporabnik.findId");
		q.setParameter("userid", id);
		Uporabnik usr;
		try {
			usr = (Uporabnik) q.getSingleResult();
		} catch (NoResultException e) {
			// user not found
			usr = null;
		}
		return usr;
	}

	@Override
	public int deleteUser(int id) {
		Query q = em.createNamedQuery("Uporabnik.idDelete");
		q.setParameter("userid", id);
		// return affected rows
		return q.executeUpdate();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public int addUser(Uporabnik newUser) {
		// persist the new User into the database
		em.persist(newUser);
		em.flush();
		return newUser.getId();
	}
}
