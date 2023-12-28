package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    ImageView navHome, navChat, navInfo, navAcc;
    FrameLayout navProfile;
    Button midInfo;


    LinearLayout capres1, capres2, capres3;

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

        capres1 = findViewById(R.id.linearColumnpaslonnoOne);
//        capres2 = findViewById(R.id.)

        //        navHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainIntent = new Intent(HomeActivity.this, HomeActivity.class);
//                startActivity(mainIntent);
//            }
//        });

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