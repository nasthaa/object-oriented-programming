public class Mobil {
	private String merek;
	private String warna;
	private String jenis;
	private int kapasitasMesin;
	private int jumlahKursi;

	public Mobil(String merek, String warna, String jenis, int kapasitasMesin, int jumlahKursi) {
		this.merek = merek;
		this.warna = warna;
		this.jenis = jenis;
		this.kapasitasMesin = kapasitasMesin;
		this.jumlahKursi = jumlahKursi;
	}

	public String getMerek() {
		return merek;
	}

	public String getWarna() {
		return warna;
	}

	public String getJenis() {
		return jenis;
	}


	public int getKapasitasMesin() {
		return kapasitasMesin;
	}


	public int getJumlahKursi() {
		return jumlahKursi;
	}

	public void infoMobil()	{
		System.out.println("Merek          : " + merek);
		System.out.println("Warna          : " + warna);
        	System.out.println("Jenis          : " + jenis);
        	System.out.println("Kapasitas Mesin: " + kapasitasMesin + " cc");
        	System.out.println("Jumlah Kursi   : " + jumlahKursi);
        	System.out.println("---------------------------------");
	}
}