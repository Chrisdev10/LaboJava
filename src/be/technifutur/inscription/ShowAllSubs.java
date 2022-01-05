package be.technifutur.inscription;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Subs;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ShowAllSubs extends SubMaster implements Callable<Subs> {
    @Override
    public Subs call() throws Exception {
        if (getModel().getPersonne().isEmpty()) {
            System.out.println("*** LISTE VIDE ***");
        }else{
            for (Map.Entry<Activity, List<Subs>> entry : getModel().getPersonne().entrySet()) {
                System.out.println(entry.getKey().toStringLinear()+"\n => liste inscription :  "+entry.getValue());
            }
        }
        return null;
    }
}
