package semi02.project.project;

import java.util.ArrayList;

public class SubmitTool {
    //필드
    private String toolName;
    private ArrayList<TftMember> memberList = new ArrayList<>();

    //생성자
    public SubmitTool(String toolName) {
        this.toolName = toolName;
    }

    //메소드
    // - submitTool 가입하기
    public void registerTool (TftMember member) {
        memberList.add(member);
    }

    // - getter & setter 구하기
    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public ArrayList<TftMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<TftMember> memberList) {
        this.memberList = memberList;
    }
}
