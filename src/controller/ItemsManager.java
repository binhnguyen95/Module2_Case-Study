package controller;

import model.Items;
import model.accessories.Belt;
import model.accessories.Scarf;
import model.accessories.Spectacles;
import model.top.Jacket;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemsManager implements Serializable {
//    private List<Items> itemsList = new ArrayList<>();
    List<Items> itemsList = new ArrayList<>();
    private List<Jacket> jacketList;
    private List<Scarf> scarfList;
    private List<Spectacles> spectaclesList;
    private List<Belt> beltList;
    private ReadWriteData readWriteData = ReadWriteFile.getInstance();

    public ItemsManager() {
        itemsList = new ArrayList<>();
    }

    public void add(Items items) {
        itemsList.add(items);
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void remove(int index) {
        if (itemsList.size() > 0) {
            for (int i = 0; i < itemsList.size(); i++) {
                if (i == (index - 1)) {
                    itemsList.remove(i);
                    writeFile();
                }
            }
        } else if (index >= itemsList.size()) {
            System.err.println("Vị trí không tồn tại");
        } else
            System.err.println("Danh sách rỗng !!!");
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void editName(String code, String editName) {
        for (Items i: itemsList) {
            if (i.getCode().equals(code)) {
                i.setName(editName);
                break;
            }
        }
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void editColor(String code, String editColor) {
        for (Items i: itemsList) {
            if (i.getCode().equals(code)) {
                i.setColor(editColor);
                break;
            }
        }
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void editBrand(String code, String editBrand) {
        for (Items i: itemsList) {
            if (i.getCode().equals(code)) {
                i.setBrand(editBrand);
                break;
            }
        }
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void editPrice(String code, Double editPrice) {
        for (Items i: itemsList) {
            if (i.getCode().equals(code)) {
                i.setPrice(editPrice);
                break;
            }
        }
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void display() {
        int count=1;
        try{
            ArrayList<Items> displayFile = readWriteData.readData("Items.a");
            for (Items i: displayFile
            ) {
                System.out.println(count +". "+ i);
                count++;
            }
        } catch (Exception e) {
            System.err.println("Gian hàng trống!!!!");
            e.getMessage();
        }
    }

    public void sortHighestFirst() {
        ArrayList<Items> list = readWriteData.readData("Items.a");
        list.sort(((o1, o2) -> {
            if (o1.getPrice() < o2.getPrice())
                return 1;
            if (o1.getPrice() > o2.getPrice())
                return -1;
            else return 0;
        }));
        display();
    }

    public void sortLowestFirst() {
        itemsList.sort(((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice())));
        display();
    }


    public void writeFile() {
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void readFile() {
        itemsList = readWriteData.readData("Items.a");
    }

}
