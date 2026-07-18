package com.studentmanager.dao;

import java.util.ArrayList;
import java.util.List;

import com.studentmanager.model.Student;

public class StudentDAO {

	private static final List<Student> students = new ArrayList<>();
	private static int nextId = 1;

	public void save(Student student) {
		student.setId(nextId++);
		students.add(student);
	}

	public List<Student> findAll() {
		return new ArrayList<>(students);
	}

	public Student findById(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	public boolean update(Student updatedStudent) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == updatedStudent.getId()) {
				students.set(i, updatedStudent);
				return true;
			}
		}
		return false;
	}

	public boolean deleteById(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}
}