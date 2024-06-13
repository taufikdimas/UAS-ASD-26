package UAS26;

public class TransaksiPajak26 {
    private static int autoIncrement = 1;
    public int kode;
    public long nominalBayar;
    public long denda;
    public int bulanBayar;
    public Kendaraan26 kendaraan;

    public TransaksiPajak26(long nominalBayar, long denda, int bulanBayar, Kendaraan26 kendaraan) {
        this.kode = autoIncrement++;
        this.nominalBayar = nominalBayar;
        this.denda = denda;
        this.bulanBayar = bulanBayar;
        this.kendaraan = kendaraan;
    }

    public String toString() {
        return "Kode: " + kode + ", TNKB: " + kendaraan.noTNKB + ", Nama: " + kendaraan.nama + ", Nominal Bayar: "
                + nominalBayar + ", Denda: " + denda + ", Bulan Bayar: " + bulanBayar;
    }

    public static long hitungNominalBayar(Kendaraan26 kendaraan) {
        long nominal = 0;
        switch (kendaraan.jenis.toLowerCase()) {
            case "motor":
                if (kendaraan.cc < 100)
                    nominal = 100000;
                else if (kendaraan.cc <= 250)
                    nominal = 250000;
                else
                    nominal = 500000;
                break;
            case "mobil":
                if (kendaraan.cc < 1000)
                    nominal = 750000;
                else if (kendaraan.cc <= 2500)
                    nominal = 1000000;
                else
                    nominal = 1500000;
                break;
        }
        return nominal;
    }

    public static long hitungDenda(int bulanHarusBayar, int bulanBayar) {
        int selisihBulan = bulanBayar - bulanHarusBayar;
        if (selisihBulan <= 0) {
            return 0;
        } else if (selisihBulan <= 3) {
            return 50000;
        } else {
            return 50000 * selisihBulan;
        }
    }

    public static void tampilkanSeluruhTransaksi() {
        long totalPendapatan = 0;
        for (int i = 0; i < Main26.jumlahTransaksi; i++) {
            System.out.println(Main26.daftarTransaksi[i].toString());
            totalPendapatan += Main26.daftarTransaksi[i].nominalBayar + Main26.daftarTransaksi[i].denda;
        }
        System.out.println("Total Pendapatan: " + totalPendapatan);
    }

    public static void urutkanTransaksi() {
        for (int i = 0; i < Main26.jumlahTransaksi - 1; i++) {
            for (int j = i + 1; j < Main26.jumlahTransaksi; j++) {
                TransaksiPajak26 t1 = Main26.daftarTransaksi[i];
                TransaksiPajak26 t2 = Main26.daftarTransaksi[j];
                char initial1 = t1.kendaraan.nama.charAt(0);
                char initial2 = t2.kendaraan.nama.charAt(0);

                boolean swap = false;
                if (initial1 <= 'M' && initial2 <= 'M') {
                    if (t1.kendaraan.noTNKB.compareTo(t2.kendaraan.noTNKB) > 0) {
                        swap = true;
                    }
                } else if (initial1 > 'M' && initial2 > 'M') {
                    if (t1.kendaraan.nama.compareTo(t2.kendaraan.nama) > 0) {
                        swap = true;
                    }
                } else if (initial1 <= 'M') {
                    swap = false;
                } else {
                    swap = true;
                }

                if (swap) {
                    TransaksiPajak26 temp = Main26.daftarTransaksi[i];
                    Main26.daftarTransaksi[i] = Main26.daftarTransaksi[j];
                    Main26.daftarTransaksi[j] = temp;
                }
            }
        }

        for (int i = 0; i < Main26.jumlahTransaksi; i++) {
            System.out.println(Main26.daftarTransaksi[i].toString());
        }
    }

}
