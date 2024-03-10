package semi02.project.position;

public class JuniorPosition implements Position {
    //주니어 업무 능률 기준 정하기
    @Override
    public int getEfficiency(String submitTool, int submitCount) {
        int efficiency = 0;

        switch (submitTool) {
            case "Perforce":
                if (submitCount >= 10) efficiency = 100;
                else if (submitCount >= 8) efficiency = 90;
                else if (submitCount >= 5) efficiency = 70;
                else if (submitCount >= 3) efficiency = 50;
                else if (submitCount >= 1) efficiency = 30;
                break;
            case "Jira":
                if (submitCount >= 15) efficiency = 100;
                else if (submitCount >= 13) efficiency = 90;
                else if (submitCount >= 10) efficiency = 70;
                else if (submitCount >= 5) efficiency = 50;
                else if (submitCount >= 2) efficiency = 30;
                break;
        }
        return efficiency;
    }
}