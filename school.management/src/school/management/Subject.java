package school.management;

public class Subject {
    private int subjectId;
    private String subjectName;
    private int gradeId;
    public Subject() {
    	
    }
    public Subject(int subjectId, String subjectName, int gradeId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.gradeId = gradeId;
    }

    public int getSubjectId() { return subjectId; }
    public void setSubjectId(int subjectId) { this.subjectId = subjectId; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public int getGradeId() { return gradeId; }
    public void setGradeId(int gradeId) { this.gradeId = gradeId; }

    @Override
    public String toString() {
        return "Subject [ID=" + subjectId + ", Name=" + subjectName + ", GradeID=" + gradeId + "]";
    }
}