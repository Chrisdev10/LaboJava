package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Subs;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ViewSub extends SubMaster {

    public void ShowMap() {
        if (getModel().getPersonne().isEmpty()) {
            System.out.println("*** LISTE VIDE ***");
        }else{
            for (Map.Entry<Activity, List<Subs>> entry : getModel().getPersonne().entrySet()) {
                System.out.println(entry.getKey()+"   "+entry.getValue());
            }
        }

    }


    public String saisirSubs(String str) {

        System.out.println(str);
        System.out.print("saisir : ");
        return new Scanner(System.in).nextLine();
    }

    public void showList(List<Activity> liste) {
        if (liste.size() == 0) {
            System.out.println("***liste vide***");
        }else{
            for (int i = 0; i < liste.size(); i++) {
                System.out.printf("(%2d ) %s%n",i+1,liste.get(i).toString());
            }
        }

        System.out.println();
    }
}
