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
    //싱글톤 객체 생성
    Tft tft = Tft.getInstance();

    public static final String TITLE = "TFT 구성원 별 업무 능률 \n";
    public static final String HEADER = "이름 | ID | 부서 | 연차 | Perforce | Jira | 업무능률 \n";
    public static final String LINE = "------------------------------------------------- \n\n";

    //StringBuffer 객체 생성
    private StringBuffer buffer = new StringBuffer();

    //메소드
    // - 전체 리포트 작성하기
    public String getReport() {
        makeHeader();
        makeBody();
        makeFooter();
        return buffer.toString();
    }

    // - 헤더 작성하기
    public void makeHeader() {
        buffer.append(TITLE);
        buffer.append(HEADER);
        buffer.append(LINE);
    }

    // - 바디 작성하기
    public void makeBody() {
        ArrayList<TftMember> memberList = tft.getTftMemberList();

        for (TftMember member : memberList) {
            buffer.append(member.getMemberName());
            buffer.append(" | ");
            buffer.append(member.getMemberID());
            buffer.append(" | ");
            buffer.append(member.getMemberDept());
            buffer.append(" | ");
            buffer.append(member.getMemberYearsOfExp());
            buffer.append(" | ");

            getEfficiency(member);
            buffer.append("\n\n");
        }
    }

    // - 푸터 작성하기
    public void makeFooter() {
        buffer.append(LINE);
    }


    public void getEfficiency(TftMember member) {
        ArrayList<SubmitCount> submitCountList = member.getCountList();

        Position[] positions = {
                new SeniorPosition(), new SemiSeniorPosition(), new JuniorPosition()};

        int perforceCount = 0;
        int jiraCount = 0;
        int perforceEfficiency = 0;
        int jiraEfficiency = 0;

        for (int i = 0; i < submitCountList.size(); i++) {
            SubmitCount submitCount = submitCountList.get(i);

            if (submitCount.getSubmitTool().getToolName().equals("Perforce")) {
                perforceCount += submitCount.getSubmitCount();
                perforceEfficiency = calculateEfficiency(member, positions, "Perforce", perforceCount);
            } else if (submitCount.getSubmitTool().getToolName().equals("Jira")) {
                jiraCount += submitCount.getSubmitCount();
                jiraEfficiency = calculateEfficiency(member, positions, "Jira", jiraCount);
            }
        }

        buffer.append(perforceCount);
        buffer.append(" | ");
        buffer.append(jiraCount);
        buffer.append(" | ");

        int maxEfficiency = Math.max(perforceEfficiency, jiraEfficiency);
        buffer.append(maxEfficiency);
        buffer.append(" | ");
    }

    private int calculateEfficiency(TftMember member, Position[] positions, String submitToolName, int submitCount) {
        int efficiency;
        if (member.getMemberYearsOfExp() >= 7) {
            efficiency = positions[Define.SENIOR_POSITION].getEfficiency(submitToolName, submitCount);
        } else if (member.getMemberYearsOfExp() >= 4) {
            efficiency = positions[Define.SEMISENIOR_POSITION].getEfficiency(submitToolName, submitCount);
        } else {
            efficiency = positions[Define.JUNIOR_POSITION].getEfficiency(submitToolName, submitCount);
        }
        return efficiency;
    }
}

