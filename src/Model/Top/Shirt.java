package Model.Top;

import Model.Items;

public class Shirt extends Items {
    public Shirt() {
    }

    public Shirt(String code, String name, String color, String brand, Double price) {
        super(code, name, color, brand, price);
    }

    @Override
    public String toString() {
        return "Model.a.Shirt { " +
                super.toString()+
                "] }";
    }
}
