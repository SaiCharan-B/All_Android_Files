package com.example.androidversions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adap extends RecyclerView.Adapter<Adap.MyViewHolder> {

    int imgs[];
    String cnames[],versions[],apis[],dates[];
    Context c;

    public Adap(MainActivity mainActivity, int[] images, String[] codename, String[] version, String[] apilevels, String[] releasedate) {

        imgs = images;
        cnames = codename;
        versions = version;
        apis = apilevels;
        dates = releasedate;
        c = mainActivity;

    }

    @NonNull
    @Override
    public Adap.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.itemone,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adap.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imgs[position]);
        holder.cn.setText(cnames[position]);
        holder.vers.setText(versions[position]);
        holder.api.setText(apis[position]);
        holder.dates.setText(dates[position]);

    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView cn,vers,api,dates;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imgview);
            cn = itemView.findViewById(R.id.codename);
            vers = itemView.findViewById(R.id.vernum);
            api = itemView.findViewById(R.id.apilvl);
            dates = itemView.findViewById(R.id.releasedate);

        }
    }
}
