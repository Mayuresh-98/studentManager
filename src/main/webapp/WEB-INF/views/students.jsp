<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered Students</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

	<div class="container">
		<div class="title-bar">
			<h1>Registered Students</h1>
			<a class="action-link" href="${pageContext.request.contextPath}/home">
				Go To Home</a>
		</div>

		<c:if test="${not empty sessionScope.success}">
			<div class="success-message">${sessionScope.success}</div>
			<c:remove var="success" scope="session" />
		</c:if>

		<c:if test="${not empty sessionScope.error}">
			<div class="error-message">${sessionScope.error}</div>
			<c:remove var="error" scope="session" />
		</c:if>

		<c:choose>
			<c:when test="${not empty error}">
				<!-- Don't show empty message or table -->
			</c:when>

			<c:when test="${empty students }">
				<div class="empty-msg">
					<p>No students registered yet.</p>
				</div>

			</c:when>

			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Age</th>
							<th>Course</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="student" items="${students}">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.email}</td>
								<td>${student.age}</td>
								<td>${student.course}</td>
								<td><a class="action-link action-edit"
									href="${pageContext.request.contextPath}/student/edit?id=${student.id}">
										Edit </a></td>
								<td><a class="action-link action-delete"
									href="${pageContext.request.contextPath}/student/delete?id=${student.id}">
										Delete </a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>


		<a class="action-link"
			href="${pageContext.request.contextPath}/student/register">
			Register New Student </a>

	</div>

</body>
</html>