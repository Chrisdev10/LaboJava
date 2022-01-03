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
        if (model.getList().size() == 0) {
            System.out.println("***liste vide***");
        }else{
            for (int i = 0; i < model.getList().size(); i++) {
                System.out.printf("(%2d ) %s%n",i+1,model.getList().get(i).toString());
            }
        }

        System.out.println();
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

    public void alertMsg(String str, int pos, ActivityModel model) {
        System.out.printf("### l'activité suivante va être %s ###%n",str);
        System.out.println();
        ActivityType type = model.getList().get(pos);
        System.out.println(type.toString());
    }


    public void successAdd(ActivityType type) {
        System.out.println("### ajout terminé ###");
        System.out.println("### élément ajouté ###");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }
    public void successMod(ActivityType type) {
        System.out.println("### élément modifié ###");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }
    public void successDel(ActivityType type) {
        System.out.println("### suppression terminée ###");
        System.out.println("élément supprimé");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }
    public void failDel(ActivityType type) {
        System.out.println("### suppression annulée ###");
        System.out.println("/!\\ élément présent dans la liste des horaires /!\\");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }

    public void cancelDelete() {
        System.out.println("suppression annulée");
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
