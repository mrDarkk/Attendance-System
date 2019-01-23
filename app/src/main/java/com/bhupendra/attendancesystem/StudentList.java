package com.bhupendra.attendancesystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;

public class StudentList extends AppCompatActivity {

    RecyclerView mRecyclerView;
    StudentAdapter mAdapter;
    List<String> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        temp = new ArrayList<>();
        temp.add("Aditya Gupta");
        temp.add("Bhupendra Banothe");
        temp.add("Yash Golchha");
        temp.add("Vivek Modi");
        temp.add("Raj Sahu");
        temp.add("Deepansh Dubey");
        temp.add("Rishabh Khandelwal");
        temp.add("Aditya Gupta");
        temp.add("Bhupendra Banothe");
        temp.add("Yash Golchha");
        temp.add("Vivek Modi");
        temp.add("Raj Sahu");
        temp.add("Deepansh Dubey");
        temp.add("Rishabh Khandelwal");
        temp.add("");

        mAdapter = new StudentAdapter(temp,this);
        mRecyclerView.setAdapter(mAdapter);

        ((Button)findViewById(R.id.onTakeAttendance)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Boolean> presentList = mAdapter.getSelectedList();
                for (int i = 0 ; i < presentList.size() ; i++ )
                {
                    Log.e("Student Present", temp.get(i));
                }
            }
        });
    }
}
