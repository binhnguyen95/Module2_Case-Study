package model.accessories;

import model.Items;

import java.time.LocalDate;

public class Belt extends Items {
    private String leather;

    public Belt(String code, String name, String color, String brand, Double price, String leather, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
        this.leather = leather;
    }

    public String getLeather() {
        return leather;
    }

    public void setLeather(String leather) {
        this.leather = leather;
    }

    @Override
    public String toString() {
        return "Belt { " +
                super.toString()+
                "][Leather:" + leather+
                "] }";
    }
}
