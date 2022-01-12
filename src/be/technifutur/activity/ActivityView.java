package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.mvc.GeneriqueView;

import java.util.Scanner;

public class ActivityView extends GeneriqueView {
    private final static Scanner scan = new Scanner(System.in);
    public String confirm(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.printf("êtes vous sur d' %s ? o/n %n",str);
        System.out.print("choix : ");
        return scan.nextLine();
    }
    public String confirm2(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.printf("êtes vous sur de %s ? o/n %n",str);
        System.out.print("choix : ");
        return scan.nextLine();
    }

    public void alertMsg(String str, int pos, ActivityModel model) {
        System.out.printf("### l'activité suivante va être %s ###%n",str);
        System.out.println();
        ActivityType type = model.getList().get(pos);
        System.out.println(type.toString());
    }

    public String nameOrRegMOD() {
        System.out.println("""
                Modifier :
                1. Nom
                2. Inscription
                3. Nom et Inscription""");
        System.out.print("choix :");
        return scan.nextLine();
    }
}
