public class HitungHurufA {
    public static void main(String[] args) {
        char[] matkul = {
            'p', 'e', 'm', 'o', 'g', 'r', 'a', 'm', 'a', 'n', 'b', 'e', 'r', 'b', 'a', 's', 'i', 's', 'o', 'b', 'y', 'e', 'k'
        };

        int jumlahA = 0;

        for (int indeks = 0; indeks < matkul.length; indeks++) {
            if (matkul[indeks] == 'a' || matkul[indeks] == 'A') {
                jumlahA++;
            }
        }
        System.out.println("Jumlah huruf 'a' pada array adalah: " + jumlahA);
    }
}