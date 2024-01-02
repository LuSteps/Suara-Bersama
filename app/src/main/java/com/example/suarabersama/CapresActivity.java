package com.example.suarabersama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Comment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CapresActivity extends AppCompatActivity {
    public static int nomor = 1;

    DBHandlerComment commentDB = new DBHandlerComment(CapresActivity.this);

    ArrayList<String> capres = new ArrayList<String>(Arrays.asList("Anies Baswedan", "Prabowo Subianto", "Ganjar Pranowo"));
    ArrayList<String> cawapres = new ArrayList<String>(Arrays.asList("Muhaimin Iskandar", "Gibran R.K.", "Mahfud M.D."));
    ArrayList<String> judul =new ArrayList<String>(Arrays.asList("Paslon No.1", "Paslon No.2", "Paslon No.3"));

    ImageView navHome, navChat, navInfo, navAcc;
    FrameLayout navProfile;

    Button berpendapat;

    TextView capresNama, cawapresNama;
    TextView visi, misi;
    TextView judulView;

    RecyclerView comments;

    SQLiteDatabase commentDBView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capres_page);

        if(Objects.equals(getIntent().getStringExtra("fromComment"), "TRUE")){
            nomor = CommentActivity.selected;
        } else{
            Intent intent = getIntent();
            if (intent != null) {
                nomor = intent.getIntExtra("nomor", 1);
            }
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


        CommentActivity.judulKomentar = null;
        CommentActivity.namaKomentar = null;
        CommentActivity.kotaKomentar = null;
        CommentActivity.isiKomentar = null;

        String query = "SELECT * " +
                "FROM Komentar " +
                "WHERE pasangan_calon = " + (nomor+1);


        commentDBView = commentDB.getReadableDatabase();
        Cursor cursor = commentDBView.rawQuery(query, null);

        ArrayList<String> komentar = new ArrayList<String>();
        ArrayList<String> headline = new ArrayList<String>();
        ArrayList<String> namaKomen = new ArrayList<String>();
        ArrayList<String> kota = new ArrayList<String>();

        if(cursor.moveToFirst()){
            do{
                headline.add(cursor.getString(5));
                namaKomen.add(cursor.getString(3));
                komentar.add(cursor.getString(4));
                kota.add(cursor.getString(2));
            }while(cursor.moveToNext());
        }
        cursor.close();

        comments = findViewById(R.id.recyclerCapresPage);
        LinearLayoutManager linlayman = new LinearLayoutManager(getApplicationContext());
        comments.setLayoutManager(linlayman);
        CapresAdapter ad = new CapresAdapter(CapresActivity.this,  headline, namaKomen, komentar, kota);
        comments.setAdapter(ad);



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