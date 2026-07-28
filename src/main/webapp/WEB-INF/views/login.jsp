<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="container">
		<div class="title-bar">
			<h1>Student Manager Login</h1>
		</div>

		<c:if test="${not empty error}">
			<div class="error-message">${error}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/login" method="post">

			<div class="form-group">
				<label for="username">Username</label> <input id="username"
					type="text" name="username"
					value="${empty username ? lastUsername : username}"
					autocomplete="username" required>
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input id="password"
					type="password" name="password" autocomplete="current-password"
					required>
			</div>

			<button type="submit">Login</button>

		</form>
	</div>
</body>
</html>