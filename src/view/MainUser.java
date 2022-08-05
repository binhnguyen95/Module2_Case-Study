package view;

import controller.ItemsManager;
import controller.UserManager;
import model.Items;

import java.util.ArrayList;
import java.util.Scanner;

public class MainUser {
    static private final UserManager user = new UserManager();
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        ArrayList<Items> items = new ArrayList<>();
        while (true) {
            System.out.println("----------------Khách hàng-----------------");
            System.out.println("[Nhập 1] Hiển thị sản phẩm");
            System.out.println("[Nhập 2] Thêm sản phẩm vào giỏ");
            System.out.println("[Nhập 3] Hiển thị sản phẩm trong giỏ");
            System.out.println("[Nhập 4] Ví");
            System.out.println("[Nhập 0] THOÁT");
            System.out.println("--------------------------------------------");
            System.out.print("[Chọn]:\t");
            try {
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        user.display();
                        break;
                    case 2:
                        user.display();
                        System.out.println("\n[THÊM VÀO GIỎ]");
                        user.addProductsToCart(getIndex());
                        break;
                    case 3: {
                        user.showProductsInCart();
                        System.out.println("\n[NHẬP 1] XÓA SẢN PHẨM");
                        System.out.println("[NHẬP 2] THANH TOÁN SẢN PHẨM");
                        System.out.println("[NHẬP 0] THOÁT");
                        choice = Integer.parseInt(scan.nextLine());
                        switch (choice) {
                            case 1:
                                user.deleteProductInCart(getIndex());
                                break;
                            case 2:
                                payment();
                                break;
                            case 0:
                                return;
                        }
                    }
                    break;
                    case 4: {
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
            user.payment();
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
