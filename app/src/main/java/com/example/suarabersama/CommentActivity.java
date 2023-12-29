package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class CommentActivity extends AppCompatActivity {

    String targetKomen = "Paslon 1";
    ImageView navHome, navChat, navInfo, navAcc;
    FrameLayout navProfile;
    Button kirim;
    EditText judulIsi, komenIsi;

    public static int selected = 0;
    public static String namaKomentar, kotaKomentar, isiKomentar, judulKomentar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_box);

        navHome = findViewById(R.id.imageHome);
        navChat = findViewById(R.id.imageAntdesigncomm);
        navProfile = findViewById(R.id.frameHealthiconscit);
        navInfo = findViewById(R.id.imageSearch);
        navAcc = findViewById(R.id.imageUserOne);

        kirim = findViewById(R.id.kirimbutton);

        judulIsi = findViewById(R.id.tulisjudulartikel);
        komenIsi = findViewById(R.id.tuliskanpendapattext);

        Spinner spin = findViewById(R.id.spinneritem);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_array_comment, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                targetKomen = name;
                // Perform your action with the name here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });;

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

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judulKomentar = judulIsi.getText().toString();
                isiKomentar = komenIsi.getText().toString();
                namaKomentar = LoginRegActivity.username;
                kotaKomentar = "Jakarta";

                switch (targetKomen) {
                    case "Paslon 1":
                        selected = 0;
                        break;
                    case "Paslon 2":
                        selected = 1;
                        break;
                    case "Paslon 3":
                        selected = 2;
                        break;
                }
                Intent nextAct = new Intent(getApplicationContext(), CapresActivity.class).putExtra("fromComment", "TRUE");
                startActivity(nextAct);

                Toast.makeText(getApplicationContext(), "Komentar anda telah ditambahkan!.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}