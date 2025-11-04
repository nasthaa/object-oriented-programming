package perbankan;

public class Tabungan {
    private int saldo;

    public Tabungan(int saldoAwal) {
        saldo = saldoAwal;
    }

    public int getSaldo() {
        return saldo;
    }

    public void simpanUang(int jumlah) {
        saldo += jumlah;
    }

    public boolean ambilUang(int jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        } else {
            return false;
        }
    }
}
