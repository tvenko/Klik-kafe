package si.fri.prpo.rest;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
		if (usr != null) {
			// 200 OK
			return Response.ok(usr, MediaType.APPLICATION_JSON).build();
		} else {
			// 404 Not Found
			return Response.status(Response.Status.NOT_FOUND).entity("Ne najdem uporabnika s tem ID: " + id).build();
		}
	}

	@Override
	@POST
	public Response addUser(@HeaderParam("name")String name, @HeaderParam("surname") String surname,
			@HeaderParam("username")String username, @HeaderParam("name")String email, 
			@HeaderParam("latitude")double latitude, @HeaderParam("longitude")double longitude) {
		// TODO Auto-generated method stub
		Uporabnik newUser = new Uporabnik();
		newUser.setName(name);
		newUser.setSurname(surname);
		newUser.setEmail(email);
		newUser.setUsername(username);
		newUser.setLatitude(latitude);
		newUser.setLongitude(longitude);
		int newId = uu.addUser(newUser);
		if (newId > 0) {
			return Response.ok("Uspesno kreiran uporabnik, vas ID: " + newId).build();
		} else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Prislo je do napake na strezniku").build();
		}
	}

	@Override
	@DELETE
	@Path("{id}")
	@Produces({ MediaType.TEXT_PLAIN })
	public Response deleteUser(@PathParam("id") int id) {
		int rowsAffected = uu.deleteUser(id);
		// 204 if success and 404 if user does not exist
		if (rowsAffected > 0) {
			return Response.status(Response.Status.NO_CONTENT).entity("Uspesno zbrisan uporabnik z ID: " + id).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Uporabnika ni v bazi, in ga nemorem zbrisat").build();
		}
	}

	@Override
	@PUT
	@Path("{id}")
	public Response updateUser(@PathParam("id") int id, @Context HttpHeaders headers) {
		//  0  no errors
		//  1  user not found
		// -1  double parse error 
		int success = uu.updateUser(id, headers);	
		
		if (success == 0) {
			return Response.ok("Uporabnik uspesno posodobljen.").build();
		} else if (success < 0) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Prosim vnesite veljavno stevilo pod latitude in longitude").build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity("Uporabnika ne najdem").build();
		}
	}

}
