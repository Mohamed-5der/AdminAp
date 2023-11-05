package com.example.adminapp.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.Activites.AttendanceActivity;
import com.example.adminapp.Activites.ScanQrActivity;
import com.example.adminapp.Adapter.AttendanceAdapter;
import com.example.adminapp.Adapter.GroupAdapter;
import com.example.adminapp.Classes.DataQuiz;
import com.example.adminapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public static Dialog dialog ;
    RecyclerView re;

    Button scan;
    public static TextView selectGroup;
    public static String nameGroup;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_home, container, false);
        selectGroup=v.findViewById(R.id.txt_selectGroup);
        scan=v.findViewById(R.id.btn_scan);
        selectGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectGroupDialog();

            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameGroup==null){
                    Toast.makeText(getActivity(), "Select Group", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent =new Intent(getContext(), ScanQrActivity.class);
                    startActivity(intent);
                }
            }
        });
        return v;
    }
    public void showSelectGroupDialog(){
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.group_custom_dialog);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().getAttributes().windowAnimations =R.style.DialoAnimation;
        ImageButton close= dialog.findViewById(R.id.btn_close);
        re =dialog.findViewById(R.id.rv_selectGroup);
        setupRvSelectGroup();
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
    public  void setupRvSelectGroup(){
        ArrayList<DataQuiz> dataQuizzes =new ArrayList<>();
        dataQuizzes.add(new DataQuiz("Group 1",""));
        dataQuizzes.add(new DataQuiz("Group 2",""));
        dataQuizzes.add(new DataQuiz("Group 3",""));
        dataQuizzes.add(new DataQuiz("Group 4",""));
        RecyclerView.LayoutManager lm =new LinearLayoutManager(getActivity());
        GroupAdapter groupAdapter = new GroupAdapter(dataQuizzes);
        re.setHasFixedSize(true);
        re.setLayoutManager(lm);
        re.setAdapter(groupAdapter);

    }

}