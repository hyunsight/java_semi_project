package semi02.project.application;

import semi02.project.project.SubmitCount;
import semi02.project.project.SubmitTool;
import semi02.project.project.Tft;
import semi02.project.project.TftMember;
import semi02.project.project.report.GenerateReport;
import semi02.project.utils.Define;

public class ProjectInfoApplication {
    //전역 객체/변수 선언하기
    Tft tft = Tft.getInstance();
    GenerateReport generateReport = new GenerateReport();
    SubmitTool perforce;
    SubmitTool jira;

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
        TftMember[] members = {
        new TftMember("나영석", "N0001", "기획", 20),
        new TftMember("김태호", "N0162", "기획", 2),
        new TftMember("이은지", "N0015", "서버", 11),
        new TftMember("김미현", "N0070", "서버", 6),
        new TftMember("안유진", "N1009", "서버", 1),
        new TftMember("이영지", "N0027", "클라", 13),
        new TftMember("도경수", "N0928", "클라", 3),
        new TftMember("김우빈", "N0036", "아트", 9),
        new TftMember("이광수", "N0703", "아트", 5),
        new TftMember("김기방", "N1244", "아트", 2)
        };

        for (TftMember member : members) {
            tft.addTftMember(member);
        }

//        for (int i =0; i <= 9; i++) {
//            perforce.registerTool(tft.getTftMemberList().get(i));
//            jira.registerTool(tft.getTftMemberList().get(i));
//        }

        addSubmitCountForMember(members[0], perforce, 10);
        addSubmitCountForMember(members[0], jira, 10);
        addSubmitCountForMember(members[1], perforce, 8);
        addSubmitCountForMember(members[1], jira, 13);
        addSubmitCountForMember(members[2], perforce, 15);
        addSubmitCountForMember(members[2], jira, 21);
        addSubmitCountForMember(members[3], perforce, 12);
        addSubmitCountForMember(members[3], jira, 3);
        addSubmitCountForMember(members[4], perforce, 5);
        addSubmitCountForMember(members[4], jira, 9);
        addSubmitCountForMember(members[5], perforce, 4);
        addSubmitCountForMember(members[5], jira, 19);
        addSubmitCountForMember(members[6], perforce, 4);
        addSubmitCountForMember(members[6], jira, 3);
        addSubmitCountForMember(members[7], perforce, 19);
        addSubmitCountForMember(members[7], jira, 17);
        addSubmitCountForMember(members[8], perforce, 2);
        addSubmitCountForMember(members[8], jira, 5);
        addSubmitCountForMember(members[9], perforce, 7);
        addSubmitCountForMember(members[9], jira, 6);
    }

    public void addSubmitCountForMember(TftMember member, SubmitTool submitTool, int submitCount) {
        SubmitCount totalSubmitCount = new SubmitCount(member.getMemberName(), submitTool, submitCount);
        member.addSubmitCount(totalSubmitCount);
    }
}