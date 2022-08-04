package model.top;

import model.Items;

import java.io.Serializable;
import java.time.LocalDate;

public class Jacket extends Items implements Serializable {
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
    public LocalDate getExpiryDate() {
        return this.getReleaseDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        return 0;
    }

    @Override
    public String toString() {
        return "Jacket { " +
                super.toString()+
                "][Jacket:" + fabric+
                "] }";
    }
}
