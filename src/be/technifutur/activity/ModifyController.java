package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import java.util.concurrent.Callable;

public class ModifyController extends GestionnaireActivite implements Callable<ActivityType> {
    @Override
    public ActivityType call() throws Exception {
        int choix = 0;
        int choice = 0;
        String user = "";
        ActivityType pos;
        boolean isPresent = false;
        vue.showList(model.getList(),true,"Liste de Type d'activité");
        if (model.getList().size() == 0) {
            return null;
        }
        try {
            user = vue.userInput("Séléctionnez l'activité à modifier (enter pour sortir)");
            if (user.isEmpty()) {
                return null;
            }else{
                choice = Integer.parseInt(user)-1;
            }
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

        }
        return null;
    }
}
