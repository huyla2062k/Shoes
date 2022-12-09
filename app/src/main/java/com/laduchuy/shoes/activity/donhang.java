package com.laduchuy.shoes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.adapter.AdapterDonhang;
import com.laduchuy.shoes.object.Donhang;
import com.laduchuy.shoes.object.Product;

import java.util.ArrayList;

public class donhang extends AppCompatActivity {
    ArrayList<Donhang> arrayList;
    AdapterDonhang adapterDonhang;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donhang);
        arrayList = new ArrayList<>();
        arrayList.add(new Donhang("320000", "1", "Giày Sneakers Unisex DOMBA High Point", 001, "9/12/2022", 230000, "đang giao", "Mai toàn", "Hà nội", "675", R.drawable.pro4));
        adapterDonhang = new AdapterDonhang(this, R.layout.item_donhang, arrayList);
        listView = findViewById(R.id.listdonhang);
        listView.setAdapter(adapterDonhang);
    }
}