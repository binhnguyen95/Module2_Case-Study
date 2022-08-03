package controller;

import model.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ItemsManager {
    List<Items> itemsList;
    private final String PATHNAME_OF_ITEMS = "items.dat";

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
