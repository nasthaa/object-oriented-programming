class Dosen extends Orang {
    private int nip;

    public Dosen(String nama) {
        super(nama);
        this.nip = 0;
    }

    public Dosen(String nama, int nip) {
        super(nama);
        this.nip = nip;
    }

    public Dosen(String nama, int nip, int umur) {
        super(nama, umur);
        this.nip = nip;
    }

    public void Info() {
        System.out.println("Nama\t: " + nama);
        System.out.println("NIP\t: " + (nip == 0 ? "-" : nip));
        System.out.println("Umur\t: " + (umur == 0 ? "-" : umur));
    }
}