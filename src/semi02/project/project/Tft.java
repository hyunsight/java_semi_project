package semi02.project.project;

import java.util.ArrayList;

//싱글톤 구현
public class Tft {
    // - 객체 선언
    private static Tft instance = null;

    //필드
    // - TFT 구성원 및 툴 리스트 생성하기
    private static String TFT_NAME = "New Development";
    private ArrayList<TftMember> memberList = new ArrayList<>();

    private ArrayList<SubmitTool> toolList = new ArrayList<>();

    //생성자
    // - 기본
    private Tft () {}

    // - TFT 생성하기
    public static Tft getInstance() {
       if(instance == null) {
           instance = new Tft();
       }
       return instance;
    }

    //메소드
    // - TFT 구성원 추가하기 (리스트 내)
    public void addTftMember (TftMember member) {
        memberList.add(member);
    }

    // - TFT 구성원 리스트 반환하기
    public ArrayList<TftMember> getTftMemberList () {
        return memberList;
    }

    // - TFT 툴 추가하기 (리스트 내)
    public void addSubmitTool (SubmitTool tool) {
        toolList.add(tool);
    }

    // - TFT 툴 리스트 반환하기
    public ArrayList<SubmitTool> getSubmitToolList () {
        return toolList;
    }
}
