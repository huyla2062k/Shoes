package com.laduchuy.shoes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.object.User;

public class ConfirmAddressActivity extends AppCompatActivity {

    EditText edName,edPhoneNumber,edAddress;
    Button btnConfirmBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_address);
        mapping();
        Intent intent = getIntent();
        Bundle bundle =intent.getBundleExtra("bund");
        User user= (User) bundle.getSerializable("user");
        edName.setText(user.getName());
        edPhoneNumber.setText(user.getPhoneNumber());
        edAddress.setText(user.getAddress());
        btnConfirmBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext() , "Bạn đã đặt hàng thành công" ,Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    private void mapping() {
        edName = findViewById(R.id.edName);
        edPhoneNumber = findViewById(R.id.edPhoneNumber);
        edAddress = findViewById(R.id.edAddress);
        btnConfirmBuy = findViewById(R.id.btnConfirmBuy);
    }
}