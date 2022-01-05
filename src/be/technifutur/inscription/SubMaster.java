package be.technifutur.inscription;


import be.technifutur.horaire.HoraireModel;

public class SubMaster {
    private HoraireModel horaireModel;
    private ModelSub model;
    ViewSub vue;

    public ModelSub getModel() {
        return model;
    }

    public void setModel(ModelSub model) {
        this.model = model;
    }

    public ViewSub getVue() {
        return vue;
    }

    public void setVue(ViewSub vue) {
        this.vue = vue;
    }

    public HoraireModel getHoraireModel() {
        return horaireModel;
    }

    public void setHoraireModel(HoraireModel horaireModel) {
        this.horaireModel = horaireModel;
    }
}
