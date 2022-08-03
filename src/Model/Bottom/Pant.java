package Model.Bottom;

import Model.Items;

public class Pant extends Items {
    public Pant() {
    }

    public Pant(String code, String name, String color, String brand, Double price) {
        super(code, name, color, brand, price);
    }

    @Override
    public String toString() {
        return "Model.Bottom.Pant { " +
                super.toString()+
                "] }";
    }
}
