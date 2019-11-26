package com.example.orent.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orent.R;
import com.example.orent.model.Motor;

import java.util.ArrayList;
import java.util.List;

public class MotorAdapter extends RecyclerView.Adapter<MotorAdapter.ViewHolder> {

    List<Motor> mItems;

    public MotorAdapter() {
        super();
        mItems = new ArrayList<Motor>();
        Motor nama = new Motor();
        nama.setName("Yamaha R15");
        nama.setThumbnail(R.drawable.motor);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Honda Vario 110");
        nama.setThumbnail(R.drawable.motor2);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Yamaha R25");
        nama.setThumbnail(R.drawable.motor3);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Honda Beat");
        nama.setThumbnail(R.drawable.motor4);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Yamaha Aerox");
        nama.setThumbnail(R.drawable.motor5);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Yamaha Lexi");
        nama.setThumbnail(R.drawable.motor6);
        mItems.add(nama);

    }

    @Override
    public MotorAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_motor, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MotorAdapter.ViewHolder viewHolder, int i) {
        Motor nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.img_thumbnail);
            tvspecies = itemView.findViewById(R.id.status);
        }
    }
}
