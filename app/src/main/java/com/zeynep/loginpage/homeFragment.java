package com.zeynep.loginpage;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class homeFragment extends Fragment {

    Button btn;
    private RecyclerView benimrecyc;
    private ArrayList<musics> şarkılar;
    private myreycadaptor myadaptor;

    @SuppressLint("MissingInflatedId")


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        benimrecyc = view.findViewById(R.id.myrecycle);
        şarkılar = new ArrayList<>();
        myadaptor = new myreycadaptor(şarkılar);
        benimrecyc.setAdapter(myadaptor);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        benimrecyc.setLayoutManager(layoutManager); // LayoutManager'ı RecyclerView'a ekledik

        arrayyap();
        myadaptor.notifyDataSetChanged();

       return view;
    }

    private void arrayyap() {
        şarkılar.add(new musics(R.drawable.istbey,"İstanbul Beyefendisi","Yaşlı Amca"));
        şarkılar.add(new musics(R.drawable.istbey,"Giderdi Hoşuma","Yaşlı Amca"));
        şarkılar.add(new musics(R.drawable.miley,"Flowers","Miley Cyrus"));
        şarkılar.add(new musics(R.drawable.love,"Lovestick","Alan Walker"));
        şarkılar.add(new musics(R.drawable.istbey," Yıldızlara Bak","Yaşlı Amca"));
        şarkılar.add(new musics(R.drawable.teo,"Paris","The Chainsmokers"));
        şarkılar.add(new musics(R.drawable.love,"Shut Up","Alan Walker"));
        şarkılar.add(new musics(R.drawable.iki,"Bütün İstanbul Biliyor","İkiye On Kala"));
        şarkılar.add(new musics(R.drawable.che,"Karma Chameleon","Culture Club"));
        şarkılar.add(new musics(R.drawable.direkt,"Hasret","Direc-t"));
        şarkılar.add(new musics(R.drawable.dur,"Dursun Zaman","Manga,Göksel"));
        şarkılar.add(new musics(R.drawable.bos,"Boş Ders Şarkısı","Feridun Düzağaç"));


        şarkılar.add(new musics(R.drawable.teo,"Serseri","Teoman"));
        şarkılar.add(new musics(R.drawable.onmy,"On My Way","Alan Walker"));

        şarkılar.add(new musics(R.drawable.teo,"N'apim Tabiatım Böyle","Teoman"));
        şarkılar.add(new musics(R.drawable.ava,"Not Your Barbie Girl","Ava Max"));
        şarkılar.add(new musics(R.drawable.teo,"Renkli Rüyalar Oteli","Teoman"));
        şarkılar.add(new musics(R.drawable.teo,"Paramparça","Teoman"));
        şarkılar.add(new musics(R.drawable.pera,"Gökyüzüm","Pera"));
        şarkılar.add(new musics(R.drawable.istbey,"Ve Ben","Yaşlı Amca"));
        şarkılar.add(new musics(R.drawable.istbey,"Hep De Yorgun","Yaşlı Amca"));
        şarkılar.add(new musics(R.drawable.onmy,"Different World","Alan Walker"));
        şarkılar.add(new musics(R.drawable.istbey,"Sal Beni","Yaşlı Amca"));
        şarkılar.add(new musics(R.drawable.swif,"Cruel Summer","Taylor Swift"));




    }
}