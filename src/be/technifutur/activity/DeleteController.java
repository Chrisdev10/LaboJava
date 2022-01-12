package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.horaire.HoraireModel;

import java.util.concurrent.Callable;

public class DeleteController extends GestionnaireActivite implements Callable<ActivityType> {

    // Injection du model2 afin de vérifier si le type d'activité est utilisé ou non
    // dans l'horaire.
    //////////////////
    HoraireModel model2;
    @Override
    public ActivityType call() {
        char choix = 'i';
        int choice  = 0;
        String user = "";
        vue.showList(model.getList(),true,"Liste de Type d'activité");
        if (model.getList().size() == 0) {
            return null;
        }
        try {
            user = vue.userInput("Séléctionnez l'activité à supprimer (enter pour sortir)");
            if (user.isEmpty()) {
                return null;
            }else{
                choice = Integer.parseInt(user) - 1;
            }
        } catch (NumberFormatException e) {
            choice = -1;
            vue.unValid();
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
                   vue.failDel(model.getList().get(choice));
                }
            }

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
