package controllers.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/product"})
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		request.getRequestDispatcher("/views/admin/product.jsp").forward(request, response);	 
	}

}