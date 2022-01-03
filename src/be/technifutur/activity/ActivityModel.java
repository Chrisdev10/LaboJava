package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import java.io.Serializable;
import java.util.*;

public class ActivityModel implements Serializable {

    // On donne un path et un élément à instancier. Ce sera la liste d'élément.
    // getData va injecter les données récoltées dans la liste list.
    private final List<ActivityType> list = new ArrayList<>();

    // Ajout activité
    public ActivityType addActivityType(String name, boolean reg) {
        Optional<ActivityType> opt = getActivity(name);
        if (opt.isEmpty()) {
            ActivityType act = new ActivityType(name, reg);
            list.add(act);
            return act;
        }
        return opt.get();
    }
    // Suppression d'un type d'activité avec pour paramètre le nom de cette activité
    public void removeActivityType(String name) {
        Optional<ActivityType> opt = getActivity(name);
        if (opt.isPresent()) {
            list.remove(opt.get());
        }
    }

    // Modification d'un type d'activité avec pour paramètre
    // 1) le choix de modification du user
    // 2) l'activité en question
    // 3) la vue afin d'afficher les éléments
    /////////////////////////////////////////

    public void modifyActivity(int choix, ActivityType pos, ShowAct vue) {

        if (choix == 1) {
            final String str = vue.saisirActivity("entrez la nouvelle activité");
            if (list.stream().noneMatch(x -> x.getName().equals(str))) {
                pos.setName(str);
                vue.successMod(pos);
            }else{
                vue.alreadyIN();
            }

        }else{
            if (choix == 2) {
                pos.setRegistration(!pos.isRegistration());
                vue.successMod(pos);
            }else{
                if (choix == 3) {
                    final String str = vue.saisirActivity("entrez la nouvelle activité");
                    if (list.stream().noneMatch(x -> x.getName().equals(str))) {
                        pos.setName(str);
                        pos.setRegistration(!pos.isRegistration());
                        vue.successMod(pos);
                    }else{
                        vue.alreadyIN();
                    }
                }else{
                    vue.unValid();
                }
            }
        }
    }

    // Récupère un élément avec le nom tapez par le user
    private Optional<ActivityType> getActivity(String name) {
        return list.stream().filter(x -> x.getName().equals(name)).findFirst();
    }


    public List<ActivityType> getList() {
        return list;
    }
    // Appel de la méthode saveData pour sauvegarder les données entrées

}
