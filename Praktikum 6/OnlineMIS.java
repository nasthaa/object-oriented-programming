import java.util.ArrayList;

class Mahasiswa {
    int nrp;
    String nama;
    double ipk;

    public Mahasiswa(int nrp, String nama, double ipk) {
        this.nrp = nrp;
        this.nama = nama;
        this.ipk = ipk;
    }

    public int getNrp() {
        return nrp;
    }
    
    public String getNama() {
        return nama;
    }
    
    public double getIpk() {
        return ipk;
    }

    public void display() {
        System.out.println("----\t\tDATA MAHASISWA\t\t-----\n");
        System.out.println("NRP\t: " + nrp + "\nNama\t: " + nama + "\nIPK\t: " + ipk + "\n");
    }
}

class MataKuliah {
    String kode;
    String nama;
    int kredit;

    public MataKuliah(String kode, String nama, int kredit) {
        this.kode = kode;
        this.nama = nama;
        this.kredit = kredit;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kreditBaru) {
        this.kredit = kreditBaru;
    }

    public void display() {
        System.out.println(kode + "\t" + nama + "\t" + kredit);
    }
}

class FRS {
    Mahasiswa mhs;
    ArrayList<MataKuliah> list = new ArrayList<>();

    public FRS(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public void tambahMatkul(MataKuliah mk) {
        list.add(mk);
    }

    public int totalKredit() {
        int total = 0;
        for (MataKuliah mk : list) {
            total += mk.getKredit();
        }
        return total;
    }

    public void display() {
        System.out.println("=============================================");
        System.out.println("Kode\t\tNama Mata Kuliah\tSKS");
        System.out.println("=============================================");

        for (int index = 0; index < list.size(); index++) {
            MataKuliah mk = list.get(index);
            mk.display();

            if (index < list.size() - 1) {
                System.out.println("---------------------------------------------");
            }
        }

        System.out.println("=============================================");
        System.out.println("\t\tTotal SKS\t:\t" + totalKredit());
    }
}

public class OnlineMIS {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa(600050, "ALthana Zaen", 3.65);

        MataKuliah mk1 = new MataKuliah("TI043103", "Basis Data Lanjut", 2);
        MataKuliah mk2 = new MataKuliah("KP000005", "English for Developing", 2);
        MataKuliah mk3 = new MataKuliah("KM000002", "Kreatifitas Mahasiswa 2", 1);

        FRS frs = new FRS(mhs);
        frs.tambahMatkul(mk1);
        frs.tambahMatkul(mk2);
        frs.tambahMatkul(mk3);

        mhs.display();
        frs.display();
    }
}