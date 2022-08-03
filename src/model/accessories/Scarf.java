package model.accessories;

import model.Items;

import java.time.LocalDate;

public class Scarf extends Items {
    private String design;
    private String fabric;

    public Scarf(String code, String name, String color, String brand, Double price, LocalDate releaseDate, String design, String fabric) {
        super(code, name, color, brand, price, releaseDate);
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
