public class TesTugas2 {
    public static void main(String[] args) {
        Katak O1 = new Katak(5, "Froggy");
        System.out.println("Nama\t: " + O1.getNama());
        System.out.println("Umur\t: " + O1.getUmur());
        System.out.println("Cara bergerak\t: " + O1.caraBergerak());
        System.out.println();

        Kecebong O2 = new Kecebong(2, "Junior Frog", 10);
        System.out.println("Nama\t: " + O2.getNama());
        System.out.println("Umur\t: " + O2.getUmur());
        System.out.println("Cara bergerak\t: " + O2.caraBergerak());
        System.out.println("Panjang ekor\t: " + O2.getPanjangEkor());
    }
}