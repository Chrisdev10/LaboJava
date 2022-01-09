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

    public void showData(Personne e) {
        System.out.println(subber.get(e));
    }

    public void showAll() {
        if (subber.isEmpty()) {
            System.out.println("*** LISTE VIDE ***");
        }else{
            for (Map.Entry<Personne, List<Activity>> entry : subber.entrySet()) {
                System.out.println(entry.getKey().toString());
                System.out.println(" Liste d'inscription =>");
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.printf("[%d] %s \n",i+1,entry.getValue().get(i).toStringLinear());
                }
            }
        }

    }

    public Map<Personne, List<Activity>> getData() {
        return subber;
    }
}
