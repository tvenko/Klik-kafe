package si.fri.prpo.rest;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import si.fri.prpo.ponudniki.izjeme.NeveljavnoNarociloException;
import si.fri.prpo.rest.NarociloRESTInterface;
import si.fri.prpo.vaje.entitete.Narocilo;
import si.fri.prpo.vaje.entitete.Uporabnik;
import si.fri.prpo.zrna.UpravljalecKavarnSBLocal;
import si.fri.prpo.zrna.UpravljalecNarocilSBLocal;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;

//@DeclareRoles({"user","admin"})
@Api(value="/narocila")
@RequestScoped
@PermitAll
@Path("/narocila")
@Produces({"application/json"})
@Consumes({"application/json"})
public class NarociloREST implements NarociloRESTInterface {
	
	@EJB
	private UpravljalecNarocilSBLocal un;
	@EJB
	private UpravljalecUporabnikovSBLocal uu;
	@EJB
	private UpravljalecKavarnSBLocal uk;

	@GET
	@ApiOperation(value="get all orders", notes="orders are return in pages of size specified in step", response=Narocilo.class, responseContainer="list")
	@Override
	public Response getOrders(@DefaultValue("0") @QueryParam("offset") int offset, @DefaultValue("10") @QueryParam("step") int step) {
		ArrayList<Narocilo> orders = (ArrayList<Narocilo>) un.getOrdersByPage(offset, step);
		return Response.ok(orders).build();
	}

	@GET
	@Path("{id}")
	@ApiOperation(value="get order for chosen ID", notes="return order with chosen ID", response=Narocilo.class)
	@Override
	public Response getOrder(@PathParam("id") int id) {
		Narocilo order = un.returnOrderId(id);
		if (order != null)
			return Response.ok(order).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Ne najdem narocilo s tem ID: " + id).build();
	}

	@GET
	@Path("{userId}/uporabnik")
	@ApiOperation(value="get order for chosen user ID", notes="All orders from user with this ID", response=Narocilo.class)
	@Override
	public Response getUserOrders(@PathParam("userId") int userId) {
		Uporabnik user = uu.getUser(userId);
		ArrayList<Narocilo> orders = un.getUserOrders(user);
		if (orders != null)
			return Response.ok(orders).build();
		else
			return Response.status(Response.Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("{id}")
	@ApiOperation(value="delete order", notes="delete order with chosen ID")
	@Override
	public Response cancelOrder(@PathParam("id") int id) {
		//:TODO problem ker ne mores zbrisat zaradi tujega kljuca.
		boolean response = un.cancelOrder(id);
		if (response)
			return Response.status(Response.Status.NO_CONTENT).entity("Narocilo z ID: "+id+" je bilo uspesno izbrisano.").build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Ne najdem narocilo s tem ID: "+id).build();
	}

	@POST
	@ApiOperation(value="submit new order", notes="submit new order for user with userID")
	@Override
	public Response submitOrder(@HeaderParam("uporabnik") int idUporabnik, @HeaderParam("kavarna") int idKavarna, @HeaderParam("size") String size, @HeaderParam("napitek") String[] napitki) 
			throws NeveljavnoNarociloException {
		
		if (checkParams(idUporabnik, idKavarna, size, napitki)) {
			throw new NeveljavnoNarociloException("Napaka pri oddaji narocila.");
		}
		int[] napitkiIds = un.getNapitekIds(napitki, size);
		int idNarocila = -1;
		int prepTime = un.getPrepTime(napitkiIds);
		double totalPrice = un.getTotalPrice(napitkiIds);
		idNarocila = un.addOrder(idUporabnik, idKavarna, prepTime, "pending", "paid", totalPrice);
		un.addDrinks(idNarocila, napitkiIds);
		
		Integer newId = un.addOrder(idUporabnik, idKavarna, prepTime, "in progress", "paid", totalPrice);
		return Response.status(Response.Status.CREATED).entity("Uspesno kreirano narocilo s ID: " + newId).build();
	
	}
	
	private boolean checkParams(int idUser, int idCafe, String size, String[] drinks) {
		// user not found / missing
		if (uu.getUser(idUser) == null)
			return true;
		// cafe not found / missing
		if (uk.returnById(idCafe) == null)
			return true;
		// size not given
		if (size == null || size.equals(""))
			return true;
		// no drinks selected
		if (drinks.length == 0)
			return true;
		
		//Everything given
		return false;
	}

}
