package semi02.project.project;

import java.util.ArrayList;

//싱글톤 구현
public class Tft {
    // - 객체 선언
    private static Tft instance = null;

    //필드
    private static String TFT_NAME = "New Development";
    private ArrayList<TftMember> memberList = new ArrayList<>();

    private ArrayList<SubmitTool> toolList = new ArrayList<>();

    //생성자
    // - 기본
    private Tft () {}

    // - tft 생성
    public static Tft getInstance() {
       if(instance == null) {
           instance = new Tft();
       }
       return instance;
    }

    //메소드
    // - tft 멤버 추가
    public void addTftMember (TftMember member) {
        memberList.add(member);
    }

    // - tft 멤버 리스트 반환
    public ArrayList<TftMember> getTftMemberList () {
        return memberList;
    }

    // - tft 멤버 추가
    public void addSubmitTool (SubmitTool tool) {
        toolList.add(tool);
    }

    // - tft 멤버 리스트 반환
    public ArrayList<SubmitTool> getSubmitToolList () {
        return toolList;
    }

}
