package com.example.orent.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.orent.helper.PrefsHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.fragment.AkunFragment;
import com.example.orent.fragment.HistoryFragment;
import com.example.orent.fragment.HomeFragment;
import com.example.orent.fragment.PeminjamanFragment;

public class HomeActivity extends AppCompatActivity{

    BottomNavigationView bn_home;
    private long backpresstime;
    private Toast backToast;

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

    @Override
    public void onBackPressed() {
        if (backpresstime + 2000 > System.currentTimeMillis()) {
            finish();
        } else {
            backToast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backpresstime = System.currentTimeMillis();
    }
}
