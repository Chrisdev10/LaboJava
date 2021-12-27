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

    public void addActivity(LocalDateTime start, LocalDateTime end, String name, ActivityType type) {
        Activity activity = new Activity(start, end, name, type);
        liste.add(activity);
    }
    public void dellActivity(Activity e) {
        liste.remove(e);
    }
    public void ModActivityName(Activity e, String str) {
        liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst().get().setName(str);
    }
    public void ModActivityStart(Activity e) {
        liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst().get().setStart(ToolsBox.checkUserDate());
    }
    public void ModActivityEnd(Activity e) {
        liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst().get().setStart(ToolsBox.checkUserDate());
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
