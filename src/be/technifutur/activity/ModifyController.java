package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.Optional;
import java.util.concurrent.Callable;

public class ModifyController extends GestionnaireActivite implements Callable<ActivityType> {
    @Override
    public ActivityType call() throws Exception {
        int choix = 0;
        ActivityType pos;
        boolean isPresent = false;
        vue.showList(model);
        name = vue.saisirActivity("### activité à modifier ###");
        isPresent = model.getList().stream().anyMatch(x -> x.getName().equals(name));
        if (isPresent) {
            pos = model
                    .getList()
                    .stream()
                    .filter(x -> x.getName().equals(name))
                    .findAny()
                    .get();
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
