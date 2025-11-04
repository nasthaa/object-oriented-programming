import java.util.Scanner;

public class TukarFamilyName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("String nama pertama\t: ");
        String firstNameInput = scanner.nextLine();

        System.out.print("String nama kedua\t: ");
        String secondNameInput = scanner.nextLine();

        String[] parts1 = firstNameInput.split(" ");
        String[] parts2 = secondNameInput.split(" ");

        String familyName1 = parts1[parts1.length - 1];
        String familyName2 = parts2[parts2.length - 1];

        String firstPart1 = firstNameInput.substring(0, firstNameInput.lastIndexOf(" "));
        String firstPart2 = secondNameInput.substring(0, secondNameInput.lastIndexOf(" "));

        String newName1 = firstPart1 + " " + familyName2;
        String newName2 = firstPart2 + " " + familyName1;

        System.out.println("String nama pertama : " + newName1);
        System.out.println("String nama kedua   : " + newName2);

        scanner.close();
    }
}
