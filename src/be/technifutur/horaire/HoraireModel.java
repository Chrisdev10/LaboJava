package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import be.technifutur.dataStore.DataStore;
import be.technifutur.toolbox.ToolsBox;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HoraireModel implements Serializable {
    DataStore<ArrayList<Activity>> dataStore = new DataStore<>("data2.myfile", ArrayList::new);
    private final List<Activity> liste = dataStore.getData();

    public void addActivity(Activity activity) {
        liste.add(activity);
    }
    public void dellActivity(Activity e) {
        liste.remove(e);
    }
    public void ModActivityName(Activity e, String str) {
        liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst().get().setName(str);
    }
    public void ModActivityStart(Activity e, LocalDateTime dateTime) {
        liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst().get().setStart(dateTime);
    }
    public void ModActivityEnd(Activity e, LocalDateTime dateTime) {
        liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst().get().setEnd(dateTime);
    }
    public void ModActivityType(Activity e, ActivityType act) {
        liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst().get().setType(act);
    }


    public List<Activity> getList() {
        return liste;
    }

    public void saveData() {
        dataStore.save();
    }
}
