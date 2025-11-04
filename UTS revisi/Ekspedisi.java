import java.util.Scanner;

public class Ekspedisi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DATA PENGIRIM:");
        System.out.print("- Nama Pengirim\t: ");
        String namaPengirim = scanner.nextLine();
        System.out.print("- No. Telp.\t: ");
        String noTeleponPengirim = scanner.nextLine();
        System.out.print("- Alamat Asal\t: ");
        String alamatAsal = scanner.nextLine();
        System.out.print("- Metode Bayar\t: ");
        String metodePembayaran = scanner.nextLine();
        Sender sender = new Sender(namaPengirim, noTeleponPengirim, alamatAsal, metodePembayaran);

        System.out.println("\nDATA PENERIMA:");
        System.out.print("- Nama Penerima\t: ");
        String namaPenerima = scanner.nextLine();
        System.out.print("- No. Telp.\t: ");
        String noTeleponPenerima = scanner.nextLine();
        System.out.print("- Alamat Tujuan\t: ");
        String alamatTujuan = scanner.nextLine();
        Receiver receiver = new Receiver(namaPenerima, noTeleponPenerima, alamatTujuan);

        System.out.println("\nDATA KURIR:");
        System.out.print("- Nama Kurir\t: ");
        String namaKurir = scanner.nextLine();
        System.out.print("- No. Telp.\t: ");
        String noTeleponKurir = scanner.nextLine();
        System.out.print("- Cabang\t: ");
        String cabang = scanner.nextLine();
        Courier courier = new Courier(namaKurir, noTeleponKurir, cabang);

        System.out.println("\nDATA PAKET:");
        System.out.print("Masukkan jumlah paket yang akan dikirim: ");
        int length = scanner.nextInt();
        scanner.nextLine();

        Package[] daftarPaket = new Package[length];

        for (int index = 0; index < length; index++) {
            System.out.println("\nPaket ke-" + (index + 1));
            System.out.print("- Nama Barang\t: ");
            String namaBarang = scanner.nextLine();
            System.out.print("- Jarak (km)\t: ");
            double jarak = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("- Pilih Ekspedisi:");
            System.out.println("  1. Express");
            System.out.println("  2. Reguler");
            System.out.println("  3. Hemat");
            System.out.print("  Opsi Pengiriman (1/2/3): ");
            int jenis = scanner.nextInt();
            String jenisEkspedisi = String.valueOf(jenis);
            scanner.nextLine(); 
            System.out.print("- Berat (kg)\t: ");
            double berat = scanner.nextDouble();
            System.out.print("- Panjang (cm)\t: ");
            double panjang = scanner.nextDouble();
            System.out.print("- Lebar (cm)\t: ");
            double lebar = scanner.nextDouble();
            System.out.print("Apakah ingin menambahkan tinggi? (y/n)\t: ");
            char tinggi = scanner.next().charAt(0);
            scanner.nextLine();

            if (tinggi == 'n' || tinggi == 'N') {
                System.out.print("Apakah ingin menambahkan perangko? (y/n): ");
                char inputPerangko = scanner.next().charAt(0);
                scanner.nextLine();
                boolean perangko = (inputPerangko == 'y' || inputPerangko == 'Y');
                daftarPaket[index] = new Letter(namaBarang, jarak, jenisEkspedisi, berat, panjang, lebar, perangko);
            } else {
                System.out.print("- Tinggi (cm)\t: ");
                double tinggiValue = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Jenis barang (cargo/makanan)\t\t: ");
                String jenisBarang = scanner.nextLine();

                if(jenisBarang.equalsIgnoreCase("cargo")) {
                    System.out.print("Apakah barang mudah pecah? (y/n)\t: ");
                    boolean fragile = scanner.next().charAt(0) == 'y';
                    scanner.nextLine();
                    System.out.print("Apakah ingin menambahkan bubble wrap? (y/n): ");
                    boolean bubbleWrap = scanner.next().charAt(0) == 'y';
                    scanner.nextLine();
                    daftarPaket[index] = new Cargo(namaBarang, jarak, jenisEkspedisi, berat, panjang, lebar, tinggiValue, fragile, bubbleWrap);
                } else {
                    System.out.print("Jenis makanan basah? (y/n)\t\t: ");
                    boolean sameday = scanner.next().charAt(0) == 'y';
                    scanner.nextLine();
                    System.out.print("Apakah ingin menambahkan bubble wrap? (y/n): ");
                    boolean bubbleWrap = scanner.next().charAt(0) == 'y';
                    scanner.nextLine();
                    daftarPaket[index] = new Food(namaBarang, jarak, jenisEkspedisi, berat, panjang, lebar, tinggiValue, sameday, bubbleWrap);
                }
            }
        }

        System.out.println("\n=== DETAIL PENGIRIMAN ===");
        System.out.println(sender.detail());
        System.out.println(receiver.detail());
        System.out.println(courier.detail());

        System.out.println(" ");
        System.out.println("No.\tNama Barang\t\tBerat\tEkspedisi\tKeterangan\t\t\t\t\tBiaya");

        double total = 0;

        for (int index = 0; index < length; index++) {
            System.out.println((index + 1) + "\t" + daftarPaket[index].detail() + "\tRp " + daftarPaket[index].hitungBiaya());
            total += daftarPaket[index].hitungBiaya();
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Total Biaya:\t\t\t\t\tRp " + total);

        scanner.close();
    }
}