package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LoginRegActivity extends AppCompatActivity {

    Button login;
    LinearLayout google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_register);

        login = findViewById(R.id.button5);
        google = findViewById(R.id.linearRowflatcoloricon);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LoginRegActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LoginRegActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}