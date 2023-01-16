package com.model;

import java.time.LocalDateTime;

public class tiket {
    private String jenis_tiket;
    private int HargaTiket, stok;
    private LocalDateTime now= LocalDateTime.now();
    public int getHargaTiket() {
        return HargaTiket;
    }

    public void setHargaTiket(int hargaTiket) {
        HargaTiket = hargaTiket;
    }

    public String getJenis_tiket() {
        return jenis_tiket;
    }

    public void setJenis_tiket(String jenis_tiket) {
        this.jenis_tiket = jenis_tiket;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

}
