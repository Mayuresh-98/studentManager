<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management Portal</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>
</head>
<body>
	<div class="container">
		<h1>Student Management Portal</h1>
		<p>Welcome to my first Servlet and JSP application.</p>
		<br>
		<div>
			<a class="action-link"
				href="${pageContext.request.contextPath}/students"> Student List
			</a>
		</div>
		<br>
		<div>
			<a class="action-link"
				href="${pageContext.request.contextPath}/student/register">
				Student Register </a>
		</div>
		<br>
		<div>
			<a class="action-link"
				href="${pageContext.request.contextPath}/logout"> Click Logout </a>
		</div>

	</div>
</body>
</html>