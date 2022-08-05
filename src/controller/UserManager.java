package controller;

import controller.user.User;
import model.Items;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    ReadWriteData readWriteData = ReadWriteFile.getInstance();
    ArrayList<Items> itemsList = readWriteData.readData("Items.a");
    ArrayList<Items> cartList = readWriteData.readData("Cart.a");
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
        int count = 1;
        try{
            ArrayList<Items> displayFile = readWriteData.readData("Items.a");
            for (Items i: displayFile
            ) {
                System.out.println(count +". "+ i);
                count++;
            }
        } catch (Exception e) {
            System.err.println("Gian hàng trống!!!!");
        }
    }

    public void displayHighestFirst() {
        itemsList.sort(((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice())));
        readWriteData.writeData(itemsList, "Items.a");
        display();
    }

    public void displayLowestFirst() {
        itemsList.sort((Comparator.comparingDouble(Items::getPrice)));
        readWriteData.writeData(itemsList, "Items.a");
        display();
    }

    // lựa chọn sản phẩm trong cửa hàng
    public Items selected(int index) {
        Items product = itemsList.get(index);
        return product;
    }

    // thêm sản phẩm vào giỏ hàng
    public void addProductsToCart(int index) {
        itemsList.add(selected(index));
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
        }
    }

    // xóa sản phẩm trong giỏ
    public void deleteProductInCart(int index) {
        if (cartList.size() > 0) {
            for (int i = 0; i < cartList.size(); i++) {
                if (i == (index - 1)) {
                    cartList.remove(i);
                    readWriteData.writeData(cartList, "Cart.a");
                }
            }
        } else if (index >= cartList.size()) {
            System.err.println("Vị trí không tồn tại");
        } else
            System.err.println("Danh sách rỗng !!!");
        readWriteData.writeData(cartList, "Cart.a");
    }

    //tổng tiền sản phẩm trong giỏ
    public double totalPrice() {
        double totalMoneyProduct = 0;
        List<Items> cart = cartList;
        for (Items i : cart) {
            totalMoneyProduct += i.getPrice();
        }
        return totalMoneyProduct;
    }

}
