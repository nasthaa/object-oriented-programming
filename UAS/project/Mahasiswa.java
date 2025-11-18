import java.util.ArrayList;

public class Mahasiswa extends Person {
    private String nrp;
    private String departemen;
    private String programStudi;
    private ArrayList<SemesterNilai> semesterList;

    public Mahasiswa(String nrp, String nama, String departemen, String programStudi) {
        super(nama);
        this.nrp = nrp;
        this.departemen = departemen;
        this.programStudi = programStudi;
        this.semesterList = new ArrayList<>();
    }

    public String getNrp() {
        return nrp;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public ArrayList<SemesterNilai> getSemesterList() {
        return semesterList;
    }

    public boolean tambahSemester(SemesterNilai semesterNilai) {
        for (SemesterNilai s : semesterList) {
            if (s.getSemester() == semesterNilai.getSemester()) {
                return false;
            }
        }
        semesterList.add(semesterNilai);
        return true;
    }

    public SemesterNilai cariSemester(int semester) {
        for (SemesterNilai s : semesterList) {
            if (s.getSemester() == semester) {
                return s;
            }
        }
        return null;
    }

    public double hitungIPK() {
        if (semesterList.isEmpty()) return 0.0;
        double totalIps = 0.0;
        for (SemesterNilai s : semesterList) {
            totalIps += s.hitungIPS();
        }
        return totalIps / semesterList.size();
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("NRP\t\t: " + nrp);
        System.out.println("Nama\t\t: " + getNama());
        System.out.println("Departemen\t: " + departemen);
        System.out.println("Program Studi\t: " + programStudi);
        System.out.printf("IPK\t\t: %.2f%n", hitungIPK());
    }
}
