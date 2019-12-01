package com.example.orent.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.helper.PrefsHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    TextView tv_register;
    Button btn_login;
    ProgressBar pb_login;
    EditText et_username, et_password;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inisialisasi
        tv_register = findViewById(R.id.tv_regist);
        btn_login = findViewById(R.id.btn_login);
        et_username = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        pb_login = findViewById(R.id.pb_login);
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("account", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("account", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        Boolean statusLogin = PrefsHelper.sharedInstance(this).getStatusLogin();
        if (statusLogin) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }

        //on click listener
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(i);
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username,password;
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                if(!username.isEmpty() && !password.isEmpty()){
                    pb_login.setVisibility(View.VISIBLE);
                    btn_login.setVisibility(View.GONE);
                    mFirebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "email dan password salah", Toast.LENGTH_SHORT).show();
                                pb_login.setVisibility(View.GONE);
                                btn_login.setVisibility(View.VISIBLE);
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                PrefsHelper.sharedInstance(LoginActivity.this).setStatusLogin(true);
                                PrefsHelper.sharedInstance(LoginActivity.this).setDpembayaran("tanpanama");
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }else if (username.isEmpty()){
                    et_username.setError("email tidak boleh kosong");
                    et_username.requestFocus();
                }else if (password.isEmpty()){
                    et_password.setError("password tidak boleh kosong");
                    et_password.requestFocus();
                }else {
                    Toast.makeText(LoginActivity.this, "kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}
