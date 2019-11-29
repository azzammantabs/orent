package com.example.orent.helper;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

//untuk menyimpan value yang dibutuhkan oleh aplikasi
public class PrefsHelper {
    SharedPreferences prefs;
    Context ctx;
    private final String PREF_STATUS = "status_login";
    private final String PREF_FRAGMENT = "status_fragment";
    private final String PREF_SK = "status_kendaraan";
    private final String PREF_NAMA = "status_nama";
    private final String PREF_DEPAN = "status_namad";
    private final String PREF_BELAKANG = "status_namab";
    private final String PREF_IMG = "status_img";

    private static PrefsHelper instance;

    public static PrefsHelper sharedInstance(Context ctx) {
        if (instance == null) {
            instance = new PrefsHelper(ctx);
        }
        return instance;
    }

    private PrefsHelper(Context ctx) {
        this.ctx = ctx;
        this.prefs = ctx.getSharedPreferences("LATIHANSHARED", Context.MODE_PRIVATE);
    }

    //fungsi untuk menyimpan login status pada perangkat kita
    public void setStatusLogin(boolean status) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_STATUS, status);
        editor.apply();
    }

    //fungsi untuk mengambil status login
    public boolean getStatusLogin() {
        return prefs.getBoolean(PREF_STATUS, false);
    }

    //fungsi untuk menyimpan status page
    public void setStatusK(boolean status) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_SK, status);
        editor.apply();
    }

    //fungsi untuk mengambil status page
    public boolean getStatusK() {
        return prefs.getBoolean(PREF_SK, false);
    }

    //fungsi untuk menyimpan nama
    public void setNamaUser(String nama) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_NAMA, nama);
        editor.apply();
    }

    //fungsi untuk mengambil nama
    public String getNamaUser(){
        return prefs.getString(PREF_NAMA, "tanpanama");
    }

    //fungsi untuk menyimpan status fragment
    public void setStatusFragment(boolean status) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_FRAGMENT, status);
        editor.apply();
    }

    //fungsi untuk mengambil status fragment
    public boolean getStatusFragment() {
        return prefs.getBoolean(PREF_FRAGMENT, false);
    }

    //fungsi untuk menyimpan nama depan
    public void setNamaDepan(String nama) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_DEPAN, nama);
        editor.apply();
    }

    //fungsi untuk mengambil nama depan
    public String getNamaDepan(){
        return prefs.getString(PREF_DEPAN, "tanpanama");
    }

    //fungsi untuk menyimpan nama belakang
    public void setNamaBelakang(String nama) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_BELAKANG, nama);
        editor.apply();
    }

    //fungsi untuk mengambil nama belakang
    public String getNamaBelakang(){
        return prefs.getString(PREF_BELAKANG, "tanpanama");
    }
    //fungsi untuk menyimpan Image
    public void setImage(int nama) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(PREF_IMG, nama);
        editor.apply();
    }

    //fungsi untuk mengambil Image
    public int getImage(){
        return prefs.getInt(PREF_IMG, 0);
    }

}
