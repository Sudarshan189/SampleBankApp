<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success/ Error</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="card m-5">
		<div class="card-header">Status</div>
		<div class="m-3">
			<c:if test="${requestScope.success == true || param.success == true}">
				<div class="alert alert-success" role="alert">
					<h4 class="alert-heading">Your request Completed</h4>
					<p>Your request has been completed succesfully. Thank u for
						using this service...</p>
					<hr>
					<p class="mb-0">
						Are u done,.. Please <a href="account">click here</a> to go
						Home....
					</p>
				</div>
			</c:if>
			<c:if test="${requestScope.success == false}">
				<div class="alert alert-danger" role="alert">
					<h4 class="alert-heading">Your request not completed</h4>
					<p>Error:= ${requestScope.error}</p>
					<hr>
					<p class="mb-0">
						Are u done,.. Please <a href="account">click here</a> to go
						Home....
					</p>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>