package be.technifutur.dataStore;
import be.technifutur.activity.ActivityModel;
import be.technifutur.horaire.HoraireModel;

import java.io.Serializable;


public class DataType implements Serializable {
    private final ActivityModel type = new ActivityModel();
    private final HoraireModel activity = new HoraireModel();

    public ActivityModel getType() {
        return type;
    }

    public HoraireModel getActivity() {
        return activity;
    }
}
