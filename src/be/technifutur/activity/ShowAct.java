package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.Scanner;

public class ShowAct {
    private final static Scanner scan = new Scanner(System.in);
    public String confirm(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.printf("êtes vous sur d' %s ? o/n %n",str);
        System.out.print("choix : ");
        return scan.nextLine();
    }
    public String saisirActivity(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.println(str);
        System.out.print("saisir : ");
        return scan.nextLine();
    }

    public void emptyInput() {
        System.out.println("pas d'entrée");
    }

    public void alreadyIN() {
        System.out.println("déjà présent");
    }

    public void unValid() {
        System.out.println("non valide");
    }


}
