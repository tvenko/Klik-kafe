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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import si.fri.prpo.rest.UporabnikRESTInterface;
import si.fri.prpo.vaje.entitete.Narocilo;
import si.fri.prpo.vaje.entitete.Uporabnik;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;

@RequestScoped
@PermitAll
@Path("/uporabniki")
@Produces({"application/json"})
@Consumes({"application/json"})
public class UporabnikREST implements UporabnikRESTInterface {
	
	@EJB
	UpravljalecUporabnikovSBLocal uu;

	@Override
	@GET
	public Response getUsers() {
		// TODO Auto-generated method stub
		ArrayList<Uporabnik> users = (ArrayList<Uporabnik>) uu.returnAll();
		return Response.ok(users).build();
	}
	
	@GET
	@Path("{id}")
	@Override
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getUser(@PathParam("id") int id) {
		Uporabnik usr = uu.getUser(id);
		if (usr != null)
			return Response.ok(usr, MediaType.APPLICATION_JSON).build();
		else
			return Response.status(404).entity("Ne najdem uporabnika s tem ID: " + id).build();
	}

	@Override
	@POST
	public Response addUser(Uporabnik usr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DELETE
	@Path("{id}")
	public Response deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
