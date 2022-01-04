package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import be.technifutur.activity.AddController;
import be.technifutur.exceptions.UnvalidFieldException;
import be.technifutur.toolbox.ToolsBox;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;


public class AddHoraire extends HoraireMaster implements Callable<Activity> {
    AddController adder;
    @Override
    public Activity call() throws Exception {
        int user = 0;
        String name = "";
        ActivityType type = null;
        boolean check = false;
        vue.showType2(model2);
        while (!check) {
            try {
                user = Integer.parseInt(vue.choiceUserAdd());
                if (user < 1 || user > 2) {
                    throw new UnvalidFieldException("choix non valide");
                } else {
                    check = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("non numérique");
            }catch (UnvalidFieldException e) {
                System.out.println(e.getMessage());
            }
        }
        check = false;
        if (user == 1) {
            vue.showType(model2);
            while (!check) {
                try {
                    user = Integer.parseInt(vue.saisirActivity("Entrez le numéro de l'item")) - 1;
                    if (user >= 0 && user < model2.getList().size()) {
                        check = true;
                    }else{
                        System.out.println("non valide");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("non numérique");
                }
                type = model2.getList().get(user);
            }
        }else{
            type = getAdder().call();

        }
        if (type == null) {
            System.out.println("erreur lors de l'ajout de type");
            this.call();
        }
        while (name.isEmpty()) {
            name = vue.saisirActivity("entrez le nom de l'activité");

        }
        LocalDateTime timeStart = ToolsBox.checkUserDate(null,true);
        if (timeStart != null) {
            LocalDateTime timeEnd = ToolsBox.checkUserDate(timeStart,false);
            if (timeEnd != null) {
                Activity act = new Activity(timeStart, timeEnd, name, type);
                if (!ToolsBox.timeChecker(act,timeStart, timeEnd, model)) {
                    model.addActivity(act);
                    vue.confirmAdd(act);
                }else{
                    vue.dateConflict(act);
                }

            }else{
                vue.dateAlert();
            }
        }else{
            vue.dateAlert();
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
