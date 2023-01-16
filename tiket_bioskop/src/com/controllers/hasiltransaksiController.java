package com.controllers;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.Utility;
import com.model.transaksi;

public class hasiltransaksiController {
  private List<transaksi> listtransaksi;
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
  public hasiltransaksiController(List<transaksi>listtransaksi){
    this.listtransaksi = listtransaksi;
    showData();

  }
    void showData() {
        System.out.println(
                "________________________________________________________________________________________________________________");
        System.out.println(
                "| NO |      Tanggal      |     Jenis Tiket     |   QTY      |          Harga          |          Total         |");
        System.out.println(
                "================================================================================================================");
        int i = 1;
        for (transaksi Transaksi : listtransaksi) {
            System.out.printf("|%-4s|%-10s|%-21s|%-12s|%-25s|%-25s| %n",
                    i++,
                    Transaksi.getNow().format(dtf),
                    Transaksi.getHarga_tiket(),
                    Transaksi.getQty(),
                    Utility.toRupiah(Transaksi.getHarga_tiket()),
                    Utility.toRupiah(Transaksi.getHarga_tiket() * Transaksi.getQty()));
        }
    }
}
