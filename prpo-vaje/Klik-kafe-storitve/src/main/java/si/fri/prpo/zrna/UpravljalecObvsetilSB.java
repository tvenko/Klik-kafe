package si.fri.prpo.zrna;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;


/**
 * Session Bean implementation class UpravljalecObvsetilSB
 */
@DeclareRoles({"user, admin"})
@Stateless
public class UpravljalecObvsetilSB implements UpravljalecObvsetilSBRemote, UpravljalecObvsetilSBLocal {
	
	@PersistenceContext(unitName="Klik-kafe-JPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UpravljalecObvsetilSB() {
        // TODO Auto-generated constructor stub
    }

    @RolesAllowed({"user, admin"})
	@Override
	public void createBill (int id_narocila, HttpServletResponse response) throws IOException  {
		// TODO Auto-generated method stub
	}

}
