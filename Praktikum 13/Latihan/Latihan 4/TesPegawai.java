public class TesPegawai {
    public static void main(String[] args) {
        Pegawai manajer = new Manajer("Joko", 8000000, 2000000, "Eskpedisi");
        Pegawai kurir = new Kurir("Anwar", 4000000, 500000, "Kertomanunggal");
        tampilkanInfo(manajer);
        tampilkanInfo(kurir);
    }

    public static void tampilkanInfo(Pegawai pegawai) {
        pegawai.info();
        System.out.println("------------------------------");
    }
}