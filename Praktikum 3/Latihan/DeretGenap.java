public class DeretGenap {
	public static void main(String[] args) {
		for (int bilangan = 1; bilangan <= 20; bilangan++) {
			if (bilangan % 2 == 0 && bilangan % 6 != 0) {
				System.out.print(bilangan + " ");
			}
		}
	}
}