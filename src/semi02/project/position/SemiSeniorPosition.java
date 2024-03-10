package semi02.project.position;

public class SemiSeniorPosition implements Position {
    //준시니어 업무 능률 기준 정하기
    @Override
    public int getEfficiency(String submitTool, int submitCount) {
        int efficiency = 0;

        switch (submitTool) {
            case "Perforce":
                if (submitCount >= 13) efficiency = 100;
                else if (submitCount >= 10) efficiency = 90;
                else if (submitCount >= 8) efficiency = 70;
                else if (submitCount >= 5) efficiency = 50;
                else if (submitCount >= 3) efficiency = 30;
                break;
            case "Jira":
                if (submitCount >= 18) efficiency = 100;
                else if (submitCount >= 15) efficiency = 90;
                else if (submitCount >= 13) efficiency = 70;
                else if (submitCount >= 10) efficiency = 50;
                else if (submitCount >= 5) efficiency = 30;
                break;
        }
        return efficiency;
    }
}
