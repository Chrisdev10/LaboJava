package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.concurrent.Callable;

public class DeleteController extends GestionnaireActivite implements Callable<ActivityType> {
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
            if (choix == 'o') {
                vue.successDel(model.getList().get(choice));
                model.removeActivityType(model.getList().get(choice).getName());
            }else{
                if (choix == 'n') {
                    vue.cancelDelete();
                }
            }

        }else{
            vue.unValid();
        }
        return null;
    }
}
