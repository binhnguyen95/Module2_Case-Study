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
        ItemsManager itemsManager = new ItemsManager();
        Shirt shirt1 = new Shirt("SH-05", "ao1", "den", "bub", 50.5, LocalDate.now());
        itemsManager.add(shirt1);


        System.out.println("\n--------------CỬA HÀNG THỜI TRANG--------------");
        System.out.println("Nhập 1: Hiển thị danh sách hiện có");
        System.out.println("Nhập 2: Thêm trang phục");
        System.out.println("Nhập 3: Xóa trang phục");
        System.out.println("Nhập 4: Sắp xếp theo giá");
        System.out.println("Nhập 5: Tìm kiếm sản phẩm theo tên");
        System.out.println("Nhập 6: Hàng mới về");
        System.out.println("Nhập 7: >>> [SALE] <<<");
        System.out.println("Nhập 0: Thoát");
        System.out.println("----------------------------------------------");
        System.out.print("[Lựa chọn]:\t");
        try {
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    try {
                        itemsManager.display();
                    } catch (NullPointerException e) {
                        System.err.println("Dữ liệu trống !!!");
                    }
                    break;
                case 2:
                    addItems(itemsManager);
                    break;
                case 3:
                    removeItems(itemsManager);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println();
        }

        itemsManager.display();
    }

    private static void edit(String code, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Nhập tên mới:");

        }
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

    private static Items infomation(String type, String code) {
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

    private static void removeItems(ItemsManager items) {
        System.out.println("Nhập mã sản phẩm mún xóa:");
        String code = scan.nextLine();
        if (validate.validateCode(code)) {
            items.remove(code);
        } else {
            System.err.println("Cú pháp không hợp lệ!!!!");
            System.out.println();
        }
    }
}
