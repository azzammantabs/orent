package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.fragment.AkunFragment;
import com.example.orent.fragment.HistoryFragment;
import com.example.orent.fragment.HomeFragment;
import com.example.orent.fragment.PeminjamanFragment;

public class HomeActivity extends AppCompatActivity{

    BottomNavigationView bn_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.tl_fragmenthome);
        setSupportActionBar(toolbar);

        //inisialisasi
        bn_home = findViewById(R.id.bn_home);



        getSupportFragmentManager().beginTransaction().replace(R.id.fl_home, new HomeFragment()).commit();

        BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectedFragment = null;

                        switch (menuItem.getItemId()){
                            case R.id.nav_home :{
                                selectedFragment = new HomeFragment();
                            }break;
                            case R.id.nav_peminjaman :{
                                selectedFragment = new PeminjamanFragment();
                            }break;
                            case R.id.nav_history :{
                                selectedFragment = new HistoryFragment();
                            }break;
                            case R.id.nav_akun :{
                                selectedFragment = new AkunFragment();
                            }default:
                                //do nothing
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_home, selectedFragment).commit();

                        return true;
                    }
                };
        bn_home.setOnNavigationItemSelectedListener(navListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

}
