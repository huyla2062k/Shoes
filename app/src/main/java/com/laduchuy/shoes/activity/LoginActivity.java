package com.laduchuy.shoes.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.laduchuy.shoes.R;
import com.laduchuy.shoes.database.DBHelper;

import com.laduchuy.shoes.object.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText edUsername,edPassword;
    Button btnLogin;
    List<User> userList;
    TextView tvForgot,tvSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgot = findViewById(R.id.tvForgot);
        tvSignUp = findViewById(R.id.tvSignup);

        dbHelper = new DBHelper(this);

       // dbHelper.insertUser(new User("Lã Đức Huy","lahuy2062k","0836870764","Nam Từ Liêm, Hà Nội","Huy2062k@",true));
//
        if (dbHelper.getAllUser().isEmpty()){
            dbHelper.insertUser(new User("Lã Đức Huy","lahuy2062k123","0836870764","Nam Từ Liêm, Hà Nội","Huy2062k@",false));
        }
        userList = dbHelper.getAllUser();
        btnLogin.setOnClickListener(view -> {
            String username =edUsername.getText().toString();
            String password =edPassword.getText().toString();
            int check1=0;
            int check=0;

            for (User user:userList) {
                if (username.equals(user.getUserName())){
                    if(password.equals(user.getPassword())){
                        if(user.isAdmin()) {
                            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            intent.putExtra("login", bundle);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            intent.putExtra("login", bundle);
                            startActivity(intent);
                        }
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("user", user);
//                        intent.putExtra("login", bundle);
//                        startActivity(intent);
                    }

                }
                else check1++;
            }
            //if (check1!=0) Toast.makeText(this,"Tên đăng nhập không đúng",Toast.LENGTH_LONG).show();
            //if (check!=0) Toast.makeText(this,"Mật khẩu không đúng",Toast.LENGTH_LONG).show();
        });
        tvSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });


    }
}