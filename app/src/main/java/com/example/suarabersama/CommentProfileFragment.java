package com.example.suarabersama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CommentProfileFragment extends DialogFragment {

    EditText kota;
    EditText nama;

    public static String namaReq;
    public static String kotaReq;

    public CommentProfileFragment listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_comment_profile, null);

        kota = view.findViewById(R.id.kotakirimkomen);
        nama = view.findViewById(R.id.namaKirimKomen);

        builder.setView(view)
                .setTitle("Kosongkan untuk anonim")
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String namaTemp = nama.getText().toString();
                        String kotaTemp = kota.getText().toString();

                        CommentActivity.namaKomentar = namaTemp;
                        CommentActivity.kotaKomentar = kotaTemp;
                    }
                });


        return builder.create();
    }

}