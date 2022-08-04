package controller;

import controller.user.User;
import model.Items;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    ReadWriteData readWriteData = ReadWriteFile.getInstance();
    List<Items> productList = readWriteData.readData("Items.a");
    User user;

    public User getUser() {
        return user;
    }
    // hàm khởi tạo

    public UserManager() {
        user = new User();
    }
    // hiển thí sản phẩm cửa hàng

    public void display() {
        for (Items i : productList) {
            System.out.println(i);
        }
    }
    // lựa chọn sản phẩm trong cửa hàng

    public Items selected(int index) {
        Items product = productList.get(index);
        return product;
    }
    // thêm sản phẩm vào giỏ hàng

    public void addProductsToCart(int index) {
        List<Items> cart = user.getCart().getList();
        cart.add(selected(index));
    }
    // hiển thị sản phẩm trong giỏ

    public void showProductsInCart() {
        List<Items> cart = user.getCart().getList();
        for (Items i : cart) {
            System.out.println(i);
        }
    }
    // xóa sản phẩm trong giỏ

    public void deleteProductInCart(int index) {
        List<Items> cart = user.getCart().getList();
        cart.remove(index);
    }
    //tổng tiền sản phẩm trong giỏ

    public double totalPrice() {
        double totalMoneyProduct = 0;
        List<Items> cart = user.getCart().getList();
        for (Items clothes : cart) {
            totalMoneyProduct += clothes.getPrice();
        }
        return totalMoneyProduct;
    }

    // thanh toán sản phẩm
    public double payment() {
        double moneyInWallet = user.getWallet().getMoney();
        double payment = moneyInWallet - totalPrice();
        user.getWallet().setMoney(payment);
        return user.getWallet().getMoney();
    }

    // nap tiền vào ví
    public void addMoney(double money) {
        double wallet = user.getWallet().addMoney(money);
    }

}
