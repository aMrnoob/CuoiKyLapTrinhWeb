<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang chủ</title> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" integrity="sha384-1CmrxMRARb6aLqgBO7VVf0SzP+UlwzwyFw4klZ+khcAhmGn8So7rH2yKD5nMjNA2" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-4 d-flex justify-content-center" style="margin: 0 0 0 -80px;">
		<div style="width: 90%; max-width: 900px;">
			<h3 class="mb-4 text-center">Thông tin cửa hàng</h3>
			<%
				User user = (User) session.getAttribute("vendorInfor");
				String userId = user != null ? user.getUserId() : "";
			%>
			<form action="${pageContext.request.contextPath}/vendor/register-shop" method="post" enctype="multipart/form-data">
				<div class="row mb-5">	
					<div class="col-md-6">
						<label for="shopName" class="form-label">Mã chủ cửa hàng:</label> 
						<strong class="form-control" style="display: block; padding: 0.375rem 0.75rem; border: 1px solid #ced4da; border-radius: 0.25rem; background-color: #e9ecef; color: #495057;"> 
    						<%= userId %> 
						</strong>
						<input type="hidden" name="userId" value="<%= userId %>">
					</div>
					<div class="col-md-6">
						<label for="status" class="form-label">Trạng thái:</label> <select
							class="form-select" id="status" name="status" required
							style="width: 100%;">
							<option selected disabled>Chọn trạng thái</option>
							<option value="active">Hoạt động</option>
							<option value="inactive">Không hoạt động</option>
						</select>
					</div>
				</div>
				<div class="row mb-5">
					<div class="col-md-12">
						<label for="description" class="form-label">Tên cửa hàng:</label>
						<textarea class="form-control" id="shopName" name="shopName"
							rows="1" placeholder="Nhập tên cửa hàng" required
							style="width: 100%;"></textarea>
					</div>
				</div>
				<div class="row mb-5">
					<div class="col-md-12">
						<label for="shopName" class="form-label">Mô tả:</label> <input
							type="text" class="form-control" id="description" name="description"
							placeholder="Mô tả về cửa hàng (nếu muốn)" required style="width: 100%;">
					</div>
				</div>
				<div class="d-flex justify-content-end" style="transform: translateX(-370px);">
					<button type="submit" class="btn btn-primary mt-3" style=" background-color: #3498db;">Lưu
						thông tin</button>
				</div>
			</form>
		</div>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7VVf0SzP+UlwzwyFw4klZ+khcAhmGn8So7rH2yKD5nMjNA2" crossorigin="anonymous"></script>
</body>
</html>