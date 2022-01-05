package be.technifutur.inscription;

import be.technifutur.DataType.Personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModelSub implements Serializable {
    private final List<Personne> personne = new ArrayList<>();

    public void AddPersonne(Personne e) {
        personne.add(e);
    }
}
