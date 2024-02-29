package Semi02Final.project.project;

import java.util.ArrayList;

public class SubmitTool {
    private String toolName;
    private ArrayList<TftMember> registeredMembers = new ArrayList<>();

    public SubmitTool(String toolName) {
        this.toolName = toolName;
    }

    public void registerTool(TftMember member) {
        registeredMembers.add(member);
    }

    public ArrayList<TftMember> getRegisteredMembers() {
        return registeredMembers;
    }
}
