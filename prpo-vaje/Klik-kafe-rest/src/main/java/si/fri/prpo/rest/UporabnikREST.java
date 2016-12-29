package si.fri.prpo.rest;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import si.fri.prpo.rest.UporabnikRESTInterface;
import si.fri.prpo.vaje.entitete.Uporabnik;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;

@Api(value="/uporabniki")
@RequestScoped
@PermitAll
@Path("/uporabniki")
@Produces({"application/json"})
@Consumes({"application/json"})
public class UporabnikREST implements UporabnikRESTInterface {
	
	@EJB
	UpravljalecUporabnikovSBLocal uu;
	
	@GET
	@ApiOperation(value="get all users", notes="get information for all users in database", response=Uporabnik.class, responseContainer="list")
	@Override
	public Response getUsers() {
		// TODO Auto-generated method stub
		ArrayList<Uporabnik> users = (ArrayList<Uporabnik>) uu.returnAll();
		return Response.ok(users).build();
	}
	
	@GET
	@Path("{id}")
	@ApiOperation(value="get user", notes="get user information by chosen ID", response=Uporabnik.class)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Override
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

	@POST
	@ApiOperation(value="add new user", notes="add new user")
	@Override
	public Response addUser(Uporabnik newUser) {
		// TODO Auto-generated method stub
		int newId = uu.addUser(newUser);
		if (newId > 0) {
			return Response.status(Response.Status.CREATED).entity("Uspesno kreiran uporabnik, vas ID: " + newId).build();
		} else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Prislo je do napake na strezniku").build();
		}
	}

	@DELETE
	@Path("{id}")
	@ApiOperation(value="delete user", notes="delete user with chosen ID")
	@Produces({ MediaType.TEXT_PLAIN })
	@Override
	public Response deleteUser(@PathParam("id") int id) {
		int rowsAffected = uu.deleteUser(id);
		// 204 if success and 404 if user does not exist
		if (rowsAffected > 0) {
			return Response.status(Response.Status.NO_CONTENT).entity("Uspesno zbrisan uporabnik z ID: " + id).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Uporabnika ni v bazi, in ga nemorem zbrisat").build();
		}
	}
	
	@PUT
	@Path("{id}")
	@ApiOperation(value="update user", notes="update user information with chosen ID")
	@Override
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
