package model.top;

import model.Items;

import java.io.Serializable;
import java.time.LocalDate;

public class Shirt extends Items implements Serializable {

    public Shirt(String code, String name, String color, String brand, Double price, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
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
        return "Shirt { " +
                super.toString()+
                "] }";
    }
}
