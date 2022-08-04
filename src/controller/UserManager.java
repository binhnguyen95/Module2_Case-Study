package controller;

import controller.user.User;
import model.Items;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.List;

public class UserManager {
    List<Items> items;
    private ReadWriteData readWriteData = ReadWriteFile.getInstance();
    List<Items> itemsList = (List<Items>) readWriteData.readData("Items.a");
    User user;

    public User getUser() {
        return user;
    }

    public UserManager() {
        this.user = user;
    }

    //hiển thị sản phẩm
    public void display() {
        int count=1;
        try{
            List<Items> displayFile = readWriteData.readData("Items.a");
            for (Items i: displayFile
            ) {
                System.out.println(count +". "+ i);
                count++;
            }
        } catch (Exception e) {
            System.err.println("Gian hàng trống!!!!");
            e.getMessage();
        }
    }

    // lựa chọn sản phẩm trong cửa hàng
    public Items selected(int index) {
        Items items = itemsList.get(index);
        return items;
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
    public double totalMoneyProduct() {
        double totalMoneyProduct = 0;
        List<Items> cart = user.getCart().getList();
        for (Items i : cart) {
            totalMoneyProduct += i.getPrice();
        }
        return totalMoneyProduct;
    }

    // thanh toán sản phẩm
    public double payment() {
        double moneyInWallet = user.getWallet().getMoney();
        double payment = moneyInWallet - totalMoneyProduct();
        user.getWallet().setMoney(payment);
        return user.getWallet().getMoney();
    }

    // nap tiền vào ví
    public void addMoney(double money) {
        double wallet = user.getWallet().addMoney(money);
    }

}
