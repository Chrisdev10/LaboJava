package be.technifutur.activity;

import be.technifutur.DataType.ActivityType;
import be.technifutur.mvc.MenuVue;

import java.util.concurrent.Callable;

public class AddAct implements Callable<ActivityType> {
    ActivityModel model = new ActivityModel();
    MenuVue vue = new MenuVue();
    @Override
    public ActivityType call() throws Exception {
        String activité = "";
        boolean isReg = false;boolean check = false;boolean continued = false;
        char choice = 0;
        while(!continued) {
            try {
                activité = vue.saisirActivity();
                isReg = Boolean.parseBoolean(vue.saisirReg());

            } catch (Exception e) {
                e.printStackTrace();
            }
            choice = (vue.confirm("ajouter")).toLowerCase().charAt(0);
            if (choice == 'o') {
                ActivityType type = model.addActivityType(activité, isReg);
            }else if(choice =='n'){
                System.out.println("non ajouté");
            }else{
                System.out.println("non valide");
            }
            choice = (vue.confirm("continuer")).toLowerCase().charAt(0);
            if (choice == 'n') {
                continued = true;
            }else if(choice !='o'){
                System.out.println("non valide");
            }
            model.getList().forEach( x -> System.out.println(x.getName()+"  "+x.isRegistration()));
        }

        return null;
    }
}
