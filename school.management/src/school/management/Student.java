package school.management;

public class Student {
	private int studentId;
	private String name;
	private int age;
	private String gender;
	private int gradeId;
	private String section;

	public Student() {

	}

	public Student(int studentId, String name, int age, String gender, int gradeId, String section) {
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.gradeId = gradeId;
		this.section = section;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Student [ID=" + studentId + ", Name=" + name + ", Age=" + age + ", Gender=" + gender + ", GradeID="
				+ gradeId + ", Section=" + section + "]";
	}
}
