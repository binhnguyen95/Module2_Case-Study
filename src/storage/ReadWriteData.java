package storage;

import model.Items;

import java.util.List;

public interface ReadWriteData<E> {
    List<E> readData(String pathname);
    List<Items> writeData(List<E> e, String pathname);
}
