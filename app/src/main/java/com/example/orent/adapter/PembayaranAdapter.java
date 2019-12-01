package com.example.orent.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orent.R;
import com.example.orent.model.Pembayaran;

import java.util.ArrayList;
import java.util.List;

public class PembayaranAdapter extends RecyclerView.Adapter<PembayaranAdapter.ViewHolder> {

    List<Pembayaran> mItems;

    public PembayaranAdapter(String nd, String nb, int img) {
        super();
        mItems = new ArrayList<Pembayaran>();
        Pembayaran nama = new Pembayaran();
        nama.setName(nd);
        nama.setmName2(nb);
        nama.setThumbnail(img);
        mItems.add(nama);
    }

    @Override
    public PembayaranAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_peminjaman, viewGroup, false);
        PembayaranAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Pembayaran nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.tvspecies2.setText(nature.getmName2());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }


    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies, tvspecies2;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.img_produkp);
            tvspecies = itemView.findViewById(R.id.tv_namadp);
            tvspecies2 = itemView.findViewById(R.id.tv_namabp);
        }
    }
}
