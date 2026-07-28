package com.studentmanager.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session Created : " + se.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session Destroyed : " + se.getSession().getId());
	}

}
