package com.zeynep.loginpage;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.zeynep.loginpage.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMain3Binding binding;
    Button btnKayitol;
    EditText editAdsoyad,editpassaword,editEmail;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnKayitol = findViewById(R.id.btnkayıtol);
        editAdsoyad = findViewById(R.id.editTextPersonName);
        editpassaword = findViewById(R.id.editTextPersonPass);
        editEmail = findViewById(R.id.editTextPersonMail);

        //SQL bağlama(tablo oluşturduk içindeki sutunları oluşturduk
        try {
            db = this.openOrCreateDatabase("login", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person(Id INTEGER PRIMARY KEY,ad VARCHAR,sifre VARCHAR,email VARCHAR)");

        } catch (Exception e) {
            e.printStackTrace();

        }


        btnKayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad = editAdsoyad.getText().toString();
                String sifre = editpassaword.getText().toString();
                String email = editEmail.getText().toString();

                // Verileri veritabanına ekleme işlemi
                ContentValues values = new ContentValues();
                values.put("ad", ad);
                values.put("sifre", sifre);
                values.put("email", email);

                long result = db.insert("person", null, values);
                if (result != -1) {
                    Toast.makeText(MainActivity3.this, "Bilgiler kaydedildi.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity3.this, "Bir hata oluştu. Bilgiler kaydedilemedi.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        // Veritabanı bağlantısını kapatma
        if (db != null) {
            db.close();
        }
    }




}