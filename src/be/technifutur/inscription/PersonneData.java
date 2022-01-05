package be.technifutur.inscription;

import be.technifutur.DataType.Personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonneData implements Serializable {

    private List<Personne> subber = new ArrayList<>();

    public Personne addSubber(Personne e) {
        subber.add(e);
        return e;
    }

    public void showData() {
        subber.forEach( x -> System.out.println(x.toString()));
    }

    public List<Personne> getData() {
        return subber;
    }
}
