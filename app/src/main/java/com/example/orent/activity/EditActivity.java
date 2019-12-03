package com.example.orent.activity;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.orent.R;
import com.example.orent.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditActivity extends AppCompatActivity {

    EditText et_email, et_nama, et_no;
    Button btn_edit;
    ProgressBar pb_edit;
    private String sPid, sPemail, sPnama, sPno;
    private String namaUser;
    private String image;
    private String email;
    private String no;
    private Handler handler;
    private DatabaseReference database;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);

        Toolbar toolbar = findViewById(R.id.tl_editprofil);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Akun");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi
        database = FirebaseDatabase.getInstance().getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        sPid = user.getUid();
        sPnama = user.getDisplayName();
        sPemail = user.getEmail();
        sPno = user.getPhoneNumber();

        et_email = findViewById(R.id.et_emailedit);
        et_nama = findViewById(R.id.et_namaedit);
        et_no = findViewById(R.id.et_noedit);
        btn_edit = findViewById(R.id.btn_edit);
        pb_edit = findViewById(R.id.pb_edit);

        getUser();
        //set No Hp
        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    //update
                    et_email.setText(email);
                    et_nama.setText(namaUser);
                    et_no.setText(no);
                }
            }
        };


        //set on click
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString();
                String nama = et_nama.getText().toString();
                String no = et_no.getText().toString();

                //perintah edit
                if (email.equals("")) {
                    et_email.setError("silahkan masukkan email");
                    et_email.requestFocus();
                } else if (nama.equals("")) {
                    et_nama.setError("silahkan masukkan nama lengkap");
                    et_nama.requestFocus();
                } else if (no.equals("")) {
                    et_no.setError("silahkan masukkan no hp");
                    et_no.requestFocus();
                } else {
                    pb_edit.setVisibility(View.VISIBLE);
                    btn_edit.setVisibility(View.GONE);

                    editUser(new User(
                            email.toLowerCase(),
                            nama,
                            image,
                            no), sPid);
                }
            }
        });
    }

    private void editUser(User requests, String id) {
        database.child("User")
                .child(id)
                .setValue(requests)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        pb_edit.setVisibility(View.GONE);
                        btn_edit.setVisibility(View.VISIBLE);

                        et_nama.setText("");
                        et_email.setText("");
                        et_no.setText("");

                        Toast.makeText(EditActivity.this,
                                "Data Berhasil diedit",
                                Toast.LENGTH_SHORT).show();

                    }

                });
    }

    private void getUser() {
        database.child("User").child(sPid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = dataSnapshot.getValue(User.class);

                        namaUser = user.getnama();
                        email = user.getEmail();
                        image = user.getImage();
                        no = user.getNo();

                        Message message = new Message();
                        message.what = 1;

                        handler.sendMessage(message);

                    }
                }).start();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
