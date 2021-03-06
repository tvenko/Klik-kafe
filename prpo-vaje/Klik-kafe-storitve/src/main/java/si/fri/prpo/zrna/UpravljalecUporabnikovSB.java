package si.fri.prpo.zrna;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.HttpHeaders;

import si.fri.prpo.vaje.entitete.Uporabnik;

/**
 * Session Bean implementation class UpravljalecUporabnikovSB
 */

@DeclareRoles({"user", "admin"})
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
    
    @RolesAllowed({"user", "admin"})
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
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

    @RolesAllowed({"user", "admin"})
    @Override
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

    //@RolesAllowed({"admin"})
    @PermitAll
    @Override
	public ArrayList<Uporabnik> returnAll() {
		// TODO Auto-generated method stub
		Query q1 = em.createNamedQuery("Uporabnik.findAll");
		return (ArrayList<Uporabnik>) q1.getResultList();
	}

    @RolesAllowed({"user", "admin"})
    @Override
	public void getLocation() {
		// TODO Auto-generated method stub
		
	}

    //@RolesAllowed({"user", "admin"})
    @PermitAll
	@Override
	public int getUserId(String username) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Uporabnik.findName");
		q.setParameter("username", username);
		Uporabnik u = (Uporabnik) q.getSingleResult();
		return u.getId();
	}

    //SOAP call
    @PermitAll
    //@RolesAllowed({"user", "admin"})
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

    @RolesAllowed({"user", "admin"})
	@Override
	public int deleteUser(int id) {
		Query q = em.createNamedQuery("Uporabnik.idDelete");
		q.setParameter("userid", id);
		// return affected rows
		return q.executeUpdate();
	}

    @RolesAllowed({"user", "admin"})
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public int addUser(Uporabnik newUser) {
		// persist the new User into the database
		em.persist(newUser);
		em.flush();
		return newUser.getId();
	}

    @RolesAllowed({"user", "admin"})
	@Override
	public int updateUser(int id, HttpHeaders headers) {
		Uporabnik updateUser = getUser(id);
		if (updateUser != null) {
			for(String header : headers.getRequestHeaders().keySet()){
				try {
					switch (header) {
					case "name":
						updateUser.setName(headers.getRequestHeader(header).get(0));
						break;
					case "surname":
						updateUser.setSurname(headers.getRequestHeader(header).get(0));
						break;
					case "email":
						updateUser.setEmail(headers.getRequestHeader(header).get(0));
						break;
					case "longitude":
						updateUser.setLongitude(Double.parseDouble(headers.getRequestHeader(header).get(0)));
						break;
					case "latitude":
						updateUser.setLatitude(Double.parseDouble(headers.getRequestHeader(header).get(0)));
						break;
					case "username":
						updateUser.setUsername(headers.getRequestHeader(header).get(0));
						break;
					}
				} catch (NumberFormatException nfe) {
					return -1;
				}
			}
			em.merge(updateUser);
			// everything ok, return 0
			return 0;
		} else {
			// user was not found in the db, return 1
			return 1;
		}
	}

    //Remote interface
    @PermitAll
	@Override
	public String getResponse() {
		// TODO Auto-generated method stub
		return "Uspesno povezan";
	}

    //Remote interface
    @PermitAll
	@Override
	public List<Uporabnik> oddaljenoVrni() {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Uporabnik.findAll");
		return (ArrayList<Uporabnik>) q.getResultList();
	}
}
