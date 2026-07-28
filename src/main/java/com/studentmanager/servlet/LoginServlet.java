package com.studentmanager.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.studentmanager.util.AuthenticationUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("lastUsername".equals(cookie.getName())) {
					request.setAttribute("lastUsername", cookie.getValue());
					break;
				}
			}
		}

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (!AuthenticationUtil.authenticate(username, password)) {
			request.setAttribute("username", username);
			request.setAttribute("error", "Invalid username or password.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("user", username);
		session.setMaxInactiveInterval(300);
		Cookie cookie = new Cookie("lastUsername", username);
		cookie.setMaxAge(7 * 24 * 60 * 60);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		response.sendRedirect(request.getContextPath() + "/home");
	}

}
