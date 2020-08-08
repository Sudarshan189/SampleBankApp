<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>head</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent1"
			aria-controls="navbarSupportedContent1" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent1">
			<img
				src="https://pbs.twimg.com/profile_images/880333363982159872/lA3myMTv_400x400.jpg"
				style="width: 100px; height: 100px">

			<h2>
				<a href="/">HDFC BANK</a>
			</h2>
			<marquee>Welcome to safebank net banking... Thank you for
				choosing us...</marquee>
		</div>
		<div class="d-flex flex-row-reverse"></div>
	</nav>

	<c:if test="${sessionScope.customer.customerName == null}">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a class="nav-link" href="#">Community</a>
					</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a class="nav-link" href="#">Personal</a>
					</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a class="nav-link" href="#">About Us</a>
					</li>
				</ul>
			</div>
		</nav>
	</c:if>

	<c:if test="${sessionScope.customer.customerName != null}">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item active"><a class="nav-link" href="account">Accounts
							<span class="sr-only">(current)</span>
					</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a class="nav-link"
						href="fundtransferPage">Fund Transfer</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a class="nav-link" href="editCustomer">Edit
							Profile</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a class="nav-link"
						href="editPasswordPage">Change Password</a></li>
				</ul>
			</div>
			<div class="d-flex flex-row-reverse">
				<div class="p-2">
					<a class="btn btn-danger btn-sm" href="logout">Logout</a>
				</div>
				<div class="p-2">
					<h6 class="p-0 m-1" style="color: white">Welcome
						${sessionScope.customer.customerName}</h6>
				</div>
				&nbsp;
			</div>
		</nav>
	</c:if>
	<div></div>

</body>
</html>