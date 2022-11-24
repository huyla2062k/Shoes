package com.laduchuy.shoes.object;

import java.io.Serializable;

public class User implements Serializable {
    int id;
    String name,userName,phoneNumber,address,password;
    boolean admin;

    public User(String name, String userName, String phoneNumber, String address, String password, boolean admin) {
        this.name = name;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.admin = admin;
    }

    public User(int id, String name, String userName, String phoneNumber, String address, String password, boolean admin) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
