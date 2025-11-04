import java.util.Scanner;

public class GantiKata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("String kalimat utama\t: ");
        String mainSentence = scanner.nextLine();

        System.out.print("String yang diganti\t: ");
        String targetWord = scanner.nextLine();

        System.out.print("String pengganti\t: ");
        String replacementWord = scanner.nextLine();

        String newSentence = mainSentence.replace(targetWord, replacementWord);

        System.out.println("Kalimat utama menjadi\t: " + newSentence);

        scanner.close();
    }
}
