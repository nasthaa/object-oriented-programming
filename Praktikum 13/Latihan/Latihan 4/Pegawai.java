class Pegawai {
    private String nama;
    private double gaji;
    private double tunjangan;

    public Pegawai(String nama, double gaji, double tunjangan) {
        this.nama = nama;
        this.gaji = gaji;
        this.tunjangan = tunjangan;
    }

    public void info() {
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Gaji\t\t: " + gaji);
        System.out.println("Tunjangan\t: " + tunjangan);
    }
}