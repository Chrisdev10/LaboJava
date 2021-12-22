package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.Optional;
import java.util.concurrent.Callable;

public class ModifyController extends GestionnaireActivite implements Callable<ActivityType> {
    @Override
    public ActivityType call() throws Exception {
        int choix = 0;
        int choice = 0;
        ActivityType pos;
        boolean isPresent = false;
        vue.showList(model);
        try {
            choice = Integer.parseInt(vue.saisirActivity("Séléctionnez l'activité à modifier")) - 1;
        } catch (NumberFormatException e) {
            choice = -1;
        }
        if (choice >= 0 && choice < model.getList().size()) {
            pos = model.getList().get(choice);
            try {
                choix = Integer.parseInt(vue.nameOrRegMOD());

            } catch (Exception e) {
                System.out.println("non valide");
            }
            model.modifyActivity(choix, pos, vue);

        }else{
            System.out.println("nope");
        }
        return null;
    }
}
