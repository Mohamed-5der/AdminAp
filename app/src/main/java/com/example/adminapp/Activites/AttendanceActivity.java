package com.example.adminapp.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.adminapp.Adapter.AttendanceAdapter;
import com.example.adminapp.Classes.DataAttendance;
import com.example.adminapp.R;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    ImageButton back;
    RecyclerView rv_attendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        back=findViewById(R.id.btn_back);
        rv_attendance=findViewById(R.id.rv_Attendance);
        setupRvAttendance();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    public void setupRvAttendance(){
        ArrayList<DataAttendance> dataAttendances =new ArrayList<>();
        dataAttendances.add(new DataAttendance("mohamed Khedr","Group 4",R.drawable.alsafty_logo,"2:25"));
        dataAttendances.add(new DataAttendance("mohamed Khedr","Group 4",R.drawable.alsafty_logo,"2:25"));
        dataAttendances.add(new DataAttendance("mohamed Khedr","Group 4",R.drawable.alsafty_logo,"2:25"));
        dataAttendances.add(new DataAttendance("mohamed Khedr","Group 4",R.drawable.alsafty_logo,"2:25"));
        RecyclerView.LayoutManager lm =new LinearLayoutManager(this);
        AttendanceAdapter attendanceAdapter = new AttendanceAdapter(dataAttendances);
        rv_attendance.setAdapter(attendanceAdapter);
        rv_attendance.setHasFixedSize(true);
        rv_attendance.setLayoutManager(lm);
    }
}