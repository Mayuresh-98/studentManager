package com.studentmanager.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentmanager.dao.StudentDAO;
import com.studentmanager.model.Student;

@WebServlet("/student/edit")
public class StudentEditServlet extends HttpServlet {
	private final StudentDAO studentDAO = new StudentDAO();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentDAO.findById(id);

		request.setAttribute("student", student);

		request.getRequestDispatcher("/WEB-INF/views/editStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String course = request.getParameter("course");

		Student student = new Student(name, email, age, course);
		student.setId(id);
		studentDAO.update(student);

		response.sendRedirect(request.getContextPath() + "/students");
	}

}
