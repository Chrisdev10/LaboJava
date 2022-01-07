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
                System.out.println("faux");

            }
        }
        if(choice == getPersonne().getData().size()){
            name = getVue().saisirSubs("Entrez un nom");
            prenom = getVue().saisirSubs("Entrez un prénom");
            Personne personne = new Personne(name, prenom);
            if (unicityChecker(name, prenom)) {
                choix = vue.saisirSubs("La personne est déjà encodée. Désirez vous l'inscrire?").toLowerCase();
                if (choix.equals("oui") || choix.charAt(0) == 'o') {
                    if (unicitySubsChecker(personne,act)) {
                        vue.saisirSubs("La personne est déjà inscrite. Annulation en cours...");
                    }else{
                        Personne sub = getSubs().addSubber(new Personne(name,prenom),act);
                        getModel().AddPersonne(act, sub);
                    }
                }
            }else{
                Personne sub = getSubs().addSubber(new Personne(name,prenom),act);
                getPersonne().addSubber(new Personne(name,prenom));
                getModel().AddPersonne(act, sub);
            }
        }else{
            Personne pers = getPersonne().getData().get(choice);
            if (!unicitySubsChecker(pers,act)) {
                getModel().AddPersonne(act, getPersonne().getData().get(choice));
            }else{
                System.out.println("nope déjà encodé");
            }

        }
        getSubs().showAll();

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
