package be.technifutur.horaire;

import be.technifutur.DataType.Activity;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;

public class ShowAllHoraire extends HoraireMaster implements Callable<Activity> {
    @Override
    public Activity call() throws Exception {
        Set<Activity> view = new TreeSet<>(Comparator.comparing(Activity::getStart));
        view.addAll(model.getList());
        view.forEach( x -> System.out.println(x.toStringLinear()));
        return null;
    }



}
