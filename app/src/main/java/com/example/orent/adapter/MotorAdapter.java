package com.example.orent.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orent.R;
import com.example.orent.activity.DetailActivity;
import com.example.orent.helper.PrefsHelper;
import com.example.orent.model.Motor;

import java.util.ArrayList;
import java.util.List;

public class MotorAdapter extends RecyclerView.Adapter<MotorAdapter.ViewHolder> {

    List<Motor> mItems;

    public MotorAdapter() {
        super();
        mItems = new ArrayList<Motor>();
        Motor nama = new Motor();
        nama.setName("Yamaha");
        nama.setmName2("R15");
        nama.setThumbnail(R.drawable.motor);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Honda");
        nama.setmName2("Vario 110");
        nama.setThumbnail(R.drawable.motor2);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Yamaha");
        nama.setmName2("R25");
        nama.setThumbnail(R.drawable.motor3);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Honda");
        nama.setmName2("Beat");
        nama.setThumbnail(R.drawable.motor4);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Yamaha");
        nama.setmName2("Aerox");
        nama.setThumbnail(R.drawable.motor5);
        mItems.add(nama);

        nama = new Motor();
        nama.setName("Yamaha");
        nama.setmName2("Lexi");
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
        final Motor nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.tvspecies2.setText(nature.getmName2());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());

        viewHolder.cv_motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailActivity.class);
                PrefsHelper.sharedInstance(view.getContext()).setImage(nature.getThumbnail());
                PrefsHelper.sharedInstance(view.getContext()).setNamaDepan(nature.getName());
                PrefsHelper.sharedInstance(view.getContext()).setNamaBelakang(nature.getmName2());
                PrefsHelper.sharedInstance(view.getContext()).setStatusK(false);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies, tvspecies2;
        CardView cv_motor;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.img_thumbnail);
            tvspecies = itemView.findViewById(R.id.status);
            tvspecies2 = itemView.findViewById(R.id.status2);
            cv_motor = itemView.findViewById(R.id.card_motor);
        }
    }
}
