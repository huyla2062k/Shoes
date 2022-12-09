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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText edUserName,edPassword,edPassword2,edName,edPhonenumber,edAddress;
    Button btnSignUp;
    TextView tvLogin;

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final String PHONENUMBER_PATTERN =
            "^([0-9]).{10}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbHelper = new DBHelper(this);
        edUserName = findViewById(R.id.edUserName);
        edPassword = findViewById(R.id.edPassword);
        edPassword2 = findViewById(R.id.edPassword2);
        edName = findViewById(R.id.edName);
        edPhonenumber = findViewById(R.id.edPhonenumber);
        edAddress = findViewById(R.id.edAddress);
        btnSignUp = findViewById(R.id.btnSignup);
        tvLogin = findViewById(R.id.tvLogin);

        btnSignUp.setOnClickListener(view -> {
            String userName = edUserName.getText().toString();
            String password = edPassword.getText().toString();
            String password2 = edPassword2.getText().toString();
            String name = edName.getText().toString();
            String phoneNumber = edPhonenumber.getText().toString();
            String address = edAddress.getText().toString();
            if (checkUser(userName,dbHelper.getAllUser())){
                if (checkPassword(password)){
                    if(checkPasswor2(password,password2)){
                        //if(checkPhoneNumber(phoneNumber)) {
                            User user = new User(name, userName, phoneNumber, address, password, false);
                            dbHelper.insertUser(user);
                            Toast.makeText(getBaseContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                            startActivity(intent);
                       // }else Toast.makeText(getBaseContext(),"Số điện thoại không đúng",Toast.LENGTH_LONG).show();
                    }else Toast.makeText(getBaseContext(),"Xác nhận mật khẩu không chính xác",Toast.LENGTH_LONG).show();
                }else Toast.makeText(getBaseContext(),"Mật khẩu phải từ 8-20 ký tự bao gôm chữ hoa chữ thường, số và ký tự đặc biệt",Toast.LENGTH_LONG).show();
            }else Toast.makeText(getBaseContext(),"Tài khoản đã tồn tại",Toast.LENGTH_LONG).show();

        });

        tvLogin.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
            startActivity(intent);
           // finish();
        });


    }

    private boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONENUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private boolean checkPasswor2(String password, String password2) {
        return password.equals(password2);
    }



    private boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean checkUser(String userName, List<User> users1) {
        for (User user: users1) {
            if (userName.equals(user.getUserName())) return false;
        }
        return true;
    }
}