package Perbankan;

public class PengambilanUang extends Tabungan{
    private int proteksi;
    
    public PengambilanUang(int saldo) {
        super(saldo);
        this.proteksi = 0;
    }

    public PengambilanUang(int saldo, int proteksi) {
        super(saldo);
        this.proteksi = proteksi;
    }

    public boolean ambilUang(int jumlah) {
        if ((saldo - jumlah) >= proteksi) {
            saldo -= jumlah;
            return true;
        } else
            return false;
    }
}