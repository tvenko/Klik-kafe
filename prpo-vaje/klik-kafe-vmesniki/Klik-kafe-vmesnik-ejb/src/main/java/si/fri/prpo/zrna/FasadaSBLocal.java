package si.fri.prpo.zrna;

import java.io.IOException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

@Local
public interface FasadaSBLocal {
	
	void addUser(HttpServletResponse response) throws IOException;
	void removeUser(HttpServletResponse response) throws IOException;
	void finadAllUsers(HttpServletResponse response) throws IOException;
	
	void addOrder(HttpServletResponse response) throws IOException;
	void findAllOrders(HttpServletResponse response) throws IOException;
	
	void getBill(HttpServletResponse response) throws IOException;
}
