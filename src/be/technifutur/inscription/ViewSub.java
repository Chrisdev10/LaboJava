package be.technifutur.inscription;
import be.technifutur.DataType.Personne;
import be.technifutur.mvc.GeneriqueView;


import java.util.List;
import java.util.Scanner;

public class ViewSub extends GeneriqueView {

    public void messageOutput(String str) {
        System.out.println(str);
    }

    public String choosePersonne(List<Personne> data) {
        for (int i = 0; i < data.size(); i++) {
            System.out.printf("(%d) %s\n",i+1,data.get(i).toString());
        }
        System.out.println("("+(data.size()+1)+") une nouvelle personne \n");
        return new Scanner(System.in).nextLine();
    }
}
