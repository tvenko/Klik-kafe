package si.fri.prpo.rest;

import javax.ws.rs.core.Response;

public interface NarociloRESTInterface {
	
	public Response getOrders();
	public Response getOrder(int id);
	public Response getUserOrders(int userId);
	public Response cancelOrder(int id);
	public Response submitOrder(int idUporabnik, int idKavarna, String size, String[] napitki);
	
}
