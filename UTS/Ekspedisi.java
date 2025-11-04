import java.util.Scanner;

public class Ekspedisi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Data Pengirim:");
        System.out.print("Nama\t\t: ");
        String namaSender = scanner.nextLine();
        System.out.print("Alamat\t\t: ");
        String alamatSender = scanner.nextLine();
        Sender pengirim = new Sender(namaSender, alamatSender);

        System.out.println("\nData Penerima:");
        System.out.print("Nama\t\t: ");
        String namaReceiver = scanner.nextLine();
        System.out.print("Alamat\t\t: ");
        String alamatReceiver = scanner.nextLine();
        Receiver penerima = new Receiver(namaReceiver, alamatReceiver);

        System.out.println("\nData Kurir:");
        System.out.print("Nama\t\t: ");
        String namaKurir = scanner.nextLine();
        Courier kurir = new Courier(namaKurir);

        System.out.println("\nDetail Paket:");
        System.out.print("Jarak Tempuh (km)\t: ");
        int jarak = scanner.nextInt();
        System.out.print("Jumlah Paket\t\t: ");
        int jumlahPaket = scanner.nextInt();
        scanner.nextLine();
        Packet[] daftarPaket = new Packet[jumlahPaket];

        for (int index = 0; index < jumlahPaket; index++) {
            System.out.println("\nPaket ke-" + (index + 1));
            System.out.print("Nama Barang\t\t: ");
            String barang = scanner.nextLine();
            System.out.print("Berat (kg)\t\t: ");
            double berat = scanner.nextDouble();
            System.out.println("Pilih Jasa Pengiriman:");
            System.out.println("1. Express");
            System.out.println("2. Regular");
            System.out.println("3. Hemat");
            System.out.print("Opsi Pengiriman\t: ");
            int jenis = scanner.nextInt();
            scanner.nextLine();
            daftarPaket[index] = new Packet(barang, berat, jarak, jenis);
        }

        System.out.println("\n=== DETAIL PENGIRIMAN ===");
        System.out.println(pengirim.detail());
        System.out.println(penerima.detail());
        System.out.println("Kurir\t\t: " + kurir.getNama());

        System.out.println("");
        System.out.println("No.\tNama Barang\tBerat\tEkspedisi\tBiaya");

        double total = 0;

        for (int index = 0; index < jumlahPaket; index++) {
            System.out.println((index + 1) + "\t" + daftarPaket[index].detail());
            total += daftarPaket[index].hitungBiaya();
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Total Biaya:\t\t\t\t\tRp " + total);

        scanner.close();
    }
}
