import java.util.ArrayList;

public class Departemen {
    private String namaDepartemen;
    private ArrayList<ProgramStudi> daftarProdi;

    public Departemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
        this.daftarProdi = new ArrayList<>();
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public ArrayList<ProgramStudi> getDaftarProdi() {
        return daftarProdi;
    }

    public void tambahProdi(ProgramStudi prodi) {
        daftarProdi.add(prodi);
    }
}
