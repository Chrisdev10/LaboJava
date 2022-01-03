package be.technifutur.horaire;

import be.technifutur.DataType.Activity;

import java.util.concurrent.Callable;

public class ShowAllHoraire extends HoraireMaster implements Callable<Activity> {
    @Override
    public Activity call() throws Exception {
        vue.showType(model);
        return null;
    }
}
