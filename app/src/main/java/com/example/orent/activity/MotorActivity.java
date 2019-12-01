package com.example.orent.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.example.orent.R;
import com.example.orent.adapter.MotorAdapter;

public class MotorActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    SearchView sv_motor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewamotor);

        Toolbar toolbar = findViewById(R.id.tl_sewamotor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);

        return true;
    }
}
