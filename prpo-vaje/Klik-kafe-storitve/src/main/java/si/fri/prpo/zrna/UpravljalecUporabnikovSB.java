package si.fri.prpo.zrna;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Session Bean implementation class UpravljalecUporabnikovSB
 */

@Stateless
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBRemote, UpravljalecUporabnikovSBLocal {
	
	@Resource
	UserTransaction tx;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Klik-kafe-JPA");
	EntityManager em = emf.createEntityManager();
	
	
	/**
     * Default constructor. 
     */
    public UpravljalecUporabnikovSB() {
        // TODO Auto-generated constructor stub
    }

	public void dodajUporabnika(String username, String name, String surname, String email, int id) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("INSERT INTO Uporabnik (username, email, surname, name, id) VALUES (:username, :email, :surname, :name, :id");
		q.setParameter("username", username);
		q.setParameter("email", email);
		q.setParameter("surname", surname);
		q.setParameter("name", name);
		q.setParameter("id", id);
		q.executeUpdate();
	}

	public void odstraniUporabnika(int id) {
		// TODO Auto-generated method stub
		try {
			tx.begin();
			Query q = em.createNamedQuery("Uporabnik.delete");
			q.setParameter("userid", id);
			q.executeUpdate();
			tx.commit();
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

}
