package si.fri.prpo.rest;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import si.fri.prpo.rest.KavarnaRESTInterface;
import si.fri.prpo.vaje.entitete.Kavarna;
import si.fri.prpo.zrna.UpravljalecKavarnSBLocal;

@RequestScoped
@PermitAll
@Path("/kavarne")
@Produces({"application/json"})
@Consumes({"application/json"})
public class KavarnaREST implements KavarnaRESTInterface {

	@EJB UpravljalecKavarnSBLocal uk;
	
	@GET
	@Override
	public Response returnAll() {
		ArrayList<Kavarna> kavarnas = uk.returnAll();
		return Response.ok(kavarnas).build();
	}
	
	@GET
	@Path("{id}")
	@Override
	public Response returnById(@PathParam("id") int id) {
		Kavarna kavarna = uk.returnById(id);
		return Response.ok(kavarna).build();
	}

}
