package be.technifutur.activity;

import java.util.concurrent.Callable;

public class Item implements NodeMenu {

    private String name;
    private Callable<?> call;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Callable<?> getCall() {
        return call;
    }

    public void setCall(Callable<?> call) {
        this.call = call;
    }

}
