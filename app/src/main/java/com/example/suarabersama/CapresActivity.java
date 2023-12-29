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
import android.widget.TextView;

import org.w3c.dom.Comment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

    RecyclerView comments;

    public static ArrayList<String> headline = new ArrayList<String>(Arrays.asList("Kinerja Terbukti", "Akhlak Teruji", "Kurang Professional"));
    public static ArrayList<String> namaKomen = new ArrayList<String>(Arrays.asList("Wawan Sudrajat", "Andi Bumiputera", "Budi Soegija"));
    public static ArrayList<String> komentar = new ArrayList<String>(Arrays.asList(
            "Daerah yang dipimpin sebelumnya sudah bagus. Beri peluang untuk memperbaiki Indonesia bagi pasangan calon ini.",
            "Sopan santun dari kedua kandidat tersebut merepresentasikan hati yang bersih. Rakyat butuh pemimpin yang bersih hatinya.",
            "Hanya mampu beretorika dan kurang mampu mengantarkan performa yang bagus. Kurang layak maju memimpin Indonesia yang lebih luas."));

    public static ArrayList<String> kota = new ArrayList<String >(Arrays.asList("Sidoarjo", "Pamulang", "Cikini"));

    public void addData(ArrayList<String> target, String x){
        if(x!=null){
            target.add(x);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capres_page);

        if(Objects.equals(getIntent().getStringExtra("fromComment"), "TRUE")){
            nomor = CommentActivity.selected;
        } else{
            Intent intent = getIntent();
            if (intent != null) {
                nomor = intent.getIntExtra("nomor", 0);
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

        addData(headline, CommentActivity.judulKomentar);
        addData(namaKomen, CommentActivity.namaKomentar);
        addData(kota, CommentActivity.kotaKomentar);
        addData(komentar, CommentActivity.isiKomentar);

        CommentActivity.judulKomentar = null;
        CommentActivity.namaKomentar = null;
        CommentActivity.kotaKomentar = null;
        CommentActivity.isiKomentar = null;


        comments = findViewById(R.id.recyclerCapresPage);
        LinearLayoutManager linlayman = new LinearLayoutManager(getApplicationContext());
        comments.setLayoutManager(linlayman);
        CapresAdapter ad = new CapresAdapter(CapresActivity.this, headline, namaKomen, komentar, kota);
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