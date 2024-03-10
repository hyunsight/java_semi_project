package semi02.project.project;

import java.util.ArrayList;

public class SubmitTool {
    //필드
    private String toolName; //TFT 툴 이름

    //생성자
    public SubmitTool(String toolName) {
        this.toolName = toolName;
    }

    // - 기타 getter & setter 구하기
    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }
}
