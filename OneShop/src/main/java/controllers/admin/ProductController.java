package controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Product;
import service.ProductService;
import serviceImpl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/admin/product"})
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		List<Product> products = productService.getAllProducts();

		request.setAttribute("products", products);	
		request.getRequestDispatcher("/views/admin/product.jsp").forward(request, response);
	}
}
