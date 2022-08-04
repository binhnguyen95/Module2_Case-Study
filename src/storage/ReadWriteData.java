package storage;

import model.Items;

import java.util.List;

public interface ReadWriteData<E> {
    List<E> readData(String pathname);
    void writeData(List<E> e, String pathname);
}
