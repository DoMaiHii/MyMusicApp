package com.maihoa.mymusicapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChonbaihatMainActivity2 extends AppCompatActivity implements View.OnClickListener  {
    TextView tvSoBai;
    Button btnBai1, btnBai2, btnBai3, btnBai4, btnBai5, btnBai6, btnChon;
    ArrayList<BaiHat> arrayBaiHat;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonbaihat_main2);
        setTitle("Chọn bài hát");

        Anhxa();
        AddBaiHat();


    }

    private void Anhxa() {
        tvSoBai = findViewById(R.id.tvSoBai);
        btnBai1 = findViewById(R.id.btnBai1);
        btnBai2 = findViewById(R.id.btnBai2);
        btnBai3 = findViewById(R.id.btnBai3);
        btnBai4 = findViewById(R.id.btnBai4);
        btnBai5 = findViewById(R.id.btnBai5);
        btnBai6 = findViewById(R.id.btnBai6);
        btnChon = findViewById(R.id.btnChon);

        btnBai1.setOnClickListener(this);
        btnBai2.setOnClickListener(this);
        btnBai3.setOnClickListener(this);
        btnBai4.setOnClickListener(this);
        btnBai5.setOnClickListener(this);
        btnBai6.setOnClickListener(this);
        btnChon.setOnClickListener(this);
    }



    private void AddBaiHat() {
        arrayBaiHat = new ArrayList<>();
        arrayBaiHat.add(new BaiHat(1,"Anh muốn em sống sao", R.raw.anh_muon_em_song_sao));
        arrayBaiHat.add(new BaiHat(2,"Có chàng trai viết lên cây",R.raw.co_trang_chai_viet_len_cay));
        arrayBaiHat.add(new BaiHat(3,"Gương mặt lạ lẫm",R.raw.guong_mat_la_lam));
        arrayBaiHat.add(new BaiHat(4,"Nước ngoài",R.raw.nuoc_ngoai));
        arrayBaiHat.add(new BaiHat(5,"Váy cưới",R.raw.vay_cuoi));
        arrayBaiHat.add(new BaiHat(6,"Yêu em rất nhiều",R.raw.yeu_em_rat_nhieu));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBai1:
                position = 0;
                tvSoBai.setText("1");
                break;
            case R.id.btnBai2:
                position = 1;
                tvSoBai.setText("2");
                break;
            case R.id.btnBai3:
                position = 2;
                tvSoBai.setText("3");
                break;
            case R.id.btnBai4:
                position = 3;
                tvSoBai.setText("4");
                break;
            case R.id.btnBai5:
                position = 4;
                tvSoBai.setText("5");
                break;
            case R.id.btnBai6:
                position = 5;
                tvSoBai.setText("6");
                break;
            case R.id.btnChon:
                Intent intent = new Intent(this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("BaiHat",arrayBaiHat.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                break;
        }
    }
}