package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import be.technifutur.dataStore.DataStore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoraireModel implements Serializable {
    DataStore<ArrayList<Activity>> dataStore = new DataStore<>("data2.myfile", ArrayList::new);
    private final List<Activity> liste = dataStore.getData();

    public void addActivity(LocalDate start, LocalDate end, String name, ActivityType type) {
        Activity activity = new Activity(start, end, name, type);
        liste.add(activity);
    }
    public List<Activity> getList() {
        return liste;
    }

    public void saveData() {
        dataStore.save();
    }
}
