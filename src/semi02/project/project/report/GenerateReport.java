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

//보고서 작성하기
public class GenerateReport {
    //싱글톤 객체 생성하기
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

    // - 전체 리포트 중 헤더 작성하기
    public void makeHeader() {
        buffer.append(TITLE);
        buffer.append(HEADER);
        buffer.append(LINE);
    }

    // - 전체 리포트 중 바디 작성하기
    public void makeBody() {
        // - TFT 구성원 리스트 객체 생성하기
        ArrayList<TftMember> memberList = tft.getTftMemberList();

        // - TFT 구성원 별 이름/ID/부서/연차/업무 능률 정보 출력하기
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
            buffer.append("\n");
        }
    }

    // - 전체 리포트 중 푸터 작성하기
    public void makeFooter() {
        buffer.append("\n");
        buffer.append(LINE);
    }

    // - TFT 구성원 별 업무 능률 구하기
    //   : TFT 구성원 매개변수로 사용
    public void getEfficiency(TftMember member) {
        // - TFT 구성원의 서밋 카운트 리스트 가져오기
        ArrayList<SubmitCount> submitCountList = member.getCountList();

        // - TFT 구성원 직급들로 구성된 배열 객체 생성하기
        //   : 업무 능률 계산을 위해서는 각 지급별 업무 능률 기준을 사용해야하므로
        Position[] positions = {
                new SeniorPosition(), new SemiSeniorPosition(), new JuniorPosition()};

        // - perforce 서밋 카운트/업무 능률, jira 서밋 카운트/업무 능률 변수 생성 및 선언하기
        int perforceCount = 0;
        int jiraCount = 0;
        int perforceEfficiency = 0;
        int jiraEfficiency = 0;

        // - 서밋 카운트 리스트 순회하면서 서밋 카운트 데이터 가져와서 출력하기
        for (int i = 0; i < submitCountList.size(); i++) {
            SubmitCount submitCount = submitCountList.get(i);

            // - 추가로 조건 설정 통해 서밋 툴 이름이 Perforce / Jira에 매칭되는 서밋 카운트를 각 변수에 대입하기
            //   : 또한 각 조건별 실제 업무 능률 계산 메소드 실행하는 문 작성
            if (submitCount.getSubmitTool().getToolName().equals("Perforce")) {
                perforceCount = submitCount.getSubmitCount();
                perforceEfficiency = calculateEfficiency(member, positions, "Perforce", perforceCount);
            } else if (submitCount.getSubmitTool().getToolName().equals("Jira")) {
                jiraCount = submitCount.getSubmitCount();
                jiraEfficiency = calculateEfficiency(member, positions, "Jira", jiraCount);
            }
        }

        buffer.append(perforceCount);
        buffer.append(" | ");
        buffer.append(jiraCount);
        buffer.append(" | ");

        //계산된 퍼포스 기준 업무 능률과 지라 기준 업무 능률 중 높은 것을 최종 업무 능률로 출력하기
        int maxEfficiency = Math.max(perforceEfficiency, jiraEfficiency);
        buffer.append(maxEfficiency);
        buffer.append("%");
    }

    // - TFT 구성원 별 실 업무 능률 계산하기
    //   : 총 4가지 매개변수 사용
    //   1) Tft 구성원
    //   2) TFT 구성원 직급들로 구성된 배열 객체 (인덱스의 경우, Define 이용)
    //   3) Position에 정의된 직급 별 업무 능률 기준을 사용하기 위해 submitToolName, submitCount
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

