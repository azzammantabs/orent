package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.adapter.MobilAdapter;
import com.example.orent.adapter.PembayaranAdapter;
import com.example.orent.helper.PrefsHelper;
import com.example.orent.model.Pembayaran;

import java.util.ArrayList;
import java.util.List;

public class TransferActivity extends AppCompatActivity {

    Button btn_cekstatus;
    ImageView img_tlogo;
    TextView tv_nama, tv_rek;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer);

        Toolbar toolbar = findViewById(R.id.tl_transfer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Transfer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi
        btn_cekstatus = findViewById(R.id.btn_cekstatus);
        img_tlogo = findViewById(R.id.img_tlogo);
        tv_nama = findViewById(R.id.tv_tnama);
        tv_rek = findViewById(R.id.tv_norek);

        //set item kendaraan
        final String nd = PrefsHelper.sharedInstance(this).getNamaDepan();
        final String nb = PrefsHelper.sharedInstance(this).getNamaBelakang();
        final int img = PrefsHelper.sharedInstance(this).getImage();

        //set item bank
        String namabnk = PrefsHelper.sharedInstance(this).getNamaBank();
        String rek = PrefsHelper.sharedInstance(this).getRekBank();
        int logo = PrefsHelper.sharedInstance(this).getLogoBank();

        tv_nama.setText(namabnk);
        tv_rek.setText(rek);
        img_tlogo.setImageResource(logo);

        //set on click
        btn_cekstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TransferActivity.this, "cek peminjaman", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(TransferActivity.this, HomeActivity.class);
                PrefsHelper.sharedInstance(TransferActivity.this).setDpembayaran(nd);
                PrefsHelper.sharedInstance(TransferActivity.this).setBpembayaran(nb);
                PrefsHelper.sharedInstance(TransferActivity.this).setIpembayaran(img);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
//        return true;
//    }
}
