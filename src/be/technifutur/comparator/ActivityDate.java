package be.technifutur.comparator;

import be.technifutur.DataType.Activity;

import java.util.Comparator;

public class ActivityDate implements Comparator<Activity> {

    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.getStart().compareTo(o2.getStart());
    }
}
