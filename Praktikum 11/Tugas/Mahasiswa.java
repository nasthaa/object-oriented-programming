class Mahasiswa extends User {
    private Dosen dosenWali;
    private String kelas;

    public Mahasiswa() { super(); }

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    public Mahasiswa(String username, String password, String phone) {
        super(username, password, phone);
    }

    public void setDosenWali(Dosen dosenWali) { this.dosenWali = dosenWali; }
}