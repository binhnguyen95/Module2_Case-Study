package model.accessories;

import model.Items;

import java.io.Serializable;
import java.time.LocalDate;

public class Scarf extends Items implements Serializable {
    private String design;
    private String fabric;

    public Scarf(String code, String name, String color, String brand, Double price, String design, String fabric, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
        this.design = design;
        this.fabric = fabric;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getReleaseDate().plusMonths(6);
    }

    @Override
    public double getRealMoney() {
        return 0;
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
