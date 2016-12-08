package si.fri.prpo.rest;


import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import si.fri.prpo.vaje.entitete.Uporabnik;

public interface UporabnikRESTInterface {
	
	public Response getUsers();
	public Response getUser(int id);
	public Response addUser(String name, String surname, String username, String email, double latitude, double longitude);
	public Response updateUser(int id, HttpHeaders headers);
	public Response deleteUser(int id);

}
