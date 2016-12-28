

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJDBCServlet
 */
public class TestJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestJDBCServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection povezava = null;
		UporabnikDaolmpl usr_dao = new UporabnikDaolmpl();
		try {
			povezava = usr_dao.getConnection();
			ArrayList<UporabnikJDBC> u = usr_dao.vrniVse(povezava);
			response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
			response.getWriter().append("Uporabniki: \n");
			for (UporabnikJDBC usr : u) {
				response.getWriter().append(usr.getName() + " " + usr.getSurname() + ", " + usr.getEmail() + ", @(" + Double.toString(usr.getLatitude()) + ""
						+ " lat, " + Double.toString(usr.getLongitude()) + " long)\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
