class Courier extends Person {
    private String cabang;

    public Courier(String nama, String noTelepon, String cabang) {
        super("", 0, "", 0, 0, 0, nama, noTelepon);
        this.cabang = cabang;
    }

    public String getCabang() { return cabang; }
    public void setCabang(String cabang) { this.cabang = cabang; }

    @Override
    public String detail() {
        return "Kurir\t\t: " + super.detail() + " - " + cabang;
    }

    @Override
    public double hitungBiaya() {
        return 0;
    }
}