package be.technifutur.factory;

import be.technifutur.DataType.Item;
import be.technifutur.DataType.NodeMenu;
import be.technifutur.activity.AddAct;
import be.technifutur.mvc.MenuControler;
import be.technifutur.mvc.MenuModel;
import be.technifutur.mvc.MenuVue;

import java.util.concurrent.Callable;


public class MenuFactory {
    MenuControler mainMenu;

    /*
     $ Major method where MVC Architecture is created.
     */
    public MenuFactory(){
        mainMenu = mainCreator(initTab());
        getMenu();
    }
    public void getMenu() {
        mainMenu.getCall();
    }

    private NodeMenu createItem(String name, Callable<?> call) {
        Item createItem = new Item();
        createItem.setName(name);
        createItem.setCall(call);
        return createItem;
    }

    /*
     * mainCreator generate MAIN menu
     */
    private NodeMenu backBtn(String name, NodeMenu run) {
        run.setName(name);
        return run;
    }
    private MenuControler mainCreator(MenuModel model) {
        MenuControler menu = new MenuControler();
        menu.setModel(model);
        menu.setVue(new MenuVue());
        return menu;
    }

    private MenuControler createMenu(String name, MenuModel model) {
        MenuControler menu = new MenuControler();
        menu.setVue(new MenuVue());
        menu.setModel(model);
        menu.setName(name);
        return menu;
    }

    // Init all model item in the list
    private MenuModel initTab() {
        MenuModel model = new MenuModel();
        model.addItem(createItem("exit", null));
        model.addItem(createMenu("gestionnaire activité", initSubMenu()));
        return model;
    }
    private MenuModel initSubMenu() {
        MenuModel model = new MenuModel();
        model.addItem(createItem("exit", null));
        model.addItem(createItem("Ajouter une activité",new AddAct()));
        //model.addItem(createItem("Afficher une activité",new ShowAct()));
        //model.addItem(createItem("Supprimer une activité",new RemoveAct()));



        return model;
    }

}
