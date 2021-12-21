package be.technifutur.toolbox;

import be.technifutur.DataType.ActivityType;

import java.util.List;

public class ToolsBox {
    public static boolean isChecked(List<ActivityType> act, String name) {
        return act.stream().anyMatch(x -> x.getName().equals(name));
    }
}
