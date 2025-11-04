class Dosen extends User {
    private String pangkat;
    private String golongan;
    private String key;

    public Dosen() { super(); }

    public Dosen(String username, String password) {
        super(username, password);
    }

    public Dosen(String username, String password, String key) {
        super(username, password);
        this.key = key;
    }

    public boolean login(String username, String password, String key) {
        return super.login(username, password) && this.key != null && this.key.equals(key);
    }

    public boolean loginByPhone(String phone, String password, String key) {
        return super.loginByPhone(phone, password) && this.key != null && this.key.equals(key);
    }

    public void setKey(String key) { this.key = key; }
}