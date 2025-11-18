import java.util.ArrayList;

public class DepartemenData {
    private ArrayList<Departemen> daftarDepartemen;

    public DepartemenData() {
        daftarDepartemen = new ArrayList<>();
        // isi dengan data contoh sesuai instruksi
        Departemen d1 = new Departemen("Teknik Elektronika");
        d1.tambahProdi(new ProgramStudi("D3 Teknik Elektronika", "D3"));
        d1.tambahProdi(new ProgramStudi("D3 Teknik Telekomunikasi", "D3"));
        d1.tambahProdi(new ProgramStudi("D3 Teknik Elektro Industri", "D3"));
        d1.tambahProdi(new ProgramStudi("S.Tr. Teknik Elektronika", "S.Tr"));
        d1.tambahProdi(new ProgramStudi("S.Tr. Teknik Telekomunikasi", "S.Tr"));
        d1.tambahProdi(new ProgramStudi("S.Tr. Teknik Elektro Industri", "S.Tr"));
        d1.tambahProdi(new ProgramStudi("S.Tr. Teknologi Rekayasa Internet", "S.Tr"));

        Departemen d2 = new Departemen("Teknik Informatika dan Komputer");
        d2.tambahProdi(new ProgramStudi("D3 Teknik Informatika", "D3"));
        d2.tambahProdi(new ProgramStudi("S.Tr. Teknik Informatika", "S.Tr"));
        d2.tambahProdi(new ProgramStudi("S.Tr. Teknik Komputer", "S.Tr"));
        d2.tambahProdi(new ProgramStudi("S.Tr. Sains Data Terapan", "S.Tr"));

        Departemen d3 = new Departemen("Teknik Multimedia Kreatif");
        d3.tambahProdi(new ProgramStudi("D3 Multimedia Broadcasting", "D3"));
        d3.tambahProdi(new ProgramStudi("S.Tr. Teknologi Game", "S.Tr"));
        d3.tambahProdi(new ProgramStudi("S.Tr. Teknologi Rekayasa Multimedia", "S.Tr"));

        Departemen d4 = new Departemen("Teknik Mekanika Energi");
        d4.tambahProdi(new ProgramStudi("S.Tr. Teknik Mekatronika", "S.Tr"));
        d4.tambahProdi(new ProgramStudi("S.Tr. Sistem Pembangkit Energi", "S.Tr"));

        daftarDepartemen.add(d1);
        daftarDepartemen.add(d2);
        daftarDepartemen.add(d3);
        daftarDepartemen.add(d4);
    }

    public ArrayList<Departemen> getDaftarDepartemen() {
        return daftarDepartemen;
    }
}
