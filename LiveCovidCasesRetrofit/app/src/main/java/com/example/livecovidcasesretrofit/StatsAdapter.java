package com.example.livecovidcasesretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.MyViewHolder> {

    Context ac;
    List<Stats> myList;

    public StatsAdapter(Context c, List<Stats> statsList)
    {
        ac = c;
        myList = statsList;
    }

    @NonNull
    @Override
    public StatsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ac).inflate(R.layout.items,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsAdapter.MyViewHolder holder, int position) {

        Stats sts = myList.get(position);
        holder.dt.setText(sts.getDate());
        holder.actv.setText(sts.getActive());
        holder.rectv.setText(sts.getRecovery());
        holder.dthstv.setText(sts.getDeaths());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dt,actv,rectv,dthstv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dt = itemView.findViewById(R.id.date);
            actv = itemView.findViewById(R.id.activecasestv);
            rectv = itemView.findViewById(R.id.recoveredtv);
            dthstv = itemView.findViewById(R.id.deathstv);
        }
    }
}
