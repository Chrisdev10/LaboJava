package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;

import java.util.concurrent.Callable;

public class ShowAllAct extends GestionnaireActivite implements Callable<ActivityType> {
    @Override
    public ActivityType call() throws Exception {
        vue.showList(model);
        return null;
    }
}
