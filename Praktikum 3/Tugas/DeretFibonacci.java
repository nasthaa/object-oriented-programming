import java.util.Scanner;

public class DeretFibonacci {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		System.out.print("Masukkan berapa deret Fibonacci? ");
		int deret = inputScanner.nextInt();

		int bilPertama = 1;
		int bilKedua = 1;

		System.out.print(deret + " deret Fibonacci = ");

		for (int urutan = 1; urutan <= deret; urutan++) {
			if (urutan == 1) {
				System.out.print(bilPertama + " ");
			} else if (urutan == 2) {
				System.out.print(bilKedua + " ");
			} else {
				int bilBerikutnya = bilPertama + bilKedua;
				System.out.print(bilBerikutnya + " ");
				bilPertama = bilKedua;
				bilKedua = bilBerikutnya;
			}
		}

		inputScanner.close();
	}
}
