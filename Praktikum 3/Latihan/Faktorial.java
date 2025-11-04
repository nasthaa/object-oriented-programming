import java.util.Scanner;

public class Faktorial {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		System.out.print("Masukkan bilangan faktorial: ");
		int batas = inputScanner.nextInt();

		System.out.println("n\tn!");
		System.out.println("-----------------------");

		long faktorial = 1;

		for (int posisi = 1; posisi <= batas; posisi++) {
			faktorial = faktorial * posisi;
			System.out.println(posisi + "\t" + faktorial);
		}

		System.out.println("-----------------------");

		inputScanner.close();
	}
}
