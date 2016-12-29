package si.fri.prpo.zrna;

import java.util.ArrayList;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import si.fri.prpo.vaje.entitete.Kavarna;
import si.fri.prpo.vaje.entitete.Napitek;
import si.fri.prpo.vaje.entitete.Narocilo;
import si.fri.prpo.vaje.entitete.Uporabnik;

/**
 * Session Bean implementation class UpravljalecNarocilSB
 */
@DeclareRoles({"user", "admin"})
@Stateless
public class UpravljalecNarocilSB implements UpravljalecNarocilSBRemote, UpravljalecNarocilSBLocal {
	
	@PersistenceContext(unitName="Klik-kafe-JPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UpravljalecNarocilSB() {
        // TODO Auto-generated constructor stub
    }
    
    @RolesAllowed({"admin"})
    @Override
	public ArrayList<Narocilo> returnAll() {
		Query q1 = em.createNamedQuery("Narocilo.findAll");
		return (ArrayList<Narocilo>) q1.getResultList();
	}
	
    @RolesAllowed({"user", "admin"})
	@Override
	public ArrayList<Narocilo> getUserOrders(Uporabnik user) {
		Query q = em.createNamedQuery("Narocilo.findUserId");
		q.setParameter("user", user);
		try {
			return (ArrayList<Narocilo>) q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

    @RolesAllowed({"admin"})
	@Override
	public ArrayList<Narocilo> getOrdersByPage(int offset, int step) {
		Query q = em.createNamedQuery("Narocilo.findAll");
		q.setFirstResult(offset).setMaxResults(step);
		return (ArrayList<Narocilo>) q.getResultList();
	}

    @RolesAllowed({"user", "admin"})
	@Override
	public Narocilo returnOrderId(int id) {
		Query q = em.createNamedQuery("Narocilo.findId");
		q.setParameter("id", id);
		try {
			return (Narocilo) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
    
    @RolesAllowed({"user", "admin"})
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int addOrder(int idUporabnik, int idKavarna, int prepTime, String prepStatus, String paymentStatus, double totalPrice) {
		Narocilo new_order = new Narocilo();
		Uporabnik narocnik = em.find(Uporabnik.class, idUporabnik);
		Kavarna kava = em.find(Kavarna.class, idKavarna);
		new_order.setKavarna(kava);
		new_order.setUporabnik(narocnik);
		new_order.setPrepTime(prepTime);
		new_order.setPrepStatus(prepStatus);
		new_order.setPaymentStatus(paymentStatus);
		new_order.setTotalPrice(totalPrice);
		em.persist(new_order);
		em.flush();
		
		return new_order.getId();
	}
    
    @RolesAllowed({"user", "admin"})
	public boolean cancelOrder(int id) {
		//:TODO problem ker ne mores zbrisat zaradi tujega kljuca.
		try {
			Query q = em.createNamedQuery("Narocilo.delete");
			q.setParameter("id", id);
			q.executeUpdate();
			return true;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

    @RolesAllowed({"user", "admin"})
    @Override
	public int getPrepTime(int[] ids) {
		int time = 0;
		for (int id : ids) {
			Query q = em.createNamedQuery("Napitek.findId");
			q.setParameter("id", id);
			Napitek n = (Napitek)q.getSingleResult();
			time += n.getPrepTime();
		}
		return time;
	}

    @RolesAllowed({"user", "admin"})
    @Override
	public double getTotalPrice(int[] ids) {
		double price = 0;
		for (int id : ids) {
			Query q = em.createNamedQuery("Napitek.findId");
			q.setParameter("id", id);
			Napitek n = (Napitek)q.getSingleResult();
			price += n.getPrice();
		}
		return price;
	}

    @RolesAllowed({"user", "admin"})
	@Override
	public int[] getNapitekIds(String[] napitki, String size) {
		int [] ids = new int[napitki.length];
		Query q = em.createNamedQuery("Napitek.findAll");
		ArrayList<Napitek> napitkiList = (ArrayList<Napitek>) q.getResultList();
		for (Napitek n : napitkiList) {
			for(int i=0; i<napitki.length; i++) {
				if (n.getType().equals(napitki[i]) && n.getSize().equals(size)) {
					ids[i] = n.getId();
				}
			}
		}
		return ids;
	}

    @RolesAllowed({"user", "admin"})
    @Override
	public int getIdKavarna(String name) {
		Query q = em.createNamedQuery("Kavarna.findName");
		q.setParameter("name", name);
		Kavarna k = (Kavarna) q.getSingleResult();
		if(k != null) {
			return k.getId();
		}
		else 
			return -1;
	}

    @RolesAllowed({"user", "admin"})
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addDrinks(int idNarocila, int[] idsNapitka) {
		for (int id : idsNapitka) {
			Query q = em.createNativeQuery("INSERT INTO public.\"Napitki_narocila\" (id_narocila, id_napitka) VALUES (:id_narocila, :id_napitka)");
			q.setParameter("id_narocila", idNarocila);
			q.setParameter("id_napitka", id);
			q.executeUpdate();
		}
	}
}
