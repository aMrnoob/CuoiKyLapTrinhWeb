<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../static/styles/vendor/left.css">
<link rel="stylesheet" type="text/css" href="../static/styles/vendor/body.css">
<link rel="stylesheet" type="text/css" href="../static/styles/vendor/footer.css">
<title>Vendor (Seller)</title>
</head>
<body>
	<%@ include file= "/common/vendor/header.jsp"%>
	<div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
                <%@ include file="/common/vendor/left.jsp" %>
            </div>
			<div class="col-md-8" style="margin-top: 110px;"> 
                <sitemesh:write property="body"/>
            </div>
        </div>
    </div>
	<%@ include file= "/common/vendor/footer.jsp"%>
</body>
</html>