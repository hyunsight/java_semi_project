package practice01.project.position;

public class SemiSeniorPosition implements Position {
    @Override
    public int getEfficiency(String toolName, int count) {
        switch (toolName) {
            case "Perforce":
                if (count >= 13) return 100;
                else if (count >= 10) return 90;
                else if (count >= 8) return 70;
                else if (count >= 5) return 50;
                else if (count >= 3) return 30;
                break;
            case "Jira":
                if (count >= 18) return 100;
                else if (count >= 15) return 90;
                else if (count >= 13) return 70;
                else if (count >= 10) return 50;
                else if (count >= 5) return 30;
                break;
        }
        return 0;
    }
}