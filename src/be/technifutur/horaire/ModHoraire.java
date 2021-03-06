package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import be.technifutur.activity.AddController;
import be.technifutur.toolbox.ToolsBox;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class ModHoraire extends HoraireMaster implements Callable<Activity> {
    AddController adder;

    @Override
    public Activity call() throws Exception {
        getVue().showList(getModel().getList(),true,"Liste de Type d'activité");
        int choix = 0;
        String confirm = "";
        Activity activity = null;
        boolean check = false;
        if (getModel().getList().size() == 0) {
            return null;
        }
        while (!check) {
            try {
                choix = Integer.parseInt(getVue().userInput("Tapez le numéro de l'activité à modifier")) - 1;
                if (choix >= 0 && choix < getModel().getList().size()) {
                    activity = getModel().getList().get(choix);
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
                choix = Integer.parseInt(getVue().choiceUserMod()) - 1;
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
        String str = "";
        while(str.isEmpty()) {
            str = getVue().userInput("Entrez le nouveau nom");
        }
        getModel().ModActivityName(activity, str);
    }
    private boolean startDate(Activity activity) {
        LocalDateTime date = ToolsBox.checkUserDate(null,true);
        if (date == null) {
            getVue().dateAlert();
            startDate(activity);
        } else {
            if (timechecker(date, true, activity)) {

                System.out.println("erreur");

            } else {
                getModel().ModActivityStart(activity, date);
                return true;
            }

        }
        return false;
    }
    private boolean endDate(Activity activity) {
        LocalDateTime date = ToolsBox.checkUserDate(activity.getStart(),false);
        if (date == null) {
            getVue().dateAlert();
            endDate(activity);
        } else {
            if (timechecker(date, false, activity)) {
                System.out.println("erreur");
            } else {

                getModel().ModActivityStart(activity, date);
                return true;
            }
        }
        return false;
    }
    private void typeActivity(Activity activity) {
        boolean check = false;
        int choix = 0;
        ActivityType type;
        try {
            choix = Integer.parseInt(getVue().choiceUserAdd());
        } catch (NumberFormatException e) {
            System.out.println("non valide");
        }
        if (choix == 1) {
            getVue().showList(getModel2().getList(),true,"Liste de Type d'activité");
            while (!check) {
                try {
                    choix = Integer.parseInt(getVue().userInput("Entrez le numéro de l'item")) - 1;
                    if (choix >= 0 && choix < getModel2().getList().size()) {
                        check = true;
                    }else{
                        System.out.println("non valide");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("non numérique");
                }
                type = getModel2().getList().get(choix);
                getModel().ModActivityType(activity,type);
            }
        }else{
            getModel().ModActivityType(activity, getAdder().call());
        }
    }

    private void allChange(Activity activity) {
        boolean keepContinue;
        nameChange(activity);
        keepContinue = startDate(activity);
        if (keepContinue) {
            keepContinue = endDate(activity);
            if (keepContinue) {
                typeActivity(activity);
            }

        }

    }

    private boolean timechecker(LocalDateTime dateTime, boolean isBefore, Activity activity) {
        List<Activity> activityList = getModel()
                .getList()
                .stream()
                .filter(x -> x.equals(activity))
                .collect(Collectors.toList());

        if (isBefore) {
            return activityList
                    .stream()
                    .anyMatch(x -> x.getEnd().isAfter(dateTime));
        }else{
            return activityList
                    .stream()
                    .anyMatch(x -> x.getStart().isBefore(dateTime));
        }
    }

    public void setAdder(AddController addActivity) {
        this.adder = addActivity;
    }

    public AddController getAdder() {
        return adder;
    }
}
