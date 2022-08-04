package model.accessories;

import model.Items;

import java.time.LocalDate;

public class Spectacles extends Items {
    private String shape;

    public Spectacles(String code, String name, String color, String brand, Double price, String shape, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
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
        return "Spectacles { " +
                super.toString()+
                "][Shape:" + shape+
                "] }";
    }
}
