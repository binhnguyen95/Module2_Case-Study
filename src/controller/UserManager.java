package controller;

import controller.user.User;
import model.Items;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.ArrayList;
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
        List<Items> cart = readWriteData.writeData(itemsList, "Cart.a");
        cart.add(selected(index));
    }

    // hiển thị sản phẩm trong giỏ
    public void showProductsInCart() {
        int count=1;
        try{
            List<Items> displayFile = readWriteData.readData("Cart.a");
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

    public void sortHighestFirst() {
        itemsList.sort(((o1, o2) -> {
            if (o1.getPrice() < o2.getPrice())
                return 1;
            if (o1.getPrice() > o2.getPrice())
                return -1;
            else return 0;
        }));
        display();
    }

    public void sortLowestFirst() {
        itemsList.sort(((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice())
                return 1;
            if (o1.getPrice() < o2.getPrice())
                return -1;
            else return 0;
        }));
        display();
    }

    public void sortByDate() {
        itemsList.sort(((o1, o2) -> {
            if (o1.getReleaseDate().isBefore(o2.getReleaseDate()))
                return 1;
            if (o1.getReleaseDate().isAfter(o2.getReleaseDate()))
                return -1;
            else return 0;
        }));
        display();
    }

    // xóa sản phẩm trong giỏ
    public void deleteProductInCart(int index) {
        if (itemsList.size() > 0) {
            for (int i = 0; i < itemsList.size(); i++) {
                if (i == (index - 1)) {
                    itemsList.remove(i);
                    writeFileCart();
                }
            }
        } else if (index >= itemsList.size()) {
            System.err.println("Vị trí không tồn tại");
        } else
            System.err.println("Danh sách rỗng !!!");
        readWriteData.writeData(itemsList, "Items.a");
    }

    //tổng tiền sản phẩm trong giỏ
    public double totalPrice() {
        double totalPrice = 0;
        List<Items> cart = user.getCart().getList();
        for (Items i : cart) {
            totalPrice += i.getPrice();
        }
        return totalPrice;
    }

    // thanh toán sản phẩm
    public void check() {
        double moneyInWallet = user.getWallet().getMoney();
        double payment = moneyInWallet - totalPrice();
        user.getWallet().setMoney(payment);
    }

    // nap tiền vào ví
    public void addMoney(double money) {
        double wallet = user.getWallet().addMoney(money);
    }

    public void writeFileCart() {
        readWriteData.writeData(itemsList, "Cart.a");
    }

    public void readFileCart() {
        itemsList = readWriteData.readData("Cart.a");
    }

}
