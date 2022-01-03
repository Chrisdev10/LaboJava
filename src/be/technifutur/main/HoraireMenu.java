package be.technifutur.main;

import be.technifutur.DataType.ActivityType;
import be.technifutur.mvc.MenuControler;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class HoraireMenu implements Callable<ActivityType> {

    MenuControler menu;

    public HoraireMenu(MenuControler controler) {
        this.menu = controler;
    }
    @Override
    public ActivityType call() throws Exception {
        ToolsBox.looperMain(menu);
        return null;
    }
}
