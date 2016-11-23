package si.fri.prpo.rest;

import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import si.fri.prpo.vaje.entitete.Narocilo;
import si.fri.prpo.zrna.UpravljalecNarocilSB;

@Path("/narocila")
@Produces("Application/json")
@Consumes("Application/json")
public class NarociloREST implements NarociloRESTInterface {
	
	//@PersistenceContext
	//UpravljalecNarocilSB un;
	
	@GET
	@Override
	public Response getOrders() {
		// TODO Auto-generated method stub
		return Response.ok().build();
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
