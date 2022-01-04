package be.technifutur.DataType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Activity implements Serializable {
    LocalDateTime start;
    LocalDateTime end;
    String name;
    ActivityType type;

    public Activity(LocalDateTime start, LocalDateTime end, String name, ActivityType type) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.type = type;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd  MMMM  yyyy HH:mm", Locale.FRENCH);
        return "Nom de L'activité = "+ name + "\n" +
                "\tDate Début = " + start.format(formatter) +"\n"+
                "\tDate Fin = " + end.format(formatter) +"\n"+
                "\ttype = " + type.getName()+"\n"+
                "\tinscription = " + (type.isRegistration() ? "obligatoire" : "non obligatoire");
    }
    public String toStringLinear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd  MMMM  yyyy HH:mm", Locale.FRENCH);
        return "Début : "+ start.format(formatter)+
                " | Fin : "+end.format(formatter)+
                " | Nom : "+name+
                " | Type : "+type.getName()+
                " | Inscription : "+(type.isRegistration() ? "V" : "X");
    }
}
