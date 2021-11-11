package com.maihoa.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        TextView tvSoBai, tvTenBai, tvThoiGian;
        Button btnChonBai, btnPlay, btnPause;

        Bundle bundle;
        BaiHat song;
        MediaPlayer mediaPlayer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("Trình nghe nhạc");
            anhxa();
            bundle = getIntent().getExtras();

            if (bundle != null) {
                song = (BaiHat) bundle.get("BaiHat");
            } else {
                song = new BaiHat(1, "Anh muốn em sống sao", R.raw.anh_muon_em_song_sao);
            }
            mediaPlayer = MediaPlayer.create(this, song.getFile());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
            tvThoiGian.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
            tvSoBai.setText(String.valueOf(song.getSoBai()));
            tvTenBai.setText(song.getTitle());

    /*
         btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if( mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                    }else {
                        mediaPlayer.start();
                    }
                }
            });
     */
        }


        private void anhxa() {
            tvSoBai = findViewById(R.id.tvSoBai);
            tvTenBai = findViewById(R.id.tvTenBai);
            tvThoiGian = findViewById(R.id.tvThoiGian);
            btnChonBai = findViewById(R.id.btnChonBai);
            btnPlay = findViewById(R.id.btnPlay);
            btnPause = findViewById(R.id.btnPause);

            btnChonBai.setOnClickListener(this);
            btnPlay.setOnClickListener(this);
            btnPause.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnChonBai:
                    startActivity(new Intent(this, ChonbaihatMainActivity2.class));
                    break;
                case R.id.btnPlay:
                    mediaPlayer.start();
                    Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnPause:
                    mediaPlayer.pause();
                    Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }