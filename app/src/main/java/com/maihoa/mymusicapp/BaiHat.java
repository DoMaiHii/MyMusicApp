package com.maihoa.mymusicapp;

import java.io.Serializable;

public class BaiHat implements Serializable {
    private int soBai;
    private String title;
    private int file;

    public BaiHat() {
    }

    public BaiHat(int soBai, String title, int file) {
        this.soBai = soBai;
        this.title = title;
        this.file = file;
    }

    public int getSoBai() {
        return soBai;
    }

    public void setSoBai(int soBai) {
        this.soBai = soBai;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }
}
