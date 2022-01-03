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
import java.util.regex.Matcher;

public class ToolsBox {
    private static final Scanner scan = new Scanner(System.in);
    private final String DATE_PATTERN = "";
    public static boolean isChecked(List<ActivityType> act, String name) {
        return act.stream().anyMatch(x -> x.getName().equals(name));
    }
    public static LocalDateTime checkUserDate(LocalDateTime before, boolean isStart) {
        boolean isOk = false;
        String date = "";
        LocalDateTime dateFormatted = null;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyyy H:mm", Locale.FRENCH);
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("d-MM-yyyy H:mm", Locale.FRENCH);
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("d MM yyyy H:mm", Locale.FRENCH);
        
        while (!isOk) {
            System.out.println("Entrez une date dans le format suivant : d/mm/yyyy H:mm");
            date = scan.nextLine();
            try {
                dateFormatted = LocalDateTime.parse(date, format);
                isOk = true;
            } catch (DateTimeParseException e) {
                try {
                    dateFormatted = LocalDateTime.parse(date, format2);
                    isOk = true;
                } catch (DateTimeParseException f) {
                    try {
                        dateFormatted = LocalDateTime.parse(date, format3);
                        isOk = true;
                    } catch (DateTimeParseException g) {
                        System.out.println("format non valide");
                    }
                }
            }
        }
        if(isStart) {
            if (dateFormatted.isBefore(LocalDateTime.now())) {
                System.out.println("date inférieur au " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMMM yyyy H:mm", Locale.FRENCH)));
                return null;
            } else {
                return dateFormatted;
            }
        }
        else{
            if (dateFormatted.isBefore(before)) {
                System.out.println("date inférieur au " + before.format(DateTimeFormatter.ofPattern("d MMMM yyyy H:mm", Locale.FRENCH)));
                return null;
            } else {
                return dateFormatted;
            }
        }
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
