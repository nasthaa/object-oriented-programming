class Person extends Package {
    private String nama;
    private String noTelepon;

    public Person(String namaBarang, double jarak, String jenis, double berat, double panjang, double lebar, String nama, String noTelepon) {
        super(namaBarang, jarak, jenis, berat, panjang, lebar);
        this.nama = nama;
        this.noTelepon = noTelepon;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }

    @Override
    public String detail() {
        return nama + " (" + noTelepon + ")";
    }
}