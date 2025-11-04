public class Taksi extends Mobil {
    private int tarifAwal;
    private int tarifPerKm;

    public int getTarifAwal() {
        return tarifAwal;
    }

    public void setTarifAwal(int tarifAwal) {
        this.tarifAwal = tarifAwal;
    }

    public int getTarifPerKm() {
        return tarifPerKm;
    }

    public void setTarifPerKm(int tarifPerKm) {
        this.tarifPerKm = tarifPerKm;
    }
}