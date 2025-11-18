package app;

import java.util.ArrayList;
import java.util.List;

public class Mahasiswa extends Person {
    private Departemen departemen;
    private ProgramStudi programStudi;
    private final List<NilaiSemester> daftarNilai = new ArrayList<>();

    public Mahasiswa(String nrp, String nama, Departemen departemen, ProgramStudi programStudi) {
        super(nrp, nama);
        this.departemen = departemen;
        this.programStudi = programStudi;
    }

    public Departemen getDepartemen() { return departemen; }
    public void setDepartemen(Departemen departemen) { this.departemen = departemen; }

    public ProgramStudi getProgramStudi() { return programStudi; }
    public void setProgramStudi(ProgramStudi programStudi) { this.programStudi = programStudi; }

    public List<NilaiSemester> getDaftarNilai() { return daftarNilai; }

    public void tambahNilai(NilaiSemester nilai) {
        daftarNilai.add(nilai);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("NRP\t\t: " + getNrp());
        System.out.println("Nama\t\t: " + getNama());
        System.out.println("Departemen\t: " + (departemen != null ? departemen.getNama() : "-"));
        System.out.println("Program Studi\t: " + (programStudi != null ? programStudi.getNama() : "-"));
    }

    public double hitungIPK() {
        return hitungIPK(this.daftarNilai);
    }

    public double hitungIPK(List<NilaiSemester> daftarNilai) {
        if (daftarNilai == null || daftarNilai.isEmpty()) return 0.0;
        double totalIps = 0.0;
        for (NilaiSemester nilaiSemester : daftarNilai) {
            totalIps += nilaiSemester.hitungIPS();
        }
        return totalIps / daftarNilai.size();
    }
}
