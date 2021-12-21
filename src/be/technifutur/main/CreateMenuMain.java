package be.technifutur.main;

import be.technifutur.DataType.ActivityType;
import be.technifutur.DataType.NodeMenu;
import be.technifutur.factory.MenuFactory;
import be.technifutur.mvc.MenuControler;

import java.util.concurrent.Callable;

public class CreateMenuMain implements Callable<ActivityType> {

    MenuControler menu;

    public CreateMenuMain(MenuControler controler) {
        this.menu = controler;
    }
    @Override
    public ActivityType call() throws Exception {
        Callable<? extends Object> call;
        do {
            call  = menu.getCall();
            if (call != null) {
                call.call();
            }
        } while (call != null);
        return null;
    }
}

