package student.manager.dao;

import school.management.Student;
import school.management.Subject;
import school.management.Teacher;
import school.management.Grade;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class SchoolDaoImplementation implements SchoolDao {
	private Connection conn;
	Scanner scan = new Scanner(System.in);

	 public SchoolDaoImplementation() {
	        Properties uses = new Properties();

	        // 1. Loading the credentials file from class path
	        try (InputStream in = Thread.currentThread()
	                                   .getContextClassLoader()
	                                   .getResourceAsStream("Credential.properties")) {
	            if (in == null) {
		        	DriverMain.logger.error("Credential file not found");
	            }
	            uses.load(in);
	        } catch (Exception e) {
	        	DriverMain.logger.error(e);
	        }

	        // 🧩 2. Retrieve the values
	        String url = uses.getProperty("url");
	        String user = uses.getProperty("userName");
	        String password = uses.getProperty("password");

	        // 3. Connect using those values
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            DriverMain.logger.info("Failed to connect — check credentials or DB status", e);
	        }
	    }

	@Override
	public void createTables() {
		try (Statement stmt = conn.createStatement()) {
			stmt.execute(
					"CREATE TABLE if not  Exists Grade (gradeId INT AUTO_INCREMENT PRIMARY KEY, gradeName VARCHAR(20))");
			stmt.execute(
					"CREATE TABLE if not  Exists Student (studentId INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), age INT, gender VARCHAR(10), gradeId INT, section VARCHAR(5))");
			stmt.execute(
					"CREATE TABLE if not  Exists Teacher (teacherId INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), subject VARCHAR(50), gradeId INT)");
			stmt.execute(
					"CREATE TABLE if not  Exists Subject (subjectId INT AUTO_INCREMENT PRIMARY KEY, subjectName VARCHAR(50), gradeId INT)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// implementation of one method
	@Override
	public void addGrade(Grade grade) {
		try (PreparedStatement ps = conn.prepareStatement("INSERT INTO Grade (gradeName) VALUES (?)")) {
			ps.setString(1, grade.getGradeName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addStudent(Student s) {
		String sql = "INSERT INTO Student (name, age, gender, gradeId, section) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getGender());
			ps.setInt(4, s.getGradeId());
			ps.setString(5, s.getSection());
			ps.executeUpdate();
			DriverMain.logger.info("Student Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addTeacher(Teacher t) {
		String sql = "INSERT INTO Teacher (name, subject, gradeId) VALUES (?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, t.getName());
			ps.setString(2, t.getSubject());
			ps.setInt(3, t.getGradeId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addSubject(Subject sub) {
		String sql = "INSERT INTO Subject (subjectName, gradeId) VALUES (?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, sub.getSubjectName());
			ps.setInt(2, sub.getGradeId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> viewStudents() {
		List<Student> students = new ArrayList<>();
		String query = "SELECT * FROM Student";
		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("studentId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				int gradeId = rs.getInt("Id");
				String section = rs.getString("section");
				students.add(new Student(id, name, age, gender, gradeId, section));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public List<Teacher> viewTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		String query = "SELECT * FROM Teacher";
		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("teacherId");
				String name = rs.getString("name");
				String subject = rs.getString("subject");
				int gradeId = rs.getInt("grade");
				teachers.add(new Teacher(id, name, subject, gradeId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}

	@Override
	public List<Grade> viewGrades() {
		List<Grade> grades = new ArrayList<>();
		String query = "SELECT * FROM Grade";
		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("grdId");
				String name = rs.getString("gradeName");
				grades.add(new Grade(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grades;
	}

	@Override
	public List<Subject> viewSubjects() {
		List<Subject> subjects = new ArrayList<>();
		String query = "SELECT * FROM Subject";
		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			DriverMain.logger.info("Enter Grade id: ");
			int ch = scan.nextInt();
			while (rs.next()) {
				int gId = rs.getInt("subjectId");
				if (gId == ch) {
					int id = gId;
					String name = rs.getString("subjectName");
					int gradeId = rs.getInt("gradeId");
					subjects.add(new Subject(id, name, gradeId));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjects;
	}

	@Override
	public void editStudent(Student s) {
		DriverMain.logger.info("Enter Student Id: ");
		int sId = scan.nextInt();
		String sql = ("UPDATE Student SET name = ?, age = ?, gender = ?, gradeId = ?, section = ? WHERE studentId ="
				+ sId);

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			DriverMain.logger.info(s.getName() + "Enter Correct Name : ");
			ps.setString(1, scan.next());
			DriverMain.logger.info("");
			DriverMain.logger.info(s.getAge() + "Enter Correct Age : ");
			ps.setInt(2, scan.nextInt());
			DriverMain.logger.info("Enter Correct gender : ");
			ps.setString(3, scan.next());
			DriverMain.logger.info("Enter Correct gradeId : ");
			ps.setInt(4, scan.nextInt());
			DriverMain.logger.info("Enter Correct Section : ");
			ps.setString(5, scan.next());
			ps.executeUpdate();
			DriverMain.logger.info("Changes Accepted!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editTeacher(Teacher t) {
		String sql = "UPDATE Teacher SET name = ?, subject = ?, gradeId = ? WHERE teacherId = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, t.getName());
			ps.setString(2, t.getSubject());
			ps.setInt(3, t.getGradeId());
			ps.setInt(4, t.getTeacherId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editGrade(Grade g) {
		String sql = "UPDATE Grade SET gradeName = ? WHERE gradeId = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, g.getGradeName());
			ps.setInt(2, g.getGradeId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editSubject(Subject s) {
		String sql = "UPDATE Subject SET subjectName = ?, gradeId = ? WHERE subjectId = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, s.getSubjectName());
			ps.setInt(2, s.getGradeId());
			ps.setInt(3, s.getSubjectId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}