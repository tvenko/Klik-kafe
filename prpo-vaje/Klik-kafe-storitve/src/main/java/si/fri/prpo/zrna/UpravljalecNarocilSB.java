package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.vaje.narocanje.entitete.Kavarna;
import si.fri.prpo.vaje.narocanje.entitete.Napitek;
import si.fri.prpo.vaje.narocanje.entitete.Narocilo;

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

	public void addOrder(int idKavarna, int idUporabnik, int idNapitek, String payment, String prepStatus, String prepTime, String item) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("INSERT INTO public.\"Narocilo\" (id_kavarna, id_uporabnik, id_napitek, payment_status, prep_status, prep_time, item_list) "
				+ "VALUES (:id_kavarna, :id_uporabnik, :id_napitek, :payment_status, :prep_status, :prep_time, :item_list)");
		q.setParameter("id_kavarna", idKavarna);
		q.setParameter("id_uporabnik", idUporabnik);
		q.setParameter("id_napitek", idNapitek);
		q.setParameter("payment_status", payment);
		q.setParameter("prep_status", prepStatus);
		q.setParameter("prep_time", prepTime);
		q.setParameter("item_list", item);
		q.executeUpdate();
	}

	public void cancelOrder() {
		// TODO Auto-generated method stub
	}

	@Override
	public void returnAll(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
				Query q1 = em.createNamedQuery("Narocilo.findAll");
				ArrayList<Narocilo> nList = (ArrayList<Narocilo>) q1.getResultList();
				boolean prazna = true;
				
				for (Narocilo nar : nList) {
					prazna = false;
					response.getWriter().append(nar.getId() + " " + nar.getItemList() + " " + nar.getUporabnik().getName() + " " + nar.getPaymentStatus() + " "
					+ nar.getPrepStatus() + " " + nar.getPrepTime()+"\n");
				}
				
				if (prazna)
					response.getWriter().append("Zgleda da ni nobenga ...");
	}

	@Override
	public void returnOrderId(int id, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Narocillo.findId");
		q.setParameter("id", id);
		Narocilo nar = (Narocilo) q.getSingleResult();
		if (nar != null) {
			response.getWriter().append(nar.getId() + " " + nar.getItemList() + " " + nar.getUporabnik() + " " + nar.getPaymentStatus() + " "
					+ nar.getPrepStatus() + " " + nar.getPrepTime()+"\n");
		}
		else {
			response.getWriter().append("ne obstaja narocilo s IDjem "+id);
		}
	}

	@Override
	public int getPrepTime(int[] ids) {
		// TODO Auto-generated method stub
		int time = 0;
		for (int id : ids) {
			Query q = em.createNamedQuery("Napitek.findId");
			q.setParameter("id", id);
			Napitek n = (Napitek)q.getSingleResult();
			time += Integer.parseInt(n.getPrepTime());
		}
		return time;
	}

	@Override
	public double getTotalPrice(int[] ids) {
		// TODO Auto-generated method stub
		double price = 0;
		for (int id : ids) {
			Query q = em.createNamedQuery("Napitek.findId");
			q.setParameter("id", id);
			Napitek n = (Napitek)q.getSingleResult();
			//TODO dodaj metodo ki ti vrne ceno 
			//price += Integer.parseInt(n.getPrice());
		}
		return price;
	}

	@Override
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
	public int getIdKavarna(String name) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Kavarna.findName");
		q.setParameter("name", name);
		Kavarna k = (Kavarna) q.getSingleResult();
		return k.getId();
	}
}
