<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.studentmanager.model.Student"%>

<%
List<Student> students = (List<Student>) request.getAttribute("students");
%>

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

				<%
				for (Student student : students) {
				%>

				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getName()%></td>
					<td><%=student.getEmail()%></td>
					<td><%=student.getAge()%></td>
					<td><%=student.getCourse()%></td>

					<td><a class="action-link action-edit"
						href="<%=request.getContextPath()%>/student/edit?id=<%=student.getId()%>">
							Edit </a></td>

					<td><a class="action-link action-delete"
						href="<%=request.getContextPath()%>/student/delete?id=<%=student.getId()%>">
							Delete </a></td>
				</tr>

				<%
				}
				%>

			</tbody>

		</table>

		<a class="action-link"
			href="${pageContext.request.contextPath}/student/register">
			Register New Student </a>

	</div>

</body>
</html>