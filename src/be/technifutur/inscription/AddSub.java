package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Subs;
import be.technifutur.horaire.HoraireModel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class AddSub extends SubMaster implements Callable<Subs> {
    @Override
    public Subs call() throws Exception {
        String choix = "";
        String name = "";
        String prenom = "";
        Activity act;
        int choice = 0;
        boolean isOk = false;
        List<Activity> filterList = listFilter(getHoraireModel());
        getVue().showList(filterList);

        while(!isOk) {
            choix = getVue().saisirSubs("Selectionnez un horaire");
            while (choix.isEmpty()) {
                getVue().showList(filterList);
                choix = getVue().saisirSubs("Selectionnez un horaire");
            }
            try {
                choice = Integer.parseInt(choix)-1;
                if (choice >= 0 && choice < filterList.size()) {
                    isOk = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("faux");

            }
        }

        act = filterList.get(choice);
        name = getVue().saisirSubs("Entrez un nom");
        prenom = getVue().saisirSubs("Entrez un prénom");
        Subs sub = new Subs(name, prenom);
        getModel().AddPersonne(act, sub);
        return null;
    }

    private List<Activity> listFilter(HoraireModel model) {
        return model.getList().stream().filter( x -> x.getType().isRegistration()).collect(Collectors.toList());
    }
}
