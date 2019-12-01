package com.example.orent.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.activity.LoginActivity;
import com.example.orent.helper.PrefsHelper;
import com.example.orent.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class AkunFragment extends Fragment implements View.OnClickListener {

    Button btn_logout;
    ProgressBar pb_akun;
    RelativeLayout rl_akun;
    ImageView img_profil;
    TextView tv_editprofil, tv_nama, tv_email;
    private DatabaseReference databaseReference;
    private FirebaseUser Fuser;
    private FirebaseAuth Fauth;
    private Handler handler;
    private String iduser;
    private String namaUser;
    private String image;
    private String email;
    public AkunFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_akun, container, false);

        //inisialisasi
        btn_logout = v.findViewById(R.id.btn_logout);
        img_profil = v.findViewById(R.id.img_profiluser);
        tv_nama = v.findViewById(R.id.tv_namauser);
        tv_email = v.findViewById(R.id.tv_emailuser);
        tv_editprofil = v.findViewById(R.id.tv_editprofil);
        pb_akun = v.findViewById(R.id.pb_akun);
        rl_akun = v.findViewById(R.id.rl_akun);

        //set on click
        btn_logout.setOnClickListener(this);
        tv_editprofil.setOnClickListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        Fauth = FirebaseAuth.getInstance();
        //get user yang teruautentikasi
        Fuser = Fauth.getCurrentUser();
        iduser = Fuser.getUid();

        //get nama , email, dan jurusan
        getUser();

        //set Nama User, Email dan Jurusan
        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    //update
                    pb_akun.setVisibility(View.GONE);
                    rl_akun.setVisibility(View.VISIBLE);
                    tv_nama.setText(namaUser);
                    tv_email.setText(email);
                    Picasso.get().load(image).fit().centerCrop().into(img_profil);
                }
            }
        };

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_logout :{
                Intent i = new Intent(getActivity(), LoginActivity.class);
                PrefsHelper.sharedInstance(getActivity()).setStatusLogin(false);
                getActivity().finish();
                startActivity(i);
            }break;
            case R.id.tv_editprofil :{
                Toast.makeText(getActivity(), "belum bisa", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getUser() {
        pb_akun.setVisibility(View.VISIBLE);
        rl_akun.setVisibility(View.GONE);
        databaseReference.child("User").child(iduser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = dataSnapshot.getValue(User.class);

                        namaUser = user.getnama();
                        email = user.getEmail();
                        image = user.getImage();

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
