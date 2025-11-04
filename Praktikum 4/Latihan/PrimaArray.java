import java.util.Scanner;

public class PrimaArray {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan? ");
        int bilangan = inputScanner.nextInt();
        
        int[] pembagi = new int[bilangan];
        int jumlahPembagi = 0;

        for (int angkaUji = 1; angkaUji <= bilangan; angkaUji++) {
            if (bilangan % angkaUji == 0) {
                pembagi[jumlahPembagi] = angkaUji;
                jumlahPembagi++;
            }
        }

        if (jumlahPembagi == 2) {
            System.out.println(bilangan + " adalah bilangan prima");
        } else {
            System.out.println(bilangan + " bukan termasuk bilangan prima");
        }

        inputScanner.close();
    }
}
