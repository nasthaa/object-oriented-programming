class Sender extends Person {
    private String alamatAsal;
    private String metodePembayaran;

    public Sender(String nama, String noTelepon, String alamatAsal, String metodePembayaran) {
        super("", 0, "", 0, 0, 0, nama, noTelepon);
        this.alamatAsal = alamatAsal;
        this.metodePembayaran = metodePembayaran;
    }

    public String getAlamatAsal() { return alamatAsal; }
    public void setAlamatAsal(String alamatAsal) { this.alamatAsal = alamatAsal; }

    public String getMetodePembayaran() { return metodePembayaran; }
    public void setMetodePembayaran(String metodePembayaran) { this.metodePembayaran = metodePembayaran; }

    @Override
    public String detail() {
        return "Pengirim\t: " + super.detail() + " - " + alamatAsal;
    }

    @Override
    public double hitungBiaya() {
        return 0;
    }
}