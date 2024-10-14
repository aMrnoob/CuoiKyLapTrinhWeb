package controllers.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import serviceImpl.UserServiceImpl;

@WebServlet(urlPatterns = {"/forget-password"})
public class ForgetPasswordController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl(); 

	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    request.getRequestDispatcher("/views/login/forgetPassword.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String email = request.getParameter("email");
    	String password = request.getParameter("pw");

        boolean isValidEmail = false;

        if (email != null && !email.isEmpty()) {
            isValidEmail = userService.checkDuplicate("email", email); 
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"isValidEmail\": " + isValidEmail + "}");
        
        if(isValidEmail)
        {
        	userService.resetPassword(email, password);
        	request.getRequestDispatcher("/views/login/resetPasswordSuccess.jsp").forward(request, response);
        }
    }
}
