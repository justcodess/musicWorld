package com.zeynep.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    RelativeLayout r1;
    Button btngiriş,btnkayitol;
    TextView showtxt;

    EditText ad,sifre,email;
    SQLiteDatabase db;
    String userAd,userSifre,userMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1=findViewById(R.id.panelim);
        btngiriş=findViewById(R.id.btngiriş);
        btnkayitol=findViewById(R.id.btnkayıtol);
        ad=findViewById(R.id.editTextPersonName);
        sifre=findViewById(R.id.editTextPersonPass);
        email=findViewById(R.id.editTextPersonMail);
        showtxt=findViewById(R.id.txtshow);

        //SQL bağlama(tablo oluşturduk içindeki sutunları oluşturduk
        try{db=this.openOrCreateDatabase("login",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person(Id INTEGER PRIMARY KEY, ad VARCHAR, sifre VARCHAR, email VARCHAR)");

        }catch(Exception e){
            e.printStackTrace();

            }

        // Veritabanı şemasını güncelle
       //db.execSQL("ALTER TABLE person ADD COLUMN email TEXT;");
        //verileri okuyarak tabloya bastırdım

        Cursor c=db.rawQuery("SELECT*FROM person",null);
        int IDIndex=c.getColumnIndex("Id");
        int adIndex=c.getColumnIndex("ad");
        int sifreIndex=c.getColumnIndex("sifre");
        int emailIndex=c.getColumnIndex("email");
        while(c.moveToNext()){
            //showtxt.append("Id:"+c.getInt(IDIndex)+"Ad:"+c.getInt(adIndex)+"Şifre:"+c.getInt(sifreIndex)+
                   // "Email:"+c.getInt(emailIndex));
        }
        c.close();

        //görsel animasyonları aktifleştirme kısmı
        Animation anim1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo);
        Animation animPanel= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim2);

        //image1.startAnimation(anim1);
        r1.startAnimation(animPanel);



        btnkayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        btngiriş.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                userAd = ad.getText().toString();
                userSifre = sifre.getText().toString();
                userMail = email.getText().toString();

                if (!TextUtils.isEmpty(userAd) && !TextUtils.isEmpty(userSifre) && !TextUtils.isEmpty(userMail)) {
                    // Veritabanındaki verileri kontrol et
                    if (checkCredentials(userAd,userSifre,userMail)) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("intentAd",userAd);
                        intent.putExtra("intentSifre",userSifre);
                        intent.putExtra("intentEmail",userMail);

                        finish();
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim2, R.anim.logo);
                    } else {
                        Toast.makeText(MainActivity.this, "Kullanıcı adı, şifre veya e-posta yanlış girdiniz.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Kullanıcı adı, şifre ve e-posta boş olamaz.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean checkCredentials(String userAd, String userSifre, String userMail) {
        Cursor c = db.rawQuery("SELECT * FROM person WHERE ad=? AND sifre=? AND email=?", new String[]{userAd, userSifre, userMail});
        boolean result = c.moveToFirst();
        c.close();
        return result;
    }

    public void sqlprog(View view) {
        switch(view.getId()){
            case R.id.btnkayıtol:
                try{
                    db.execSQL("INSERT INTO person(ad,sifre,email) VALUES('"+ad.getText().toString()+"','"+sifre.getText().toString()+"'," +
                            "'"+email.getText().toString()+"')");
                    Toast.makeText(this, "veri eklendi", Toast.LENGTH_SHORT).show();
                    ad.setText("");
                    sifre.setText("");
                    email.setText("");
                    getData();
                }catch(Exception e){

                }
                break;

            case R.id.btngiriş:
                try{
                    db.execSQL("INSERT INTO person(ad,sifre,email) VALUES('"+ad.getText().toString()+"','"+sifre.getText().toString()+"'," +
                            "'"+email.getText().toString()+"')");
                    Toast.makeText(this, "veri eklendi", Toast.LENGTH_SHORT).show();
                    ad.setText("");
                    sifre.setText("");
                    email.setText("");
                    getData();
                }catch(Exception e){

                }
                break;
        }
    }

    private void getData() {
        showtxt.setText("");
        Cursor c = db.rawQuery("SELECT * FROM person", null);
        int IDIndex = c.getColumnIndex("Id");
        int adIndex = c.getColumnIndex("ad");
        int sifreIndex = c.getColumnIndex("sifre");
        int emailIndex = c.getColumnIndex("email");
        while (c.moveToNext()) {
            showtxt.append("Id:" + c.getInt(IDIndex) + " Ad:" + c.getString(adIndex) +
                    " Şifre:" + c.getString(sifreIndex) + " Email:" + c.getString(emailIndex));
        }
        c.close();
    }
}