package com.studentmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanager.model.Student;
import com.studentmanager.util.DBConnection;

public class StudentDAO {

	public void save(Student student) throws SQLException {

		String sql = "INSERT INTO students (name, email, age, course) VALUES (?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setInt(3, student.getAge());
			ps.setString(4, student.getCourse());

			ps.executeUpdate();

		}
	}

	public List<Student> findAll() throws SQLException {

		List<Student> students = new ArrayList<>();

		String sql = "SELECT * FROM students ORDER BY id ASC";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				Student student = new Student(rs.getString("name"), rs.getString("email"), rs.getInt("age"),
						rs.getString("course"));

				student.setId(rs.getInt("id"));

				students.add(student);
			}

		}

		return students;
	}

	public Student findById(int id) throws SQLException {
		Student student = null;
		String sql = "SELECT id, name, email, age, course FROM students WHERE id = ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					student = new Student(rs.getString("name"), rs.getString("email"), rs.getInt("age"),
							rs.getString("course"));

					student.setId(rs.getInt("id"));
				}
			}

		}

		return student;
	}

	public boolean update(Student updatedStudent) throws SQLException {
		String sql = "UPDATE students SET name = ?, email = ?, age = ?, course = ? WHERE id = ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, updatedStudent.getName());
			ps.setString(2, updatedStudent.getEmail());
			ps.setInt(3, updatedStudent.getAge());
			ps.setString(4, updatedStudent.getCourse());
			ps.setInt(5, updatedStudent.getId());

			return ps.executeUpdate() == 1;

		}

	}

	public boolean deleteById(int id) throws SQLException {
		String sql = "DELETE FROM students WHERE id = ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() == 1;

		}
	}
}