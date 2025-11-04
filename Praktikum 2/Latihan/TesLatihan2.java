class Mahasiswa {
	int nrp;
	String nama;

	public Mahasiswa(int i, String n) {
		nrp = 1;
		nama = n;
	}

	public int getNrp() {
		return nrp;
	}

	public String getNama() {
		return nama;
	}
}

public class TesLatihan2 {
	public static void main(String args[]) {
		Mahasiswa mhs = new Mahasiswa(12345, "Jono"); 
		System.out.println("NRP : " + mhs.getNrp()); 
		System.out.println("Nama : " + mhs.getNama());
	}
}
