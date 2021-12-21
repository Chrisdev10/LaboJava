package be.technifutur.factory;

import be.technifutur.DataType.Item;
import be.technifutur.DataType.NodeMenu;
import be.technifutur.activity.*;
import be.technifutur.main.CreateMenuMain;
import be.technifutur.mvc.MenuControler;
import be.technifutur.mvc.MenuModel;
import be.technifutur.mvc.MenuVue;

import java.util.concurrent.Callable;


public class MenuFactory {
    MenuControler mainMenu;
    MenuControler subMenu;
    ActivityModel data = new ActivityModel();

    /*
     $ Major method where MVC Architecture is created.
     */
    public MenuControler getMenu() {
        return mainMenu = mainCreator(initTab());
    }
    public MenuControler getMenu2() {
        subMenu = new MenuControler();
        subMenu.setModel(initSubMenu());
        subMenu.setVue(new MenuVue());
        return subMenu;
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

    private MenuControler mainCreator(MenuModel model) {
        MenuControler menu = new MenuControler();
        menu.setModel(model);
        menu.setVue(new MenuVue());
        return menu;
    }

    private MenuControler createMenu(MenuModel model) {
        MenuControler menu = new MenuControler();
        menu.setVue(new MenuVue());
        menu.setModel(model);
        return menu;
    }

    // Init all model item in the list
    private MenuModel initTab() {
        MenuModel model = new MenuModel("main");
        model.addItem(createItem("exit", null));
        model.addItem(createItem("gestionnaire",new CreateMenuMain(getMenu2())));
        return model;
    }
    private MenuModel initSubMenu() {
        MenuModel model = new MenuModel("gestionnaire");
        model.addItem(createItem("exit", null));
        model.addItem(createItem("Ajouter une activité",addActivity()));
        model.addItem(createItem("Afficher une activité",ModActivity()));
        model.addItem(createItem("Supprimer une activité", DeleteActivity()));
        return model;
    }

    private AddController addActivity() {
        AddController menu = new AddController();
        menu.setModel(data);
        menu.setVue(new ShowAct());
        return menu;
    }
    private DeleteController DeleteActivity() {
        DeleteController menu = new DeleteController();
        menu.setModel(data);
        menu.setVue(new ShowAct());
        return menu;
    }
    private ModifyController ModActivity() {
        ModifyController menu = new ModifyController();
        menu.setModel(data);
        menu.setVue(new ShowAct());
        return menu;
    }
}
