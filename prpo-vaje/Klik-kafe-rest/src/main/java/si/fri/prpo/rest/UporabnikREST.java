package si.fri.prpo.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import si.fri.prpo.rest.UporabnikRESTInterface;

@RequestScoped
@Path("/uporabniki")
public class UporabnikREST implements UporabnikRESTInterface {

}
