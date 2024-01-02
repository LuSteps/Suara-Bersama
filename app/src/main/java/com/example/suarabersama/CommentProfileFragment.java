package com.example.suarabersama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

    public CommentProfileFragments listener;

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
                        namaReq = nama.getText().toString();
                        kotaReq = kota.getText().toString();

                        if(namaReq.equals("Anonim")){
                            namaReq = CommentActivity.namaKomentar;
                        }
                        if(kotaReq.equals("Jakarta")){
                            kotaReq = CommentActivity.kotaKomentar;
                        }

//                        CommentActivity.namaKomentar = namaReq;
//                        CommentActivity.kotaKomentar = kotaReq;

                        listener.applyText(namaReq, kotaReq);

                        Intent nextAct = new Intent(getContext(), CapresActivity.class).putExtra("fromComment", "TRUE");
                        startActivity(nextAct);

                    }
                });


        return builder.create();
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener = (CommentProfileFragments) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }

    }

    public interface CommentProfileFragments{
        void applyText(String nama, String kota);
    }

}