package be.technifutur.main;

import be.technifutur.DataType.Personne;
import be.technifutur.mvc.MenuControler;
import be.technifutur.toolbox.ToolsBox;

import java.util.concurrent.Callable;

public class SubMain implements Callable<Personne> {
    MenuControler menu;

    public SubMain(MenuControler controler) {
        this.menu = controler;
    }
    @Override
    public Personne call() throws Exception {
        ToolsBox.looperMain(menu);
        return null;
    }
}
