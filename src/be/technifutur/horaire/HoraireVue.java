package be.technifutur.horaire;
import be.technifutur.DataType.Activity;
import be.technifutur.mvc.GeneriqueView;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class HoraireVue extends GeneriqueView {
    private final Scanner scan = new Scanner(System.in);

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


    public void dateConflict(Activity act) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyyy H:mm", Locale.FRENCH);
        System.out.println("""
                *** Ajout annulé ***
                Raison : Conflit dans les dates !""");
        System.out.println("La date d'une activité portant le même nom se trouve entre le "+act.getStart().format(format)+" et le "
                            +act.getEnd().format(format));

    }

}
