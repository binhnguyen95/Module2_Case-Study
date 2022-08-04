package controller;

import controller.user.User;
import model.Items;

import java.util.List;

public class UserManager {
    List<Items> itemsList;

    User user;

    public User getUser() {
        return user;
    }

    public UserManager() {
        this.user = user;
    }
}
