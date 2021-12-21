package be.technifutur.main;
import be.technifutur.factory.MenuFactory;
import be.technifutur.mvc.MenuControler;

import java.util.concurrent.Callable;

public class GestionMain {
    public static void main(String[] args) throws Exception {
        MenuFactory factory = new MenuFactory();
        MenuControler main = factory.getMenu();
        Callable<? extends Object> call;
        do {
            call  = main.getCall();
            if (call != null) {
                call.call();
            }
        } while (call != null);
    }
}
