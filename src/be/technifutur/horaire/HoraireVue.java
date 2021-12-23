package be.technifutur.horaire;
import be.technifutur.activity.ActivityModel;

import java.util.Scanner;

public class HoraireVue {
    private final Scanner scan = new Scanner(System.in);
    public void showType(ActivityModel model) {
        for (int i = 0; i < model.getList().size(); i++) {
            System.out.printf("(%2d ) %s%n",i+1,model.getList().get(i).toString());
        }
    }

    public String saisirActivity(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.println(str);
        System.out.print("saisir : ");
        return scan.nextLine();
    }
    public String choiceUserAdd(){
        System.out.println("""
                1. Ajouter un horaire à une activité existante
                2. Ajouter un horaire à une nouvelle activité""");
        return scan.nextLine();
    }
}
