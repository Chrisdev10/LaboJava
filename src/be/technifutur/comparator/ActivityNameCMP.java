package be.technifutur.comparator;

import be.technifutur.DataType.ActivityType;

import java.util.Comparator;

public class ActivityNameCMP implements Comparator<ActivityType> {
    @Override
    public int compare(ActivityType o1, ActivityType o2) {
        int numb = 0;
        numb = o1.getName().compareTo(o2.getName());
        return numb;
    }
}
