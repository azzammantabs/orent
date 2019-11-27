package com.example.orent.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.orent.R;
import com.example.orent.adapter.MobilAdapter;
import com.example.orent.adapter.MotorAdapter;

public class MotorActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewamotor);

        Toolbar toolbar = findViewById(R.id.tl_sewamotor);
        setSupportActionBar(toolbar);

        //inisialisasi
        mRecyclerView = findViewById(R.id.rc_motor);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager  = new GridLayoutManager(MotorActivity.this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MotorAdapter();
        //Memasang Adapter pada RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }
}