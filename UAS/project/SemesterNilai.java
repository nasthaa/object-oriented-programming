public class SemesterNilai {
    private int semester;
    private Nilai nilai;

    public SemesterNilai(int semester, Nilai nilai) {
        this.semester = semester;
        this.nilai = nilai;
    }

    public int getSemester() {
        return semester;
    }

    public Nilai getNilai() {
        return nilai;
    }

    public double hitungIPS() {
        double rata = nilai.hitungRataRata();
        return rata / 25.0;
    }
}
