package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Personne;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class RemoveSub extends SubMaster implements Callable<Personne> {


    @Override
    public Personne call() throws Exception {
        List<Activity> liste = new ArrayList<>(getModel().getPersonne().keySet());
        String choix = "";
        boolean checker=false;
        int choice = 0;
        Activity act;
        vue.showKeyMap(liste);
        choix = vue.saisirSubs("Entrez le numéro de l'activité.");
        while (!checker) {
            try {
                choice = Integer.parseInt(choix)-1;
            } catch (NumberFormatException e) {
                System.out.println("non conforme");
            }
            if (choice >= 0 && choice < getModel().getPersonne().size()) {
                checker = true;

            }else {
                System.out.println("hors champ");
            }
        }
        act = liste.get(choice);

        List<Personne> listeSub = getModel().getPersonne().get(act);
        vue.showKeyMap(listeSub);



        return null;
    }
}
