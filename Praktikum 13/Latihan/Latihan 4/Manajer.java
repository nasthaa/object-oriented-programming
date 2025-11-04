class Manajer extends Pegawai {
    private String departemen;

    public Manajer(String nama, double gaji, double tunjangan, String departemen) {
        super(nama, gaji, tunjangan);
        this.departemen = departemen;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Departemen\t: " + departemen);
    }
}