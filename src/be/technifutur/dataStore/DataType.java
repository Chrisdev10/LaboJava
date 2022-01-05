package be.technifutur.dataStore;
import be.technifutur.activity.ActivityModel;
import be.technifutur.horaire.HoraireModel;
import be.technifutur.inscription.ModelHoraireSubs;
import be.technifutur.inscription.PersonneData;
import be.technifutur.inscription.SubData;

import java.io.Serializable;


public class DataType implements Serializable {
    private final ActivityModel type = new ActivityModel();
    private final HoraireModel activity = new HoraireModel();
    private final ModelHoraireSubs sub = new ModelHoraireSubs();
    private final SubData subber = new SubData();
    private final PersonneData personne = new PersonneData();

    public ActivityModel getType() {
        return type;
    }

    public HoraireModel getActivity() {
        return activity;
    }

    public ModelHoraireSubs getSub() {
        return sub;
    }

    public SubData getSubber() {
        return subber;
    }

    public PersonneData getPersonne() {
        return personne;
    }
}
