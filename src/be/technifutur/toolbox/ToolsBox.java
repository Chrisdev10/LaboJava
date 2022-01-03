package be.technifutur.toolbox;

import be.technifutur.DataType.ActivityType;
import be.technifutur.mvc.MenuControler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ToolsBox {
    private static final Scanner scan = new Scanner(System.in);
    public static boolean isChecked(List<ActivityType> act, String name) {
        return act.stream().anyMatch(x -> x.getName().equals(name));
    }
    public static LocalDateTime checkUserDate() {
        boolean isOk = false;
        String date = "";
        LocalDateTime dateFormatted = null;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.FRENCH);
        while (!isOk) {
            System.out.println("Entrez une date dans le format suivant : dd/mm/yyyy HH:mm");
            date = scan.nextLine();
            try {
                dateFormatted = LocalDateTime.parse(date, format);
                isOk = true;
            } catch (DateTimeParseException e) {
                System.out.println("format non valide");
            }
        }
        return dateFormatted;
    }

    public static String confirm(String str) {
        /*
         * Will iterated through the entire tab and print name of item
         */
        System.out.printf("êtes vous sur de %s ? o/n %n",str);
        System.out.print("choix : ");
        return scan.nextLine();
    }

    public static void looperMain(MenuControler menu) throws Exception {
        Callable<? extends Object> call;
        do {
            call  = menu.getCall();
            if (call != null) {
                call.call();
            }
        } while (call != null);
    }

}
