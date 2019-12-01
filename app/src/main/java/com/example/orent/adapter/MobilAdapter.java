package com.example.orent.adapter;

import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orent.R;
import com.example.orent.activity.DetailActivity;
import com.example.orent.helper.PrefsHelper;
import com.example.orent.model.Mobil;

import java.util.ArrayList;
import java.util.List;

public class MobilAdapter extends RecyclerView.Adapter<MobilAdapter.ViewHolder> {

    List<Mobil> mItems;

    public MobilAdapter() {
        super();
        mItems = new ArrayList<Mobil>();
        Mobil nama = new Mobil();
        nama.setName("Mitsubishi");
        nama.setmName2("Xpander");
        nama.setThumbnail(R.drawable.mobil);
        mItems.add(nama);

        nama = new Mobil();
        nama.setName("Honda");
        nama.setmName2("Mobilio RS");
        nama.setThumbnail(R.drawable.mobil2);
        mItems.add(nama);

        nama = new Mobil();
        nama.setName("Toyota");
        nama.setmName2("Avanza Veloz");
        nama.setThumbnail(R.drawable.mobil3);
        mItems.add(nama);

        nama = new Mobil();
        nama.setName("Toyota");
        nama.setmName2("Agya 1.2 TRD");
        nama.setThumbnail(R.drawable.mobil4);
        mItems.add(nama);

        nama = new Mobil();
        nama.setName("Honda");
        nama.setmName2("Brio Satya");
        nama.setThumbnail(R.drawable.mobil5);
        mItems.add(nama);

        nama = new Mobil();
        nama.setName("Toyota");
        nama.setmName2("Calya");
        nama.setThumbnail(R.drawable.mobil6);
        mItems.add(nama);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_mobil, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final Mobil nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.tvspecies2.setText(nature.getmName2());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());

        viewHolder.cv_mobil.setOnClickListener(new View.OnClickListener() {
            final int i = viewHolder.getAdapterPosition();
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailActivity.class);
                PrefsHelper.sharedInstance(view.getContext()).setNamaDepan(nature.getName());
                PrefsHelper.sharedInstance(view.getContext()).setNamaBelakang(nature.getmName2());
                PrefsHelper.sharedInstance(view.getContext()).setImage(nature.getThumbnail());
                PrefsHelper.sharedInstance(view.getContext()).setStatusK(true);
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
        CardView cv_mobil;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.img_thumbnail);
            tvspecies = itemView.findViewById(R.id.status);
            tvspecies2 = itemView.findViewById(R.id.status2);
            cv_mobil = itemView.findViewById(R.id.card_mobil);
        }
    }
}
