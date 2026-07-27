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

@WebServlet("/student/edit")
public class StudentEditServlet extends HttpServlet {
	private final StudentDAO studentDAO = new StudentDAO();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Student student = null;
		try {
			student = studentDAO.findById(id);
			if (student == null) {
				request.getSession().setAttribute("error", "Student not found.");
				response.sendRedirect(request.getContextPath() + "/students");
				return;
			}
			request.setAttribute("student", student);
			request.getRequestDispatcher("/WEB-INF/views/editStudent.jsp").forward(request, response);
		} catch (SQLException e) {
			request.getSession().setAttribute("error", SQLExceptionUtil.getUserMessage(e));
			response.sendRedirect(request.getContextPath() + "/students");
		}

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
		try {
			boolean updated = studentDAO.update(student);

			if (updated) {
				request.getSession().setAttribute("success", "Student updated successfully.");
				response.sendRedirect(request.getContextPath() + "/students");
				return;
			}

			request.setAttribute("error", "Student not found.");
			request.setAttribute("student", student);
			request.getRequestDispatcher("/WEB-INF/views/editStudent.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error", SQLExceptionUtil.getUserMessage(e));

			// Preserve entered values so the user doesn't have to type again
			request.setAttribute("student", student);

			request.getRequestDispatcher("/WEB-INF/views/editStudent.jsp").forward(request, response);
		}
	}

}
