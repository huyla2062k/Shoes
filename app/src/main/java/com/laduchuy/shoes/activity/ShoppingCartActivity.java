package com.laduchuy.shoes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.Util;
import com.laduchuy.shoes.adapter.AdapterProductCart;
import com.laduchuy.shoes.object.ProductCart;
import com.laduchuy.shoes.object.User;

public class ShoppingCartActivity extends AppCompatActivity {
    ImageView imgBack;
    Button btnBuy;
    RecyclerView recyclerView;
    TextView tvPrice;
    AdapterProductCart adapterProductCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        mapping();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bund");
        User user = (User) bundle.getSerializable("user");
        int price = 0;
        for (ProductCart productCart: Util.productCart) {
          price+=productCart.getPrice();
        }
        tvPrice.setText("Thành tiền: "+price);
        imgBack.setOnClickListener(view -> finish());
        adapterProductCart = new AdapterProductCart(Util.productCart);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1,RecyclerView.VERTICAL,false);
        adapterProductCart.setOnProductItemClick(productCart -> {
            Util.productCart.remove(productCart);
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProductCart);
        btnBuy.setOnClickListener(view -> {
            Intent intent1 = new Intent(ShoppingCartActivity.this, ConfirmAddressActivity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable("user",user);
            intent1.putExtra("bund",bundle1);
            startActivity(intent1);
         });

    }

    private void mapping() {
        imgBack= findViewById(R.id.imgBack);
        btnBuy = findViewById(R.id.btnBuy);
        recyclerView = findViewById(R.id.recyclerviewCart);
        tvPrice = findViewById(R.id.tvPrice);
    }
}