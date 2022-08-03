package view;

import controller.ItemsManager;
import model.Items;
import model.accessories.Scarf;
import model.accessories.Spectacles;
import model.bottom.Pant;
import model.top.Shirt;
import validate.Validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainAdmin {
    public static Scanner scan = new Scanner(System.in);
    private static Validate validate = new Validate();

    public static void main(String[] args) {
        ItemsManager items = new ItemsManager();
        Shirt shirt1 = new Shirt("SH-05", "ao1", "den", "bub", 50.5, LocalDate.now());
        items.add(shirt1);
        addItems(items);
        items.display();

    }

    private static void addItems(ItemsManager items) {
        System.out.println("Nhập mã sản phẩm:");
        String code = scan.nextLine();
        if (validate.validateCode(code)) {
            String type = code.substring(0, 2);
            items.add(infomation(type, code));
        } else {
            System.err.println("Cú pháp không hợp lệ!!!!");
            System.out.println();
        }
    }

    public static Items infomation(String type, String code) {
        System.out.println("Nhập tên sản phẩm:");
        String name = scan.nextLine();
        System.out.println("Nhập màu sắc sản phẩm:");
        String color = scan.nextLine();
        System.out.println("Nhập nhãn hiệu sản phẩm:");
        String brand = scan.nextLine();
        System.out.println("Nhập giá tiền sản phẩm:");
        Double price = scan.nextDouble();
        scan.nextLine();
        System.out.println("Ngày lên kệ:");
        String rd = scan.nextLine();
        LocalDate releaseDate = LocalDate.parse(rd, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        switch (type) {
            case "SH":
                return new Shirt(code, name, color, brand, price, releaseDate);
            case "PA":
                return new Pant(code, name, color, brand, price, releaseDate);
            case "SC":
                System.out.print("Nhập tròng kính:");
                String lens = scan.nextLine();
                return new Spectacles(code, name, color, brand, price, releaseDate, lens);
            case "SP":
                System.out.print("Nhập kiểu dáng:");
                String design = scan.nextLine();
                System.out.print("Nhập chất liệu:");
                String fabric = scan.nextLine();
                return new Scarf(code, name, color, brand, price, releaseDate, design, fabric);
            default:
                return null;
        }
    }

//    public static edit(String code, int choice) {
//        switch (choice) {
//            case 1:
//                System.out.println("Nhập tên mới:");
//        }
//    }
}
