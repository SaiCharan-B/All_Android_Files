package com.example.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GitAdapter extends RecyclerView.Adapter<GitAdapter.MyViewHolder> {

    Context ac;
    List<Repo> myList;

    public GitAdapter(Context c, List<Repo> gitList)
    {
        ac = c;
        myList = gitList;
    }

    @NonNull
    @Override
    public GitAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ac).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GitAdapter.MyViewHolder holder, int position) {

        Repo rep = myList.get(position);
        holder.gtvn.setText(rep.getName());
        holder.gtvf.setText(rep.getFullname());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView gtvn,gtvf;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gtvn = itemView.findViewById(R.id.gittextname);
            gtvf = itemView.findViewById(R.id.gittextfull);
        }
    }
}
