package com.laduchuy.shoes.object;

import android.net.Uri;

import java.io.Serializable;

public class Product implements Serializable {
    int productCode;
    String name,img,describe,color;
    int price,number,size;

    public Product(int productCode,String name, String img, String describe, String color, int size, int price, int number) {
        this.productCode=productCode;
        this.name = name;
        this.img = img;
        this.describe = describe;
        this.color = color;
        this.size = size;
        this.price = price;
        this.number = number;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
