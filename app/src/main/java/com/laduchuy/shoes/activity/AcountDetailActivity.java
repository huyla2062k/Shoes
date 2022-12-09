package com.laduchuy.shoes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.database.DBHelper;
import com.laduchuy.shoes.object.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcountDetailActivity extends AppCompatActivity {
    TextView tvUserName;
    EditText edName,edPhoneNumber,edAddress,edPass,edNewPass,edConfirmPass;
    Button btnUpdate;
    DBHelper dbHelper;
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount_detail);
        mapping();
        dbHelper = new DBHelper(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("detail");
        User user = (User) bundle.getSerializable("user");
        tvUserName.setText(user.getUserName());
        edName.setText(user.getName());
        edPhoneNumber.setText(user.getPhoneNumber().toString());
        edAddress.setText(user.getAddress());
        btnUpdate.setOnClickListener(view -> {
            if (!edPass.getText().toString().isEmpty()){
                if (user.getPassword().equals(edPass.getText().toString())){
                    if (checkNewPass(edNewPass.getText().toString())){
                        if (edNewPass.getText().toString().equals(edConfirmPass.getText().toString())){
                            User user1 = new User(edName.getText().toString(),tvUserName.getText().toString(),
                                    edPhoneNumber.getText().toString(),edAddress.getText().toString(),
                                    edPass.getText().toString(),false);
                            dbHelper.updateUser(String.valueOf(user.getId()),user1);
                            Toast.makeText(this,"Cập nhật thành công",Toast.LENGTH_LONG).show();
                            
                        }else Toast.makeText(this,"Xác nhận mật khẩu không khớp",Toast.LENGTH_LONG).show();
                    }else Toast.makeText(this,"Mật khẩu phải từ 8-20 ký tự bao gôm chữ hoa chữ thường, số và ký tự đặc biệt",Toast.LENGTH_LONG).show();
                }else Toast.makeText(getBaseContext(),"Mật khẩu không đúng",Toast.LENGTH_LONG).show();
            }
        });


    }

    private boolean checkNewPass(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private void mapping() {
        tvUserName = findViewById(R.id.tvUserName);
        edName = findViewById(R.id.edName);
        edPhoneNumber = findViewById(R.id.edPhoneNumber);
        edAddress = findViewById(R.id.edAddress);
        edPass = findViewById(R.id.edPassword);
        edNewPass = findViewById(R.id.edNewPass);
        edConfirmPass = findViewById(R.id.edConfirmPass);
        btnUpdate= findViewById(R.id.btnUpdate);
    }
}