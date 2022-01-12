package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Personne;
import be.technifutur.horaire.HoraireModel;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class AddSub extends SubMaster implements Callable<Personne> {
    SubData subs;
    PersonneData personne;
    @Override
    public Personne call() throws Exception {
        String choix = "";
        String name = "";
        String prenom = "";
        Activity act;
        int choice = 0;
        boolean isOk = false;
        List<Activity> filterList = listFilter(getHoraireModel());
        if (filterList.isEmpty()) {
            vue.messageOutput("*** Liste vide ***");
            return null;
        }
        getVue().showList(filterList,true,"Liste d'Horaire");

        while(!isOk) {
            choix = getVue().userInput("Selectionnez un horaire");
            while (choix.isEmpty()) {
                getVue().showList(filterList,true,"Liste d'Horaire");
                choix = getVue().userInput("Selectionnez un horaire");
            }
            try {
                choice = Integer.parseInt(choix)-1;
                if (choice >= 0 && choice < filterList.size()) {
                    isOk = true;
                }else{
                    vue.messageOutput("Valeurs entrée hors portée");
                }
            } catch (NumberFormatException e) {
                vue.messageOutput("Valeurs non valide.");
            }
        }

        act = filterList.get(choice);
        isOk = false;
        while(!isOk) {
            choix = getVue().choosePersonne(getPersonne().getData());
            while (choix.isEmpty()) {

                choix = getVue().choosePersonne(getPersonne().getData());
            }
            try {
                choice = Integer.parseInt(choix)-1;
                if (choice >= 0 && choice < getPersonne().getData().size()+1) {
                    isOk = true;
                }
            } catch (NumberFormatException e) {
                vue.messageOutput("Valeurs non valide.");
            }
        }
        if(choice == getPersonne().getData().size()){
            while (name.isEmpty()) {
                name = getVue().userInput("Entrez un nom");
                if (name.isEmpty()) {
                    vue.messageOutput("Champ vide");
                }
            }
            while (prenom.isEmpty()) {
                prenom = getVue().userInput("Entrez un prénom");
                if (prenom.isEmpty()) {
                    vue.messageOutput("Champ vide");
                }
            }

            Personne personne = new Personne(name, prenom);
            if (unicityChecker(name, prenom)) {
                choix = vue.userInput("La personne est déjà encodée. Désirez vous l'inscrire?").toLowerCase();
                if (choix.equals("oui") || choix.charAt(0) == 'o') {
                    if (unicitySubsChecker(personne,act)) {
                        vue.messageOutput("La personne est déjà inscrite. Annulation en cours...");
                    }else{
                        Personne sub = getSubs().addActToSubs(new Personne(name,prenom),act);
                        getModel().AddPersonne(act, sub);
                    }
                }
            }else{
                Personne sub = getSubs().addActToSubs(new Personne(name,prenom),act);
                getPersonne().addSubber(new Personne(name,prenom));
                getModel().AddPersonne(act, sub);
            }
        }else{
            Personne pers = getPersonne().getData().get(choice);
            if (!unicitySubsChecker(pers,act)) {
                getModel().AddPersonne(act, getPersonne().getData().get(choice));
            }else{
                vue.messageOutput("déjà encodé ...");
            }

        }
        return null;
    }

    private List<Activity> listFilter(HoraireModel model) {
        return model.getList().stream().filter( x -> x.getType().isRegistration()).collect(Collectors.toList());
    }

    private boolean unicityChecker(String name, String prenom) {
        return getPersonne()
                .getData()
                .stream()
                .anyMatch(x -> x.getNom().equals(name) && x.getPrenom().equals(prenom));
    }
    private boolean unicitySubsChecker(Personne personne, Activity activity) {
        return getSubs().getData().get(personne).stream().anyMatch(x -> x.equals2(activity));
    }
    public SubData getSubs() {
        return subs;
    }

    public void setSubs(SubData subs) {
        this.subs = subs;
    }

    public PersonneData getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneData personne) {
        this.personne = personne;
    }
}
