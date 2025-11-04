import java.util.Scanner;

public class TukarHuruf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("String masukkan : ");
        String sentence = scanner.nextLine();

        if (sentence.length() > 1) {
            char firstChar = sentence.charAt(0);
            char lastChar = sentence.charAt(sentence.length() - 1);

            char firstUpper = Character.toUpperCase(firstChar);
            char firstLower = Character.toLowerCase(firstChar);
            char lastUpper = Character.toUpperCase(lastChar);
            char lastLower = Character.toLowerCase(lastChar);

            StringBuilder result = new StringBuilder();

            for (int potition = 0; potition < sentence.length(); potition++) {
                char current = sentence.charAt(potition);

                if (current == firstUpper) {
                    result.append(lastUpper);
                } else if (current == firstLower) {
                    result.append(lastLower);
                } else if (current == lastUpper) {
                    result.append(firstUpper);
                } else if (current == lastLower) {
                    result.append(firstLower);
                } else {
                    result.append(current);
                }
            }

            System.out.println("String hasil    : " + result.toString());
        } else {
            System.out.println("String is too short!");
        }

        scanner.close();
    }
}
