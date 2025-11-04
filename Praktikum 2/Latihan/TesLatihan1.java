class Tabungan {
	int saldo;

	public Tabungan(int initsaldo) {
		saldo = initsaldo;
	}

	public void ambilUang(int jumlah) {
		if (jumlah <= saldo)
			saldo -= jumlah;
		else
			System.out.println("Saldo tidak cukup!");
	}
}

public class TesLatihan1 {
	public static void main(String args[]) {
		int ambilUang = 2300;
		Tabungan tabungan = new Tabungan(5000);
		
		System.out.println("Saldo awal : " + tabungan.saldo); 
		tabungan.ambilUang(ambilUang);

		System.out.println("Jumlah uang yang diambil : " + ambilUang); 
		System.out.println("Saldo sekarang : " + tabungan.saldo);
	}
}