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

public class PembayaranDetailActivity extends AppCompatActivity {

    Button btn_bayar;
    TextView tv_namabank;
    ImageView img_logo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pembayarandetail);

        Toolbar toolbar = findViewById(R.id.tl_pembayarandetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail Pembayaran");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi
        btn_bayar = findViewById(R.id.btn_bayar);
        tv_namabank = findViewById(R.id.tv_namabank);
        img_logo = findViewById(R.id.img_logobank);

        //set item
        String namabank = PrefsHelper.sharedInstance(this).getNamaBank();
        int logo = PrefsHelper.sharedInstance(this).getLogoBank();

        tv_namabank.setText(namabank);
        img_logo.setImageResource(logo);

        //set on click
        btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PembayaranDetailActivity.this, TransferActivity.class);
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
