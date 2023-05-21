package com.zeynep.loginpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class personFragment extends Fragment {

    //Button btngiriş;
    public TextView txtshow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_person, container, false);
        super.onCreate((savedInstanceState));
        //btngiriş.findViewById(R.id.btngiriş);

        TextView txtshow = view.findViewById(R.id.txtshow);
        //txtshow.setText("");


        // MainActivity'den gelen verileri al

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            String ad = bundle.getString("intentAd");
            String sifre = bundle.getString("intentSifre");
            String email = bundle.getString("intentEmail");

            // TextView'a verileri yazdır
            String text = "  Ad: " + ad + "\n  Şifre: " + sifre + "\n  Email: " + email;
            txtshow.setText(text);
        }

        //txtshow.setText("blabala");



        return view;
    }



}