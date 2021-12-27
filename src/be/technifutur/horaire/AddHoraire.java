package be.technifutur.horaire;

import be.technifutur.DataType.Activity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.Callable;

public class AddHoraire extends HoraireMaster implements Callable<Activity> {
    @Override
    public Activity call() throws Exception {
        int user = 0;
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
            }
            LocalDateTime timeStart = LocalDateTime.of(1992, 10, 1, 12, 30);
            LocalDateTime timeEnd = LocalDateTime.of(1992, 10, 1, 13, 30);
            model.addActivity(timeStart, timeEnd, "test", model2.getList().get(user));

        }
        return null;
    }
}
