package be.technifutur.inscription;

import be.technifutur.DataType.Personne;

import java.util.concurrent.Callable;

public class ShowAllSubs extends SubMaster implements Callable<Personne> {
    @Override
    public Personne call() throws Exception {
        getVue().showMap(getModel().getPersonne());
        return null;
    }
}
