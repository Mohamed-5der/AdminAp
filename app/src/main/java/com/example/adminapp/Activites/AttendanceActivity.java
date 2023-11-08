package com.example.adminapp.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adminapp.Adapter.AttendanceAdapter;
import com.example.adminapp.Classes.DataAttendance;
import com.example.adminapp.Fragments.HomeFragment;
import com.example.adminapp.R;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    ImageButton back;
    Button scan, submit;
    RecyclerView rv_attendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        back=findViewById(R.id.btn_back);
        scan=findViewById(R.id.btn_scanQr);
        submit=findViewById(R.id.btn_submit);
        rv_attendance=findViewById(R.id.rv_Attendance);
        setupRvAttendance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAttendance();
            }
        });
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
    public void showDialogAttendance(){
        final Dialog dialog = new Dialog(AttendanceActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.sucsessfully);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        TextView show =dialog.findViewById(R.id.txt_show);
        show.setText("Attendance submitted sucsessfully ");
        Button home =dialog.findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AttendanceActivity.this, HomeFragment.class);
                startActivity(intent);
                dialog.dismiss();
                finish();
            }
        });

        ImageButton close =dialog.findViewById(R.id.btn_close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}