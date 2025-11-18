package app;

public class NilaiSemester implements PerhitunganNilai {
    private String nrp;
    private int semester;
    private double tugas1;
    private double tugas2;
    private double tugas3;
    private double tugas4;
    private double uts;
    private double uas;

    public NilaiSemester(String nrp, int semester, double tugas1, double tugas2, double tugas3, double tugas4, double uts, double uas) {
        this.nrp = nrp;
        this.semester = semester;
        this.tugas1 = tugas1;
        this.tugas2 = tugas2;
        this.tugas3 = tugas3;
        this.tugas4 = tugas4;
        this.uts = uts;
        this.uas = uas;
    }

    public String getNrp() { return nrp; }
    public int getSemester() { return semester; }
    public double getTugas1() { return tugas1; }
    public double getTugas2() { return tugas2; }
    public double getTugas3() { return tugas3; }
    public double getTugas4() { return tugas4; }
    public double getUts() { return uts; }
    public double getUas() { return uas; }

    public void setTugas1(double tugas1) { this.tugas1 = tugas1; }
    public void setTugas2(double tugas2) { this.tugas2 = tugas2; }
    public void setTugas3(double tugas3) { this.tugas3 = tugas3; }
    public void setTugas4(double tugas4) { this.tugas4 = tugas4; }
    public void setUts(double uts) { this.uts = uts; }
    public void setUas(double uas) { this.uas = uas; }

    public double hitungRataRata() {
        return (tugas1 + tugas2 + tugas3 + tugas4 + uts + uas) / 6.0;
    }

    @Override
    public double hitungIPS() {
        double rata = hitungRataRata();
        return rata / 25.0;
    }
}
