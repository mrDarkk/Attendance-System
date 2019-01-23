package com.bhupendra.attendancesystem;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhupendrabanothe on 12/03/2018 AD.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.TakeAttendanceHolder> {

    List<String> studentList;
    List<Boolean> selectedStudent;
    Context context;

    public StudentAdapter(List<String> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;

        selectedStudent = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++)
            selectedStudent.add(false);
    }

    public List<Boolean> getSelectedList()
    {
        return selectedStudent;
    }

    @Override
    public TakeAttendanceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_student, parent, false);
        return new TakeAttendanceHolder(v);
    }

    @Override
    public void onBindViewHolder(TakeAttendanceHolder holder, final int position) {
        String name = studentList.get(position);

        if (!name.equals("")) {
            holder.index.setText((position + 1) + ".");
            holder.name.setText(name);

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedStudent.get(position))
                        selectedStudent.set(position, false);
                    else
                        selectedStudent.set(position, true);
                    notifyDataSetChanged();
                }
            });

            if (selectedStudent.get(position)) {
                holder.card.setBackground(context.getResources().getDrawable(R.drawable.card_background_accent));
                holder.name.setTextColor(Color.parseColor("#ffffff"));
                holder.index.setTextColor(Color.parseColor("#ffffff"));
            } else {
                holder.card.setBackground(context.getResources().getDrawable(R.drawable.card_background));
                holder.index.setTextColor(Color.parseColor("#757575"));
                holder.name.setTextColor(Color.parseColor("#757575"));
            }
            holder.itemView.setVisibility(View.VISIBLE);
        } else
            holder.itemView.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class TakeAttendanceHolder extends RecyclerView.ViewHolder {

        TextView name, index;
        LinearLayout card;

        public TakeAttendanceHolder(View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.index);
            name = itemView.findViewById(R.id.name);
            card = itemView.findViewById(R.id.cardView);
        }
    }
}
