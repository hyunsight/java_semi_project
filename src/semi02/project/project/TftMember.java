package semi02.project.project;

import semi02.project.position.Position;
import semi02.project.position.JuniorPosition;
import semi02.project.position.SemiSeniorPosition;
import semi02.project.position.SeniorPosition;

import java.util.ArrayList;

public class TftMember {
    //필드
    private String memberName; //TFT 구성원 이름
    private String memberID; //TFT 구성원 ID
    private String memberDept; //TFT 구성원 부서
    private int memberYearsOfExp; //TFT 구성원 연차
    private Position position; //TFT 구성원 직급 (Position 타입)
    private ArrayList<SubmitCount> countList = new ArrayList<>(); //TFT 구성원별 서밋 카운트 리스트 생성하기

    //생성자
    public TftMember(String memberName, String memberID, String memberDept, int memberYearsOfExp) {
        this.memberName = memberName;
        this.memberID = memberID;
        this.memberDept = memberDept;
        this.memberYearsOfExp = memberYearsOfExp;
        getPosition(memberYearsOfExp);
    }

    //메소드
    // - TFT 구성원 직급 구하기
    public void getPosition(int memberYearsOfExp) {
        if (memberYearsOfExp >= 7) {
            this.position = new SeniorPosition();
        } else if (memberYearsOfExp >= 4) {
            this.position = new SemiSeniorPosition();
        } else this.position = new JuniorPosition();
    }

    //  - TFT 구성원별 서밋 카운트 추가하기 (리스트 내)
    public void addSubmitCount (SubmitCount submitCount) {
        countList.add(submitCount);
    }

    // - 기타 getter & setter 구하기
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

    public String getMemberDept() {
        return memberDept;
    }

    public void setMemberDept(String memberDept) {
        this.memberDept = memberDept;
    }

    public int getMemberYearsOfExp() {
        return memberYearsOfExp;
    }

    public void setMemberYearsOfExp(int memberYearsOfExp) {
        this.memberYearsOfExp = memberYearsOfExp;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ArrayList<SubmitCount> getCountList() {
        return countList;
    }

    public void setCountList(ArrayList<SubmitCount> countList) {
        this.countList = countList;
    }
}