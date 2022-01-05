package be.technifutur.inscription;

import be.technifutur.DataType.Personne;

import java.util.concurrent.Callable;

public class AddSub extends SubMaster implements Callable<Personne> {
    @Override
    public Personne call() throws Exception {
        System.out.println("test");
        return null;
    }
}
