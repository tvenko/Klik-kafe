

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.zrna.FasadaSB;
import si.fri.prpo.zrna.NeveljavnoNarociloException;

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
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String kavarna = request.getParameter("kavarna");
		String size = request.getParameter("size");
		String[] napitki = request.getParameterValues("napitek");
		int orderId = -1;
		try {
			orderId = f.submitOrder(username, kavarna, size, napitki, response);
		} catch (NeveljavnoNarociloException nnex) {
			response.getWriter().append(nnex.error());
			return;
		}
		
		if( orderId >= 0) {
			// Order was added successfully without any exceptions
			response.getWriter().append("Uspesno ste oddali svoje narocilo:\n");
			response.getWriter().append("ID vasega narocila je " + Integer.toString(orderId));
		}
		else {
			// The order ID is negative and no exceptions
			response.getWriter().append("NAPAKA");
		}
	}

}
