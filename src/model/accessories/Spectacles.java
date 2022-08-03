package model.accessories;

import model.Items;

import java.time.LocalDate;

public class Spectacles extends Items {
    private final String lens;

    public Spectacles(String code, String name, String color, String brand, Double price, LocalDate releaseDate, String lens) {
        super(code, name, color, brand, price, releaseDate);
        this.lens = lens;
    }

    @Override
    public String toString() {
        return "Spectacles { " +
                super.toString()+
                "][Lens:" + lens+
                "] }";
    }
}
