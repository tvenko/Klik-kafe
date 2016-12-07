package si.fri.prpo.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import si.fri.prpo.rest.KavarnaRESTInterface;

@RequestScoped
@Path("/kavarne")
public class KavarnaREST implements KavarnaRESTInterface {

}
