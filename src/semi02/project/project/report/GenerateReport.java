package semi02.project.project.report;

import semi02.project.position.Position;
import semi02.project.position.JuniorPosition;
import semi02.project.position.SemiSeniorPosition;
import semi02.project.position.SeniorPosition;
import semi02.project.project.Tft;
import semi02.project.project.TftMember;
import semi02.project.project.SubmitTool;
import semi02.project.project.SubmitCount;
import semi02.project.utils.Define;

import java.util.ArrayList;

public class GenerateReport {
    /*
    //싱글톤 객체 생성
    Tft tft = Tft.getInstance();

    public static final String TITLE = "TFT 구성원 별 업무 능률 \n";
    public static final String HEADER = "이름 | ID | 부서 | 연차 | Perforce | Jira | 업무 능률 \n";
    public static final String LINE = "----------------------------- \n";

    //StringBuffer 객체 생성
    private StringBuffer buffer = new StringBuffer();

    //메소드
    // - 전체 리포트 작성하기
    public String getReport() {

        ArrayList<SubmitTool> toolList = tft.getSubmitToolList();

        for(SubmitTool tool : toolList) {
            makeHeader();
            SubmitTool submitTool;
            makeBody(submitTool);
            makeFooter();
        }
    }

    // - 헤더 작성하기
    public void makeHeader() {
        buffer.append(TITLE);
        buffer.append(HEADER);
        buffer.append(LINE);
    }

    // - 바디 작성하기
    public void makeBody(SubmitTool submitTool) {
        ArrayList<TftMember> memberList = submitTool.getMemberList();

        for (int i = 0; i < memberList.size(); i++) {
            TftMember member = memberList.get(i);
            buffer.append(member.getMemberName());
            buffer.append("|");
            buffer.append(member.getMemberID());
            buffer.append("|");

            getEfficiency(member, submitTool);
            buffer.append("\n");
            buffer.append(LINE);
        }
    }

    // - 푸터 작성하기
    public void makeFooter() {
        buffer.append("\n");
    }

    public void getEfficiency(TftMember member, SubmitTool submitTool) {

        ArrayList<SubmitCount> submitCountList = member.getCountList();

        Position[] positions = {
                new SeniorPosition(), new SemiSeniorPosition(), new JuniorPosition()};

        for (int i = 0; i > submitCountList.size(); i++) {
            SubmitCount submitCount = submitCountList.get(i);

            if (submitCount.getSubmitTool().equals("Jira")) {
                int efficiency;

                if (member.getPosition() == 0) {
                    efficiency = positions[Define.SENIOR_POSITION].getEfficiency(submitTool.getToolName(), submitCount.getSubmitCount());
                } else if (member.getMemberPosition() == 1) {
                    efficiency = positions[Define.SEMISENIOR_POSITION].getEfficiency(submitTool.getToolName(), submitCount.getSubmitCount());
                } else if (member.getMemberPosition() == 2) {
                    efficiency = positions[Define.JUNIOR_POSITION].getEfficiency(submitTool.getToolName(), submitCount.getSubmitCount());
                    buffer.append(submitCount.getSubmitCount());
                    buffer.append(":");
                    buffer.append(efficiency);
                    buffer.append(" | ");
                }
            }
        }

    }

     */
}

