package controllers.noLayout;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/footer-complaint-policy"})
public class ComplaintPolicyController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    request.getRequestDispatcher("/views/noLayout/complaintPolicy.jsp").forward(request, response);
	}
}