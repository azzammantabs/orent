package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.helper.PrefsHelper;

public class PembayaranActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_bni, tv_mandiri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pembayaran);

        Toolbar toolbar = findViewById(R.id.tl_pembayaran);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Metode Pembayaran");
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
                Intent i = new Intent(this, PembayaranDetailActivity.class);
                PrefsHelper.sharedInstance(this).setNamaBank("Transfer Bank BNI");
                PrefsHelper.sharedInstance(this).setRekBank("878-78-12345678");
                PrefsHelper.sharedInstance(this).setLogoBank(R.drawable.bni);
                startActivity(i);
            }break;
            case R.id.tv_mandiri :{
                Intent i = new Intent(this, PembayaranDetailActivity.class);
                PrefsHelper.sharedInstance(this).setNamaBank("Transfer Bank Mandiri");
                PrefsHelper.sharedInstance(this).setRekBank("838-54-12345678");
                PrefsHelper.sharedInstance(this).setLogoBank(R.drawable.mandiri);
                startActivity(i);
            }
        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
//        return true;
//    }
}
