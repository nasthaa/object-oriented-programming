class User {
    private String username;

    public User() {
        this.username = "Guest";
        System.out.println("User dibuat: " + username);
    }

    public User(String username) {
        this.username = username;
        System.out.println("User dibuat: " + username);
    }
}