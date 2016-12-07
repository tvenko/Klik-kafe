package si.fri.prpo.rest;

import javax.ws.rs.core.Response;
import si.fri.prpo.vaje.entitete.Narocilo;;

public interface NarociloRESTInterface {
	
	public Response getOrders();
	public Response getOrder(int id);
	public Response getUserOrders(int userId);
	public Response cancelOrder(int id);
	public Response submitOrder(Narocilo narocilo);
	
}
