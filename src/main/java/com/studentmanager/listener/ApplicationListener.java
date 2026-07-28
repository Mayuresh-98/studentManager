package com.studentmanager.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("========================================");
		System.out.println("Student Manager Started");
		System.out.println("========================================");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("========================================");
		System.out.println("Student Manager Stopped");
		System.out.println("========================================");
	}

}
