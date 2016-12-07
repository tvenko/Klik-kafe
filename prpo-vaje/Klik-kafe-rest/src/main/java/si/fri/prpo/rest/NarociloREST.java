package si.fri.prpo.rest;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.swing.UIDefaults.LazyInputMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import si.fri.prpo.rest.NarociloRESTInterface;
import si.fri.prpo.vaje.entitete.Narocilo;
import si.fri.prpo.zrna.UpravljalecNarocilSBLocal;

//@DeclareRoles({"Uporabnik","Admin"})
@RequestScoped
@PermitAll
@Path("/narocila")
@Produces({"application/json"})
@Consumes({"application/json"})
public class NarociloREST implements NarociloRESTInterface {
	
	@EJB
	private UpravljalecNarocilSBLocal un;

	@GET
	@Override
	public Response getOrders() {
		ArrayList<Narocilo> n = un.returnAll();
		return Response.ok(n).build();
	}

	@GET
	@Path("{id}")
	@Override
	public Response getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("{userId}")
	@Override
	public Response getUSerOrders(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@DELETE
	@Path("{id}")
	@Override
	public Response cancelOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Override
	public Response submitOrder(Narocilo narocilo) {
		// TODO Auto-generated method stub
		return null;
	}

}
