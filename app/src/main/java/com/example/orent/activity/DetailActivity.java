package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_driver, btn_nodriver;
    ImageView img_produk;
    TextView tv_namadepan, tv_namabelakang;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobildetail);

        Toolbar toolbar = findViewById(R.id.tl_mobildetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi
        btn_driver = findViewById(R.id.btn_withdriver);
        btn_nodriver = findViewById(R.id.btn_nodriver);
        img_produk = findViewById(R.id.img_produk);
        tv_namadepan = findViewById(R.id.tv_namadepan);
        tv_namabelakang = findViewById(R.id.tv_namabelakang);


        //set on click
        btn_driver.setOnClickListener(this);
        btn_nodriver.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_withdriver :{
                Toast.makeText(this, "driver tidak tersedia", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.btn_nodriver :{
                Intent i = new Intent(this, RincianActivity.class);
                startActivity(i);
            }break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }
}
