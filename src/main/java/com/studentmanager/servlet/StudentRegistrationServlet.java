package com.studentmanager.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.studentmanager.dao.StudentDAO;
import com.studentmanager.model.Student;
import com.studentmanager.util.SQLExceptionUtil;

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
		try {
			studentDAO.save(student);
			request.getSession().setAttribute("success", "Student registered successfully.");
			response.sendRedirect(request.getContextPath() + "/students");
		} catch (SQLException e) {
			request.setAttribute("error", SQLExceptionUtil.getUserMessage(e));
			request.setAttribute("student", student);

			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
		}

	}

}
