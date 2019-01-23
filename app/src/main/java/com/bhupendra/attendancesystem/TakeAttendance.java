package com.bhupendra.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;

public class TakeAttendance extends AppCompatActivity {

    RecyclerView mRecyclerView;
    TakeAttendanceAdapter mAdapter;

    public void setDate(String date,String am)
    {
        int textSize1 = getResources().getDimensionPixelSize(R.dimen.text_size_1);
        int textSize2 = getResources().getDimensionPixelSize(R.dimen.text_size_2);
        SpannableString span1 = new SpannableString(date);
        span1.setSpan(new AbsoluteSizeSpan(textSize1), 0, date.length(), SPAN_INCLUSIVE_INCLUSIVE);
        SpannableString span2 = new SpannableString(am);
        span2.setSpan(new AbsoluteSizeSpan(textSize2), 0, am.length(), SPAN_INCLUSIVE_INCLUSIVE);
        CharSequence finalText = TextUtils.concat(span1, span2);
        ((TextView)findViewById(R.id.time)).setText(finalText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        setDate("10:00","AM");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        List<String> temp = new ArrayList<>();
        temp.add("14");
        temp.add("15");
        temp.add("18");
        temp.add("16");
        temp.add("19");
        temp.add("11");
        temp.add("12");

        mAdapter = new TakeAttendanceAdapter(temp,this);
        mRecyclerView.setAdapter(mAdapter);

        ((Button)findViewById(R.id.takeAttendance)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TakeAttendance.this,StudentList.class));
            }
        });
    }
}
