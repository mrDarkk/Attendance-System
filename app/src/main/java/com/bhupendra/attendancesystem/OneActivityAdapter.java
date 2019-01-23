package com.bhupendra.attendancesystem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.AccessController;
import java.util.List;

/**
 * Created by bhupendrabanothe on 12/03/2018 AD.
 */

public class OneActivityAdapter extends RecyclerView.Adapter<OneActivityAdapter.OneActivityHolder> {

    List<String> datelist;
    Context context;
    int index = -1;

    public OneActivityAdapter(List<String> datelist, Context context) {
        this.datelist = datelist;
        this.context = context;
    }

    @Override
    public OneActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_staff_student, parent, false);
        return new OneActivityHolder(v);
    }

    @Override
    public void onBindViewHolder(OneActivityHolder holder, final int position) {
        String date = datelist.get(position);

        holder.sec.setText(date);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = position;
                notifyDataSetChanged();
            }
        });

        if(index == position)
        {
            holder.card.setBackground(context.getResources().getDrawable(R.drawable.card_background_accent));
            holder.sec.setTextColor(Color.parseColor("#ffffff"));
           // holder.day.setTextColor(Color.parseColor("#ffffff"));

            Intent myIntent = new Intent(context , MainActivity.class);
            context.startActivity(myIntent);
        }else
        {
            holder.card.setBackground(context.getResources().getDrawable(R.drawable.card_background));
            holder.sec.setTextColor(Color.parseColor("#757575"));
           // holder.day.setTextColor(Color.parseColor("#757575"));
        }

    }

    @Override
    public int getItemCount() {
        return datelist.size();
    }

  
    public class OneActivityHolder extends RecyclerView.ViewHolder {

        TextView sec;
        ImageView img;


        LinearLayout card;

        public OneActivityHolder(View itemView) {
            super(itemView);
            img  = itemView.findViewById(R.id.img);
            sec = itemView.findViewById(R.id.sec);
            card = itemView.findViewById(R.id.cardView);
        }
    }
}
