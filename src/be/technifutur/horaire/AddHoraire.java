package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.ActivityType;
import be.technifutur.activity.AddController;
import be.technifutur.toolbox.ToolsBox;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;


public class AddHoraire extends HoraireMaster implements Callable<Activity> {
    AddController adder;
    @Override
    public Activity call() throws Exception {
        int user = 0;
        ActivityType type = null;
        boolean check = false;

        vue.showType(model);
        while (!check) {
            try {
                user = Integer.parseInt(vue.choiceUserAdd());
                if (user < 1 || user > 2) {
                    System.out.println("non valide");
                }else{
                    check = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("non numérique");
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
        LocalDateTime timeStart = ToolsBox.checkUserDate();
        if (timeStart != null) {
            LocalDateTime timeEnd = ToolsBox.checkUserDate(timeStart);
            if (timeEnd != null) {
                model.addActivity(timeStart, timeEnd, "test", type);
            }else{
                vue.DateAlert();
            }
        }else{
            vue.DateAlert();
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
