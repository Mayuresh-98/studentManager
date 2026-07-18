<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

	<div class="container">
		<div class="title-bar">
			<h1>Student Registration</h1>
			<a class="action-link" href="${pageContext.request.contextPath}/home">
				Go To Home</a>
		</div>
		

		<form action="${pageContext.request.contextPath}/student/register"
			method="post">

			<div class="form-group">
				<label>Name</label> <input type="text" name="name" required>
			</div>

			<div class="form-group">
				<label>Email</label> <input type="email" name="email" required>
			</div>

			<div class="form-group">
				<label>Age</label> <input type="number" name="age" required>
			</div>

			<div class="form-group">
				<label>Course</label> <input type="text" name="course" required>
			</div>

			<button type="submit">Register Student</button>

		</form>

	</div>

</body>
</html>