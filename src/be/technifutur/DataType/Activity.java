package be.technifutur.DataType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Activity implements Serializable{
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
                "\tinscription = " + (type.isRegistration() ? "obligatoire" : "facultative");
    }
    public String toStringLinear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd  MMMM  yyyy HH:mm", Locale.FRENCH);
        return "Début : "+ start.format(formatter)+
                " | Fin : "+end.format(formatter)+
                " | Nom : "+name+
                " | Type : "+type.getName()+
                " | Inscription : "+(type.isRegistration() ? "obligatoire" : "facultative");
    }
    public boolean equals2(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (start != null ? !start.equals(activity.start) : activity.start != null) return false;
        if (end != null ? !end.equals(activity.end) : activity.end != null) return false;
        if (name != null ? !name.equals(activity.name) : activity.name != null) return false;
        return type != null ? type.equals(activity.type) : activity.type == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (name != null ? !name.equals(activity.name) : activity.name != null) return false;
        return type != null ? type.equals(activity.type) : activity.type == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
