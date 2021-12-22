package be.technifutur.main;

import be.technifutur.DataType.ActivityType;

import be.technifutur.mvc.MenuControler;

import java.util.concurrent.Callable;

/*
 * Classe qui permet de garder en mémoire les Parents du folder cible.
 * Si le user choisit gestion activité, alors la classe sera appelée.
 * Tant que la valeur de l'object n'est pas nul, alors on reste dans ce menu.
 */

public class GestionMenuActivity implements Callable<ActivityType> {

    MenuControler menu;

    public GestionMenuActivity(MenuControler controler) {
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

