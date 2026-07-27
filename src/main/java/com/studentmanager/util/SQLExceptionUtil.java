package com.studentmanager.util;

import java.sql.SQLException;

public class SQLExceptionUtil {
	public static String getUserMessage(SQLException e) {
		switch (e.getSQLState()) {

		case "23505":
			return "Email is already registered.";

		case "23514":
			return "Age must be greater than 0.";

		default:
			return "Something went wrong. Please try again.";
		}
	}
}
