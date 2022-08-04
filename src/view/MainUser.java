package view;

import controller.UserManager;
import java.util.Scanner;

public class MainUser {
    static private final UserManager user = new UserManager();
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
//        UserManager user = new UserManager();
        user.display();

        while (true) {
            System.out.println("----------------Khách hàng-----------------");
            System.out.println("[Nhập 1] Hiển thị sản phẩm");
            System.out.println("[Nhập 2] Hiển thị sản phẩm giá thấp lên cao");
            System.out.println("[Nhập 3] Hiển thị sản giá cao xuống thấp");
            System.out.println("[Nhập 4] Hiển thị theo sản phẩm mới nhất trước");
            System.out.println("[Nhập 5] Hiển thị sản phẩm trong giỏ");
            System.out.println("[Nhập 6] Ví");
            System.out.println("[Nhập 0] THOÁT");
            System.out.println("--------------------------------------------");
            System.out.print("[Chọn]:\t");
            try {
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        user.display();
                        System.out.println("\n[THÊM VÀO GIỎ]");
                        user.addProductsToCart(getIndex());
                        break;
                    case 2:
                        user.sortLowestFirst();
                        break;
                    case 3:
                        user.sortHighestFirst();
                        break;
                    case 4:
                        user.sortByDate();
                        break;
                    case 5: {
                        user.showProductsInCart();
                        System.out.println("\n[NHẬP 1] XÓA SẢN PHẨM");
                        System.out.println("[NHẬP 2] THANH TOÁN SẢN PHẨM");
                        choice = Integer.parseInt(scan.nextLine());
                        switch (choice) {
                            case 1:
                                user.deleteProductInCart(getIndex());
                                break;
                            case 2:
                                payment();
                                break;
                        }
                    }
                    break;
                    case 6: {
                        double wallet = user.getUser().getWallet().getMoney();
                        System.out.println("Số dư trong ví:" + wallet);
                        System.out.println("\n[Nạp tiền]");
                        double money = Integer.parseInt(scan.nextLine());
                        user.addMoney(money);

                    }
                    break;
                    case 0:
                        return;
                    default:
                        System.out.println();
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi cú pháp !!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int getIndex() {
        System.out.print("Nhập vị trí sản phẩm:");
        return Integer.parseInt(scan.nextLine());
    }

    private static void payment() {
        double checkMoney = user.getUser().getWallet().getMoney();
        double totalMoneyProduct = user.totalPrice();
        if (checkMoney >= totalMoneyProduct) {
            user.check();
            System.out.println("\nThanh toán thành công. \t Cảm ơn quý khách\n");
        } else {
            System.err.println("Nạp tiền vào ví!!!");
            System.out.print("\nNhập số tiền:");
            double money = Integer.parseInt(scan.nextLine());
            user.getUser().getWallet().addMoney(money);
            payment();
        }
    }
}
