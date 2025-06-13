package school.management;

import java.util.Scanner;
import student.manager.dao.*;

public class OutputMethod {

	SchoolDao dao = new SchoolDaoImplementation();
//	OutputMethod outputMethods = new OutputMethod();

	public OutputMethod() { /**
							 * just to
							 **/
	}

	public static Scanner scanner = new Scanner(System.in);

	public void addGrade(OutputMethod outputMethods) {

		DriverMain.logger.info("Available Grades are: ");
		dao.viewGrades().forEach(g -> DriverMain.logger.info(g.toString()));
		DriverMain.logger.info("Enter Grade Name: ");
		String gradeName = scanner.nextLine();
		dao.addGrade(new Grade(0, gradeName));
	}

	public void addSubject(OutputMethod outputMethods) {

		DriverMain.logger.info("Enter Subject Name: ");
		String subjectName = scanner.nextLine();
		outputMethods.gradeIdInput();
		int subjectGradeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		dao.addSubject(new Subject(0, subjectName, subjectGradeId));
	}

	public void addTeacher(OutputMethod outputMethods) {

		DriverMain.logger.info("Enter Teacher Name: ");
		String teacherName = scanner.nextLine();
		DriverMain.logger.info("Enter Subject: ");
		String teacherSubject = scanner.nextLine();
		outputMethods.gradeIdInput();
		int teacherGradeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		dao.addTeacher(new Teacher(0, teacherName, teacherSubject, teacherGradeId));
	}

	public void addStudent(OutputMethod outputMethods) {

		DriverMain.logger.info("Enter Student Name: ");
		String studentName = scanner.nextLine();
		DriverMain.logger.info("Enter Age: ");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter Gender: ");
		String gender = scanner.nextLine();
		outputMethods.gradeIdInput();
		int studentGradeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter Section: ");
		String section = scanner.nextLine();
		dao.addStudent(new Student(0, studentName, age, gender, studentGradeId, section));
	}

	/**
	 * view Methods are declared here
	 * 
	 * @return
	 */

	public void viewGrade() {
		dao.viewGrades().forEach(DriverMain.logger::info);
	}

	public void viewSubject() {
		dao.viewSubjects().forEach(g -> DriverMain.logger.info(g.toString()));
	}

	public void viewTeacher() {
		dao.viewGrades().forEach(g -> DriverMain.logger.info(g.toString()));
	}

	public void viewStudents() {
		dao.viewStudents().forEach(g -> DriverMain.logger.info(g.toString()));
	}
	
	/**
	 * edit methods  are declared here and called from DriverMain class
	 * @return
	 */
	
	public void editGrade(){
		DriverMain.logger.info("Enter Grade ID to edit: ");
		int gradeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter new Grade Name: ");
		String gradeName = scanner.nextLine();
		dao.editGrade(new Grade(gradeId, gradeName));
		
	}
	
	public void editSubject(OutputMethod outputMethods) {
		DriverMain.logger.info("Enter Subject ID to edit: ");
		int subjectId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter new Subject Name: ");
		String subjectName = scanner.nextLine();
		outputMethods.gradeIdInput();
		int gradeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		dao.editSubject(new Subject(subjectId, subjectName, gradeId));
	}
	
	public void editTeacher(OutputMethod outputMethods) {
		DriverMain.logger.info("Enter Teacher ID to edit: ");
		int teacherId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter new Teacher Name: ");
		String teacherName = scanner.nextLine();
		DriverMain.logger.info("Enter new Subject: ");
		String teacherSubject = scanner.nextLine();
		outputMethods.gradeIdInput();
		int gradeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		dao.editTeacher(new Teacher(teacherId, teacherName, teacherSubject, gradeId));
	}
	
	public void editStudents(OutputMethod outputMethods) {
		DriverMain.logger.info("Enter Student ID to edit: ");
		int studentId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter new Student Name: ");
		String studentName = scanner.nextLine();
		DriverMain.logger.info("Enter new Age: ");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter new Gender: ");
		String gender = scanner.nextLine();
		outputMethods.gradeIdInput();
		int gradeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		DriverMain.logger.info("Enter new Section: ");
		String section = scanner.nextLine();
		dao.editStudent(new Student(studentId, studentName, age, gender, gradeId, section));
	}

	public int id() {
		DriverMain.logger.info("enter id");
		int id1 = scanner.nextInt();
		return id1;
	}

	public void choice() {
		DriverMain.logger.info("Enter your choice: ");
	}

	public void defaultFunction() {
		DriverMain.logger.info(" Invalid choice. Please try again.");
	}

	public void gradeIdInput() {
		DriverMain.logger.info("Enter Grade Id");
	}

	public void createTables() {
		dao.createTables();
	}
}
