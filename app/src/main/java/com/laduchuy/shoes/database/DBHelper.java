package com.laduchuy.shoes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.laduchuy.shoes.object.Product;
import com.laduchuy.shoes.object.User;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLHelper";
    static  final String DB_NAME="OrderFood.db";
    static final String DB_TABLE="User";
    static final String DB_PRODUCT_TABLE="Product";
    static final int DB_VERSION = 1;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateTable = "CREATE TABLE User("+
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                "username Text,"+
                "password Text,"+
                "name Text,"+
                "address Text,"+
                "phonenumber Text,"+
                "admin INTEGER NOT NULL)";
        String queryCreateTableProduct = "CREATE TABLE Product("+
                "productcode INTEGER NOT NULL PRIMARY KEY,"+
                "name Text,"+
                "img Text,"+
                "describe Text,"+
                "color Text,"+
                "size INTEGER,"+
                "price INTEGER," +
                "number INTEGER)";
        String queryCreateTableDonhang = "CREATE TABLE Donhang("+
                "Madon INTEGER NOT NULL PRIMARY KEY,"+
                "Ngaytao Text,"+
                "thanhtien INTEGER,"+
                "trangthai Text,"+
                "tenKH Text,"+
                "diachi INTEGER,"+
                "idtaikhoan INTEGER)";
        sqLiteDatabase.execSQL(queryCreateTable);
        sqLiteDatabase.execSQL(queryCreateTableProduct);
        sqLiteDatabase.execSQL(queryCreateTableDonhang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i!=i){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
            onCreate(sqLiteDatabase);
        }
    }

    public  void insertUser(User user){
        sqLiteDatabase=getWritableDatabase();
        contentValues=new ContentValues();

        contentValues.put("username" , user.getUserName());
        contentValues.put("password",user.getPassword());
        contentValues.put("name",user.getName());
        contentValues.put("address",user.getAddress());
        contentValues.put("phonenumber",user.getPhoneNumber());
        contentValues.put("admin",user.isAdmin());

        sqLiteDatabase.insert(DB_TABLE,null,contentValues);
    }
    public  void insertProduct(Product product){
        sqLiteDatabase=getWritableDatabase();
        contentValues=new ContentValues();

        contentValues.put("productcode" , product.getProductCode());
        contentValues.put("name",product.getName());
        contentValues.put("img",product.getImg());
        contentValues.put("describe",product.getDescribe());
        contentValues.put("color",product.getColor());
        contentValues.put("size",product.getSize());
        contentValues.put("price",product.getPrice());
        contentValues.put("number",product.getNumber());

        sqLiteDatabase.insert(DB_PRODUCT_TABLE,null,contentValues);
    }

    public  void insertDonhang(Product product){
        sqLiteDatabase=getWritableDatabase();
        contentValues=new ContentValues();

        contentValues.put("productcode" , product.getProductCode());
        contentValues.put("name",product.getName());
        contentValues.put("img",product.getImg());
        contentValues.put("describe",product.getDescribe());
        contentValues.put("color",product.getColor());
        contentValues.put("size",product.getSize());
        contentValues.put("price",product.getPrice());
        contentValues.put("number",product.getNumber());

        sqLiteDatabase.insert(DB_PRODUCT_TABLE,null,contentValues);
    }
    public  void updateUser(String id,User user){
        sqLiteDatabase=getWritableDatabase();
        contentValues=new ContentValues();

        contentValues.put("username" , user.getUserName());
        contentValues.put("password",user.getPassword());
        contentValues.put("name",user.getName());
        contentValues.put("address",user.getAddress());
        contentValues.put("phonenumber",user.getPhoneNumber());
        contentValues.put("admin",user.isAdmin());

        sqLiteDatabase.update(DB_TABLE,contentValues,"id=?",
                new String[]{String.valueOf(id)});

    }

    public List<User> getAllUser(){
        List<User> users= new ArrayList<>();
        User user;
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor= sqLiteDatabase.query(false,DB_TABLE,
                null,null,null,null,
                null,null,null);


        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String phonenumber = cursor.getString(cursor.getColumnIndex("phonenumber"));
            boolean admin=false;
            if (cursor.getInt(cursor.getColumnIndex("admin"))==1){
                admin=true;
            }
            user = new User(id,name,username,phonenumber,address,password,admin);

            users.add(user);
        }
        return users;
    }
    public List<Product> getAllProduct(){
        List<Product> products= new ArrayList<>();
        Product product;
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor= sqLiteDatabase.query(false,DB_PRODUCT_TABLE,null,null,null,
                                null, null,null,null);
        while (cursor.moveToNext()){
            int productCode = cursor.getInt(cursor.getColumnIndex("productcode"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String img = cursor.getString(cursor.getColumnIndex("img"));
            String describe = cursor.getString(cursor.getColumnIndex("describe"));
            String color = cursor.getString(cursor.getColumnIndex("address"));
            int size = cursor.getInt(cursor.getColumnIndex("size"));
            int price = cursor.getInt(cursor.getColumnIndex("price"));
            int number = cursor.getInt(cursor.getColumnIndex("number"));

            product = new Product(productCode,name,img,describe,color,size,price,number);

            products.add(product);
        }
        return products;
    }
}
