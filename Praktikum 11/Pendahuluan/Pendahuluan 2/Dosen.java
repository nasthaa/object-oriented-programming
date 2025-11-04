class Dosen extends User {
    private String key;

    public Dosen() {
        super();
        this.key = "DEFAULT_KEY";
        System.out.println("Dosen dibuat dengan key: " + key);
    }

    public Dosen(String username, String key) {
        super(username);
        this.key = key;
        System.out.println("Dosen dibuat dengan key: " + key);
    }
}