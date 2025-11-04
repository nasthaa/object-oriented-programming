public class TesMultiTabungan {
    public static void main(String args[]) {
        MultiTabungan tabungan = new MultiTabungan(500000);
        System.out.println("Saldo awal = " + tabungan.getSaldo() + " IDR");

        tabungan.simpanUang(200000, "IDR");
        System.out.println("Saldo setelah simpan 200000 IDR = " + tabungan.getSaldo() + " IDR");

        tabungan.simpanUang(50, "AUD");
        System.out.println("Saldo setelah simpan 50 AUD = " + tabungan.getSaldo() + " IDR");

        tabungan.simpanUang(30, "USD");
        System.out.println("Saldo setelah simpan 30 USD = " + tabungan.getSaldo() + " IDR");

        boolean berhasil = tabungan.ambilUang(1000000, "IDR");
        if (berhasil)
            System.out.println("Ambil 1000000 IDR: Berhasil");
        else
            System.out.println("Ambil 1000000 IDR: Gagal");
        System.out.println("Saldo sekarang = " + tabungan.getSaldo() + " IDR");
        
        berhasil = tabungan.ambilUang(25, "AUD");
        if (berhasil)
            System.out.println("Ambil 25 AUD: Berhasil");
        else
            System.out.println("Ambil 25 AUD: Gagal");
        System.out.println("Saldo sekarang = " + tabungan.getSaldo() + " IDR");
        
        berhasil = tabungan.ambilUang(1000, "USD");
        if (berhasil)
            System.out.println("Ambil 1000 USD: Berhasil");
        else
            System.out.println("Ambil 1000 USD: Gagal");
        System.out.println("Saldo sekarang = " + tabungan.getSaldo() + " IDR");
    }  
}

class MultiTabungan {
    private int saldo;

    public MultiTabungan(int initsaldo) {
        this.saldo = initsaldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void simpanUang(int jumlah, String mataUang) {
        switch (mataUang.toUpperCase()) {
            case "IDR":
                saldo += jumlah;
                break;
            case "AUD":
                saldo += jumlah * 10000;
                break;
            case "USD":
                saldo += jumlah * 9000;
                break;
            default:
                System.out.println("Mata uang tidak dikenali");
                break;
        }
    }

    public boolean ambilUang(int jumlah, String mataUang) {
        int jumlahIDR;

        switch (mataUang.toUpperCase()) {
            case "IDR":
                jumlahIDR = jumlah;
                break;
            case "AUD":
                jumlahIDR = jumlah * 10000;
                break;
            case "USD":
                jumlahIDR = jumlah * 9000;
                break;
            default:
                System.out.println("Mata uang tidak dikenali");
                return false;
        }

        if (jumlahIDR <= saldo) {
            saldo -= jumlahIDR;
            return true;
        } else
            return false;
    }
}
        