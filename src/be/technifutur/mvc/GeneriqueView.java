package be.technifutur.mvc;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GeneriqueView {

    private final Scanner scan = new Scanner(System.in);

    public <K, V> void showMap(Map<K, List<V>> map) {

        if (map.isEmpty()) {
            System.out.println("*** LISTE VIDE ***");
        } else {
            for (Map.Entry<K, List<V>> entry : map.entrySet()) {
                System.out.println(entry.getKey());
                if (entry.getValue().size() == 0) {
                    System.out.println(" *** Liste Vide ***");
                } else {
                    System.out.println(" Liste d'inscription =>");
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        System.out.printf("[%d] %s \n", i + 1, entry.getValue().get(i));
                    }
                }

            }
        }
        System.out.println();

    }

    public <D> void showList(List<D> model, boolean index, String name) {
        if (model.size() == 0) {
            System.out.println(" *** liste vide *** ");
        } else {
            if (index) {
                System.out.println(" *** "+name+" *** ");
                for (int i = 0; i < model.size(); i++) {
                    System.out.printf("(%2d ) %s%n", i + 1, model.get(i).toString());
                }
            }else{
                model.forEach(System.out::println);
            }
        }
        System.out.println();
    }

    public <D> void msgDelete(D e) {
        System.out.println(e.toString());
        System.out.println("### élément supprimé ###");
    }

    public <D> void successAdd(D type) {
        System.out.println("### ajout terminé ###");
        System.out.println("### élément ajouté ###");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }
    public <D> void successMod(D type) {
        System.out.println("### élément modifié ###");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }
    public <D> void successDel(D type) {
        System.out.println("### suppression terminée ###");
        System.out.println("élément supprimé");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }
    public <D> void failDel(D type) {
        System.out.println("### suppression annulée ###");
        System.out.println("/!\\ élément présent dans la liste des horaires /!\\");
        System.out.println(type.toString());
        System.out.println();
        System.out.println();
    }

    public void dateAlert() {
        System.out.println("La date entrée n'est pas valide");
    }

    public void cancelDelete() {
        System.out.println("suppression annulée");
    }

    public void emptyInput() {
        System.out.println("pas d'entrée");
    }

    public void alreadyIN() {
        System.out.println("déjà présent");
    }

    public void unValid() {
        System.out.println("/!\\ non valide /!\\");
    }


    public String userInput(String str) {

        System.out.println(str);
        System.out.print("saisir : ");
        return scan.nextLine();
    }

}
