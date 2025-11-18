import java.util.Scanner;

public class ConsoleValidator implements InputValidator {

    @Override
    public int validasiMenu(Scanner scanner, int min, int max, String prompt) {
        int pilihan;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                pilihan = Integer.parseInt(line);
                if (pilihan < min || pilihan > max) {
                    System.out.printf("Pilihan menu tidak tersedia! Silakan memilih lagi (%d-%d): %n", min, max);
                    continue;
                }
                return pilihan;
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang valid! ");
            }
        }
    }

    @Override
    public double validasiDouble(Scanner scanner, String prompt) {
        double val;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                val = Double.parseDouble(line);
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }

    @Override
    public int validasiInt(Scanner scanner, String prompt) {
        int val;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                val = Integer.parseInt(line);
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }
}
