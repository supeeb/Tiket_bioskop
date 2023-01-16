package com.model;

import java.time.LocalDateTime;

public class transaksi {
    private String jenis_tiket;
    private int qty;
    private int harga_tiket;
    private LocalDateTime now= LocalDateTime.now();
        
    
    public String getJenis_tiket() {
        return jenis_tiket;
    }

    public void setJenis_tiket(String jenis_tiket) {
        this.jenis_tiket = jenis_tiket;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getHarga_tiket() {
        return harga_tiket;
    }

    public void setHarga_tiket(int harga_tiket) {
        this.harga_tiket = harga_tiket;
    }
   

}
