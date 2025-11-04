class Truk {
	double muatan;
	double muatanmaks;

	public Truk(double beratmaks) {
		muatanmaks = beratmaks;
		muatan = 0;
	}

	public double getMuatan() {
		return muatan;
	}

	public double getMuatanMaks() {
		return muatanmaks;
	}

	public void tambahMuatan(double berat) {
		if (muatan + berat <= muatanmaks)
			muatan += berat;
		else
			System.out.println("Muatan terlalu berat!");
	}
}