class Mahasiswa extends User {
    private Dosen dosenWali;
    private String kelas;

    public Mahasiswa() { super(); }

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    public Dosen getDosenWali() { return dosenWali; }
    public void setDosenWali(Dosen dosenWali) { this.dosenWali = dosenWali; }

    public String getKelas() { return kelas; }
    public void setKelas(String kelas) { this.kelas = kelas; }
}