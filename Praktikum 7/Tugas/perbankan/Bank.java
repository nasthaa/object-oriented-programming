package perbankan;

public class Bank {
    private Nasabah[] nasabah;
    private int jumlahNasabah;

    public Bank() {
        nasabah = new Nasabah[10];
        jumlahNasabah = 0;
    }

    public void tambahNasabah(String namaAwal, String namaAkhir) {
        nasabah[jumlahNasabah] = new Nasabah(namaAwal, namaAkhir);
        jumlahNasabah++;
    }

    public Nasabah getNasabah(int index) {
        if (index >= 0 && index < jumlahNasabah)
            return nasabah[index];
        else
            return null;
    }

    public int getJumlahNasabah() {
        return jumlahNasabah;
    }
}