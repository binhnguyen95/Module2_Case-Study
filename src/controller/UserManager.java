package controller;

import controller.user.User;
import model.Items;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    List<ArrayList<Items>> itemsList;
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
        int count=1;
        try{
            ArrayList<Items> displayFile = readWriteData.readData("Items.a");
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
        Items product = productList.get(index);
        return product;
    }

    // thêm sản phẩm vào giỏ hàng
    public void addProductsToCart(ArrayList<Items> items) {
        itemsList.add(items);
        readWriteData.writeData(itemsList, "Cart.a");
    }

    // hiển thị sản phẩm trong giỏ
    public void showProductsInCart() {
        int count=1;
        try{
            ArrayList<Items> displayFile = readWriteData.readData("Cart.a");
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
