package storage;

import model.Items;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements ReadWriteData {
    private static ReadWriteFile instance=null;

    private ReadWriteFile() {
    }

    public static ReadWriteFile getInstance(){
        if (instance == null) instance = new ReadWriteFile();
        return instance;
    }

    @Override
    public ArrayList readData(String pathname) {
        try{
            FileInputStream fileInputStream = new FileInputStream(pathname);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object ob = objectInputStream.readObject();
            ArrayList products = (ArrayList)  ob;

            return products;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void writeData(List list, String pathname) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(pathname);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
