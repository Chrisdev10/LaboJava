package be.technifutur.horaire;
import be.technifutur.DataType.Activity;
import be.technifutur.activity.ActivityModel;

import java.util.Scanner;

public class HoraireVue {
    private final Scanner scan = new Scanner(System.in);
    public void showType(ActivityModel model) {
        for (int i = 0; i < model.getList().size(); i++) {
            System.out.printf("(%2d ) %s%n",i+1,model.getList().get(i).toString());
        }
    }
    public void showType(HoraireModel model) {
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

    public String choiceUserMod(){
        System.out.println("""
                1. Modifier le nom
                2. Modifier la date de début
                3. Modifier la date de fin
                4. Modifier le type d'activité
                5. Tout modifier""");
        return scan.nextLine();
    }

    public void MsgDelete(Activity e) {
        System.out.println(e.toString());
        System.out.println("### élément supprimé ###");
    }

}
