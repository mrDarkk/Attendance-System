package com.bhupendra.attendancesystem;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bhupendrabanothe on 12/03/2018 AD.
 */

public class TakeAttendanceAdapter extends RecyclerView.Adapter<TakeAttendanceAdapter.TakeAttendanceHolder> {

    List<String> datelist;
    Context context;
    int index = -1;

    public TakeAttendanceAdapter(List<String> datelist, Context context) {
        this.datelist = datelist;
        this.context = context;
    }

    @Override
    public TakeAttendanceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_attendance_tab, parent, false);
        return new TakeAttendanceHolder(v);
    }

    @Override
    public void onBindViewHolder(TakeAttendanceHolder holder, final int position) {
        String date = datelist.get(position);

        holder.date.setText(date);

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
            holder.date.setTextColor(Color.parseColor("#ffffff"));
            holder.day.setTextColor(Color.parseColor("#ffffff"));
        }else
        {
            holder.card.setBackground(context.getResources().getDrawable(R.drawable.card_background));
            holder.date.setTextColor(Color.parseColor("#757575"));
            holder.day.setTextColor(Color.parseColor("#757575"));
        }

    }

    @Override
    public int getItemCount() {
        return datelist.size();
    }

    public class TakeAttendanceHolder extends RecyclerView.ViewHolder {

        TextView date,day;
        LinearLayout card;

        public TakeAttendanceHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            day = itemView.findViewById(R.id.day);
            card = itemView.findViewById(R.id.cardView);
        }
    }
}
