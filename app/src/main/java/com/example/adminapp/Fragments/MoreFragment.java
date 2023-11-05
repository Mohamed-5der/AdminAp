package com.example.adminapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.Activites.ChangeLanguageAcivity;
import com.example.adminapp.Activites.ContactUsActivity;
import com.example.adminapp.Activites.PrivacyPolicyActivity;
import com.example.adminapp.Activites.ProfileAcivity;
import com.example.adminapp.Activites.TermsAndConditionsActivity;
import com.example.adminapp.R;

public class MoreFragment extends Fragment {
TextView txt_profile,txt_terms,txt_contact,txt_logout,txt_privacy,txt_changeLanguage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_more, container, false);
        txt_profile = v.findViewById(R.id.txt_profile);
        txt_terms = v.findViewById(R.id.txt_termsAndConditions);
        txt_contact = v.findViewById(R.id.txt_contactUs);
        txt_logout = v.findViewById(R.id.txt_logOut);
        txt_changeLanguage = v.findViewById(R.id.txt_changeLanguage);
        txt_privacy = v.findViewById(R.id.txt_privacy);

        txt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), ProfileAcivity.class);
                startActivity(intent);
            }
        });
        txt_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), TermsAndConditionsActivity.class);
                startActivity(intent);
            }
        });
        txt_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), ContactUsActivity.class);
                startActivity(intent);
            }
        });
        txt_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });
        txt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Log Out", Toast.LENGTH_SHORT).show();
            }
        });
        txt_changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), ChangeLanguageAcivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}