package Model.Top;

import Model.Items;

public class TShirt extends Items {
    public TShirt() {
    }

    public TShirt(String code, String name, String color, String brand, Double price) {
        super(code, name, color, brand, price);
    }

    @Override
    public String toString() {
        return "T-Shirt { " +
                super.toString()+
                "] }";
    }
}
