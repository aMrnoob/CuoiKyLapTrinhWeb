package controllers.vendor;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Order;
import models.Promotion;
import models.User;
import service.OrderService;
import service.PromotionService;
import serviceImpl.OrderServiceImpl;
import serviceImpl.PromotionServiceImpl;

@WebServlet(urlPatterns = {"/vendor/edit-promotion"})
@MultipartConfig
public class EditPromotion extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderServiceImpl();
	private PromotionService promotionService = new PromotionServiceImpl();
	private Promotion promotion;
	private String promotionId;
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = request.getSession(false);
		
		promotionId = request.getParameter("promotionId");
		promotion = promotionService.getPromotionById(promotionId);
		
		if(session != null) {
			User user = (User) httpRequest.getSession().getAttribute("vendorInfor");
			List<Order> listOrder = orderService.getAllOrdersByUserId(user.getUserId());
			
			Set<String> userIdsSet = new HashSet<>();
            for (Order order : listOrder) {
                userIdsSet.add(order.getUserId()); 
            }
            
            session.removeAttribute("editPromotion");
            session.setAttribute("editPromotion", promotion);
            session.removeAttribute("userIdsSet");
			session.setAttribute("userIdsSet", userIdsSet);
		}
		
		request.getRequestDispatcher("/views/vendor/editPromotion.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerId = request.getParameter("customerId");  
	    String decreaseStr = request.getParameter("decrease");
	    int decrease = 0;
	    if (decreaseStr != null && !decreaseStr.isEmpty()) {
	        try {
	            decrease = Integer.parseInt(decreaseStr); 
	        } catch (NumberFormatException e) {
	            e.printStackTrace();  
	        }
	    }

	    String expireDateStr = request.getParameter("expiredate");
	    Date expireDate = null;
	    if (expireDateStr != null && !expireDateStr.isEmpty()) {
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date utilDate = sdf.parse(expireDateStr);
	            expireDate = new java.sql.Date(utilDate.getTime());
	        } catch (Exception e) {
	            e.printStackTrace();  
	        }
	    } 

	    promotion.setUserId(customerId);
	    promotion.setPrice(decrease);
	    promotion.setExpirationDate(expireDate);

	    promotionService.updatePromotion(promotion);
	    
	    request.setAttribute("success", "Cập nhật phiếu giảm giá thành công!");
	    request.getRequestDispatcher("/views/vendor/editPromotion.jsp").forward(request, response); 
	}
}