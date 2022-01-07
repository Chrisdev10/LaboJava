package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelHoraireSubs extends SubMaster implements Serializable {
    private final Map<Activity, List<Personne>> personne = new HashMap<>();

    public void AddPersonne(Activity e, Personne s) {
        List<Personne> sub = personne.get(e);
        if (sub == null) {
            sub = new ArrayList<>();
            sub.add(s);
            personne.put(e, sub);
        }else{
            sub.add(s);
        }
    }

    public Map<Activity, List<Personne>> getPersonne() {
        return personne;
    }

}
