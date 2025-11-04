class Kecebong extends Katak {
    private double panjangEkor;

    public Kecebong(int umur, String nama, double panjangEkor) {
        super(umur, nama);
        this.panjangEkor = panjangEkor;
    }

    public double getPanjangEkor() {
        return panjangEkor;
    }

    public void setPanjangEkor(double panjangEkor) {
        this.panjangEkor = panjangEkor;
    }

    @Override
    public String caraBergerak() {
        return "berenang";
    }
}