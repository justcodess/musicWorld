package com.zeynep.loginpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myreycadaptor extends RecyclerView.Adapter<myreycadaptor.Myholder> {
    private ArrayList<musics> şarkılar;

    public myreycadaptor(ArrayList<musics> şarkılar){
        this.şarkılar=şarkılar;
    }
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.musicitem,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        musics currentMusic = şarkılar.get(position);

        if (currentMusic != null) {
            holder.music_logo.setImageResource(currentMusic.getLogo());
            holder.şarkı_adı.setText(currentMusic.getŞarkı());
            holder.sanatçı_adı.setText(currentMusic.getSanatçı());
        } else {
            // Eğer currentMusic null ise, boş bir varsayılan değeri kullanabilirsiniz
            holder.music_logo.setImageResource(R.drawable.ava
                    );
            holder.sanatçı_adı.setText("");
            holder.şarkı_adı.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return şarkılar.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView şarkı_adı,sanatçı_adı;
        ImageView music_logo;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            music_logo=itemView.findViewById(R.id.musiclogo);
            şarkı_adı=itemView.findViewById(R.id.şarkıadı);
            sanatçı_adı=itemView.findViewById(R.id.sanatçıadı);

        }
    }
}
