package com.example.adminapp.Activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adminapp.Fragments.HomeFragment;
import com.example.adminapp.Fragments.MoreFragment;
import com.example.adminapp.Fragments.RequestFragment;
import com.example.adminapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment = new HomeFragment();
    MoreFragment moreFragment = new MoreFragment();

    RequestFragment requestFragment = new RequestFragment();

    BottomNavigationView bottomNavigationView;
    TextView namePage;
    ImageButton notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namePage=findViewById(R.id.txt_namePage);
        notification=findViewById(R.id.btn_notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
        bottomNavigationView =  findViewById(R.id.bottom_navigation);
        selectedNavigationItem();
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        reSelectedNavigationItem();

    }
    public void selectedNavigationItem(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, homeFragment)
                                .commit();
                        namePage.setText(R.string.home);
                        return true;

                    case R.id.action_request:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, requestFragment).commit();
                        namePage.setText(R.string.requests);
                        return true;
                    case R.id.action_more:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, moreFragment).commit();
                        namePage.setText(R.string.more);
                        return true;

                }
                return false;
            }
        });
    }
    public void reSelectedNavigationItem(){
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        // Handle reselection of the "Home" item
                        break;

                    case R.id.action_request:
                        // Handle reselection of the "Files" item
                        break;
                    case R.id.action_more:
                        // Handle reselection of the "More" item
                        break;
                }
            }
        });
    }
}