package be.technifutur.horaire;

import be.technifutur.DataType.Activity;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;

public class ShowAllHoraire extends HoraireMaster implements Callable<Activity> {
    @Override
    public Activity call() throws Exception {
        Set<Activity> view = new TreeSet<>(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });
        view.addAll(model.getList());
        view.forEach( x -> System.out.println(x.toStringLinear()));
        return null;
    }



}
