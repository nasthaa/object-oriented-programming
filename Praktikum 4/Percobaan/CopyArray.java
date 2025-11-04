public class CopyArray {
	public static void main(String[] args) {
		int a[] = {10, 20, 30, 40, 50};
		int b[] = new int[5];

		System.arraycopy(a, 0, b, 0, a.length);
		System.out.println(b[2]);
	}
}