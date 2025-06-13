package student.manager.dao;

import school.management.*;

import java.util.List;

public interface SchoolDao {
	void createTables();

	void addGrade(Grade grade);

	void addStudent(Student student);

	void addTeacher(Teacher teacher);

	void addSubject(Subject subject);

	List<Student> viewStudents();

	List<Teacher> viewTeachers();

	List<Grade> viewGrades();

	List<Subject> viewSubjects();

	void editStudent(Student student);

	void editTeacher(Teacher teacher);

	void editGrade(Grade grade);

	void editSubject(Subject subject);
}
