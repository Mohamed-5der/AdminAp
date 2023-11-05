package com.example.adminapp.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.adminapp.Classes.DataAttendance;
import com.example.adminapp.R;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceViewHolder> {

    ArrayList<DataAttendance> dataAttendances;

    public AttendanceAdapter(ArrayList<DataAttendance> dataAttendances) {
        this.dataAttendances = dataAttendances;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_attendance_custom,null,false);
        return new AttendanceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        DataAttendance dataAttendance=dataAttendances.get(position);
        holder.onBind(dataAttendance);
    }

    @Override
    public int getItemCount() {
        return dataAttendances.size();
    }
}
class AttendanceViewHolder extends RecyclerView.ViewHolder{
TextView nameStudent,nameGroup,dateSend;
ImageView imageStudent;
    public AttendanceViewHolder(@NonNull View itemView) {
        super(itemView);
        nameStudent=itemView.findViewById(R.id.txt_nameStudent);
        nameGroup=itemView.findViewById(R.id.txt_namePage);
        dateSend=itemView.findViewById(R.id.txt_date);
        imageStudent=itemView.findViewById(R.id.iv_imgStudent);
    }
    public void onBind(DataAttendance dataAttendance){
        nameStudent.setText(dataAttendance.getNameStudent());
        nameGroup.setText(dataAttendance.getNameGroup());
        dateSend.setText(dataAttendance.getDateSend());
        imageStudent.setImageResource(dataAttendance.getImageStudent());
    }

}