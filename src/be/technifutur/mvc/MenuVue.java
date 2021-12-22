package be.technifutur.mvc;

import java.util.Scanner;

public class MenuVue {
    private final static Scanner scan = new Scanner(System.in);
    public String saisirMenu(MenuModel model) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.println("### "+model.getName()+" ###");
        for (int i = 0; i < model.getSize(); i++) {
            System.out.println("( "+i+" ) "+model.getItem(i).getName());
        }
        System.out.print("choix : ");
        return scan.nextLine();
    }

    // Display error message
    public void setErrorMsg(String s) {
        System.out.println(s);
    }

}
