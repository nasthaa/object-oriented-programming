package app;

import java.util.ArrayList;
import java.util.List;

public class Departemen {
    private String nama;
    private List<ProgramStudi> daftarProgramStudi = new ArrayList<>();

    public Departemen(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public List<ProgramStudi> getDaftarProgramStudi() {
        return daftarProgramStudi;
    }

    public void tambahProgramStudi(ProgramStudi programStudi) {
        daftarProgramStudi.add(programStudi);
    }
}
