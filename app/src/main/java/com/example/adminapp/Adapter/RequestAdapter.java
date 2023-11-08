package com.example.adminapp.Adapter;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.Classes.DataRequest;
import com.example.adminapp.Fragments.RequestFragment;
import com.example.adminapp.R;

import java.util.ArrayList;

public class RequestAdapter extends RecyclerView.Adapter<RequestViewHolder> {
    ArrayList<DataRequest> dataRequests =new ArrayList<>();

    Dialog dialogAccept ;
    Dialog dialogReject ;
    Dialog dialogAreSure ;


    public RequestAdapter(ArrayList<DataRequest> dataRequests, Dialog dialogAccept, Dialog dialogReject, Dialog dialogAreSure) {
        this.dataRequests = dataRequests;
        this.dialogAccept = dialogAccept;
        this.dialogReject = dialogReject;
        this.dialogAreSure = dialogAreSure;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_student,null,false);
        return new RequestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
        DataRequest dataRequest=dataRequests.get(position);
        holder.onBind(dataRequest,dialogAccept,dialogReject,dialogAreSure);
    }

    @Override
    public int getItemCount() {
        return dataRequests.size();
    }
}
class RequestViewHolder extends RecyclerView.ViewHolder{
    ImageView imgStudent;
    TextView oldGroup,newGroup;
    Button reject,accept;
    public RequestViewHolder(@NonNull View itemView) {
        super(itemView);
        imgStudent =itemView.findViewById(R.id.iv_imgStudent);
        oldGroup =itemView.findViewById(R.id.txt_oldGroup);
        newGroup =itemView.findViewById(R.id.txt_newGroup);
        reject =itemView.findViewById(R.id.btn_reject);
        accept =itemView.findViewById(R.id.btn_accept);
    }
    public void onBind(DataRequest dataRequest , Dialog dialogAccept, Dialog dialogReject, Dialog dialogAreSure){
        imgStudent.setImageResource(dataRequest.getImgStudent());
        oldGroup.setText(dataRequest.getOldGroup());
        newGroup.setText(dataRequest.getNewGroup());
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAccept.show();
            }
        });
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAreSure.show();
            }
        });
    }

}
