class Kurir extends Pegawai {
    private String cabang;

    public Kurir(String nama, double gaji, double tunjangan, String cabang) {
        super(nama, gaji, tunjangan);
        this.cabang = cabang;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Cabang\t: " + cabang);
    }
}