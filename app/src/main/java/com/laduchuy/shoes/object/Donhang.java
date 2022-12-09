package com.laduchuy.shoes.object;

public class Donhang {
    private String price ;
    private String soluong ;
    private String Name ;
    private Integer madon ;
    private String Ngaytao ;
    private Integer thanhtien ;
    private String trangthai ;
    private String tenkh ;
    private String diachi ;
    private String idtaikhoan ;
    private int img ;

    public Donhang(String price, String soluong, String name, Integer madon, String ngaytao, Integer thanhtien, String trangthai, String tenkh, String diachi, String idtaikhoan, int img) {
        this.price = price;
        this.soluong = soluong;
        Name = name;
        this.madon = madon;
        Ngaytao = ngaytao;
        this.thanhtien = thanhtien;
        this.trangthai = trangthai;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.idtaikhoan = idtaikhoan;
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Integer getMadon() {
        return madon;
    }

    public void setMadon(Integer madon) {
        this.madon = madon;
    }

    public String getNgaytao() {
        return Ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        Ngaytao = ngaytao;
    }

    public Integer getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Integer thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(String idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }
}
