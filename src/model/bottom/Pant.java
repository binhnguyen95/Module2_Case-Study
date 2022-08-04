package model.bottom;

import model.Items;

import java.time.LocalDate;

public class Pant extends Items {
    public Pant(String code, String name, String color, String brand, Double price, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
    }

    @Override
    public String toString() {
        return "Pant { " +
                super.toString()+
                "] }";
    }
}