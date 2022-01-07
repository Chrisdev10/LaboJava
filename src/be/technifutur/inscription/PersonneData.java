package be.technifutur.inscription;

import be.technifutur.DataType.Personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonneData implements Serializable {

    private final List<Personne> personne = new ArrayList<>();

    public Personne addSubber(Personne e) {
        personne.add(e);
        return e;
    }

    public void showData() {
        personne.forEach(x -> System.out.println(x.toString()));
    }

    public List<Personne> getData() {
        return personne;
    }
}
