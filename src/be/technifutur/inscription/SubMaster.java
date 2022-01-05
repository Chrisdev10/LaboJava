package be.technifutur.inscription;


import be.technifutur.horaire.HoraireModel;

public class SubMaster {
    private HoraireModel horaireModel;
    private ModelHoraireSubs model;
    ViewSub vue;

    public ModelHoraireSubs getModel() {
        return model;
    }

    public void setModel(ModelHoraireSubs model) {
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
