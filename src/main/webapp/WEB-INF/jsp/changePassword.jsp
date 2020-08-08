<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/css/bootstrap.min.css">

<body>

	<%@ include file="header.jsp"%>

	<div class="card m-5">
		<div class="card-header">Change Password</div>
		<div class="m-3">
			<form action="changePassword" method="post" class="row m-2">
				<div class="col-md-4 form-group">
					<label for="exampleInputEmail1">Old Password*</label> <input
						type="password" name="oldPassword" class="form-control" required
						id="exampleInputEmail1" aria-describedby="emailHelp"
						placeholder="Old Password">
				</div>
				<div class="col-md-4 form-group">
					<label for="exampleInputEmail1">New Password*</label> <input
						type="password" name="newPassword" class="form-control" required
						id="exampleInputEmail81" aria-describedby="emailHelp"
						placeholder="New Password">
				</div>
				<div class="col-md-4 form-group">
					<label for="exampleInputEmail1">Confirm Password*</label> <input
						type="password" name="confirmPassword" class="form-control"
						required id="exampleInputsEmai8l1" aria-describedby="emailHelp"
						placeholder="Confirm Password">
				</div>
				<div class="col-md-4 form-group">
					<!--<label for="exampleInputEmail1">Email</label>-->
					<!--<input type="email" class="form-control" id="examxpleInputEmai8l1" aria-describedby="emailHelp" placeholder="Email">-->
				</div>
				<div class="col-md-4 form-group">
					<!--<label for="exampleInputEmail1">Address</label>-->
					<!--<input type="text" class="form-control" id="exampleInputEmai8l1" aria-describedby="emailHelp" placeholder="Address">-->
					<!--<br>-->
					<button class="btn btn-primary btn-block">Change Password</button>
					<br>* - Mandatory fields
				</div>
			</form>
		</div>
	</div>


</body>
</html>