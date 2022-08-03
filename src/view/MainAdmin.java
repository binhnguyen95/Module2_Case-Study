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
        Shirt shirt1 = new Shirt("SH-05", "ao 1", "den", "bub", 50.5, LocalDate.now());
        Pant pant1 = new Pant("PA-01", "quan 1", "trang", "lacoste", 50.1, LocalDate.now());
        itemsManager.add(shirt1);
        itemsManager.add(pant1);


        System.out.println("\n--------------CỬA HÀNG THỜI TRANG--------------");
        System.out.println("Nhập 1: Hiển thị danh sách hiện có");
        System.out.println("Nhập 2: Thêm sản phẩm");
        System.out.println("Nhập 3: Sửa sản phẩm");
        System.out.println("Nhập 4: Xóa sản phẩm");
        System.out.println("Nhập 5: Sắp xếp theo giá");
        System.out.println("Nhập 6: Tìm kiếm sản phẩm theo tên");
        System.out.println("Nhập 7: Hàng mới về");
        System.out.println("Nhập 8: >>> [SALE] <<<");
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
                    edit(itemsManager);
                    break;
                case 4:
                    removeItems(itemsManager);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println();
        }

        itemsManager.display();
    }

    private static void edit(ItemsManager items) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm mún sửa:");
        String code = scanner.nextLine();
        System.out.println("Nhập 1: Sửa tên");
        System.out.println("Nhập 2: Sửa màu");
        System.out.println("Nhập 3: Sửa hãng");
        System.out.println("Nhập 4: Sũa giá");
        System.out.print("[Lựa chọn]:\t");
        int choice = scanner.nextInt();
        if (validate.validateCode(code)) {
            switch (choice) {
                case 1:
                    System.out.println("Mời bạn nhập vào tên mới:");
                    Scanner name = new Scanner(System.in);
                    String newName = name.nextLine();
                    items.editName(code, newName);
                    break;
                case 2:
                    System.out.println("Mời bạn nhập vào màu mới:");
                    Scanner color = new Scanner(System.in);
                    String newColor = color.nextLine();
                    items.editColor(code, newColor);
                    break;
                case 3:
                    System.out.println("Mời bạn nhập vào hãng mới:");
                    Scanner brand = new Scanner(System.in);
                    String newBrand = brand.nextLine();
                    items.editBrand(code, newBrand);
                    break;
                case 4:
                    System.out.println("Mời bạn nhập vào giá mới:");
                    Scanner price = new Scanner(System.in);
                    Double newPrice = price.nextDouble();
                    items.editPrice(code, newPrice);
                    break;
            }
        } else {
            System.err.println("Cú pháp không hợp lệ!!!!");
            System.out.println();
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
