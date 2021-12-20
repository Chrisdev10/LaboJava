package be.technifutur.DataType;

import java.util.concurrent.Callable;

public interface NodeMenu {
    String getName();
    Callable<? extends Object> getCall();

    void setName(String name);


}
