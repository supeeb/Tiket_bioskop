package com.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.model.tiket;
import com.model.transaksi;

public class transaksicontroller {
    private List<transaksi> listtransaksi;
    private List<tiket> listtiket;
    Scanner scan = new Scanner(System.in);

    public transaksicontroller (List<transaksi> listtransaksi, List<tiket> listtiket){
    this.listtransaksi = listtransaksi;
    this.listtiket = listtiket;
    shohwtiket();
    store();

    }
    void shohwtiket() {
        System.out.println(
                "______________________________________________________________________________");
        System.out.println(
                "| NO |    Jenis Tiket     |          Harga          |          Stok         |");
        System.out.println(
                "===============================================================================");
        int i = 1;
        for (tiket tiket  : listtiket) {
            System.out.printf("|%-4s|%-21s|%-25s|%-23s| %n", i++, tiket.getJenis_tiket(),
                    Utility.toRupiah(tiket.getHargaTiket()),
                    tiket.getStok());
        }
    }
    void store() {
        String inputan = "Y";
        do {

            System.out.println("\n~Ketik 0 kembali ke menu utama-");
            System.out.println("Input No :");
            int lokasitiket = Utility.inputInt(scan.nextLine());
            if (lokasitiket > 0 && --lokasitiket < listtiket.size()) {

                System.out.println("Jumlah");
                int jumlah = Utility.inputInt(scan.nextLine());
                int stok = listtiket.get(lokasitiket).getStok();

                if (jumlah <= stok) {

                    listtiket.get(lokasitiket).setStok(stok -= jumlah);

                    String namatiket = listtiket.get(lokasitiket).getJenis_tiket();
                    int Harga = listtiket.get(lokasitiket).getHargaTiket();
                    LocalDateTime jam = listtiket.get(lokasitiket).getNow();
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("Jenis Tiket |%-22s|Harga  |%-26s|Stok|%-24s| %n",
                            namatiket,
                            Utility.toRupiah(Harga),
                            listtiket.get(lokasitiket).getStok());

                    System.out.println("total : " + Utility.toRupiah(jumlah * Harga));
                    transaksi Transaksi = new transaksi();
                    Transaksi.setNow(jam);
                    Transaksi.setJenis_tiket(namatiket);
                    Transaksi.setQty(jumlah);
                    Transaksi.setHarga_tiket(Harga);                    
                    listtransaksi.add(Transaksi);
                    System.out.println("Pemesanan Berhasil");
                } else {
                    System.out.println("Jumlah Pemesanan Melebihi Stok");
                }
            }

            System.out.println("apakah ingin melanjutkan transaksi (Y/N) ? ");
            inputan = scan.nextLine();
        } while (inputan.equalsIgnoreCase("y"));
    }
}
