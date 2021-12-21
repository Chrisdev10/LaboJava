package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.concurrent.Callable;

public class ModifyController extends GestionnaireActivite implements Callable<ActivityType> {
    @Override
    public ActivityType call() throws Exception {
        int choix = 0;
        int pos = 0;
        vue.showList(model);
        name = vue.saisirActivity("activité à modifier");
        if (model.getList().stream().anyMatch(x -> x.getName().equals(name))) {
            pos = model
                    .getList()
                    .stream()
                    .filter(x -> x.getName().equals(name))
                    .hashCode();
            try {
                choix = Integer.parseInt(vue.nameOrRegMOD());

            } catch (Exception e) {
                System.out.println("non valide");
            }
            switch (choix) {
                case 1 : model.modifyActivity(name,pos);
            }
        }else{
            System.out.println("nope");
        }
        return null;
    }
}
