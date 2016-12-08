package si.fri.prpo.rest;

import javax.ws.rs.core.Response;

public interface KavarnaRESTInterface {
	
	Response returnAll();
	Response returnById(int id);
	
}
