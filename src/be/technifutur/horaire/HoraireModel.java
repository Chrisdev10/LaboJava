package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoraireModel implements Serializable {
    private List<Activity> liste = new ArrayList<>();

    public void addActivity(LocalDate start, LocalDate end, String name, ActivityType type) {
        Activity activity = new Activity(start, end, name, type);
        liste.add(activity);
    }
}
