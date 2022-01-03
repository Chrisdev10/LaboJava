package be.technifutur.main;
import be.technifutur.factory.MenuFactory;
import be.technifutur.mvc.MenuControler;
import be.technifutur.toolbox.ToolsBox;


public class GestionMain {
    public static void main(String[] args) throws Exception {
        MenuFactory factory = new MenuFactory();
        MenuControler main = factory.getMain();
        ToolsBox.looperMain(main);
        factory.saveData();
    }
}
