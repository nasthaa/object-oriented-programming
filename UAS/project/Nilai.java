public class Nilai {
    private double tugas1;
    private double tugas2;
    private double tugas3;
    private double tugas4;
    private double uts;
    private double uas;

    public Nilai(double tugas1, double tugas2, double tugas3, double tugas4, double uts, double uas) {
        this.tugas1 = tugas1;
        this.tugas2 = tugas2;
        this.tugas3 = tugas3;
        this.tugas4 = tugas4;
        this.uts = uts;
        this.uas = uas;
    }

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

    public void setNilaiByIndex(int index, double value) {
        switch(index) {
            case 1: setTugas1(value); break;
            case 2: setTugas2(value); break;
            case 3: setTugas3(value); break;
            case 4: setTugas4(value); break;
            case 5: setUts(value); break;
            case 6: setUas(value); break;
            default: break;
        }
    }

    public double getNilaiByIndex(int index) {
        switch(index) {
            case 1: return getTugas1();
            case 2: return getTugas2();
            case 3: return getTugas3();
            case 4: return getTugas4();
            case 5: return getUts();
            case 6: return getUas();
            default: return 0.0;
        }
    }
}
