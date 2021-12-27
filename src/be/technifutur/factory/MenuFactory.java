package be.technifutur.factory;

import be.technifutur.DataType.Item;
import be.technifutur.DataType.NodeMenu;
import be.technifutur.activity.*;
import be.technifutur.horaire.AddHoraire;
import be.technifutur.horaire.HoraireModel;
import be.technifutur.horaire.HoraireVue;
import be.technifutur.main.GestionMenuActivity;
import be.technifutur.main.HoraireMenu;
import be.technifutur.mvc.MenuControler;
import be.technifutur.mvc.MenuModel;
import be.technifutur.mvc.MenuVue;

import java.util.concurrent.Callable;


public class MenuFactory {
    MenuControler mainMenu;
    MenuControler subMenu;
    // On instancie un obj Data car il contient les données entrée par l'utilisateur
    ActivityModel data = new ActivityModel();
    HoraireModel data2 = new HoraireModel();
    public void saveData() {
        data.saveData();
    }
    public void saveData2() {
        data2.saveData();
    }

    /*
     * Methode de création de menu
     * getMainMenu génère le MAIN menu. Il prend un model définit dans initTab
     * getGestionMenu génère le subMenu avec un model définit dans initsubTab
     */
    public MenuControler getMainMenu() {
        return mainMenu = mainCreator(initTab());
    }

    public MenuControler getGestionMenu() {
        subMenu = new MenuControler();
        subMenu.setModel(initSubMenu());
        subMenu.setVue(new MenuVue());
        return subMenu;
    }
    public MenuControler getHoraireMenu() {
        subMenu = new MenuControler();
        subMenu.setModel(initSubMenu2());
        subMenu.setVue(new MenuVue());
        return subMenu;
    }



    //CREATE MAIN MENU
    private MenuControler mainCreator(MenuModel model) {
        MenuControler menu = new MenuControler();
        menu.setModel(model);
        menu.setVue(new MenuVue());
        return menu;
    }

    /*
     * Initiateur de model
     * On va ajouter les différents paramètre du menu avec une méthode
     * GETCALL intégrée dans chacunes d'entres elles
     *
     * createItem == Name + Callable<?>
     */
    private NodeMenu createItem(String name, Callable<?> call) {
        Item createItem = new Item();
        createItem.setName(name);
        createItem.setCall(call);
        return createItem;
    }

    // Init all model item in the list
    private MenuModel initTab() {
        MenuModel model = new MenuModel("Menu Principal");
        model.addItem(createItem("exit", null));
        model.addItem(createItem("gestionnaire activités",new GestionMenuActivity(getGestionMenu())));
        model.addItem(createItem("gestionnaire horaire (bientôt...)",new HoraireMenu(getHoraireMenu())));
        return model;
    }

    // Init all item in sub menu
    private MenuModel initSubMenu() {
        MenuModel model = new MenuModel("Menu Secondaire : Gestion des activités");
        model.addItem(createItem("retour", null));
        model.addItem(createItem("Ajouter une activité",addActivity()));
        model.addItem(createItem("Modifier une activité",ModActivity()));
        model.addItem(createItem("Supprimer une activité", DeleteActivity()));
        return model;
    }

    private MenuModel initSubMenu2() {
        MenuModel model = new MenuModel("Menu Secondaire : Gestion des horaires");
        model.addItem(createItem("retour", null));
        model.addItem(createItem("Ajouter une activité à l'horaire",addHoraire()));
        model.addItem(createItem("Modifier l'horaire d'une activité",ModActivity()));
        model.addItem(createItem("Supprimer une activité à l'horaire", DeleteActivity()));
        return model;
    }


    /*
     * Controlleur personnalisé pour
     * AJOUT / SUPPRESSION / MODIFICATION
     * ils implémentent Callable pour être intégré dans la liste du model
     * NodeMenu <-- item pour l'ajout dans la liste de NodeMenu
     * item <-- Name,Callable
     */


    private AddController addActivity() {
        AddController menu = new AddController();
        menu.setModel(data);
        menu.setVue(new ShowAct());
        return menu;
    }
    private DeleteController DeleteActivity() {
        DeleteController menu = new DeleteController();
        menu.setModel(data);
        menu.setModel2(data2);
        menu.setVue(new ShowAct());
        return menu;
    }
    private ModifyController ModActivity() {
        ModifyController menu = new ModifyController();
        menu.setModel(data);
        menu.setVue(new ShowAct());
        return menu;
    }
    private AddHoraire addHoraire() {
        AddHoraire menu = new AddHoraire();
        menu.setModel(data2);
        menu.setModel2(data);
        menu.setVue(new HoraireVue());
        return menu;
    }
}
