package si.fri.prpo.zrna;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.vaje.entitete.Kavarna;
import si.fri.prpo.vaje.entitete.Napitek;
import si.fri.prpo.vaje.entitete.Narocilo;
import si.fri.prpo.vaje.entitete.Uporabnik;

/**
 * Session Bean implementation class UpravljalecNarocilSB
 */
@Stateless
public class UpravljalecNarocilSB implements UpravljalecNarocilSBRemote, UpravljalecNarocilSBLocal {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Klik-kafe-JPA");
	EntityManager em = emf.createEntityManager();
	
    /**
     * Default constructor. 
     */
    public UpravljalecNarocilSB() {
        // TODO Auto-generated constructor stub
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed({"Uporabnik"})
    public int addOrder(int idUporabnik, int idKavarna, int prepTime, String prepStatus, String paymentStatus, double totalPrice) {
		// TODO Auto-generated method stub
		/*Query q = em.createNativeQuery("INSERT INTO public.\"Narocilo\" (prep_time, prep_status, payment_status, "
				+ "id_uporabnik, id_kavarna, total_price) VALUES (:prep_time, :prep_status, :payment_status, "
				+ ":id_uporabnik, :id_kavarna, :total_price) RETURNING id");
		q.setParameter("prep_time", prepTime);
		q.setParameter("prep_status", prepStatus);
		q.setParameter("payment_status", paymentStatus);
		q.setParameter("id_uporabnik", idUporabnik);
		q.setParameter("id_kavarna", idKavarna);
		q.setParameter("total_price", totalPrice);
		q.executeUpdate();*/
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
    
    @RolesAllowed({"Uporabnik"})
	public void cancelOrder() {
		// TODO Auto-generated method stub
	}

	@Override
	@RolesAllowed({"Admin"})
	public void returnAll(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
				Query q1 = em.createNamedQuery("Narocilo.findAll");
				ArrayList<Narocilo> nList = (ArrayList<Narocilo>) q1.getResultList();
				boolean prazna = true;
				
				for (Narocilo nar : nList) {
					prazna = false;
					response.getWriter().append(nar.getId() + " " + " " + nar.getUporabnik().getName() + " " + nar.getPaymentStatus() + " "
					+ nar.getPrepStatus() + " " + nar.getPrepTime()+"\n");
				}
				
				if (prazna)
					response.getWriter().append("Zgleda da ni nobenga ...");
	}

	@RolesAllowed({"Uporabnik","Admin"})
	public void returnOrderId(int id, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Narocillo.findId");
		q.setParameter("id", id);
		Narocilo nar = (Narocilo) q.getSingleResult();
		if (nar != null) {
			response.getWriter().append(nar.getId() + " "  + " " + nar.getUporabnik() + " " + nar.getPaymentStatus() + " "
					+ nar.getPrepStatus() + " " + nar.getPrepTime()+"\n");
		}
		else {
			response.getWriter().append("ne obstaja narocilo s IDjem "+id);
		}
	}

	@Override
	@RolesAllowed({"Uporabnik","Admin"})
	public int getPrepTime(int[] ids) {
		// TODO Auto-generated method stub
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
	@RolesAllowed({"Uporabnik","Admin"})
	public double getTotalPrice(int[] ids) {
		// TODO Auto-generated method stub
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
	@RolesAllowed({"Uporabnik","Admin"})
	public int[] getNapitekIds(String[] napitki, String size) {
		// TODO Auto-generated method stub
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
	@RolesAllowed({"Uporabnik","Admin"})
	public int getIdKavarna(String name) {
		// TODO Auto-generated method stub
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
	@RolesAllowed({"Uporabnik","Admin"})
	public void addDrinks(int idNarocila, int[] idsNapitka) {
		// TODO Auto-generated method stub
		for (int id : idsNapitka) {
			Query q = em.createNativeQuery("INSERT INTO public.\"Napitki_narocila\" (id_narocila, id_napitka) VALUES (:id_narocila, :id_napitka)");
			q.setParameter("id_narocila", idNarocila);
			q.setParameter("id_napitka", id);
			q.executeUpdate();
		}
	}
}
