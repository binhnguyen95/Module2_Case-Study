package controller.user;

public class User {
    private String id;
    private String name;
    private String email;
    private String address;
    private Wallet wallet;
    private Cart cart;

    public User() {
    }

    public User(String id, String name, String email, String address, Wallet wallet, Cart cart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.wallet = wallet;
        this.cart = cart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
