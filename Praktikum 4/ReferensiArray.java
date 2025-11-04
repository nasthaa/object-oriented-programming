public class ReferensiArray {
	public static void main(String[] args) {
		int[] angka1 = {1, 2, 3};
		int[] angka2 = angka1;

		// angka2[0] = 99;

		System.out.println(angka1[0]);
		System.out.println(angka2[0]);
	}
}