import java.util.Scanner;

public class CariIndeksKarakter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kalimat  : ");
        String sentence = input.nextLine();

        System.out.print("Karakter : ");
        char search = input.next().charAt(0);

        System.out.print("Karakter '" + search + "' terdapat pada indeks ");
        boolean found = false;
        for (int potition = 0; potition < sentence.length(); potition++) {
            if (sentence.charAt(potition) == search) {
                if (found) {
                    System.out.print(",");
                }
                System.out.print(potition);
                found = true;
            }
        }

        if (!found) {
            System.out.print(" (tidak ditemukan)");
        }

        System.out.println();
        input.close();
    }
}
