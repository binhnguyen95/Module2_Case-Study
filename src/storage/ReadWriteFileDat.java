package storage;

import model.Items;

import java.util.List;

public class ReadWriteFileDat implements ReadWriteData {
    private static ReadWriteFileDat instance=null;

    private ReadWriteFileDat() {
    }

    public static ReadWriteFileDat getInstance(){
        if (instance == null) instance = new ReadWriteFileDat();
        return instance;
    }

    @Override
    public List<Items> readData(String pathname) {
        return null;
    }

    @Override
    public void writeData(List<Items> itemsList, String pathname) {

    }
}
