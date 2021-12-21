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
    public String confirm2(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.printf("êtes vous sur de %s ? o/n %n",str);
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

    public void showList(ActivityModel model) {
        model.getList().forEach(x -> System.out.println("activity : "+x.getName()+"  reg : "+x.isRegistration()));
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

    public void alertMsg(String str, String name, ActivityModel model) {
        System.out.printf("$$$ l'activité suivante va être %s $$$%n",str);
        System.out.println();
        ActivityType type = model.getList().stream().filter( x -> x.getName().equals(name)).findAny().get();
        System.out.println(type);
    }

    public void successDelete() {
        System.out.println("suppression terminée");
    }

    public void cancelDelete() {
        System.out.println("suppression annulée");
    }

    public String nameOrRegMOD() {
        System.out.println("""
                Modifier :
                1. Nom
                2. Registration
                3. Nom et Registration""");
        return scan.nextLine();
    }


}
