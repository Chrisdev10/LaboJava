package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class ShowAllAct extends GestionnaireActivite implements Callable<ActivityType> {
    @Override
    public ActivityType call() throws Exception {
        Map<ActivityType, Boolean> mapper = new TreeMap<>(new CompareByName());
        for (int i = 0; i < model.getList().size(); i++) {
            mapper.put(model.getList().get(i), model.getList().get(i).isRegistration());
        }
        System.out.println("*** Liste triée par NOM ***");
        for (Map.Entry<ActivityType, Boolean> entry : mapper.entrySet()) {
            System.out.println(entry.getKey().toString2()+" | Inscription : "+
                    (entry.getValue() ? "Obligatoire" : "Facultatif"));
        }
        return null;
    }

    private class CompareByName implements Comparator<ActivityType> {

        @Override
        public int compare(ActivityType o1, ActivityType o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
