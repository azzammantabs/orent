package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.orent.R;

public class RegistActivity extends AppCompatActivity {
    TextView tv_login;
    Button btn_daftar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        //inisialisasi
        tv_login = findViewById(R.id.tv_login);
        btn_daftar = findViewById(R.id.btn_daftar);

        //on click listener
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
