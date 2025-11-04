class Food extends Package {
    private double tinggi;
    private final boolean sameday;
    private final boolean bubbleWrap;

    public Food(String namaBarang, double jarak, String jenis, double berat, double panjang, double lebar, double tinggi, boolean sameday, boolean bubbleWrap) {
        super(namaBarang, jarak, jenis, berat, panjang, lebar);
        this.tinggi = tinggi;
        this.sameday = sameday;
        this.bubbleWrap = bubbleWrap;
    }

    public double getTinggi() { return tinggi; }
    public void setTinggi(double tinggi) { this.tinggi = tinggi; }

    @Override
    public double getVolume() {
        return getPanjang() * getLebar() * tinggi;
    }

    @Override
    public double hitungBiaya() {
        double biaya = super.hitungBiaya();
        if (bubbleWrap) biaya += 2000;
        if (sameday) biaya += 30000;
        return biaya;
    }

    @Override
    public String detail() {
        return "[Food] " + super.detail() + (bubbleWrap ? "\t\tEkstra bubble wrap " : "\t\tTanpa bubble wrap ") + "dan" + (sameday ? " jenis makanan basah" : " jenis makanan kering");
    }
}