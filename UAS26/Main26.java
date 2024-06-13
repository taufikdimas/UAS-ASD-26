package UAS26;

import java.util.Scanner;

public class Main26 {
    public static Kendaraan26[] daftarKendaraan = new Kendaraan26[10];
    public static TransaksiPajak26[] daftarTransaksi = new TransaksiPajak26[100];
    public static int jumlahKendaraan = 0;
    public static int jumlahTransaksi = 0;
    public static Scanner sc26 = new Scanner(System.in);

    public static void main(String[] args) {
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan26("S 4567 YV", "Basko", "Mobil", 2000, 2012, 4);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan26("N 4511 VS", "Arta", "Mobil", 2500, 2015, 3);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan26("AB 4321 A", "Wisnu", "Motor", 125, 2010, 2);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan26("B 1234 AG", "Sisa", "Motor", 150, 2020, 1);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Bayar Pajak");
            System.out.println("3. Tampilkan Seluruh Transaksi");
            System.out.println("4. Urutkan Transaksi Berdasar Nama Pemilik");
            System.out.println("5. Keluar");
            System.out.print("Pilih (1-5): ");

            int pilihan = sc26.nextInt();
            sc26.nextLine();
            switch (pilihan) {
                case 1:
                    Kendaraan26.daftarKendaraan();
                    break;
                case 2:
                    System.out.print("Masukkan nomor TNKB: ");
                    String noTNKB = sc26.nextLine();
                    bayarPajak(noTNKB);
                    break;
                case 3:
                    TransaksiPajak26.tampilkanSeluruhTransaksi();
                    break;
                case 4:
                    TransaksiPajak26.urutkanTransaksi();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    public static void bayarPajak(String noTNKB) {
        Kendaraan26 kendaraan = null;

        for (int i = 0; i < jumlahKendaraan; i++) {
            if (daftarKendaraan[i].noTNKB.equalsIgnoreCase(noTNKB)) {
                kendaraan = daftarKendaraan[i];
                break;
            }
        }

        if (kendaraan == null) {
            System.out.println("Kendaraan tidak ditemukan");
            return;
        }

        System.out.print("Masukkan Bulan Bayar: ");
        int bulanBayar;
        while (true) {
            if (sc26.hasNextInt()) {
                bulanBayar = sc26.nextInt();
                sc26.nextLine();
                break;
            } else {
                System.out.println("Input bulan bayar harus berupa angka.");
                sc26.nextLine();
                System.out.print("Masukkan Bulan Bayar: ");
            }
        }

        long nominalBayar = TransaksiPajak26.hitungNominalBayar(kendaraan);
        long denda = TransaksiPajak26.hitungDenda(kendaraan.bulanHarusBayar, bulanBayar);

        TransaksiPajak26 transaksi = new TransaksiPajak26(nominalBayar, denda, bulanBayar, kendaraan);
        daftarTransaksi[jumlahTransaksi++] = transaksi;

        System.out.println("Transaksi berhasil:");
        System.out.println(transaksi.toString());
    }
}
