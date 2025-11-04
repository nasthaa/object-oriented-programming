public class TesLogin {
	public static void main(String arguments[]) {
        Mahasiswa fadilah = new Mahasiswa();
        fadilah.setUsername("fadilah");
        fadilah.setPassword("123456");
        fadilah.setPhone("083853501388");

        boolean result = fadilah.loginByPhone("083853501388", "123456");
        System.out.println(result ? "Login berhasil" : "Login gagal");

        Dosen fahrul = new Dosen("fahrul", "123456");
        fahrul.setKey("19990129");

        result = fahrul.login("fahrul", "123456", "19990129");
        System.out.println(result ? "Login berhasil" : "Login gagal");
    }
}