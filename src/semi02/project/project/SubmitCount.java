package semi02.project.project;

public class SubmitCount {
    private String memberName;
    private SubmitTool submitTool;
    private int submitCount;

    public SubmitCount (String memberName, SubmitTool submitTool, int submitCount) {
        this.memberName = memberName;
        this.submitTool = submitTool;
        this.submitCount = submitCount;
    }

    // - getter & setter 구하기
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
