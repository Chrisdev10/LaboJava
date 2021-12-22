package be.technifutur.DataType;

import java.io.Serializable;
import java.time.LocalDate;

public class Activity implements Serializable {
    LocalDate start;
    LocalDate end;
    String name;
    ActivityType type;

    public Activity(LocalDate start, LocalDate end, String name, ActivityType type) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.type = type;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
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
}
