import java.util.ArrayList;

public class DataManager {
    private ArrayList<Mahasiswa> mahasiswaList;

    public DataManager() {
        this.mahasiswaList = new ArrayList<>();
    }

    public boolean tambahMahasiswa(Mahasiswa m) {
        if (cariMahasiswaByNrp(m.getNrp()) != null) return false;
        mahasiswaList.add(m);
        return true;
    }

    public Mahasiswa cariMahasiswaByNrp(String nrp) {
        for (Mahasiswa m : mahasiswaList) {
            if (m.getNrp().equalsIgnoreCase(nrp)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Mahasiswa> getAllMahasiswa() {
        return mahasiswaList;
    }

    public boolean hapusMahasiswa(String nrp) {
        Mahasiswa found = cariMahasiswaByNrp(nrp);
        if (found != null) {
            mahasiswaList.remove(found);
            return true;
        }
        return false;
    }
}
