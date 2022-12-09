package com.laduchuy.shoes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.Util;
import com.laduchuy.shoes.object.Product;
import com.laduchuy.shoes.object.ProductCart;
import com.laduchuy.shoes.object.User;

public class ProductDetailActivity extends AppCompatActivity {
    TextView tvName, tvStatus, tvDes, tvPrice, tvAdd, tvMinus, tvNumber;
    Spinner spinnerSize, spinnerColor;
    ImageView imgAva, imgBack;
    Button btnAddCart;
    TextView txtGia;
    int dem = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        mapping();
        ArrayAdapter<CharSequence> adapterSize = ArrayAdapter.createFromResource(this, R.array.size_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this, R.array.color_array, android.R.layout.simple_spinner_item);
        spinnerSize.setAdapter(adapterSize);
        spinnerColor.setAdapter(adapterColor);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("product");
        Product product = (Product) bundle.getSerializable("detail");
        User user = (User) bundle.getSerializable("user");
        tvAdd.setOnClickListener(view -> {
            dem++;
            tvNumber.setText(dem + "");
            tvPrice.setText(("đ " + dem * product.getPrice()) + "");
        });
        tvMinus.setOnClickListener(view -> {
            dem--;
            if (dem < 0) dem = 1;
            tvNumber.setText(dem + "");
            tvPrice.setText(("đ " + dem * product.getPrice()) + "");
        });
        txtGia.setText(String.valueOf(product.getPrice()));
        tvName.setText(product.getName());
        tvDes.setText("Mô tả: " + product.getDescribe());
        imgAva.setImageResource(Integer.parseInt(product.getImg()));
        tvPrice.setText("Giá: " + Integer.parseInt(tvNumber.getText().toString()) * product.getPrice());
        imgBack.setOnClickListener(view -> finish());
        Product productCheck;

        btnAddCart.setOnClickListener(view -> {
            for (Product product1 : Util.products) {
                if (product1.getName().equals(tvName.getText())) {
                    if (product1.getColor().equals(spinnerColor.getSelectedItem().toString())) {
                        if (product1.getSize() == Integer.parseInt(spinnerSize.getSelectedItem().toString())) {
                            if (product1.getNumber() > Integer.parseInt(tvNumber.getText().toString())) {
                                Util.productCart.add(new ProductCart(product.getProductCode(),
                                        product.getName(), product.getImg(), product.getDescribe(), spinnerColor.getSelectedItem().toString(),
                                        Integer.parseInt(spinnerSize.getSelectedItem().toString()), Integer.parseInt(tvNumber.getText().toString()) * product.getPrice(),
                                        Integer.parseInt(tvNumber.getText().toString()), user.getId()));
                                Toast.makeText(getBaseContext(), "Đã thêm vào giỏ hàng", Toast.LENGTH_LONG).show();
                                //Toast.makeText(getBaseContext(),Util.productCart.size()+"",Toast.LENGTH_LONG).show();
                            } //else Toast.makeText(this,"Sô lượng hàng hiện không đủ xin hãy chọn lại",Toast.LENGTH_LONG).show();
                        }//else Toast.makeText(this,"Size hiện tại đã hết xin hãy chọn lại",Toast.LENGTH_LONG).show();
                    }//else Toast.makeText(this,"Màu sắc này hiện tại đã hết xin hãy chọn lạ",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void mapping() {
        txtGia = findViewById(R.id.txtGia);
        tvName = findViewById(R.id.tvName);
        tvStatus = findViewById(R.id.tvStatus);
        tvDes = findViewById(R.id.tvDes);
        tvPrice = findViewById(R.id.tvPrice);
        tvAdd = findViewById(R.id.tvAdd);
        tvMinus = findViewById(R.id.tvMinus);
        tvNumber = findViewById(R.id.tvNumber);
        spinnerSize = findViewById(R.id.sprinnerSize);
        spinnerColor = findViewById(R.id.sprinnerColor);
        imgAva = findViewById(R.id.imgAva);
        imgBack = findViewById(R.id.imgBack);
        btnAddCart = findViewById(R.id.btnAddCart);
    }
}