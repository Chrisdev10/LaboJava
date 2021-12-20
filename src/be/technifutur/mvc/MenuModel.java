package be.technifutur.mvc;
import be.technifutur.DataType.NodeMenu;
import java.util.*;

public class MenuModel {
    private List<NodeMenu> menu = new ArrayList<>();

    public void addItem(NodeMenu itemms) {
        menu.add(itemms);
    }
    public NodeMenu getItem (int pos) {
        return menu.get(pos);
    }

    public int getSize() {
        return menu.size();
    }

}
