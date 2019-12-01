package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orent.R;
import com.example.orent.helper.PrefsHelper;

public class RincianActivity extends AppCompatActivity {

    Button btn_paynodriver;
    ImageView img_rproduk;
    TextView tv_ndp, tv_nbp, tv_ndpay, tv_nbpay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayarandriver);

        Toolbar toolbar = findViewById(R.id.tl_mobilpembayaran);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Rincian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi
        btn_paynodriver = findViewById(R.id.btn_paynodriver);
        img_rproduk = findViewById(R.id.img_produkpay);
        tv_ndpay = findViewById(R.id.tv_namadpay);
        tv_nbpay = findViewById(R.id.tv_namabpay);
        tv_ndp = findViewById(R.id.tv_ndp);
        tv_nbp = findViewById(R.id.tv_nbp);

        //set item
        String nd = PrefsHelper.sharedInstance(this).getNamaDepan();
        String nb = PrefsHelper.sharedInstance(this).getNamaBelakang();
        int img = PrefsHelper.sharedInstance(this).getImage();
        img_rproduk.setImageResource(img);
        tv_ndpay.setText(nd);
        tv_nbpay.setText(nb);
        tv_ndp.setText(nd);
        tv_nbp.setText(nb);

        //on click
        btn_paynodriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RincianActivity.this, PembayaranActivity.class);
                startActivity(i);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
//        return true;
//    }
}
