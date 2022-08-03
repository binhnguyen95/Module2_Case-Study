package storage;

import model.Items;

import java.util.List;

public interface ReadWriteData {
    List<Items> readData(String pathname);
    void writeData(List<Items> itemsList, String pathname);
}
