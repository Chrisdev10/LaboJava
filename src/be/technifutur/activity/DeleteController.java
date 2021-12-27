package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.horaire.HoraireModel;

import java.util.concurrent.Callable;

public class DeleteController extends GestionnaireActivite implements Callable<ActivityType> {
    HoraireModel model2;
    @Override
    public ActivityType call() {
        char choix = 'i';
        int choice  = 0;
        vue.showList(model);
        try {
            choice = Integer.parseInt(vue.saisirActivity("Séléctionnez l'activité à delete")) - 1;
        } catch (NumberFormatException e) {
            choice = -1;
        }
        if (choice >= 0 && choice < model.getList().size()) {
            vue.alertMsg("supprimée",choice, model);
            try {
                choix = vue.confirm2("supprimer").toLowerCase().charAt(0);
            } catch (Exception e) {
                vue.unValid();
            }
            if (choix == 'o' && !isAlreadyIn(model2,model.getList().get(choice))) {
                vue.successDel(model.getList().get(choice));
                model.removeActivityType(model.getList().get(choice).getName());
            }else{
                if (choix == 'n') {
                    vue.cancelDelete();
                }
                else{
                    System.out.println("élément dans l'horaire");
                }
            }

        }else{
            vue.unValid();
        }
        return null;
    }

    public boolean isAlreadyIn(HoraireModel horaire, ActivityType type) {
        return horaire.getList().stream().anyMatch(x -> x.getType().getName().equals(type.getName()));
    }

    public void setModel2(HoraireModel model) {
        this.model2 = model;
    }

    public HoraireModel getModel2() {
        return this.model2;
    }
}
