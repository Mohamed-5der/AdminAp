package com.example.adminapp.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.adminapp.R;

public class ChangeLanguageAcivity extends AppCompatActivity {
ImageButton back;
ImageView btn_arabic,btn_english;
private String request_code_en="1";
private String request_code_ar="2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language_acivity);
        back=findViewById(R.id.btn_back);
        btn_arabic=findViewById(R.id.btn_check_ar);
        btn_english=findViewById(R.id.btn_check_en);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        checkedLanguage();

    }
    public void checkedLanguage(){
        btn_arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_arabic.setImageResource(R.drawable.rb_checked_icon);
                btn_english.setImageResource(R.drawable.rb_noncheck_icon);

            }
        });
        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_english.setImageResource(R.drawable.rb_checked_icon);
                btn_arabic.setImageResource(R.drawable.rb_noncheck_icon);

            }
        });

    }
}