package be.technifutur.horaire;
import be.technifutur.DataType.Activity;
import be.technifutur.activity.ActivityModel;

import java.util.Scanner;

public class HoraireVue {
    private final Scanner scan = new Scanner(System.in);
    public void showType(ActivityModel model){
        if (model.getList().size() == 0) {
            System.out.println("***liste vide***");
        }else{
            for (int i = 0; i < model.getList().size(); i++) {
                System.out.printf("(%2d ) %s%n",i+1,model.getList().get(i).toString());
            }
        }
    }
    public void showType2(ActivityModel model){
        System.out.println("*** LISTE TYPE ACTIVITE ***");
        if (model.getList().size() == 0) {
            System.out.println("***liste vide***");
        }else{
            model.getList().forEach( x -> System.out.println(x.toString()));
        }
    }
    public void showType(HoraireModel model) {
        System.out.println("*** HORAIRE ***");
        if (model.getList().size() == 0) {
            System.out.println("***liste vide***");
        }else{
            for (int i = 0; i < model.getList().size(); i++) {
                System.out.printf("(%2d ) %s%n",i+1,model.getList().get(i).toString());
            }
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
        System.out.print("choix : ");
        return scan.nextLine();
    }

    public String choiceUserMod(){
        System.out.println("""
                1. Modifier le nom
                2. Modifier la date de début
                3. Modifier la date de fin
                4. Modifier le type d'activité
                5. Tout modifier""");
        System.out.print("choix : ");
        return scan.nextLine();
    }

    public void msgDelete(Activity e) {
        System.out.println(e.toString());
        System.out.println("### élément supprimé ###");
    }

    public void cancelDelete() {
        System.out.println("### suppression annulée ###");
    }

    public void dateAlert() {
        System.out.println("La date entrée n'est pas valide");
    }

    public void confirmAdd(Activity e) {
        System.out.println("***Activité ajoutée***");
        System.out.println(e.toString());
    }
    public void confirmMod(Activity e) {
        System.out.println("***Activité modifiée***");
        System.out.println(e.toString());
    }

}
