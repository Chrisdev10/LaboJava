package be.technifutur.mvc;

import be.technifutur.DataType.NodeMenu;

import java.util.concurrent.Callable;

public class MenuControler implements NodeMenu {
    private MenuModel model;
    private MenuVue vue;

    @Override
    public String getName() {
        return model.getName();
    }

    // getCall est la méthode appellé au moment de la sélection du user
    // La méthode va retourner un callable OU lancer un autre controlleur avec getCall
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
            } catch (Exception e) {
                System.out.println("hors champ");
            }
        } while (!exitProg);

        return action;
    }



    /*
     * SETTER
     * Injection du model et de  la vue dans le controller
     */

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void setVue(MenuVue vue) {
        this.vue = vue;
    }

}
