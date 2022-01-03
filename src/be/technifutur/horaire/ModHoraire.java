package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import be.technifutur.activity.AddController;
import be.technifutur.toolbox.ToolsBox;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class ModHoraire extends HoraireMaster implements Callable<Activity> {
    AddController adder;

    @Override
    public Activity call() throws Exception {
        vue.showType(model);
        int choix = 0;
        String confirm = "";
        Activity activity = null;
        boolean check = false;
        while (!check) {
            try {
                choix = Integer.parseInt(vue.saisirActivity("Tapez le numéro de l'activité à modifier")) - 1;
                if (choix >= 0 && choix < model.getList().size()) {
                    activity = model.getList().get(choix);
                    check = true;
                }else{
                    System.out.println("non compris dans les champs");
                }

            } catch (NumberFormatException e) {
                System.out.println("non valide");
            }
        }
        check = false;
        while (!check) {
            try {
                choix = Integer.parseInt(vue.choiceUserMod()) - 1;
                if (choix >= 0 && choix < 5) {
                    check = true;
                }else{
                    System.out.println("non compris dans les champs");
                }
            } catch (NumberFormatException e) {
                System.out.println("non valide");
            }
        }
        switch (choix) {
            case 0 -> nameChange(activity);
            case 1 -> startDate(activity);
            case 2 -> endDate(activity);
            case 3 -> typeActivity(activity);
            case 4 -> allChange(activity);
            default -> System.out.println("nope");
        }
        return null;
    }

    private void nameChange(Activity activity) {
        String str = vue.saisirActivity("Entrez le nouveau nom");
        model.ModActivityName(activity, str);
    }
    private void startDate(Activity activity) {
        LocalDateTime date = ToolsBox.checkUserDate();
        if (date == null) {
            vue.DateAlert();
        } else {
            model.ModActivityStart(activity, date);
        }

    }
    private void endDate(Activity activity) {
        LocalDateTime date = ToolsBox.checkUserDate(activity.getStart());
        if (date == null) {
            vue.DateAlert();
        } else {
            model.ModActivityEnd(activity, date);
        }
    }
    private void typeActivity(Activity activity) {
        boolean check = false;
        int choix = 0;
        ActivityType type;
        try {
            choix = Integer.parseInt(vue.choiceUserAdd());
        } catch (NumberFormatException e) {
            System.out.println("non valide");
        }
        if (choix == 1) {
            vue.showType(model2);
            while (!check) {
                try {
                    choix = Integer.parseInt(vue.saisirActivity("Entrez le numéro de l'item")) - 1;
                    if (choix >= 0 && choix < model2.getList().size()) {
                        check = true;
                    }else{
                        System.out.println("non valide");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("non numérique");
                }
                type = model2.getList().get(choix);
                model.ModActivityType(activity,type);
            }
        }else{
            model.ModActivityType(activity, getAdder().call());
        }
    }

    private void allChange(Activity activity) {
        nameChange(activity);
        startDate(activity);
        endDate(activity);
        typeActivity(activity);
    }

    public void setAdder(AddController addActivity) {
        this.adder = addActivity;
    }

    public AddController getAdder() {
        return adder;
    }
}
