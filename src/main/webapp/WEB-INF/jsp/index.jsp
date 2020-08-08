<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body
	background="http://www.designbolts.com/wp-content/uploads/2013/02/Nasty-Fabric-Grey-Seamless-Patterns-For-Website-Background.jpg">


	<%@ include file="header.jsp"%>

	<div class="row m-2">
		<div class="col-md-6 mt-5 ml-5 mr-0 mb-5">
			<div class="card" style="width: 23rem;">
				<div class="card-body">
					<h3>Your Money. Your Way</h3>
					<p style="font-size: 12px">simply dummy text of the printing
						and typesetting industry. Lorem Ipsum has been the industry's
						standard dummy text ever survived not only five was popularised in
					</p>
				<%--  <form action="login" method="post">
						<div class="form-group input-group-md">
							<label for="exampleInputEmail1">Customer ID</label> <input
								type="number" name="custId" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Coustomer ID">
						</div>
						<div class="form-group input-group-md">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" name="password" class="form-control"
								id="exampleInputPassword1" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-primary btn-sm btn-block">Submit</button>
						<br>
						<c:if test="${requestScope.success == false}">
							<div class="alert alert-danger" role="alert">
								<b>Customer not found!!!!</b>
							</div>
						</c:if>
						<c:if test="${requestScope.logout == true}">
							<div class="alert alert-danger" role="alert">
								<b>Successfully Logged out!!</b>
							</div>
						</c:if>
					</form> --%>
					
					<!--Start  -->
				 	<form:form action="login" method="post" modelAttribute="customer">
						<div class="form-group input-group-md">
							<label for="exampleInputEmail1">Customer ID</label> <form:input
								type="number" name="custId" class="form-control" path="customerId"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Coustomer ID"/>
						</div>
						<div class="form-group input-group-md">
							<label for="exampleInputPassword1">Password</label> <form:input
								type="password" name="password" class="form-control" path="password"
								id="exampleInputPassword1" placeholder="Password"/>
						</div>
						<button type="submit" class="btn btn-primary btn-sm btn-block">Submit</button>
						<br>
						<c:if test="${requestScope.success == false}">
							<div class="alert alert-danger" role="alert">
								<b>Customer not found!!!!</b>
							</div>
						</c:if>
						<c:if test="${requestScope.logout == true}">
							<div class="alert alert-danger" role="alert">
								<b>Successfully Logged out!!</b>
							</div>
						</c:if>
					</form:form> 
					<!--End  -->
				</div>
			</div>
		</div>
		<div class="col-md-5 mt-5">
			<h1>Earn 5% Interest..</h1>
			<p>It is a long established fact that a reader will be distracted
				by the readable content of a page when looking at its layout. The
				point of using Lorem Ipsum is that it has a more-or-less normal
				distribution of letters, as opposed to using 'Content here, content
				here', making it look like readable English. Many desktop publishing
				packages and web page editors now use Lorem Ipsum as their default
				model text, and a search for 'lorem</p>
		</div>
	</div>




	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>