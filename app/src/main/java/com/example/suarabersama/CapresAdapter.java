package com.example.suarabersama;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CapresAdapter extends RecyclerView.Adapter<CapresAdapter.MyViewHolder> {

    ArrayList<String> headline;
    ArrayList<String> namaKomentator;
    ArrayList<String> komen;
    ArrayList<String> kota;


    Context context;

    public CapresAdapter(Context context, ArrayList<String> headline, ArrayList<String> namaKomentator, ArrayList<String> komen, ArrayList<String> kota) {
        this.context = context;
        this.headline = headline;
        this.namaKomentator = namaKomentator;
        this.komen = komen;
        this.kota = kota;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_capres_page, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data in items
        holder.name.setText(namaKomentator.get(position));
        // implement setOnClickListener event on item view.
        // set the data in items
        holder.title.setText(headline.get(position));
        holder.comment.setText(komen.get(position));
        holder.city.setText(kota.get(position));
        // implement setOnClickListener event on item view.

    }


    @Override
    public int getItemCount() {
        return namaKomentator.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;// init the item view's
        TextView title;
        TextView comment, city;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.txtWawanSudrajatOne);
            title = (TextView) itemView.findViewById(R.id.txtKinerjaTerbuktOne);
            comment = (TextView) itemView.findViewById(R.id.txtDescriptionOne);
            city = (TextView) itemView.findViewById(R.id.txtSidoarjo);
        }
    }
}
