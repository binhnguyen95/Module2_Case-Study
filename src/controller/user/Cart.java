package controller.user;

import model.Items;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Items> selected;

    public Cart() {
        selected = new ArrayList<>();
    }

    public List<Items> getList() {
        return selected;
    }
}
