package controllers.user;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Product;
import models.ProductFavorite;
import models.ProductReview;
import models.User;
import service.ProductService;
import service.UserService;
import serviceImpl.ProductServiceImpl;
import serviceImpl.UserServiceImpl;

@WebServlet(urlPatterns = {"/user/home", "/user/product"})
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();
	User user = new User();
	UserService userService = new UserServiceImpl();
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//List<Product> products = productService.getAllProducts();
		if(url.contains("/user/product")) {
			List<Product> products = productService.getAllProducts();
			request.setAttribute("products", products);

			request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
		
		} else if(url.contains("/user/home")){


			String filter = request.getParameter("filter") != null ? request.getParameter("filter") : "favorite";

			if(filter.equals("favorite")){
				int page = request.getParameter("page") != null ?
						Integer.parseInt(request.getParameter("page")) : 1;

				int pageSize = request.getParameter("pageSize") != null ?
						Integer.parseInt(request.getParameter("pageSize")) : 5;


				// Lấy tổng số sản phẩm (giả sử đã có DAO để đếm)
				int totalProducts = productService.countFavoriteProducts();
				int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

				// Xác định phạm vi trang hiển thị
				int visiblePages = 5; // Số trang muốn hiển thị xung quanh trang hiện tại
				int startPage = Math.max(1, page - visiblePages / 2);
				int endPage = Math.min(totalPages, startPage + visiblePages - 1);

				if (endPage - startPage < visiblePages - 1) {
					startPage = Math.max(1, endPage - visiblePages + 1);
				}
				List<ProductFavorite> products = productService.getPagedFavoriteProducts(page, pageSize);

				request.setAttribute("filter", filter);
				request.setAttribute("products", products);
				request.setAttribute("currentPage", page);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
			}
			else if(filter.equals("new")){
				int page = request.getParameter("page") != null ?
						Integer.parseInt(request.getParameter("page")) : 1;

				int pageSize = request.getParameter("pageSize") != null ?
						Integer.parseInt(request.getParameter("pageSize")) : 5;


				// Lấy tổng số sản phẩm (giả sử đã có DAO để đếm)
				int totalProducts = productService.countNewProducts();
				int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

				// Xác định phạm vi trang hiển thị
				int visiblePages = 5; // Số trang muốn hiển thị xung quanh trang hiện tại
				int startPage = Math.max(1, page - visiblePages / 2);
				int endPage = Math.min(totalPages, startPage + visiblePages - 1);

				if (endPage - startPage < visiblePages - 1) {
					startPage = Math.max(1, endPage - visiblePages + 1);
				}
				List<Product> products = productService.getNewProducts(page, pageSize);

				request.setAttribute("filter", filter);
				request.setAttribute("products", products);
				request.setAttribute("currentPage", page);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
			}
			else if(filter.equals("top-rated")){
				int page = request.getParameter("page") != null ?
						Integer.parseInt(request.getParameter("page")) : 1;

				int pageSize = request.getParameter("pageSize") != null ?
						Integer.parseInt(request.getParameter("pageSize")) : 5;


				// Lấy tổng số sản phẩm (giả sử đã có DAO để đếm)
				int totalProducts = productService.countProductsManyRated();
				int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

				// Xác định phạm vi trang hiển thị
				int visiblePages = 5; // Số trang muốn hiển thị xung quanh trang hiện tại
				int startPage = Math.max(1, page - visiblePages / 2);
				int endPage = Math.min(totalPages, startPage + visiblePages - 1);

				if (endPage - startPage < visiblePages - 1) {
					startPage = Math.max(1, endPage - visiblePages + 1);
				}
				List<ProductReview> products = productService.getProductsManyRated(page, pageSize);

				request.setAttribute("filter", filter);
				request.setAttribute("products", products);
				request.setAttribute("currentPage", page);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);

			}
			else if(filter.equals("all")){
				List<Product> products = productService.getAllProducts();
				request.setAttribute("products", products);

				request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
			}
			else{
				int page = request.getParameter("page") != null ?
						Integer.parseInt(request.getParameter("page")) : 1;

				int pageSize = request.getParameter("pageSize") != null ?
						Integer.parseInt(request.getParameter("pageSize")) : 5;


				// Lấy tổng số sản phẩm (giả sử đã có DAO để đếm)
				int totalProducts = productService.countProducts();
				int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

				// Xác định phạm vi trang hiển thị
				int visiblePages = 5; // Số trang muốn hiển thị xung quanh trang hiện tại
				int startPage = Math.max(1, page - visiblePages / 2);
				int endPage = Math.min(totalPages, startPage + visiblePages - 1);

				if (endPage - startPage < visiblePages - 1) {
					startPage = Math.max(1, endPage - visiblePages + 1);
				}
				List<ProductFavorite> products = productService.getPagedFavoriteProducts(page, pageSize);

				request.setAttribute("filter", filter);
				request.setAttribute("products", products);
				request.setAttribute("currentPage", page);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
			}
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserService userService = new UserServiceImpl();
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); 
        }
        response.sendRedirect(request.getContextPath() + "/login");

    }
}