package semiTest02.project.project.report;

import semiTest02.project.position.Position;
import semiTest02.project.project.Tft;
import semiTest02.project.project.TftMember;

import java.util.ArrayList;

public class GeneralReport {
    public static final String HEADER = "이름 / ID / 부서(파트) / 직급 / Perforce / Jira / 업무 능률\n";

    public static String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);

        Tft tft = Tft.getInstance();
        ArrayList<TftMember> members = tft.getMembers();

        for (TftMember member : members) {
            Position position = member.getPosition();
            int perforceCount = member.getPerforceCount();
            int jiraCount = member.getJiraCount();
            int efficiency = position.getEfficiency("Perforce", perforceCount) < position.getEfficiency("Jira", jiraCount) ?
                    position.getEfficiency("Perforce", perforceCount) : position.getEfficiency("Jira", jiraCount);
            report.append(String.format("%s / %s / %s / %s / %d개 / %d개 / %d%%\n",
                    member.getMemberName(), member.getMemberID(), member.getDepartment(),
                    position.getClass().getSimpleName(), perforceCount, jiraCount, efficiency));
        }

        return report.toString();
    }
}
