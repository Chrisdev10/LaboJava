package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Personne;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class RemoveSub extends SubMaster implements Callable<Personne> {

    SubData subs;

    @Override
    public Personne call() throws Exception {
        List<Activity> liste = new ArrayList<>(getModel().getPersonne().keySet());
        String choix = "";
        boolean checker=false;
        int choice = 0;
        Activity act;
        vue.showList(liste,true,"Liste d'Horaire");
        while (!checker) {

            try {
                choix = vue.userInput("Entrez le numéro de l'activité.");

                while (choix.isEmpty()) {
                    choix = vue.userInput("Entrez le numéro de l'activité.");
                }
                choice = Integer.parseInt(choix)-1;
                if (choice >= 0 && choice < getModel().getPersonne().size()) {
                    checker = true;
                }else {
                    vue.messageOutput("hors champ ..");
                }
            } catch (NumberFormatException e) {
                vue.messageOutput("valeurs non valide");
            }

        }
        act = liste.get(choice);

        List<Personne> listeSub = getModel().getPersonne().get(act);
        vue.showList(listeSub,true, "Liste de personne inscrite à une activité");
        checker = false;
        choix="";
        while (!checker) {
            try {
                choix = vue.userInput("Entrez le numéro de la personne à supprimer.");

                while (choix.isEmpty()) {
                    choix = vue.userInput("Entrez le numéro de la personne à supprimer.");
                }
                choice = Integer.parseInt(choix) - 1;
                if (choice >= 0 && choice < listeSub.size()) {
                    checker = true;

                } else {
                    vue.messageOutput("hors champ ..");
                }
            } catch (NumberFormatException e) {
                vue.messageOutput("valeurs non valide");
            }
        }
        Personne personne = listeSub.get(choice);
        System.out.println(listeSub.get(choice));
        choix = vue.userInput("ëtes vous sur de supprimer la personne suivante o/n ?");
        if (choix.equalsIgnoreCase("oui") || choix.equalsIgnoreCase("o")) {
            vue.messageOutput("*** Suppression validée");
            List<Activity> tempListe = getSubs().getData().get(listeSub.get(choice));
            Activity activity = tempListe.get(choice);
            listeSub.remove(choice);
            tempListe.removeIf(x -> x.equals2(act));
            if (tempListe.isEmpty()) {
                getSubs().removeActToSubs(personne);
            }
            if (getModel().getPersonne().get(activity).isEmpty()) {
                getModel().deletePersonne(activity);
            }

        }else{
            vue.messageOutput("*** Suppression annulée");
        }




        return null;
    }

    public SubData getSubs() {
        return subs;
    }

    public void setSubs(SubData subs) {
        this.subs = subs;
    }
}
