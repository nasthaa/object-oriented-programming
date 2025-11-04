import java.util.Scanner;

public class FibonacciArray {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah deretan Fibonacci? ");
        int jumlah = inputScanner.nextInt();

        int[] fibonacci = new int[jumlah];

        if (jumlah > 0) fibonacci[0] = 0;
        if (jumlah > 1) fibonacci[1] = 1;

        for (int indeks = 2; indeks <= jumlah; indeks++) {
            fibonacci[indeks] = fibonacci[indeks - 1] + fibonacci[indeks - 2];
        }

        for (int indeks = 0; indeks <= jumlah; indeks++) {
            System.out.print(fibonacci[indeks] + " ");
        }

        inputScanner.close();
    }
}
