package com.studentmanager.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.studentmanager.dao.StudentDAO;
import com.studentmanager.util.SQLExceptionUtil;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
	private final StudentDAO studentDAO = new StudentDAO();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("students", studentDAO.findAll());
		} catch (SQLException e) {
			request.setAttribute("error", SQLExceptionUtil.getUserMessage(e));
		}

		request.getRequestDispatcher("/WEB-INF/views/students.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
