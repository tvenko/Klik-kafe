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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import si.fri.prpo.rest.KavarnaRESTInterface;
import si.fri.prpo.vaje.entitete.Kavarna;
import si.fri.prpo.zrna.UpravljalecKavarnSBLocal;

@Api(value="/kavarne")
@RequestScoped
@PermitAll
@Path("/kavarne")
@Produces({"application/json"})
@Consumes({"application/json"})
public class KavarnaREST implements KavarnaRESTInterface {

	@EJB UpravljalecKavarnSBLocal uk;
	
	@GET
	@ApiOperation(value="return all kavarnas", notes="return list of all cavarnas in database", response=Kavarna.class, responseContainer="list")
	@Override
	public Response returnAll() {
		ArrayList<Kavarna> kavarnas = uk.returnAll();
		return Response.ok(kavarnas).build();
	}
	
	@GET
	@Path("{id}")
	@ApiOperation(value="return kavarna", notes="return kavarna by chosen ID", response=Kavarna.class)
	@Override
	public Response returnById(@PathParam("id") int id) {
		Kavarna kavarna = uk.returnById(id);
		return Response.ok(kavarna).build();
	}

}
