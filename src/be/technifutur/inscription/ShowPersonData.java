package be.technifutur.inscription;

import be.technifutur.DataType.Personne;

import java.util.List;
import java.util.concurrent.Callable;

public class ShowPersonData extends ViewSub implements Callable<Personne> {
    private SubData model;
    private ViewSub viewSub;
    @Override
    public Personne call() throws Exception {
        String choix = "";
        int choice = 0;
        boolean isOk = false;
        List<Personne> liste = getModelSubs().getData().keySet().stream().toList();
        super.showList(liste,true,"Liste de Personne");
        while (!isOk) {
            choix = super.userInput("*** Selectionnez une personne ***");
            try {
                choice = Integer.parseInt(choix) - 1;
                if (choice < 0 || choice >= liste.size()) {
                    super.messageOutput("/!\\ HORS CHAMP /!\\");
                    choix = super.userInput("*** Selectionnez une personne ***");
                }else{
                    isOk = true;
                }

            } catch (NumberFormatException e) {
                super.messageOutput("/!\\ NON VALIDE /!\\");
            }
        }

        Personne personne = liste.get(choice);
        System.out.println(personne);
        super.showList(getModelSubs().getData().get(personne),true,"Liste des activités avec inscription");

        return null;
    }

    public SubData getModelSubs() {
        return model;
    }

    public void setModelSubs(SubData model) {
        this.model = model;
    }

    public ViewSub getViewSub() {
        return viewSub;
    }

    public void setViewSub(ViewSub viewSub) {
        this.viewSub = viewSub;
    }
}
