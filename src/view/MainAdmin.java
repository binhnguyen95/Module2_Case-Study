package view;

import controller.ItemsManager;
import model.Items;
import model.accessories.Belt;
import model.accessories.Scarf;
import model.accessories.Spectacles;
import model.bottom.Pant;
import model.top.Jacket;
import model.top.Shirt;
import validate.Validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
//import java.util.List;
import java.util.Scanner;

public class MainAdmin {
    public static Scanner scan = new Scanner(System.in);
    private static final Validate validate = new Validate();

    public static void main(String[] args) {
        ItemsManager itemsManager = new ItemsManager();
        Shirt shirt1 = new Shirt("SH05", "ao 1", "den", "bub", 50.5, LocalDate.now().minusMonths(3));
        Pant pant1 = new Pant("PA01", "quan 1", "trang", "lacoste", 214.99, LocalDate.now().minusMonths(13));
        Belt belt1 = new Belt("BE11", "that lung 1", "nau", "", 14.99, "crocodile", LocalDate.now().minusMonths(6));
        Jacket jacket = new Jacket("JA21", "ao khoac", "vang", "", 29.99, "chinos", LocalDate.now().minusMonths(10));
        itemsManager.add(shirt1);
        itemsManager.add(pant1);
        itemsManager.add(belt1);
        itemsManager.add(jacket);

        while(true) {
            System.out.println("\n-------------CỬA HÀNG THỜI TRANG-------------");
            System.out.println("Nhập 1: Hiển thị danh sách hiện có");
            System.out.println("Nhập 2: Thêm sản phẩm");
            System.out.println("Nhập 3: Sửa sản phẩm");
            System.out.println("Nhập 4: Xóa sản phẩm");
            System.out.println("Nhập 5: Sắp xếp theo giá từ thấp lên cao");
            System.out.println("Nhập 6: Sắp xếp theo giá từ cao xuống thấp");
            System.out.println("Nhập 7: Tìm kiếm sản phẩm theo tên");
            System.out.println("Nhập 8: Hàng mới về");
            System.out.println("Nhập 9: >>> [SALE] <<<");
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
                        itemsManager.display();
                        editItem(itemsManager);
                        break;
                    case 4:
                        itemsManager.display();
                        removeItems(itemsManager);
                        break;
                    case 5:
                        itemsManager.sortLowestFirst();
                        break;
                    case 6:
                        itemsManager.sortHighestFirst();
                        break;
                    case 0:
                        System.err.println("BIE BIE");
                        return;
                    default:
                        System.err.println("Yêu cầu nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("YÊU CẦU NHẬP LỰA CHỌN BẰNG SỐ!!!!");
            }
        }

    }


    private static void editItem(ItemsManager items){
        System.out.println("Nhập mã sản phẩm muốn sửa:");
        String code = scan.nextLine();
        if (validate.validateCode(code)) {
            String type = code.substring(0, 2);
            items.add(editInfomation(type, code, items));
        } else {
            System.err.println("Cú pháp không hợp lệ!!!!");
            System.out.println();
        }
    }

    private static Items editInfomation(String type, String code, ItemsManager items) {
        switch (type) {
            case "SH":
            case "PA":
                try {
                    System.out.println("Nhập 1: Sửa tên");
                    System.out.println("Nhập 2: Sửa màu");
                    System.out.println("Nhập 3: Sửa hãng");
                    System.out.println("Nhập 4: Sũa giá");
                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();
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
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    editInfomation(type, code, items);
                }
                break;
            case "JA":
                try {
                    System.out.println("Nhập 1: Sửa tên");
                    System.out.println("Nhập 2: Sửa màu");
                    System.out.println("Nhập 3: Sửa hãng");
                    System.out.println("Nhập 4: Sũa giá");
                    System.out.println("Nhập 5: Sũa loại vải");
                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();
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
                        case 5:
                            System.out.println("Mời bạn nhập vào loại vải mới:");
                            Scanner fabric = new Scanner(System.in);
                            String newFabric = fabric.nextLine();
                            items.editJacketFabric(code, newFabric);
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    editInfomation(type, code, items);
                }
                break;
            case "BE":
                try {
                    System.out.println("Nhập 1: Sửa tên");
                    System.out.println("Nhập 2: Sửa màu");
                    System.out.println("Nhập 3: Sửa hãng");
                    System.out.println("Nhập 4: Sũa giá");
                    System.out.println("Nhập 5: Sũa loại da");
                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();
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
                        case 5:
                            System.out.println("Mời bạn nhập vào loại da mới:");
                            Scanner leather = new Scanner(System.in);
                            String newLeather = leather.nextLine();
                            items.editLeather(code, newLeather);
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    editInfomation(type, code, items);
                }
                break;
            default:
                System.out.println("Sản phẩm không tồn tại!!");
                break;
                }
            return null;
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
            case "JA":
                System.out.println("Nhập chất liệu áo khoác:");
                String jacketFabric = scan.nextLine();
                return new Jacket(code, name, color, brand, price, jacketFabric, releaseDate);
            case "BE":
                System.out.println("Nhập chất liệu da thắt lưng:");
                String leather = scan.nextLine();
                return new Jacket(code, name, color, brand, price, leather, releaseDate);
            case "PA":
                return new Pant(code, name, color, brand, price, releaseDate);
            case "SP":
                System.out.print("Nhập dáng kính:");
                String shape = scan.nextLine();
                return new Spectacles(code, name, color, brand, price, shape, releaseDate);
            case "SC":
                System.out.print("Nhập kiểu dáng khăn:");
                String design = scan.nextLine();
                System.out.print("Nhập chất liệu khăn:");
                String scarfFabric = scan.nextLine();
                return new Scarf(code, name, color, brand, price, design, scarfFabric, releaseDate);
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
