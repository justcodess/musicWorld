package com.zeynep.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomnavim;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomnavim=findViewById(R.id.bnavi);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new homeFragment()).commit();

        bottomnavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new homeFragment()).commit();
                        break;
                    case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new searchFragment()).commit();
                    break;
                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new personFragment()).commit();
                        break;
                }
                return true;
            }
        });

            }




    @Override
    public void onBackPressed() {
        Intent geriIntent=new Intent(MainActivity2.this,MainActivity.class);
        finish();
        startActivity(geriIntent);
        //geri döndüğünde girdiğin bilgiler siilinir
    }
}