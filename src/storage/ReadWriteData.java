package storage;

import model.Items;

import java.util.ArrayList;
import java.util.List;

public interface ReadWriteData<E> {
    ArrayList<E> readData(String pathname);
    void writeData(List<E> e, String pathname);
}
