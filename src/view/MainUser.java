package view;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
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
                        System.out.print("[Chọn]:\t");
                        user.addProductsToCart(getIndex());
                        break;
                    case 3: {
                        user.showProductsInCart();
                        System.out.println("\n[NHẬP 1] XÓA SẢN PHẨM");
                        System.out.println("[NHẬP 2] TỔNG TIỀN SẢN PHẨM");
                        System.out.println("[NHẬP 0] THOÁT");
                        System.out.print("[Chọn]:\t");
                        choice = Integer.parseInt(scan.nextLine());
                        switch (choice) {
                            case 1:
                                user.deleteProductInCart(getIndex());
                                break;
                            case 2:
                                System.out.println("Tổng tiền của sản phẩm là");
                                System.out.println(user.totalPrice());
                                break;
                            case 0:
                                break;
                        }
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

}
