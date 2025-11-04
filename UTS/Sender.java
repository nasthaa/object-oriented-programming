class Sender extends Person {
    public Sender(String nama, String alamat) {
        super(nama, alamat);
    }

    @Override
    public String detail() {
        return "Pengirim\t: " + super.detail();
    }
}