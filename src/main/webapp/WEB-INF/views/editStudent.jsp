<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.studentmanager.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div class="container">

		<h1>Update Student</h1>
		<%
		Student student = (Student) request.getAttribute("student");
		%>

		<form action="${pageContext.request.contextPath}/student/edit"
			method="post">

			<div class="form-group">
				<input type="hidden" name="id" value="<%=student.getId()%>">
			</div>


			<div class="form-group">
				<label>Name</label> <input type="text" name="name"
					value="<%=student.getName()%>" required>
			</div>

			<div class="form-group">
				<label>Email</label> <input type="email" name="email"
					value="<%=student.getEmail()%>" required>
			</div>

			<div class="form-group">
				<label>Age</label> <input type="number" name="age"
					value="<%=student.getAge()%>" required>
			</div>

			<div class="form-group">
				<label>Course</label> <input type="text" name="course"
					value="<%=student.getCourse()%>" required>
			</div>

			<button type="submit">Update Student</button>

		</form>

	</div>

</body>
</html>