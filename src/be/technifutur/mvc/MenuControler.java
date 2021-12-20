package be.technifutur.mvc;

import be.technifutur.activity.NodeMenu;

import java.util.concurrent.Callable;

public class MenuControler implements NodeMenu {
    private MenuModel model;
    private MenuVue vue;
    private String name;

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public MenuVue getVue() {
        return vue;
    }

    public void setVue(MenuVue vue) {
        this.vue = vue;
    }

    @Override
    public String getName() {
        return null;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Callable<? extends Object> getCall() {
        Callable<?> action = null;
        String choix = "";
        int choice = -1;
        boolean exitProg = false;
        do {
            try {
                choix = vue.saisirMenu(model);
                choice = Integer.parseInt(choix);
                action = model.getItem(choice).getCall();
                if (choice >= 0 && choice < model.getSize()) {
                    exitProg = true;
                }else{
                    vue.setErrorMsg("choix non valide : "+choice);
                }
            } catch (NumberFormatException e) {
                vue.setErrorMsg("non numérique : "+choix);
            }
        } while (!exitProg);
        if (choice == 0 && action == null) {
            vue.exitMsg();
        }

        return action;
    }
}