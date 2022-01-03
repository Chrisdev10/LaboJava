package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class DeleteHoraire  extends HoraireMaster implements Callable<Activity> {

    @Override
    public Activity call() throws Exception {
        vue.showType(model);
        int choix = 0;
        String confirm = "";
        boolean check = false;
        if (model.getList().size() == 0) {
            return null;
        }
        while (!check) {
            try {
                choix = Integer.parseInt(vue.saisirActivity("Tapez le numéro de l'activité à supprimer")) - 1;
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("non valide");
            }
        }
        confirm = ToolsBox.confirm("supprimer");
        if (confirm.equalsIgnoreCase("oui") || confirm.charAt(0) == 'o') {

            vue.msgDelete(model.getList().get(choix));
            model.dellActivity(model.getList().get(choix));

        }else{
            vue.cancelDelete();
        }
        return null;


    }
}
