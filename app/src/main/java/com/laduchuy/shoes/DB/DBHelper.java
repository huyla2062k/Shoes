package com.laduchuy.shoes.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.laduchuy.shoes.object.User;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLHelper";
    static  final String DB_NAME="OrderFood.db";
    static final String DB_TABLE="User";
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
        sqLiteDatabase.execSQL(queryCreateTable);
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
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String phonenumber = cursor.getString(cursor.getColumnIndex("phonenumber"));
            boolean admin=false;
            if (cursor.getInt(cursor.getColumnIndex("admin"))==1){
                admin=true;
            }
            user = new User(name,username,phonenumber,address,password,admin);

            users.add(user);
        }
        return users;
    }
}
