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
import com.example.orent.helper.PrefsHelper;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_driver, btn_nodriver, btn_pinjam;
    ImageView img_produk;
    TextView tv_namadepan, tv_namabelakang, tv_merk, tv_jenis;
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
        btn_pinjam = findViewById(R.id.btn_pinjam);
        img_produk = findViewById(R.id.img_produk);
        tv_namadepan = findViewById(R.id.tv_namadepan);
        tv_namabelakang = findViewById(R.id.tv_namabelakang);
        tv_merk = findViewById(R.id.tv_namamerk);
        tv_jenis = findViewById(R.id.tv_namajenis);

        //set item
        String nd = PrefsHelper.sharedInstance(this).getNamaDepan();
        String nb = PrefsHelper.sharedInstance(this).getNamaBelakang();
        int img = PrefsHelper.sharedInstance(this).getImage();
        boolean sk = PrefsHelper.sharedInstance(this).getStatusK();

        if (sk == false) {
            btn_driver.setVisibility(View.GONE);
            btn_nodriver.setVisibility(View.GONE);
            btn_pinjam.setVisibility(View.VISIBLE);
        }
        tv_namadepan.setText(nd);
        tv_namabelakang.setText(nb);
        tv_merk.setText(nd);
        tv_jenis.setText(nb);
        img_produk.setImageResource(img);

        //set on click
        btn_driver.setOnClickListener(this);
        btn_nodriver.setOnClickListener(this);
        btn_pinjam.setOnClickListener(this);

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
            case R.id.btn_pinjam :{
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
