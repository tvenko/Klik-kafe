package si.fri.prpo.zrna;

import java.util.ArrayList;

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
@PermitAll
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

	@Override
	public ArrayList<Narocilo> returnAll() {
		Query q1 = em.createNamedQuery("Narocilo.findAll");
		ArrayList<Narocilo> narocilos = (ArrayList<Narocilo>) q1.getResultList();
		for (Narocilo n : narocilos) {
			n.setNapitkiNarocilas(null);
		}
		return narocilos;
	}

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

	@Override
	//@RolesAllowed({"Uporabnik","Admin"})
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

	@Override
	//@RolesAllowed({"Uporabnik","Admin"})
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

	@Override
	//@RolesAllowed({"Uporabnik","Admin"})
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

	@Override
	//@RolesAllowed({"Uporabnik","Admin"})
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

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	//@RolesAllowed({"Uporabnik","Admin"})
	public void addDrinks(int idNarocila, int[] idsNapitka) {
		for (int id : idsNapitka) {
			Query q = em.createNativeQuery("INSERT INTO public.\"Napitki_narocila\" (id_narocila, id_napitka) VALUES (:id_narocila, :id_napitka)");
			q.setParameter("id_narocila", idNarocila);
			q.setParameter("id_napitka", id);
			q.executeUpdate();
		}
	}

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
}
