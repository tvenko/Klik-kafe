package si.fri.prpo.rest;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		ArrayList<Narocilo> n = (ArrayList<Narocilo>) un.returnAll();
		return Response.ok(n).build();
		
	}

	@GET
	@Path("{id}")
	@Override
	public Response getOrder(@PathParam("id") int id) {
		Narocilo order = un.returnOrderId(id);
		if (order != null)
			return Response.ok(order).build();
		else
			return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("{userId}/uporabnik")
	@Override
	public Response getUserOrders(@PathParam("userId") int userId) {
		ArrayList<Narocilo> orders = un.getUserOrders(userId);
		if (orders != null)
			return Response.ok(orders).build();
		else
			return Response.status(Response.Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("{id}")
	@Override
	public Response cancelOrder(@PathParam("id") int id) {
		//:TODO problem ker ne mores zbrisat zaradi tujega kljuca.
		boolean response = un.cancelOrder(id);
		if (response)
			return Response.status(Response.Status.NO_CONTENT).build();
		else
			return Response.status(Response.Status.NOT_FOUND).build();
	}

	@POST
	@Override
	public Response submitOrder(Narocilo narocilo) {
		// TODO Auto-generated method stub
		return null;
	}

}
