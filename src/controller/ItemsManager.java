package controller;

import model.Items;
import model.accessories.Belt;
import model.accessories.Scarf;
import model.accessories.Spectacles;
import model.top.Jacket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemsManager {
    List<Items> itemsList;
    List<Jacket> jacketList;
    List<Scarf> scarfList;
    List<Spectacles> spectaclesList;
    List<Belt> beltList;
//    private final String PATHNAME_OF_ITEMS = "items.dat";

    public ItemsManager() {
        itemsList = new ArrayList<>();
    }

    public void add(Items items) {
        itemsList.add(items);
    }

    public void remove(String code) {
        itemsList.removeIf(p -> Objects.equals(p.getCode(), code));
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
        int count = 1;
        System.out.println("[Số lượng sản phẩm: " + itemsList.size() + "]\n");
        if (itemsList.size() == 0) {
            System.err.println("Danh sách rỗng !!!");
        } else {
            for (Items items : itemsList) {
                System.out.print("[" + (count++) + "]\t");
                System.out.println(items);
            }
        }


    }
}
