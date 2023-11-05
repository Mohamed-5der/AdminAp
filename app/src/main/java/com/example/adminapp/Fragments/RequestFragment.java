package com.example.adminapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adminapp.Adapter.RequestAdapter;
import com.example.adminapp.Classes.DataRequest;
import com.example.adminapp.R;

import java.util.ArrayList;


public class RequestFragment extends Fragment {
    RecyclerView rvRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg, container, false);
        rvRequest=v.findViewById(R.id.rv_request);
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
        RequestAdapter requestAdapter =new RequestAdapter(dataRequests);
        rvRequest.setAdapter(requestAdapter);
        rvRequest.setLayoutManager(layoutManage);
        rvRequest.setHasFixedSize(true);

    }
}