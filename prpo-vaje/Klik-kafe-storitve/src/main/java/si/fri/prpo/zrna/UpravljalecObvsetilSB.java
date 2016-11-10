package si.fri.prpo.zrna;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;


/**
 * Session Bean implementation class UpravljalecObvsetilSB
 */
@Stateless
public class UpravljalecObvsetilSB implements UpravljalecObvsetilSBRemote, UpravljalecObvsetilSBLocal {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Klik-kafe-JPA");
	EntityManager em = emf.createEntityManager();
	
    /**
     * Default constructor. 
     */
    public UpravljalecObvsetilSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createBill (int id_narocila, HttpServletResponse response) throws IOException  {
		// TODO Auto-generated method stub
	}

}
