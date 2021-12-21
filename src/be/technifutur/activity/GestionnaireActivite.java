package be.technifutur.activity;

public class GestionnaireActivite {
    ActivityModel model;
    ShowAct vue;
    String name;
    public ActivityModel getModel() {
        return model;
    }

    public void setModel(ActivityModel model) {
        this.model = model;
    }

    public ShowAct getVue() {
        return vue;
    }

    public void setVue(ShowAct vue) {
        this.vue = vue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
