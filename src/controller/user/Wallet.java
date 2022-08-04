package controller.user;

public class Wallet {
    private double money = 0;

    public Wallet(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double addMoney(double money) {
        this.money += money;
        return this.money;
    }
}
