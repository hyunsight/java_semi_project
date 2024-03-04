package semi02.project.application;

import semi02.project.project.SubmitCount;
import semi02.project.project.SubmitTool;
import semi02.project.project.Tft;
import semi02.project.project.TftMember;
import semi02.project.project.report.GenerateReport;
import semi02.project.utils.Define;

public class ProjectInfoApplication {
    Tft tft = Tft.getInstance();

    SubmitTool perforce;
    SubmitTool jira;
    GenerateReport generateReport = new GenerateReport();

    public static void main(String[] args) {
        ProjectInfoApplication app = new ProjectInfoApplication();

        app.createSubmitTool();
        app.createTftMember();

        String report = app.generateReport.getReport();
        System.out.println(report);

    }

    public void createSubmitTool() {
        perforce = new SubmitTool("Perforce");
        jira = new SubmitTool("Jira");

        tft.addSubmitTool(perforce);
        tft.addSubmitTool(jira);

    }

    public void createTftMember() {
        TftMember member1 = new TftMember("나영석", "N0001", "기획", 20);
        TftMember member2 = new TftMember("김태호", "N0162", "기획", 2);
        TftMember member3 = new TftMember("이은지", "N0015", "서버", 11);
        TftMember member4 = new TftMember("김미현", "N0070", "서버", 6);
        TftMember member5 = new TftMember("안유진", "N1009", "서버", 1);
        TftMember member6 = new TftMember("이영지", "N0027", "클라", 13);
        TftMember member7 = new TftMember("도경수", "N0928", "클라", 3);
        TftMember member8 = new TftMember("김우빈", "N0036", "아트", 9);
        TftMember member9 = new TftMember("이광수", "N0703", "아트", 5);
        TftMember member10 = new TftMember("김기방", "N1244", "아트", 2);

        tft.addTftMember(member1);
        tft.addTftMember(member2);
        tft.addTftMember(member3);
        tft.addTftMember(member4);
        tft.addTftMember(member5);
        tft.addTftMember(member6);
        tft.addTftMember(member7);
        tft.addTftMember(member8);
        tft.addTftMember(member9);
        tft.addTftMember(member10);

        perforce.registerTool(member1);
        perforce.registerTool(member2);
        perforce.registerTool(member3);
        perforce.registerTool(member4);
        perforce.registerTool(member5);
        perforce.registerTool(member6);
        perforce.registerTool(member7);
        perforce.registerTool(member8);
        perforce.registerTool(member9);
        perforce.registerTool(member10);

        jira.registerTool(member1);
        jira.registerTool(member2);
        jira.registerTool(member3);
        jira.registerTool(member4);
        jira.registerTool(member5);
        jira.registerTool(member6);
        jira.registerTool(member7);
        jira.registerTool(member8);
        jira.registerTool(member9);
        jira.registerTool(member10);

        addSubmitCountForMember(member1, perforce, 10);
        addSubmitCountForMember(member2, perforce, 8);
        addSubmitCountForMember(member3, perforce, 15);
        addSubmitCountForMember(member4, perforce, 12);
        addSubmitCountForMember(member5, perforce, 5);
        addSubmitCountForMember(member6, perforce, 8);
        addSubmitCountForMember(member7, perforce, 9);
        addSubmitCountForMember(member8, perforce, 20);
        addSubmitCountForMember(member9, perforce, 6);
        addSubmitCountForMember(member10, perforce, 8);

        addSubmitCountForMember(member1, jira, 10);
        addSubmitCountForMember(member2, jira, 12);
        addSubmitCountForMember(member3, jira, 20);
        addSubmitCountForMember(member4, jira, 3);
        addSubmitCountForMember(member5, jira, 8);
        addSubmitCountForMember(member6, jira, 3);
        addSubmitCountForMember(member7, jira, 3);
        addSubmitCountForMember(member8, jira, 17);
        addSubmitCountForMember(member9, jira, 6);
        addSubmitCountForMember(member10, jira, 10);

    }

    public void addSubmitCountForMember(TftMember member, SubmitTool submitTool, int submitCount) {
        SubmitCount totalsubmitCount = new SubmitCount(member.getMemberName(), submitTool, submitCount);
        member.addSubmitCount(totalsubmitCount);
    }
}
