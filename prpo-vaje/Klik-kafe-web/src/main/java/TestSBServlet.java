

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.zrna.FasadaSB;

/**
 * Servlet implementation class TestSBServlet
 */


public class TestSBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FasadaSB f;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		f.finadAllUsers(response);
		f.addUser(response);
		f.removeUser(response);
		f.addOrder(response);*/
		
		String message = "Hello World";
        request.setAttribute("message", message); // This will be available as ${message}
        response.getContentType();
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = null;
		if(request.getParameter("username") != null){
		   username = request.getParameter("username");
		}
		if(f.checkUsername(username)) {
			response.getWriter().append("uspesno prijavljen");
		}
		else {
			response.getWriter().append("ni pravilno uporabnisko ime");
		}
	}

}
