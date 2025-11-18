import java.util.Scanner;

public class AppMenu {
    private MahasiswaCRUD crud;
    private InputValidator validator;
    private Scanner scanner;

    public AppMenu(MahasiswaCRUD crud, InputValidator validator) {
        this.crud = crud;
        this.validator = validator;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("====== APLIKASI SISTEM INFORMASI ======");
        System.out.println("==== Penilaian Mahasiswa Sederhana ====");
        while (true) {
            System.out.println("\nSilakan pilih opsi dari menu di bawah:");
            System.out.println("1. Tambahkan data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Perbarui data");
            System.out.println("4. Hapus data");
            System.out.println("5. Keluar program");
            int pilihan = validator.validasiMenu(scanner, 1, 5, "Masukkan pilihan Anda (1-5): ");
            switch (pilihan) {
                case 1:
                    crud.menuCreate();
                    break;
                case 2:
                    crud.menuRead();
                    break;
                case 3:
                    crud.menuUpdate();
                    break;
                case 4:
                    crud.menuDelete();
                    break;
                case 5:
                    System.out.println("Program telah diakhiri, terima kasih...");
                    return;
                default:
                    break;
            }
        }
    }
}
