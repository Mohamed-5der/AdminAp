package com.example.adminapp.Fragments;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adminapp.Activites.AttendanceActivity;
import com.example.adminapp.Activites.MainActivity;
import com.example.adminapp.Adapter.RequestAdapter;
import com.example.adminapp.Classes.DataRequest;
import com.example.adminapp.R;

import java.util.ArrayList;


public class RequestFragment extends Fragment {
    RecyclerView rvRequest;
     Dialog  dialogSure;
     Dialog dialogAccepted;
      Dialog dialogReject;

    HomeFragment homeFragment =new HomeFragment();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg, container, false);
        rvRequest=v.findViewById(R.id.rv_request);
        showDialogRequestReject();
        showDialogAreSure();
        showDialogRequestAccepted();
        setupRvRequest();
        return v;
    }
    public void setupRvRequest(){
        ArrayList<DataRequest> dataRequests =new ArrayList<>();
        dataRequests.add(new DataRequest("Group 2","Group 3","Mohamed Khedr",R.drawable.mohamed));
        dataRequests.add(new DataRequest("Group 4","Group 5","Mohamed Khedr",R.drawable.mohamed));
        dataRequests.add(new DataRequest("Group 1","Group 7","Mohamed Khedr",R.drawable.mohamed));
        dataRequests.add(new DataRequest("Group 3","Group 1","Mohamed Khedr",R.drawable.mohamed));
        RecyclerView.LayoutManager layoutManage =new LinearLayoutManager(getContext());
        RequestAdapter requestAdapter =new RequestAdapter(dataRequests,dialogAccepted,dialogReject,dialogSure);
        rvRequest.setAdapter(requestAdapter);
        rvRequest.setLayoutManager(layoutManage);
        rvRequest.setHasFixedSize(true);

    }

    public void showDialogRequestAccepted(){
        dialogAccepted = new Dialog(getActivity());
        dialogAccepted.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogAccepted.setCancelable(false);
        dialogAccepted.setContentView(R.layout.sucsessfully);
        dialogAccepted.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView show = dialogAccepted.findViewById(R.id.txt_show);
        show.setText("Request accepted sucsessfully");
        Button home =dialogAccepted.findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAccepted.dismiss();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        ImageButton close =dialogAccepted.findViewById(R.id.btn_close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAccepted.dismiss();
            }
        });
    }

    public void showDialogRequestReject(){
         dialogReject = new Dialog(getActivity());
        dialogReject.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogReject.setCancelable(false);
        dialogReject.setContentView(R.layout.sucsessfully);
        dialogReject.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView show =dialogReject.findViewById(R.id.txt_show);
        show.setText("Request rejected sucsessfully");
        Button home =dialogReject.findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogReject.dismiss();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        ImageButton close =dialogReject.findViewById(R.id.btn_close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogReject.dismiss();
            }
        });
    }

    public void showDialogAreSure(){
        dialogSure = new Dialog(getActivity());
        dialogSure.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogSure.setCancelable(false);
        dialogSure.setContentView(R.layout.sure_submit);
        dialogSure.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button yes =dialogSure.findViewById(R.id.btn_yes);
        Button no =dialogSure.findViewById(R.id.btn_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogSure.dismiss();
                dialogReject.show();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogSure.dismiss();
            }
        });

    }

}
