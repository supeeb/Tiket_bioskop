package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.controllers.hasiltransaksiController;
import com.controllers.tiketController;
import com.controllers.transaksicontroller;
import com.model.tiket;
import com.model.transaksi;

public class App {
    static Scanner scan = new Scanner(System.in);
    public static final Locale locale = new Locale("in", "ID");

    public static void main(String[] args) throws Exception {
        List<tiket> listtiket = new ArrayList<tiket>();
        List<transaksi>listtransaksi = new ArrayList<transaksi>();

        do {
            System.out.println("=== TODO LIST APP ===");
            System.out.println("[1] Jenis Tiket");
            System.out.println("[2] Transaksi");
            System.out.println("[3] Laporan Transaksi");
            System.out.println("---------------------");
            System.out.print("Pilih menu> ");
        } while (showMenu(listtiket, listtransaksi) != 0);
    }

    public static int showMenu(List<tiket> ltiket, List<transaksi> ltransaksi) {
        int selectedMenu = Utility.inputInt(scan.nextLine());

        switch (selectedMenu) {
            case 1:
                new tiketController(ltiket);
                break;

            case 2:
            new transaksicontroller(ltransaksi, ltiket);
            break;
             
            case 3:
            new hasiltransaksiController(ltransaksi);
            break;

        }

        return selectedMenu;
    }
}