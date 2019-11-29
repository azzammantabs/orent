package com.example.orent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;


public class AkunFragment extends Fragment implements View.OnClickListener {

    Button btn_logout;
    ImageView img_profil;
    TextView tv_editprofil, tv_nama, tv_email;
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

        //set on click
        btn_logout.setOnClickListener(this);
        tv_editprofil.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_logout :{
                Toast.makeText(getActivity(), "belum bisa logout", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.tv_editprofil :{
                Toast.makeText(getActivity(), "belum bisa", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
