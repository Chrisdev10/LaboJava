package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.dataStore.DataStore;

import java.io.Serializable;
import java.util.*;

public class ActivityModel implements Serializable {

    // On donne un path et un élément à instancier. Ce sera la liste d'élément.
    // getData va injecter les données récoltées dans la list list.
    DataStore<ArrayList<ActivityType>> dataStore = new DataStore<>("data.myfile", ArrayList::new);
    private final List<ActivityType> list = dataStore.getData();

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

    public void removeActivityType(String name) {
        Optional<ActivityType> opt = getActivity(name);
        if (opt.isPresent()) {
            list.remove(opt.get());
        }
    }

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

    private Optional<ActivityType> getActivity(String name) {
        return list.stream().filter(x -> x.getName().equals(name)).findFirst();
    }

    public List<ActivityType> getList() {
        return list;
    }

    public void saveData() {
        dataStore.save();
    }

}
