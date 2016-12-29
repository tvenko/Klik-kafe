package si.fri.prpo.zrna;

import java.util.ArrayList;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import si.fri.prpo.vaje.entitete.Kavarna;

/**
 * Session Bean implementation class UpravljalecKavarnSB
 */
@DeclareRoles({"user", "admin"})
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

    @RolesAllowed({"user", "admin"})
	@Override
	public ArrayList<Kavarna> returnAll() {
		Query q = em.createNamedQuery("Kavarna.findAll");
		return (ArrayList<Kavarna>) q.getResultList();
	}

    @RolesAllowed({"user", "admin"})
	@Override
	public Kavarna returnById(int id) {
		Kavarna k;
    	try {
			Query q = em.createNamedQuery("Kavarna.findId");
			q.setParameter("id", id);
			k = (Kavarna) q.getSingleResult();
		} catch (NoResultException e) {
			k = null;
		}
		
		return k;
	}

}
