package com.example.elfari.clearmind.Models;

/**
 * Created by Elfari on 11/9/2017.
 */
public class MySound {
    public int lagu, gambar, seffect, background;
    public String judul;


    public MySound(int lagu, String judul, int seffect, int background, int gambar) {
        this.lagu = lagu;
        this.judul = judul;
        this.seffect = seffect;
        this.background = background;
        this.gambar = gambar;
    }

    public int getLagu() {
        return lagu;
    }

    public void setLagu(int lagu) {
        this.lagu = lagu;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getSeffect() {
        return seffect;
    }

    public void setSeffect(int seffect) {
        this.seffect = seffect;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}
