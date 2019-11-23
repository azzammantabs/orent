package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.MainActivity;
import com.example.orent.NavDrawerActivity;
import com.example.orent.R;

public class LoginActivity extends AppCompatActivity {
    TextView tv_register;
    Button btn_login;
    EditText et_username, et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inisialisasi
        tv_register = findViewById(R.id.tv_regist);
        btn_login = findViewById(R.id.btn_login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        //on click listener
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(i);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username,password;
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                if(!username.isEmpty() && !password.isEmpty()){
                    if(username.equals("orent") && password.equals("orent")){
                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "username dan password salah", Toast.LENGTH_SHORT).show();
                    }
                }else if (username.isEmpty()){
                    et_username.setError("username tidak boleh kosong");
                    et_username.requestFocus();
                }else if (password.isEmpty()){
                    et_password.setError("password tidak boleh kosong");
                    et_password.requestFocus();
                }else {
                    Toast.makeText(LoginActivity.this, "kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
