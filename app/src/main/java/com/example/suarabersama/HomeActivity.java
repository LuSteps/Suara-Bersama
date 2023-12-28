package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    ImageView navHome, navChat, navInfo, navAcc;
    FrameLayout navProfile;
    Button midInfo;

    ArrayList<String> nama =new ArrayList<String>(Arrays.asList("Anies Baswedan - Muhaimin Iskandar", "Prabowo Subianto - Gibran R.K.", "Ganjar Pranowo - Mahfud M.D."));
    ArrayList<String> judul =new ArrayList<String>(Arrays.asList("Paslon No.1", "Paslon No.2", "Paslon No.3"));
    RecyclerView paslon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        midInfo = findViewById(R.id.button2);

        navHome = findViewById(R.id.imageHome);
        navChat = findViewById(R.id.imageAntdesigncomm);
        navProfile = findViewById(R.id.frameHealthiconscit);
        navInfo = findViewById(R.id.imageSearch);
        navAcc = findViewById(R.id.imageUserOne);

        paslon = findViewById(R.id.recyclerViewPaslon);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        paslon.setLayoutManager(layoutManager);
        HomeAdapter ad = new HomeAdapter(HomeActivity.this, nama, judul);
        paslon.setAdapter(ad);

        midInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(mainIntent);
            }
        });

        navChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HomeActivity.this, CommentActivity.class);
                startActivity(mainIntent);
            }
        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HomeActivity.this, CapresActivity.class);
                startActivity(mainIntent);
            }
        });

        navInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(mainIntent);
            }
        });

        navAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}