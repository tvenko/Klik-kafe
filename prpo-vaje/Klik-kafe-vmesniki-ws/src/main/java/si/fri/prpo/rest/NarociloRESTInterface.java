package si.fri.prpo.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import si.fri.prpo.vaje.entitete.Narocilo;;

@RequestScoped
public interface NarociloRESTInterface {
	
	public Response getOrders();
	public Response getOrder(int id);
	public Response getUSerOrders(int userId);
	public Response cancelOrder(int id);
	public Response submitOrder(Narocilo narocilo);
	
}
