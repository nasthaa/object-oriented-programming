public class TesOverloading {
    public static void main(String[] args) {
        User user = new User();
        user.login("user123", "pass123");

        Dosen dosen = new Dosen();
        dosen.login("dosen001", "pass456");
        dosen.login("dosen001", "pass456", "KEY999");
    }
}