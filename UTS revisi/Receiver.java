class Receiver extends Person {
    private String alamatTujuan;

    public Receiver(String nama, String noTelepon, String alamatTujuan) {
        super("", 0, "", 0, 0, 0, nama, noTelepon);
        this.alamatTujuan = alamatTujuan;
    }

    public String getAlamatTujuan() { return alamatTujuan; }
    public void setAlamatTujuan(String alamatTujuan) { this.alamatTujuan = alamatTujuan; }

    @Override
    public String detail() {
        return "Penerima\t: " + super.detail() + " - " + alamatTujuan;
    }

    @Override
    public double hitungBiaya() {
        return 0;
    }
}