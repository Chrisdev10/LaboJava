package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoraireModel implements Serializable {
    private final List<Activity> liste = new ArrayList<>();

    public void addActivity(Activity activity) {
        liste.add(activity);
    }

    public void dellActivity(Activity e) {
        liste.remove(e);
    }

    private Optional<Activity> noNullSecure(Activity e) {
        return liste.stream().filter(x -> x.getName().equals(e.getName())).findFirst();
    }

    public void ModActivityName(Activity e, String str) {
        Optional<Activity> act = noNullSecure(e);
        act.ifPresent(activity -> activity.setName(str));
    }

    public void ModActivityStart(Activity e, LocalDateTime dateTime) {
        Optional<Activity> act = noNullSecure(e);
        act.ifPresent(activity -> activity.setStart(dateTime));
    }

    public void ModActivityEnd(Activity e, LocalDateTime dateTime) {
        Optional<Activity> act = noNullSecure(e);
        act.ifPresent(activity -> activity.setEnd(dateTime));
    }

    public void ModActivityType(Activity e, ActivityType actType) {
        Optional<Activity> act = noNullSecure(e);
        act.ifPresent(activity -> activity.setType(actType));
    }

    public List<Activity> getList() {
        return liste;
    }

}
