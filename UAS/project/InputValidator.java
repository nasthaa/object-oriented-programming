import java.util.Scanner;

public interface InputValidator {
    public int validasiMenu(Scanner scanner, int min, int max, String prompt);
    public double validasiDouble(Scanner scanner, String prompt);
    public int validasiInt(Scanner scanner, String prompt);
}
