package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CommentActivity extends AppCompatActivity {
    ImageView navHome, navChat, navInfo, navAcc;
    FrameLayout navProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_box);

        navHome = findViewById(R.id.imageHome);
        navChat = findViewById(R.id.imageAntdesigncomm);
        navProfile = findViewById(R.id.frameHealthiconscit);
        navInfo = findViewById(R.id.imageSearch);
        navAcc = findViewById(R.id.imageUserOne);

        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CommentActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });

//        navChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainIntent = new Intent(CommentActivity.this, CommentActivity.class);
//                startActivity(mainIntent);
//            }
//        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CommentActivity.this, CapresActivity.class);
                startActivity(mainIntent);
            }
        });

        navInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CommentActivity.this, AboutActivity.class);
                startActivity(mainIntent);
            }
        });

        navAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CommentActivity.this, ProfileActivity.class);
                startActivity(mainIntent);
            }
        });

    }
}