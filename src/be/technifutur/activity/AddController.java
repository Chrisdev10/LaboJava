package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class AddController extends GestionnaireActivite implements Callable<ActivityType> {
    boolean fromHoraire;

    // Permet de savoir si l'appel call se fait depuis le menu horaire ou non.
    // Si false -> Continue? demandé  pendant l'ajout
    // Si true (call from horaire) -> Continue? non demandé

    public AddController(boolean isHoraire) {
        this.fromHoraire = isHoraire;
    }
    @Override
    public ActivityType call(){
        String activité = "";
        ActivityType type = null;
        String temp = "";
        boolean isReg = false;
        boolean check = true;
        boolean continued = false;
        char choice = 'i';
        while(!continued) {

            try {

                activité = vue.userInput("Nom de l'activité : (enter pour sortir)");
                if (activité.isEmpty()) {
                    return null;
                }
                if (!ToolsBox.isChecked(getModel().getList(), activité)) {
                    do {
                        temp = vue.userInput("Inscription nécessaire? o/n");
                        if (temp.equalsIgnoreCase("oui") || temp.equalsIgnoreCase("o")) {
                            isReg = true;
                            check=true;
                        }else{
                            if (temp.equalsIgnoreCase("non") || temp.equalsIgnoreCase("n")) {
                                isReg = false;
                                check=true;
                            } else {
                                vue.unValid();
                                check = false;
                            }

                        }
                    } while (!check);

                    choice = (vue.confirm("ajouter")).toLowerCase().charAt(0);
                    if (choice == 'o') {
                        type = model.addActivityType(activité, isReg);
                        vue.successAdd(type);
                    } else if (choice == 'n') {
                        System.out.println("non ajouté");
                        return null;
                    } else {
                        System.out.println("non valide");
                    }
                    if (!fromHoraire) {
                        choice = (vue.userInput("Voulez vous continuer? o/n")).toLowerCase().charAt(0);
                        if (choice == 'n') {
                            continued = true;
                        } else if (choice != 'o') {
                            vue.unValid();
                        }
                    }else{
                        continued = true;
                    }
                }else{
                    vue.alreadyIN();
                }

            } catch (Exception e) {
                System.out.println("non valide");
            }
        }
        return type;
    }

}
