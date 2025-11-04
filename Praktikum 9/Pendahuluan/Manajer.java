public class Manajer extends Pegawai {
    public String departemen;

    public void IsiData(String n, double g, String d) {
        nama = n;
        gaji = g;
        departemen = d;
    }

    public static void main(String[] args) {
	Manajer manajer = new Manajer();

        System.out.println("Nama: " + manajer.nama);
        System.out.println("Gaji: " + manajer.gaji);
        System.out.println("Departemen: " + manajer.departemen);
    }
}
