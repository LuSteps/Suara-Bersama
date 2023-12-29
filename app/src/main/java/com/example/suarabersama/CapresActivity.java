package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CapresActivity extends AppCompatActivity {
    public static int nomor = 0;

    ArrayList<String> capres = new ArrayList<String>(Arrays.asList("Anies Baswedan", "Prabowo Subianto", "Ganjar Pranowo"));
    ArrayList<String> cawapres = new ArrayList<String>(Arrays.asList("Muhaimin Iskandar", "Gibran R.K.", "Mahfud M.D."));
    ArrayList<String> judul =new ArrayList<String>(Arrays.asList("Paslon No.1", "Paslon No.2", "Paslon No.3"));

    ImageView navHome, navChat, navInfo, navAcc;
    FrameLayout navProfile;

    Button berpendapat;

    TextView capresNama, cawapresNama;
    TextView visi, misi;
    TextView judulView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capres_page);

        Intent intent = getIntent();
        if (intent != null) {
            nomor = intent.getIntExtra("nomor", 0);
        }

        navHome = findViewById(R.id.imageHome);
        navChat = findViewById(R.id.imageAntdesigncomm);
        navProfile = findViewById(R.id.frameHealthiconscit);
        navInfo = findViewById(R.id.imageSearch);
        navAcc = findViewById(R.id.imageUserOne);

        judulView = findViewById(R.id.judulPaslon);

        berpendapat = findViewById(R.id.btnMulaiBerpendapat);

        capresNama = findViewById(R.id.txtCharlie);
        cawapresNama = findViewById(R.id.txtChaplin);
        visi = findViewById(R.id.txtDescription);
        misi = findViewById(R.id.txtDescriptionOne);


        capresNama.setText(capres.get(nomor));
        cawapresNama.setText(cawapres.get(nomor));
        judulView.setText(judul.get(nomor));


        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CapresActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });

        navChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CapresActivity.this, CommentActivity.class);
                startActivity(mainIntent);
            }
        });

//        navProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainIntent = new Intent(CapresActivity.this, CapresActivity.class);
//                startActivity(mainIntent);
//            }
//        });

        navInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CapresActivity.this, AboutActivity.class);
                startActivity(mainIntent);
            }
        });

        navAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CapresActivity.this, ProfileActivity.class);
                startActivity(mainIntent);
            }
        });

        berpendapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CapresActivity.this, CommentActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}