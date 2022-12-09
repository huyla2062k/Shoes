package com.laduchuy.shoes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.laduchuy.shoes.R;

public class nhantin extends AppCompatActivity {
TextView txtmutil ;
TextView txtcontent ;
Button btngui ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhantin);
        txtcontent = findViewById(R.id.txtcontent);
        txtmutil = findViewById(R.id.txtmutil);
        btngui = findViewById(R.id.btngui);
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtmutil.setText(txtmutil.getText()+"\n\n"+ txtcontent.getText());
            }
        });
    }
}