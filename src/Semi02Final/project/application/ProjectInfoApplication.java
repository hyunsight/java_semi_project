package Semi02Final.project.application;

import Semi02Final.project.position.JuniorPosition;
import Semi02Final.project.position.SemiSeniorPosition;
import Semi02Final.project.position.SeniorPosition;
import Semi02Final.project.project.Tft;
import Semi02Final.project.project.TftMember;
import Semi02Final.project.project.report.GeneralReport;

public class ProjectInfoApplication {
    public static void main(String[] args) {
        ProjectInfoApplication app = new ProjectInfoApplication();
        app.createTftMember();
        System.out.println(GeneralReport.generateReport());
    }

    public void createTftMember() {
        Tft tft = Tft.getInstance();

        // 기획
        TftMember member1 = new TftMember("나영석", "N0001", "기획", new SeniorPosition(), 12, 10);
        TftMember member2 = new TftMember("김태호", "N0162", "기획", new JuniorPosition(), 10, 5);
        tft.addTftMember(member1);
        tft.addTftMember(member2);

        // 서버
        TftMember member3 = new TftMember("이은지", "N0015", "서버", new SeniorPosition(), 12, 10);
        TftMember member4 = new TftMember("김미현", "N0070", "서버", new SemiSeniorPosition(), 10, 5);
        TftMember member5 = new TftMember("안유진", "N1009", "서버", new JuniorPosition(), 5, 3);
        tft.addTftMember(member3);
        tft.addTftMember(member4);
        tft.addTftMember(member5);

        // 클라이언트
        TftMember member6 = new TftMember("이영지", "N0027", "클라", new SeniorPosition(), 4, 8);
        TftMember member7 = new TftMember("도경수", "N0928", "클라", new JuniorPosition(), 10, 5);
        tft.addTftMember(member6);
        tft.addTftMember(member7);

        // 아트
        // 이후의 코드는 생략했습니다.
    }
}