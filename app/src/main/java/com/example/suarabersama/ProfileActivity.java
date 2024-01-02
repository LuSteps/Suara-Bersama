package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    ImageView navHome, navChat, navInfo, navAcc;
    FrameLayout navProfile;
    Button save;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch anonSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        navHome = findViewById(R.id.imageHome);
        navChat = findViewById(R.id.imageAntdesigncomm);
        navProfile = findViewById(R.id.frameHealthiconscit);
        navInfo = findViewById(R.id.imageSearch);
        navAcc = findViewById(R.id.imageUserOne);

        save = findViewById(R.id.button);

        String namaBackup = LoginRegActivity.username;

        anonSwitch = findViewById(R.id.switchmode);
        anonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean statusMode = anonSwitch.isChecked();
                if(!statusMode && namaBackup.length() == 0){
                    Toast.makeText(getApplicationContext(), "Silahkan login terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(statusMode){
                    LoginRegActivity.username = "";
                    Toast.makeText(getApplicationContext(), "Berkomentar dalam mode anonim", Toast.LENGTH_SHORT).show();

                    if(namaBackup.length()==0){
                        anonSwitch.setClickable(false);
                    }

                } else {
                    LoginRegActivity.username = namaBackup;
                    Toast.makeText(getApplicationContext(), "Berkomentar dengan nama anda", Toast.LENGTH_SHORT).show();
                }
            }
        });


        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });

        navChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ProfileActivity.this, CommentActivity.class);
                startActivity(mainIntent);
            }
        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ProfileActivity.this, CapresActivity.class);
                startActivity(mainIntent);
            }
        });

        navInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ProfileActivity.this, AboutActivity.class);
                startActivity(mainIntent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Profil anda telah disimpan.", Toast.LENGTH_SHORT).show();
            }
        });

//        navAcc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainIntent = new Intent(ProfileActivity.this, ProfileActivity.class);
//                startActivity(mainIntent);
//            }
//        });



    }
}