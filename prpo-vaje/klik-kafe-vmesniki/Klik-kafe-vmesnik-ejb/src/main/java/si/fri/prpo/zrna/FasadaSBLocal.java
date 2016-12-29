package si.fri.prpo.zrna;

import java.io.IOException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.ponudniki.izjeme.NeveljavnoNarociloException;

@Local
public interface FasadaSBLocal {
	
	boolean checkUsername(String username);
	int submitOrder(String username, String kavarna, String size, String[] napitki, HttpServletResponse response) throws IOException, NeveljavnoNarociloException;
	
	void addUser(HttpServletResponse response) throws IOException;
	void removeUser(HttpServletResponse response) throws IOException;
	void finadAllUsers(HttpServletResponse response) throws IOException;
	
	void findAllOrders(HttpServletResponse response) throws IOException;
	
	void getBill(HttpServletResponse response) throws IOException;
}
