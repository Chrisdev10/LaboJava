package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubData implements Serializable {
    private Map<Personne, List<Activity>> subber = new HashMap<>();

    public Personne addActToSubs(Personne e, Activity act) {
        List<Activity> activityList = subber.get(e);
        if (activityList == null) {
            activityList = new ArrayList<>();
            activityList.add(act);
            subber.put(e, activityList);
        }else{
            activityList.add(act);
        }

        return e;
    }

    public void removeActToSubs(Personne personne) {
        subber.remove(personne);
    }
    public Map<Personne, List<Activity>> getData() {
        return subber;
    }
}
