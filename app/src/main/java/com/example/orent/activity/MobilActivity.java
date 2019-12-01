package com.example.orent.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.GridLayout;

import com.example.orent.R;
import com.example.orent.adapter.MobilAdapter;

public class MobilActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    GridLayout gridLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sewamobil);

        Toolbar toolbar = findViewById(R.id.tl_sewamobil);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi
        mRecyclerView = findViewById(R.id.rc_mobil);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager  = new GridLayoutManager(MobilActivity.this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MobilAdapter();
        //Memasang Adapter pada RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }
}
