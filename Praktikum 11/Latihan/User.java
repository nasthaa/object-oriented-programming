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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean login(String username, String password) {
        return this.username != null && this.username.equals(username) && this.password.equals(password);
    }

    public boolean loginByPhone(String phone, String password) {
        return this.phone != null && this.phone.equals(phone) && this.password.equals(password);
    }
}