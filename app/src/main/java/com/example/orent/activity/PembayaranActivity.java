package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;

public class PembayaranActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_bni, tv_mandiri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pembayaran);

        Toolbar toolbar = findViewById(R.id.tl_pembayaran);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi
        tv_bni = findViewById(R.id.tv_bni);
        tv_mandiri = findViewById(R.id.tv_mandiri);

        //set on click
        tv_bni.setOnClickListener(this);
        tv_mandiri.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_bni :{
                Toast.makeText(this, "belum tersedia", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.tv_mandiri :{
                Intent i = new Intent(this, PembayaranDetailActivity.class);
                startActivity(i);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }
}
