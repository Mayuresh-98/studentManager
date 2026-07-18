package com.studentmanager.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentmanager.dao.StudentDAO;
import com.studentmanager.model.Student;

@WebServlet("/student/register")
public class StudentRegistrationServlet extends HttpServlet {
	private final StudentDAO studentDAO = new StudentDAO();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String course = request.getParameter("course");

		Student student = new Student(name, email, age, course);
		studentDAO.save(student);

		response.sendRedirect(request.getContextPath() + "/students");
	}

}
