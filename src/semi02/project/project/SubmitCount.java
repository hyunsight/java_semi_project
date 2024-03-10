package semi02.project.project;

public class SubmitCount {
    private String memberName; //TFT 구성원 이름
    private SubmitTool submitTool; //TFT 구성원 서밋에 사용한 툴 (SubmitTool 타입)
    private int submitCount; //TFT 구성원 서밋 수

    //생성자
    public SubmitCount (String memberName, SubmitTool submitTool, int submitCount) {
        this.memberName = memberName;
        this.submitTool = submitTool;
        this.submitCount = submitCount;
    }

    // - 기타 getter & setter 구하기
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public SubmitTool getSubmitTool() {
        return submitTool;
    }

    public void setSubmitTool(SubmitTool submitTool) {
        this.submitTool = submitTool;
    }

    public int getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(int submitCount) {
        this.submitCount = submitCount;
    }
}
