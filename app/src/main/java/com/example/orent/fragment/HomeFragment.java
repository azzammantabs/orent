package com.example.orent.fragment;


import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orent.R;
import com.example.orent.activity.HomeActivity;
import com.example.orent.activity.MobilActivity;
import com.example.orent.activity.MotorActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    TextView tv_motor, tv_mobil;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home2, container, false);

        //inisialisasi
        tv_mobil = v.findViewById(R.id.tv_sewamobil);
        tv_motor = v.findViewById(R.id.tv_sewamotor);

        tv_motor.setOnClickListener(this);
        tv_mobil.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sewamobil :{
                Intent in = new Intent(getActivity(), MobilActivity.class);
                startActivity(in);
            }break;
            case R.id.tv_sewamotor :{
                Intent in = new Intent(getActivity(), MotorActivity.class);
                startActivity(in);
            }break;
            default:
                //do nothing
        }
    }
}
