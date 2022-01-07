package be.technifutur.factory;

import be.technifutur.DataType.Activity;
import be.technifutur.DataType.Item;
import be.technifutur.DataType.NodeMenu;
import be.technifutur.DataType.Personne;
import be.technifutur.activity.*;
import be.technifutur.dataStore.DataStore;
import be.technifutur.dataStore.DataType;
import be.technifutur.horaire.*;
import be.technifutur.inscription.*;
import be.technifutur.main.SubMain;
import be.technifutur.mvc.MenuControler;
import be.technifutur.mvc.MenuModel;
import be.technifutur.mvc.MenuVue;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;


public class MenuFactory {
    MenuControler main;

    // On instancie un obj Data car il contient les données entrée par l'utilisateur
    DataStore<DataType> dataStorage = new DataStore<>("finalData.txt", DataType::new);
    DataType type = dataStorage.getData();
    ActivityModel typeActivityModel = type.getType();
    HoraireModel horaireModel = type.getActivity();
    ModelHoraireSubs horaireAndSubsModel = type.getSub();
    SubData subs = type.getSubber();
    PersonneData personne = type.getPersonne();

    public void saveData() {
        dataStorage.save();
    }



    /*
     * Methode de création de menu
     * getMainMenu génère le MAIN menu. Il prend un model définit dans initTab
     * getGestionMenu génère le subMenu avec un model définit dans initsubTab
     */
    public MenuControler getMain() {
        return main = mainCreator(initMainMenu());
    }

    public MenuControler getGestionMenu() {
        main = new MenuControler();
        main.setModel(initActivityMenu());
        main.setVue(new MenuVue());
        return main;
    }

    public MenuControler getHoraireMenu() {
        main = new MenuControler();
        main.setModel(initScheduleMenu());
        main.setVue(new MenuVue());
        return main;
    }

    public MenuControler getSubMenu() {
        main = new MenuControler();
        main.setModel(initSubMenu());
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
    private MenuModel initMainMenu() {
        MenuModel model = new MenuModel("Menu Principal");
        model.addItem(createItem("exit", null));
        model.addItem(createItem("gestionnaire activités", new SubMain(getGestionMenu())));
        model.addItem(createItem("gestionnaire horaire", new SubMain(getHoraireMenu())));
        model.addItem(createItem("gestionnaire inscription",new SubMain(getSubMenu())));
        return model;
    }

    // Init all item in sub menu
    private MenuModel initActivityMenu() {
        MenuModel model = new MenuModel("Menu Secondaire : Gestion des activités");
        model.addItem(createItem("retour", null));
        model.addItem(createItem("Ajouter une activité", addActivity(false)));
        model.addItem(createItem("Modifier une activité", ModActivity()));
        model.addItem(createItem("Supprimer une activité", DeleteActivity()));
        model.addItem(createItem("Afficher les activités", showAll()));
        return model;
    }

    private MenuModel initScheduleMenu() {
        MenuModel model = new MenuModel("Menu Secondaire : Gestion des horaires");
        model.addItem(createItem("retour", null));
        model.addItem(createItem("Ajouter une activité à l'horaire", addHoraire()));
        model.addItem(createItem("Modifier l'horaire d'une activité", ModHoraire()));
        model.addItem(createItem("Supprimer une activité à l'horaire", DeleteHoraire()));
        model.addItem(createItem("Afficher les horaires", showHoraire()));
        return model;
    }

    private MenuModel initSubMenu() {
        MenuModel model = new MenuModel("Menu Secondaire : Gestion des inscriptions");
        model.addItem(createItem("retour", null));
        model.addItem(createItem("Ajouter une inscription", subsAdder()));
        model.addItem(createItem("Modifier une inscription",subsModifier()));
        model.addItem(createItem("Supprimer une inscription",subsRemover()));
        model.addItem(createItem("Afficher la liste d'inscription", subsShow()));
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
        menu.setModel(typeActivityModel);
        menu.setVue(new ShowAct());
        return menu;
    }

    private DeleteController DeleteActivity() {
        DeleteController menu = new DeleteController();
        menu.setModel(typeActivityModel);
        menu.setModel2(horaireModel);
        menu.setVue(new ShowAct());
        return menu;
    }

    private ModifyController ModActivity() {
        ModifyController menu = new ModifyController();
        menu.setModel(typeActivityModel);
        menu.setVue(new ShowAct());
        return menu;
    }
    private ShowAllAct showAll() {
        ShowAllAct menu = new ShowAllAct();
        menu.setModel(typeActivityModel);
        menu.setVue(new ShowAct());
        return menu;
    }

    private AddHoraire addHoraire() {
        AddHoraire menu = new AddHoraire();
        menu.setModel(horaireModel);
        menu.setModel2(typeActivityModel);
        menu.setAdder(addActivity(true));
        menu.setVue(new HoraireVue());
        return menu;
    }

    private DeleteHoraire DeleteHoraire() {
        DeleteHoraire menu = new DeleteHoraire();
        menu.setModel(horaireModel);
        menu.setVue(new HoraireVue());
        return menu;
    }
    private ModHoraire ModHoraire() {
        ModHoraire menu = new ModHoraire();
        menu.setModel(horaireModel);
        menu.setModel2(typeActivityModel);
        menu.setAdder(addActivity(true));
        menu.setVue(new HoraireVue());
        return menu;
    }
    private ShowAllHoraire showHoraire() {
        ShowAllHoraire menu = new ShowAllHoraire();
        menu.setModel(horaireModel);
        menu.setVue(new HoraireVue());
        return menu;
    }

    private AddSub subsAdder() {
        AddSub menu = new AddSub();
        menu.setSubs(subs);
        menu.setHoraireModel(horaireModel);
        menu.setModel(horaireAndSubsModel);
        menu.setPersonne(personne);
        menu.setVue(new ViewSub());
        return menu;
    }

    private ModifySub subsModifier() {
        ModifySub menu = new ModifySub();
        menu.setHoraireModel(horaireModel);
        menu.setModel(horaireAndSubsModel);
        menu.setVue(new ViewSub());
        return menu;
    }

    private RemoveSub subsRemover() {
        RemoveSub menu = new RemoveSub();
        menu.setHoraireModel(horaireModel);
        menu.setModel(horaireAndSubsModel);
        ViewSub subview = new ViewSub();
        subview.setModel(horaireAndSubsModel);
        menu.setVue(subview);
        return menu;
    }
    private ShowAllSubs subsShow() {
        ShowAllSubs menu = new ShowAllSubs();
        menu.setModel(horaireAndSubsModel);
        ViewSub subview = new ViewSub();
        subview.setModel(horaireAndSubsModel);
        menu.setVue(subview);
        return menu;
    }


}
