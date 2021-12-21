package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class AddController implements Callable<ActivityType> {
    ActivityModel model;
    ShowAct vue;
    String name;
    @Override
    public ActivityType call() throws Exception {
        String activité = "";
        ActivityType type;
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
                    if (temp.equalsIgnoreCase("oui")) {
                        isReg = true;
                    }else{
                        if (!temp.equalsIgnoreCase("non")) {
                            vue.unValid();
                            check = false;
                        }

                    }
                    if(check) {
                        choice = (vue.confirm("ajouter")).toLowerCase().charAt(0);
                        if (choice == 'o') {
                            model.addActivityType(activité, isReg);
                            model.getList().forEach(x -> System.out.println(x.getName() + "  " + x.isRegistration()));
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

        }
        return null;
    }

    public ActivityModel getModel() {
        return model;
    }

    public void setModel(ActivityModel model) {
        this.model = model;
    }

    public ShowAct getVue() {
        return vue;
    }

    public void setVue(ShowAct vue) {
        this.vue = vue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
