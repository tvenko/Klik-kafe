package si.fri.prpo.zrna;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

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
					response.getWriter().append(nar.getId() + " " + nar.getItemList() + " " + nar.getUporabnik() + " " + nar.getPaymentStatus() + " "
					+ nar.getPrepStatus() + " " + nar.getPrepTime()+"\n");
				}
				
				if (prazna)
					response.getWriter().append("Zgleda da ni nobenga ...");
	}
}
