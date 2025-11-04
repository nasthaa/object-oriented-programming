class Packet {
    private String namaBarang;
    private double berat;
    private int jarak;
    private int jenis;

    public Packet(String namaBarang, double berat, int jarak, int jenis) {
        this.namaBarang = namaBarang;
        this.berat = berat;
        this.jarak = jarak;
        this.jenis = jenis;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    public int getJenis() {
        return jenis;
    }

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    public double hitungBiaya() {
        double biaya = 0;

        switch (jenis) {
            case 1:
                int blokExpress = jarak / 500;
                if (jarak % 500 != 0) blokExpress++;
                biaya = berat * blokExpress * 20000;
                break;
            case 2:
                int blokRegular = jarak / 250;
                if (jarak % 250 != 0) blokRegular++;
                biaya = berat * blokRegular * 7000;
                break;
            case 3:
                int blokHemat = jarak / 250;
                if (jarak % 250 != 0) blokHemat++;
                biaya = berat * blokHemat * 4000;
                break;
            default:
                System.out.println("Jenis ekspedisi tidak valid.");
        }
        return biaya;
    }

    public String detail() {
        String jenisEkspedisi = "";

        switch (jenis) {
            case 1:
                jenisEkspedisi = "Express";
                break;
            case 2:
                jenisEkspedisi = "Regular";
                break;
            case 3:
                jenisEkspedisi = "Hemat";
                break;
        }
        
        
    }
}