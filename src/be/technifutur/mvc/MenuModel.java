package be.technifutur.mvc;
import be.technifutur.DataType.NodeMenu;
import java.util.*;

public class MenuModel {
    private List<NodeMenu> menu = new ArrayList<>();
    private String name;

    // On définit le nom du model au moment de l'instanciation
    public MenuModel(String name) {
        this.name = name;
    }

    // Ajoute des éléments dans la liste
    public void addItem(NodeMenu itemms) {
        menu.add(itemms);
    }

    // Cible un item de la liste
    public NodeMenu getItem (int pos) {
        return menu.get(pos);
    }

    public String getName() {

        return name;
    }

    public int getSize() {
        return menu.size();
    }

    public List<NodeMenu> getMenu() {
        return menu;
    }

    public void resetList() {
        menu.clear();
    }
}
