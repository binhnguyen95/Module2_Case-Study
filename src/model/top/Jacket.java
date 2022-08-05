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
        LocalDate now = LocalDate.now();
        LocalDate timeline1 = getExpiryDate().minusDays(120);
        LocalDate timeline2 = getExpiryDate().minusDays(60);
        if (timeline2.isAfter(now)) {
            if (timeline1.isAfter(now)) return getPrice() / 10*9.5;
            return getPrice() / 10*8;
        }
        else {
            return getPrice() / 10*6;
        }
    }

    @Override
    public String toString() {
        return "Jacket { " +
                super.toString()+
                "][Jacket:" + fabric+
                "] }";
    }
}
