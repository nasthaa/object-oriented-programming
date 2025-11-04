// Percobaan 1: Melakukan enkapsulasi pada suatu class

// Sebelum Enkapsulasi

// public class Mahasiswa {
//     public int nrp;
//     public String nama;

//     public Mahasiswa(int nrp, String nama) {
//         this.nrp = nrp;
//         this.nama = nama;
//     }

//     public static void main(String[] args) {
//         Mahasiswa mhs = new Mahasiswa(600050, "Ai");

//         System.out.println("Sebelum diubah");
//         System.out.println("NRP\t: " + mhs.nrp);
//         System.out.println("Nama\t: " + mhs.nama);

//         System.out.println("\nSetelah diubah");
//         mhs.nrp = 6000573;
//         mhs.nama = "Afif";
//         System.out.println("NRP\t: " + mhs.nrp);
//         System.out.println("Nama\t: " + mhs.nama);
//     }
// }

// Sesudah Enkapsulasi

// public class Mahasiswa {
//     private int nrp;
//     private String nama;

//     public Mahasiswa(int nrp, String nama) {
//         this.nrp = nrp;
//         this.nama = nama;
//     }

//     public int getNrp() {
//         return nrp;
//     }

//     public String getNama() {
//         return nama;
//     }

//     public void serNrp(int nrp) {
//         this.nrp = nrp;
//     }

//     public void setNama(String nama) {
//         this.nama = nama;
//     }

//     public static void main(String[] args) {
//         Mahasiswa mhs = new Mahasiswa(600050, "Ai");

//         System.out.println("Sebelum diubah");
//         System.out.println("NRP\t: " + mhs.getNrp());
//         System.out.println("Nama\t: " + mhs.getNama());

//         System.out.println("\nSetelah diubah");
//         mhs.serNrp(6000573);
//         mhs.setNama("Afif");
//         System.out.println("NRP\t: " + mhs.getNrp());
//         System.out.println("Nama\t: " + mhs.getNama());
//     }
// }

// Percobaan 2: Melakukan overloading constructor

public class Mahasiswa {
    private int nrp;
    private String nama;

    public Mahasiswa() {
        nrp = 0;
        nama = "";
    }

    public Mahasiswa(String nama) {
        nrp = 0;
        this.nama = nama;
    }

    public Mahasiswa(int nrp, String nama) {
        this.nrp = nrp;
        this.nama = nama;
    }
}