package be.technifutur.dataStore;

import java.io.*;
import java.util.function.Supplier;

public class DataStore<D extends Serializable> {
    private final Supplier<D> supplier;
    private String file;
    private D data;

    public DataStore(String fileName, Supplier<D> supplier) {
        file = fileName;
        this.supplier = supplier;
    }

    public D getData() {
        if (data == null) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                data = (D) input.readObject();
            } catch (FileNotFoundException e) {
                data = supplier.get();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public void save() {
        if (data != null) {
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
                output.writeObject(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
