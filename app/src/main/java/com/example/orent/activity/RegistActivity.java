package com.example.orent.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;



public class RegistActivity extends AppCompatActivity {

    public String image;
    TextView tv_login;
    ProgressBar pb_regist;
    Uri pickedImgUri;
    Button btn_daftar, btn_upload;
    EditText et_email, et_nama, et_no, et_pswd;
    private FirebaseAuth mAuth;
    private StorageReference Folder;
    private DatabaseReference databaseReference;

    int REQUESTCODE = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        //inisialisasi
        et_email = findViewById(R.id.email_regist);
        et_nama = findViewById(R.id.nama_regist);
        et_no = findViewById(R.id.no_regist);
        et_pswd = findViewById(R.id.password_regist);
        tv_login = findViewById(R.id.tv_login);
        btn_daftar = findViewById(R.id.btn_daftar);
        btn_upload = findViewById(R.id.btn_uploadimg);
        pb_regist = findViewById(R.id.pb_regist);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Folder = FirebaseStorage.getInstance().getReference().child("user_photos");


        //on click listener
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUESTCODE);
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nama = et_nama.getText().toString();
                final String email = et_email.getText().toString();
                final String no = et_no.getText().toString();
                final String password = et_pswd.getText().toString();

                if (email.isEmpty()) {
                    et_email.setError("Email Tidak Boleh Kosong");
                    et_email.requestFocus();
                } else if (nama.isEmpty()) {
                    et_nama.setError("Nama Tidak Boleh Kosong");
                    et_nama.requestFocus();
                } else if (no.isEmpty()) {
                    et_no.setError("Nomor Hp Tidak Boleh Kosong");
                    et_no.requestFocus();
                } else if (password.isEmpty()) {
                    et_pswd.setError("Password Tidak Boleh Kosong");
                    et_pswd.requestFocus();
                } else if (email.isEmpty() && nama.isEmpty() && no.isEmpty() && password.isEmpty()) {
                    Toast.makeText(RegistActivity.this, "Isi Seluruh Data", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty()) && !(nama.isEmpty()) && !(no.isEmpty()) && !(password.isEmpty())) {
                    pb_regist.setVisibility(View.VISIBLE);
                    btn_daftar.setVisibility(View.GONE);
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegistActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                final String imgurl = getUrlImage();
                                final User user = new User(
                                        email, nama, imgurl, no);
                                FirebaseDatabase.getInstance().getReference("User")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(RegistActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                            pb_regist.setVisibility(View.GONE);
                                            btn_daftar.setVisibility(View.VISIBLE);
                                        } else {
                                            Toast.makeText(RegistActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(RegistActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT)
                                        .show();
                                pb_regist.setVisibility(View.GONE);
                                btn_daftar.setVisibility(View.VISIBLE);
                            }
                        }
                    });

                } else {
                    Toast.makeText(RegistActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                    pb_regist.setVisibility(View.GONE);
                    btn_daftar.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private String getUrlImage() {
        return image;
    }

    private void setUrlImage(String image) {
        this.image = image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESTCODE && data != null) {
            pickedImgUri = data.getData();

            final StorageReference imageName = Folder.child(pickedImgUri.getLastPathSegment());
            imageName.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    imageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            setUrlImage(String.valueOf(uri));
                            Toast.makeText(RegistActivity.this, "Upload Foto Berhasil", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}
