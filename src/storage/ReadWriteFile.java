package storage;

import model.Items;

import java.io.*;
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
    public List readData(String pathname) {
        try {
            FileInputStream fis = new FileInputStream(pathname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object ob = ois.readObject();
            List<Items> items = (List<Items>) ob;
            ois.close();
            fis.close();
            return items;
        } catch (FileNotFoundException e) {
            System.err.println("Khum tìm thấy file!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Items> writeData(List list, String pathname) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathname);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(list);
            oos.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
