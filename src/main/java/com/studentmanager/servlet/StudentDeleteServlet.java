package com.studentmanager.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.studentmanager.dao.StudentDAO;
import com.studentmanager.util.SQLExceptionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final StudentDAO studentDAO = new StudentDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			boolean deleted = studentDAO.deleteById(id);
			if (deleted) {
				request.getSession().setAttribute("success", "Student deleted successfully.");
			} else {
				request.getSession().setAttribute("error", "Student not found.");
			}
		} catch (SQLException e) {
			request.getSession().setAttribute("error", SQLExceptionUtil.getUserMessage(e));
		}

		response.sendRedirect(request.getContextPath() + "/students");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}