package com.laduchuy.shoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.laduchuy.shoes.object.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";

    NavigationView navigationView;
    ImageView imgMenu,imgCart,imgSearch;
    EditText edSearch;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    List<Product> productList;

    //@SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMenu =findViewById(R.id.imgMenu);
        imgCart = findViewById(R.id.imgCart);
        imgSearch = findViewById(R.id.imgSearch);
        edSearch = findViewById(R.id.edSearch);
        recyclerView = findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer);
//        navigationView.setNavigationItemSelectedListener(menuItem -> {
//
//        });
        imgMenu.setOnClickListener(view -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });


    }


}