class Cargo extends Package {
    private double tinggi;
    private final boolean fragile;
    private final boolean bubbleWrap;

    public Cargo(String namaBarang, double jarak, String jenis, double berat, double panjang, double lebar, double tinggi, boolean fragile, boolean bubbleWrap) {
        super(namaBarang, jarak, jenis, berat, panjang, lebar);
        this.tinggi = tinggi;
        this.fragile = fragile;
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
        if (fragile) biaya += 2500;
        return biaya;
    }

    @Override
    public String detail() {
        return "[Cargo] " + super.detail() + (bubbleWrap ? "\t\tEkstra bubble wrap " : "\t\tTanpa bubble wrap ") + "dan" + (fragile ? " barang mudah pecah" : " barang tidak mudah pecah");
    }
}