package com.studentmanager.util;

public class AuthenticationUtil {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin@123";

    private AuthenticationUtil() {
    }

    public static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}