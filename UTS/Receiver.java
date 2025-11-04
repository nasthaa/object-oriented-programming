class Receiver extends Person {
    public Receiver(String nama, String alamat) {
        super(nama, alamat);
    }

    @Override
    public String detail() {
        return "Penerima\t: " + super.detail();
    }
}