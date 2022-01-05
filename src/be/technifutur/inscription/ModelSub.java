package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Subs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelSub extends SubMaster implements Serializable {
    private final Map<Activity, List<Subs>> personne = new HashMap<>();

    public void AddPersonne(Activity e, Subs s) {
        List<Subs> sub = personne.get(e);
        if (sub == null) {
            sub = new ArrayList<>();
            sub.add(s);
            personne.put(e, sub);
        }else{
            sub.add(s);
        }
        System.out.println("done");
    }

    public Map<Activity, List<Subs>> getPersonne() {
        return personne;
    }
}
