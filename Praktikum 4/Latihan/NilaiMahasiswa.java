public class NilaiMahasiswa {
    public static void main(String[] args) {
        int[][] dataNilai = {
            {1, 81, 90, 62}, // Nilai Ahmad
            {2, 50, 83, 87}, // Nilai Adang
            {3, 89, 55, 65}, // Nilai Dani
            {4, 77, 70, 92}  //Nilai Edi
        };

        System.out.println("NRP\tRata-rata");
        System.out.println("---------------------");

        for (int indeks = 0; indeks <= dataNilai.length; indeks++) {
            int nrp = dataNilai[indeks][0];
            double rataRata = (dataNilai[indeks][1] + dataNilai[indeks][2] + dataNilai[indeks][3]) / 3.0;
            System.out.printf("%d\t%.2f%n", nrp, rataRata);
        }
        System.out.println("---------------------");
    }
}