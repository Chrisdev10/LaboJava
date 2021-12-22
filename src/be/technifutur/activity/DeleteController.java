package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.concurrent.Callable;

public class DeleteController extends GestionnaireActivite implements Callable<ActivityType> {
    @Override
    public ActivityType call() {
        char choix = 'i';
        vue.showList(model);
        name = vue.saisirActivity("activité à delete");
        if (model.getList().stream().anyMatch(x -> x.getName().equals(name))) {
            vue.alertMsg("supprimée",name, model);
            try {
                choix = vue.confirm2("supprimer").toLowerCase().charAt(0);
            } catch (Exception e) {
                vue.unValid();
            }
            if (choix == 'o') {
                vue.successDel(model.getList().stream().filter(x -> x.getName().equals(name)).findAny().get());
                model.removeActivityType(name);
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
