package si.fri.prpo.rest;


import javax.ws.rs.core.Response;

import si.fri.prpo.vaje.entitete.Uporabnik;

public interface UporabnikRESTInterface {
	
	public Response getUsers();
	public Response getUser(int id);
	public Response addUser(Uporabnik usr);
	public Response deleteUser(int id);

}
