class Letter extends Package {
    private final boolean perangko;

    public Letter(String namaBarang, double jarak, String jenis, double berat, double panjang, double lebar, boolean perangko) {
        super(namaBarang, jarak, jenis, berat, panjang, lebar);
        this.perangko = perangko;
    }

    @Override
    public double hitungBiaya() {
        double biaya = super.hitungBiaya();
        if (perangko) biaya += 25000;
        return biaya;
    }

    @Override
    public String detail() {
        return "[Letter] " + super.detail() + (perangko ? "\t\tDengan Perangko" : "\t\tTanpa Perangko\t\t\t");
    }
}