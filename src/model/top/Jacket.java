package model.top;

import model.Items;

import java.time.LocalDate;

public class Jacket extends Items {
    private String fabric;

    public Jacket(String code, String name, String color, String brand, Double price, String fabric, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
        this.fabric = fabric;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "Jacket { " +
                super.toString()+
                "][Jacket:" + fabric+
                "] }";
    }
}
