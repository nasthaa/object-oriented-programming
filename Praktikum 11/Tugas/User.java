class User {
    private String id;
    private String phone;
    private String username;
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username != null && this.username.equals(username) && this.password.equals(password);
    }

    public boolean loginByPhone(String phone, String password) {
        return this.phone != null && this.phone.equals(phone) && this.password.equals(password);
    }

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
}