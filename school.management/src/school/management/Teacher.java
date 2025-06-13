package school.management;

public class Teacher {
	private int teacherId;
	private String name;
	private String subject;
	private int gradeId;

	public Teacher() {

	}

	public Teacher(int teacherId, String name, String subject, int gradeId) {
		this.teacherId = teacherId;
		this.name = name;
		this.subject = subject;
		this.gradeId = gradeId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	@Override
	public String toString() {
		return "Teacher [ID=" + teacherId + ", Name=" + name + ", Subject=" + subject + ", GradeID=" + gradeId + "]";
	}
}