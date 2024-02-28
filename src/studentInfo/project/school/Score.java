package studentInfo.project.school;

//어느 학생의 어느 과목 점수가 몇점이다.
public class Score {
    //필드
    private int studentId; //학번
    private Subject subject; //과목
    private int point; //점수

    //생성자
    public Score(int studentId, Subject subject, int point) {
        this.studentId = studentId;
        this.subject = subject;
        this.point = point;
    }

    //메소드 - 학번, 과목에 대한 점수 출력
    // - 객체의 주소가 아닌 객체의 정보를 출력해주는 기능
    @Override
    public String toString() {
        return "학번: " + this.studentId + ", " + subject.getSubjectName() + ": " + point;
    }

    //메소드 - getter & setter
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
