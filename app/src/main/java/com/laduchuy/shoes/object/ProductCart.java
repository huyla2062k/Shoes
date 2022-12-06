package com.laduchuy.shoes.object;

public class ProductCart extends Product {
    int userID;

    public ProductCart(int productCode, String name, String img, String describe, String color, int size, int price, int number, int userID) {
        super(productCode, name, img, describe, color, size, price, number);
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
