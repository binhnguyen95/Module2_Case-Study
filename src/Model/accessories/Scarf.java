package Model.accessories;

import Model.Items;

public class Scarf extends Items {
    private String design;
    private String fabric;

    public Scarf() {
    }

    public Scarf(String code, String name, String color, String brand, Double price, String design, String fabric) {
        super(code, name, color, brand, price);
        this.design = design;
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "Scarf { " +
                super.toString()+
                "][designs:" + design +
                "][fabric:" + fabric +
                "] }";
    }
}
