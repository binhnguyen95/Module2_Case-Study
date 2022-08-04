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
    private List<Items> itemsList;
    private List<Jacket> jacketList;
    private List<Scarf> scarfList;
    private List<Spectacles> spectaclesList;
    private List<Belt> beltList;

    private ReadWriteData readWriteData = ReadWriteFile.getInstance();

//    private final String PATHNAME_OF_ITEMS = "items.dat";

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
            if (Objects.equals(i.getCode(), code)) {
                i.setName(editName);
            }
        }
    }

    public void editColor(String code, String editColor) {
        for (Items i: itemsList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setColor(editColor);
            }
        }
    }

    public void editBrand(String code, String editBrand) {
        for (Items i: itemsList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setBrand(editBrand);
            }
        }
    }

    public void editPrice(String code, Double editPrice) {
        for (Items i: itemsList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setPrice(editPrice);
            }
        }
    }

    public void editJacketFabric(String code, String editFabric) {
        for (Jacket i: jacketList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setFabric(editFabric);
            }
        }
    }

    public void editLeather(String code, String editLeather) {
        for (Belt i: beltList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setLeather(editLeather);
            }
        }
    }

    public void editDesign(String code, String editDesign) {
        for (Scarf i: scarfList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setDesign(editDesign);
            }
        }
    }

    public void editScarfFabric(String code, String editFabric) {
        for (Scarf i: scarfList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setFabric(editFabric);
            }
        }
    }

    public void editShape(String code, String editShape) {
        for (Spectacles i: spectaclesList) {
            if (Objects.equals(i.getCode(), code)) {
                i.setShape(editShape);
            }
        }
    }

    public void display() {
        int count=1;
        try{
            List<Items> displayFile = readWriteData.readData("Items.a");
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
        itemsList.sort(((o1, o2) -> {
            if (o1.getPrice() < o2.getPrice())
                return 1;
            if (o1.getPrice() > o2.getPrice())
                return -1;
            else return 0;
        }));
        display();
    }

    public void sortLowestFirst() {
        itemsList.sort(((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice())
                return 1;
            if (o1.getPrice() < o2.getPrice())
                return -1;
            else return 0;
        }));
        display();
    }

    public void sortByDate() {
        itemsList.sort(((o1, o2) -> {
            if (o1.getReleaseDate().isBefore(o2.getReleaseDate()))
                return 1;
            if (o1.getReleaseDate().isAfter(o2.getReleaseDate()))
                return -1;
            else return 0;
        }));
        display();
    }

    public void writeFile() {
        readWriteData.writeData(itemsList, "Items.a");
    }

    public void readFile() {
        itemsList = (List<Items>) readWriteData.readData("Items.a");
    }
}
