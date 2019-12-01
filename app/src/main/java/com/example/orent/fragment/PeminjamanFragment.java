package com.example.orent.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.orent.R;
import com.example.orent.activity.TransferActivity;
import com.example.orent.adapter.MobilAdapter;
import com.example.orent.adapter.PembayaranAdapter;
import com.example.orent.helper.PrefsHelper;
import com.example.orent.model.Pembayaran;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeminjamanFragment extends Fragment {


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    TextView tv_nopinjam;

    public PeminjamanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_peminjaman, container, false);

        //inisialisasi
        tv_nopinjam = v.findViewById(R.id.tv_nopinjam);
        mRecyclerView = v.findViewById(R.id.rc_peminjaman);

        tv_nopinjam.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);

        //set item
        String nd = PrefsHelper.sharedInstance(getActivity()).getDpembayaran();
        String nb = PrefsHelper.sharedInstance(getActivity()).getBpembayaran();
        int img = PrefsHelper.sharedInstance(getActivity()).getIpembayaran();

        if (nd != "tanpanama") {
            //inisialisasi
            tv_nopinjam.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager  = new GridLayoutManager(getActivity(),1);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new PembayaranAdapter(nd,nb,img);
            //Memasang Adapter pada RecyclerView
            mRecyclerView.setAdapter(mAdapter);
        }

        return v;
    }

}
