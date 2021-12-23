package be.technifutur.horaire;

import be.technifutur.DataType.Activity;
import java.util.concurrent.Callable;

public class AddHoraire extends HoraireMaster implements Callable<Activity> {
    @Override
    public Activity call() throws Exception {
        int user = 0;
        boolean check = false;
        vue.showType(model2);

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
            if (user == 1) {

            }

        }
        return null;
    }
}
