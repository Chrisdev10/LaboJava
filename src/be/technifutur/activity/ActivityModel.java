package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.io.Serializable;
import java.util.*;

public class ActivityModel implements Serializable {
    private List<ActivityType> list = new ArrayList<>();

    public ActivityType addActivityType(String name, boolean reg) {
        Optional<ActivityType> opt = getActivity(name);
        if (opt.isEmpty()) {
            ActivityType act = new ActivityType(name, reg);
            list.add(act);
            return act;
        }
        return opt.get();
    }

    public void removeActivityType(String name) {
        Optional<ActivityType> opt = getActivity(name);
        if (opt.isPresent()) {
            list.remove(opt.get());
        }
    }

    public void modifyActivity(String name, int pos) {

    }

    private Optional<ActivityType> getActivity(String name) {
        return list.stream().filter(x -> x.getName().equals(name)).findFirst();
    }

    public List<ActivityType> getList() {
        return list;
    }

}
