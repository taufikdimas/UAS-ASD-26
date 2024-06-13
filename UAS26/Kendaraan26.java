package UAS26;

public class Kendaraan26 {
    public String noTNKB;
    public String nama;
    public String jenis;
    public int cc;
    public int tahun;
    public int bulanHarusBayar;

    public Kendaraan26(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        this.noTNKB = noTNKB;
        this.nama = nama;
        this.jenis = jenis;
        this.cc = cc;
        this.tahun = tahun;
        this.bulanHarusBayar = bulanHarusBayar;
    }

    public String toString() {
        return "TNKB: " + noTNKB + ", Nama: " + nama + ", Jenis: " + jenis + ", CC: " + cc + ", Tahun: " + tahun
                + ", Bulan Harus Bayar: " + bulanHarusBayar;
    }

    public static void daftarKendaraan() {
        for (int i = 0; i < Main26.jumlahKendaraan; i++) {
            System.out.println(Main26.daftarKendaraan[i].toString());
        }
    }

}
