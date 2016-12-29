package si.fri.prpo.rest;

import javax.ws.rs.core.Response;

import si.fri.prpo.zrna.NeveljavnoNarociloException;

public interface NarociloRESTInterface {
	
	public Response getOrders(int offset, int step);
	public Response getOrder(int id);
	public Response getUserOrders(int userId);
	public Response cancelOrder(int id);
	public Response submitOrder(int idUporabnik, int idKavarna, String size, String[] napitki) throws NeveljavnoNarociloException;
	
}
