package be.technifutur.main;

import be.technifutur.DataType.Subs;
import be.technifutur.mvc.MenuControler;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class SubMain implements Callable<Subs> {
    MenuControler menu;

    public SubMain(MenuControler controler) {
        this.menu = controler;
    }
    @Override
    public Subs call() throws Exception {
        ToolsBox.looperMain(menu);
        return null;
    }
}
