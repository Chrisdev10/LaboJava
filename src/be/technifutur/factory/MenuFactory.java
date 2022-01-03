package be.technifutur.factory;

import be.technifutur.DataType.Item;
import be.technifutur.DataType.NodeMenu;
import be.technifutur.activity.*;
import be.technifutur.dataStore.DataStore;
import be.technifutur.dataStore.DataType;
import be.technifutur.horaire.*;
import be.technifutur.main.GestionMenuActivity;
import be.technifutur.main.HoraireMenu;
import be.technifutur.mvc.MenuControler;
import be.technifutur.mvc.MenuModel;
import be.technifutur.mvc.MenuVue;

import java.util.concurrent.Callable;


public class MenuFactory {
    MenuControler main;

    // On instancie un obj Data car il contient les données entrée par l'utilisateur
    DataStore<DataType> dataStorage = new DataStore<>("finalData.txt", DataType::new);
    DataType type = dataStorage.getData();
    ActivityModel data = type.getType();
    HoraireModel data2 = type.getActivity();

    public void saveData() {
        dataStorage.save();
    }



    /*
     * Methode de création de menu
     * getMainMenu génère le MAIN menu. Il prend un model définit dans initTab
     * getGestionMenu génère le subMenu avec un model définit dans initsubTab
     */
    public MenuControler getMain() {
        return main = mainCreator(initTab());
    }

    public MenuControler getGestionMenu() {
        main = new MenuControler();
        main.setModel(initSubMenu());
        main.setVue(new MenuVue());
        return main;
    }

    public MenuControler getHoraireMenu() {
        main = new MenuControler();
        main.setModel(initSubMenu2());
        main.setVue(new MenuVue());
        return main;
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
        model.addItem(createItem("gestionnaire activités", new GestionMenuActivity(getGestionMenu())));
        model.addItem(createItem("gestionnaire horaire", new HoraireMenu(getHoraireMenu())));
        return model;
    }

    // Init all item in sub menu
    private MenuModel initSubMenu() {
        MenuModel model = new MenuModel("Menu Secondaire : Gestion des activités");
        model.addItem(createItem("retour", null));
        model.addItem(createItem("Ajouter une activité", addActivity(false)));
        model.addItem(createItem("Modifier une activité", ModActivity()));
        model.addItem(createItem("Supprimer une activité", DeleteActivity()));
        model.addItem(createItem("Afficher les activités", showAll()));
        return model;
    }

    private MenuModel initSubMenu2() {
        MenuModel model = new MenuModel("Menu Secondaire : Gestion des horaires");
        model.addItem(createItem("retour", null));
        model.addItem(createItem("Ajouter une activité à l'horaire", addHoraire()));
        model.addItem(createItem("Modifier l'horaire d'une activité", ModHoraire()));
        model.addItem(createItem("Supprimer une activité à l'horaire", DeleteHoraire()));
        model.addItem(createItem("Afficher les horaires", showHoraire()));
        return model;
    }


    /*
     * Controlleur personnalisé pour
     * AJOUT / SUPPRESSION / MODIFICATION
     * ils implémentent Callable pour être intégré dans la liste du model
     * NodeMenu <-- item pour l'ajout dans la liste de NodeMenu
     * item <-- Name,Callable
     */


    private AddController addActivity(boolean isHoraire) {
        AddController menu = new AddController(isHoraire);
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
    private ShowAllAct showAll() {
        ShowAllAct menu = new ShowAllAct();
        menu.setModel(data);
        menu.setVue(new ShowAct());
        return menu;
    }

    private AddHoraire addHoraire() {
        AddHoraire menu = new AddHoraire();
        menu.setModel(data2);
        menu.setModel2(data);
        menu.setAdder(addActivity(true));
        menu.setVue(new HoraireVue());
        return menu;
    }

    private DeleteHoraire DeleteHoraire() {
        DeleteHoraire menu = new DeleteHoraire();
        menu.setModel(data2);
        menu.setVue(new HoraireVue());
        return menu;
    }
    private ModHoraire ModHoraire() {
        ModHoraire menu = new ModHoraire();
        menu.setModel(data2);
        menu.setModel2(data);
        menu.setAdder(addActivity(true));
        menu.setVue(new HoraireVue());
        return menu;
    }
    private ShowAllHoraire showHoraire() {
        ShowAllHoraire menu = new ShowAllHoraire();
        menu.setModel(data2);
        menu.setVue(new HoraireVue());
        return menu;
    }
}
