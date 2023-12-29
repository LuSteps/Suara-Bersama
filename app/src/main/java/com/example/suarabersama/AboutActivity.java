package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {
    ImageView navHome, navChat, navInfo, navAcc;
    ImageView kpu,bawaslu,kominfo;
    FrameLayout navProfile;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        navHome = findViewById(R.id.imageHome);
        navChat = findViewById(R.id.imageAntdesigncomm);
        navProfile = findViewById(R.id.frameHealthiconscit);
        navInfo = findViewById(R.id.imageSearch);
        navAcc = findViewById(R.id.imageUserOne);

        kpu = findViewById(R.id.imgKPU);
        bawaslu = findViewById(R.id.imgBawaslu);
        kominfo = findViewById(R.id.imgKominfo);

        kpu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.kpu.go.id/");
                Intent inte = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(inte);

            }
        });

        bawaslu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.bawaslu.go.id/");
                Intent inte = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(inte);

            }
        });

        kominfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.kominfo.go.id/");
                Intent inte = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(inte);

            }
        });

        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AboutActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });

        navChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AboutActivity.this, CommentActivity.class);
                startActivity(mainIntent);
            }
        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AboutActivity.this, CapresActivity.class);
                startActivity(mainIntent);
            }
        });

//        navInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainIntent = new Intent(AboutActivity.this, AboutActivity.class);
//                startActivity(mainIntent);
//            }
//        });

        navAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AboutActivity.this, ProfileActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
