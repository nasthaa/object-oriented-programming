class Package {
    private String namaBarang;
    private double jarak;
    private String jenis;
    private double berat;
    private double panjang;
    private double lebar;

    public Package(String namaBarang, double jarak, String jenis, double berat, double panjang, double lebar) {
        this.namaBarang = namaBarang;
        this.jarak = jarak;
        this.jenis = jenis;
        this.berat = berat;
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }

    public double getJarak() { return jarak; }
    public void setJarak(double jarak) { this.jarak = jarak; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public double getBerat() { return berat; }
    public void setBerat(double berat) { this.berat = berat; }

    public double getPanjang() { return panjang; }
    public void setPanjang(double panjang) { this.panjang = panjang; }

    public double getLebar() { return lebar; }
    public void setLebar(double lebar) { this.lebar = lebar; }

    public double hitungBiaya() {
        double baseRate;
        double satuanJarak = 250;
        double satuanBerat = 1;
        double satuanVolume = 4500;

        switch (jenis) {
            case "1": baseRate = 20000; break; // Express
            case "2": baseRate = 7000; break; // Reguler
            case "3": baseRate = 4000; break;  // Hemat
            default: baseRate = 0; break;
        }

        double volume = getVolume();
        int kelipatanJarak = (jarak % satuanJarak == 0) ? (int)(jarak / satuanJarak) : (int)(jarak / satuanJarak) + 1;
        int kelipatanBerat = (berat % satuanBerat == 0) ? (int)(berat / satuanBerat) : (int)(berat / satuanBerat) + 1;
        int kelipatanVolume = (volume % satuanVolume == 0) ? (int)(volume / satuanVolume) : (int)(volume / satuanVolume) + 1;

        int totalKelipatan = kelipatanJarak + kelipatanBerat + kelipatanVolume;
        double total = baseRate * totalKelipatan;

        return total;
    }

    public double getVolume() {
        return panjang * lebar;
    }

    public String detail() {
        String jenisEkspedisi = "";
        switch (jenis) {
            case "1": jenisEkspedisi = "Express"; break;
            case "2": jenisEkspedisi = "Reguler"; break;
            case "3": jenisEkspedisi = "Hemat"; break;
        }
        return namaBarang + "\t\t" + berat + " kg\t" + jenisEkspedisi;
        //  + "\t\tRp " + hitungBiaya();
    }
}