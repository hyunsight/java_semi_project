package practice01.project.project;

import practice01.project.position.Position;

public class TftMember {
    private String memberName;
    private String memberID;
    private String department;
    private Position position;
    private int perforceCount;
    private int jiraCount;

    public TftMember(String memberName, String memberID, String department, Position position, int perforceCount, int jiraCount) {
        this.memberName = memberName;
        this.memberID = memberID;
        this.department = department;
        this.position = position;
        this.perforceCount = perforceCount;
        this.jiraCount = jiraCount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPerforceCount() {
        return perforceCount;
    }

    public void setPerforceCount(int perforceCount) {
        this.perforceCount = perforceCount;
    }

    public int getJiraCount() {
        return jiraCount;
    }

    public void setJiraCount(int jiraCount) {
        this.jiraCount = jiraCount;
    }
}
