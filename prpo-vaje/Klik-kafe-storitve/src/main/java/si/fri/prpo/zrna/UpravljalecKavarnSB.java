package si.fri.prpo.zrna;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import si.fri.prpo.vaje.entitete.Kavarna;

/**
 * Session Bean implementation class UpravljalecKavarnSB
 */
@Stateless
public class UpravljalecKavarnSB implements UpravljalecKavarnSBRemote, UpravljalecKavarnSBLocal {

	@PersistenceContext(unitName="Klik-kafe-JPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UpravljalecKavarnSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Kavarna> returnAll() {
		Query q = em.createNamedQuery("Kavarna.findAll");
		return (ArrayList<Kavarna>) q.getResultList();
	}

	@Override
	public Kavarna returnById(int id) {
		Query q = em.createNamedQuery("Kavarna.findId");
		q.setParameter("id", id);
		return (Kavarna) q.getSingleResult();
	}

}
