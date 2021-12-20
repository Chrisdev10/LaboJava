package be.technifutur.mvc;

import java.util.Scanner;

public class MenuVue {
    private final static Scanner scan = new Scanner(System.in);
    public String saisirMenu(MenuModel model) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        for (int i = 0; i < model.getSize(); i++) {
            System.out.println("( "+i+" ) "+model.getItem(i).getName());
        }
        System.out.print("choix : ");
        return scan.nextLine();
    }
    public String confirm(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.println("êtes vous sur de "+str+" ? o/n");
        System.out.print("choix : ");
        return scan.nextLine();
    }
    public String saisirActivity() {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.println("ajouter une activité");
        System.out.print("activity : ");
        return scan.nextLine();
    }
    public String saisirReg() {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.println("Reg?");

        System.out.print("reg : ");
        return scan.nextLine();
    }

    // Display error message
    public void setErrorMsg(String s) {
        System.out.println(s);
    }
    // Display Bye to user
    public void exitMsg() {
        System.out.println("bye bye");
    }
}
