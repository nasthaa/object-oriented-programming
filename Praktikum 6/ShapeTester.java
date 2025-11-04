class Shape {
    public double length;
    public double width;
    public double height;
    public double volume;

    public Shape(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        calculateVolume();
    }

    public Double compareTo(Shape other) {
        return Math.abs(this.volume - other.volume);
    }
    
    public void calculateVolume() {
        this.volume = length * width * height;
    }

    public void cetak() {
        System.out.println("panjang x lebar x tinggi = " + length + " x " + width + " x " + height);
        System.out.println("Volume = " + volume);
    }
}

public class ShapeTester{
    public static void main(String args[]){
        Shape kubus = new Shape(5, 5, 5);
        Shape balok = new Shape(10, 5, 5);
        kubus.cetak();
        balok.cetak();
        Double selisihVolume = kubus.compareTo(balok);
        System.out.println("Selisih Volume = "+selisihVolume);
    }
}
