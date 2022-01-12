package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class DeleteHoraire  extends HoraireMaster implements Callable<Activity> {

    @Override
    public Activity call() throws Exception {
        getVue().showList(getModel().getList(),true,"Liste de Type d'activité");
        int choix = 0;
        String confirm = "";
        boolean check = false;
        if (getModel().getList().size() == 0) {
            return null;
        }
        while (!check) {
            try {
                choix = Integer.parseInt(getVue().userInput("Tapez le numéro de l'activité à supprimer")) - 1;
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("non valide");
            }
        }
        confirm = ToolsBox.confirm("supprimer");
        if (confirm.equalsIgnoreCase("oui") || confirm.charAt(0) == 'o') {

            getVue().msgDelete(getModel().getList().get(choix));
            getModel().dellActivity(getModel().getList().get(choix));

        }else{
            getVue().cancelDelete();
        }
        return null;


    }
}
