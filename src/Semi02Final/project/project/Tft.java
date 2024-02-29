package Semi02Final.project.project;

import java.util.ArrayList;

public class Tft {
    private static Tft instance;
    private ArrayList<TftMember> members = new ArrayList<>();

    private Tft() {}

    public static Tft getInstance() {
        if (instance == null) {
            instance = new Tft();
        }
        return instance;
    }

    public void addTftMember(TftMember member) {
        members.add(member);
    }

    public ArrayList<TftMember> getMembers() {
        return members;
    }
}
