package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class AddController extends GestionnaireActivite implements Callable<ActivityType> {

    @Override
    public ActivityType call(){
        String activité = "";
        String temp = "";
        boolean isReg = false;
        boolean check = true;
        boolean continued = false;
        char choice = 'i';
        while(!continued) {

            try {
                activité = vue.saisirActivity("Nom de l'activité : ");

                if (!ToolsBox.isChecked(getModel().getList(), activité) && !activité.isEmpty()) {
                    temp = vue.saisirActivity("Inscription nécessaire? o/n");
                    if (temp.equalsIgnoreCase("oui") || temp.equalsIgnoreCase("o")) {
                        isReg = true;
                    }else{
                        if (!temp.equalsIgnoreCase("non") && !temp.equalsIgnoreCase("n")) {
                            vue.unValid();
                            check = false;
                        }else{
                            isReg = false;
                        }

                    }
                    if(check) {
                        choice = (vue.confirm("ajouter")).toLowerCase().charAt(0);
                        if (choice == 'o') {
                            ActivityType type = model.addActivityType(activité, isReg);
                            vue.successAdd(type);
                        } else if (choice == 'n') {
                            System.out.println("non ajouté");
                        } else {
                            System.out.println("non valide");
                        }

                        choice = (vue.saisirActivity("Voulez vous continuer? o/n")).toLowerCase().charAt(0);
                        if (choice == 'n') {
                            continued = true;
                        } else if (choice != 'o') {
                            vue.unValid();
                        }
                    }
                }else{
                    if (activité.isEmpty()) {
                        vue.emptyInput();
                    }else{
                        vue.alreadyIN();
                    }

                }

            } catch (Exception e) {
                System.out.println("non valide");
            }
            vue.showList(model);
            System.out.println(model.getList().get(1));

        }
        return null;
    }

}
