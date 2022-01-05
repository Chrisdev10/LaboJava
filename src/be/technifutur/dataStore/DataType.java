package be.technifutur.dataStore;
import be.technifutur.activity.ActivityModel;
import be.technifutur.horaire.HoraireModel;
import be.technifutur.inscription.ModelSub;

import javax.xml.crypto.Data;
import java.io.Serializable;


public class DataType implements Serializable {
    private final ActivityModel type = new ActivityModel();
    private final HoraireModel activity = new HoraireModel();
    private final ModelSub sub = new ModelSub();

    public ActivityModel getType() {
        return type;
    }

    public HoraireModel getActivity() {
        return activity;
    }

    public ModelSub getSub() {
        return sub;
    }
}
