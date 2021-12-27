package be.technifutur.horaire;

import be.technifutur.activity.ActivityModel;

public class HoraireMaster {
    String name;
    HoraireModel model;
    HoraireVue vue;
    ActivityModel model2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HoraireModel  getModel() {
        return model;
    }

    public void setModel(HoraireModel model) {
        this.model = model;
    }

    public HoraireVue getVue() {
        return vue;
    }

    public void setVue(HoraireVue vue) {
        this.vue = vue;
    }

    public ActivityModel getModel2() {
        return model2;
    }

    public void setModel2(ActivityModel model2) {
        this.model2 = model2;
    }
}
