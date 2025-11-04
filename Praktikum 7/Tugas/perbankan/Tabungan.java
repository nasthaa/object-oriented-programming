package perbankan;

public class Tabungan {
    private int saldo;

    public Tabungan(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    // public void setor(int jumlah) {
    //     saldo += jumlah;
    // }

    // public boolean tarik(int jumlah) {
    //     if (jumlah <= saldo) {
    //         saldo -= jumlah;
    //         return true;
    //     } else
    //         return false;
    // }
}