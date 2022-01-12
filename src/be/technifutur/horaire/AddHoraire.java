package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import be.technifutur.activity.AddController;
import be.technifutur.exceptions.UnvalidFieldException;
import be.technifutur.toolbox.ToolsBox;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;


public class AddHoraire extends HoraireMaster implements Callable<Activity> {
    AddController adder;
    @Override
    public Activity call() throws Exception {
        int user = 0;
        String name = "";
        ActivityType type = null;
        boolean check = false;
        getVue().showList(getModel2().getList(),true,"Liste de Type d'activité");
        while (!check) {
            try {
                if (getModel2().getList().isEmpty()) {
                    user=2;
                    check = true;
                }else{
                    user = Integer.parseInt(getVue().choiceUserAdd());
                    if (user < 1 || user > 2) {
                        throw new UnvalidFieldException("choix non valide");
                    } else {
                        check = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("non numérique");
            }catch (UnvalidFieldException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        if (user == 1) {
            getVue().showList(getModel2().getList(),true,"Liste de Type d'activité");
            while (!check) {
                try {
                    user = Integer.parseInt(getVue().userInput("Entrez le numéro de l'item")) - 1;
                    if (user >= 0 && user < getModel2().getList().size()) {
                        check = true;
                    }else{
                        System.out.println("non valide");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("non numérique");
                }
                type = getModel2().getList().get(user);
            }
        }else{
            type = getAdder().call();

        }
        if (type == null) {
            System.out.println("erreur lors de l'ajout de type");
            this.call();
        }
        while (name.isEmpty()) {
            name = getVue().userInput("entrez le nom de l'activité");

        }
        LocalDateTime timeStart = ToolsBox.checkUserDate(null,true);
        if (timeStart != null) {
            LocalDateTime timeEnd = ToolsBox.checkUserDate(timeStart,false);
            if (timeEnd != null) {
                Activity act = new Activity(timeStart, timeEnd, name, type);
                if (!ToolsBox.timeChecker(act,timeStart, timeEnd, getModel())) {
                    getModel().addActivity(act);
                    getVue().successAdd(act);
                }else{
                    getVue().dateConflict(act);
                }

            }else{
                getVue().dateAlert();
            }
        }else{
            getVue().dateAlert();
        }

        return null;
    }




    public AddController getAdder() {
        return adder;
    }

    public void setAdder(AddController adder) {
        this.adder = adder;
    }
}
