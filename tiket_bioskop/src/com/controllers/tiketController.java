package com.controllers;

import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.model.tiket;

public class tiketController {
    private List<tiket> listtiket;
    static Scanner scan = new Scanner(System.in);

    // ini adalah konstruktor unutk BarangController
    public tiketController(List<tiket> listtiket) {
        this.listtiket = listtiket;
        DaftarTiket();
    }

    void DaftarTiket() {
        int pilih = 0;
        do {
            show();

            System.out.println("[1] Input Tiket");
            System.out.println("[2] Update Tiket");
            System.out.println("[3] Batalkkan Pesanan Tiket");
            System.out.println("[0] Halaman Utama");
            System.out.println("Pilih Menu \n ============");
            pilih = Utility.inputInt(scan.nextLine());

            switch (pilih) {
                case 0:
                    System.out.println("");
                    break;
                case 1:
                    store();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    destroy();
                    break;
                default:
                    break;
            }
        } while (pilih != 0);
    }

    void show() {
        System.out.println(
                "______________________________________________________________________________");
        System.out.println(
                "| NO |     Jenis Tiket     |          Harga          |          Stok         |");
        System.out.println(
                "===============================================================================");
        int i = 1;
        for (tiket tiket : listtiket) {
            System.out.printf("|%-4s|%-21s|%-25s|%-23s| %n", i++, tiket.getJenis_tiket(),
                    Utility.toRupiah(tiket.getHargaTiket()),
                    tiket.getStok());
        }
    }

    void store() {
        
        tiket b = new tiket();
        System.out.println("Masukkan Jenis Tiket");
        b.setJenis_tiket(scan.nextLine());
        System.out.println("Masukkan Harga");
        b.setHargaTiket(Utility.inputInt(scan.nextLine()));
        System.out.println("Masukkan Stok Barang");
        b.setStok(Utility.inputInt(scan.nextLine()));
        listtiket.add(b);
    }

    void update() {
        System.out.println("======Ubah Pesanan======");
        System.out.println("~Kosongkan Data Jika Tidak Ingin Dirubah~");
        System.out.println("~Ketik 0 kembali ke menu utama-");
        System.out.println("Pilih NO :");
        int inputan = Utility.inputInt(scan.nextLine());
        if (inputan > 0 && --inputan < listtiket.size()) {
            System.out.println("Jenis Tiket");
            String nama = scan.nextLine();

            if (!nama.equals("")) {
                listtiket.get(inputan).setJenis_tiket(nama);
            }
            System.out.println("Masukkan Harga");
            int harga = Utility.inputInt(scan.nextLine());

            if (harga >= 0) {
                listtiket.get(inputan).setHargaTiket(harga);
            }

            System.out.println("Masukkan Stok");
            int stok = Utility.inputInt(scan.nextLine());
            if (stok >= 0) {
                listtiket.get(inputan).setStok(stok);
            }
        }
    }

    void destroy() {
        System.out.println("Masukkan No");
        int inputan = Utility.inputInt(scan.nextLine());

        if (inputan > 0 && --inputan < listtiket.size()) {
            listtiket.remove(inputan);
            System.out.println("\n Data Berhasil Dihapus \n");
        }
    }
}
