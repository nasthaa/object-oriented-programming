public class TesMobil {
	public static void main(String[] args) {

		Mobil mobil1 = new Mobil("Toyota", "Biru", "Minibus", 2000, 7);
		Mobil mobil2 = new Mobil("Daihatsu", "Hitam", "Pick up", 1500, 2);
		Mobil mobil3 = new Mobil("Suzuki", "Silver", "SUV", 1800, 5);
		Mobil mobil4 = new Mobil("Honda", "Merah", "Sedan", 1300, 5);

		mobil1.infoMobil();
		mobil2.infoMobil();
		mobil3.infoMobil();
		mobil4.infoMobil();
	}
}