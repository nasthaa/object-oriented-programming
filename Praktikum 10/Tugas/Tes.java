public class Tes {
    public static void main(String[] args) {
        Truk truk1 = new Truk();
        truk1.setJmlRoda(4);
        truk1.setWarna("Kuning");
        truk1.setBahanBakar("Solar");
        truk1.setKapasitasMesin(1500);
        truk1.setMuatanMaks(1000);

        Truk truk2 = new Truk();
        truk2.setJmlRoda(6);
        truk2.setWarna("Merah");
        truk2.setBahanBakar("Solar");
        truk2.setKapasitasMesin(2000);
        truk2.setMuatanMaks(5000);

        Taksi taksi1 = new Taksi();
        taksi1.setJmlRoda(4);
        taksi1.setWarna("Oranye");
        taksi1.setBahanBakar("Bensin");
        taksi1.setKapasitasMesin(1500);
        taksi1.setTarifAwal(10000);
        taksi1.setTarifPerKm(5000);

        Taksi taksi2 = new Taksi();
        taksi2.setJmlRoda(4);
        taksi2.setWarna("Biru");
        taksi2.setBahanBakar("Bensin");
        taksi2.setKapasitasMesin(1300);
        taksi2.setTarifAwal(7000);
        taksi2.setTarifPerKm(3500);

        Sepeda sepeda1 = new Sepeda();
        sepeda1.setJmlRoda(3);
        sepeda1.setWarna("Hitam");
        sepeda1.setJmlSadel("1");
        sepeda1.setJmlGir(5);

        Sepeda sepeda2 = new Sepeda();
        sepeda2.setJmlRoda(2);
        sepeda2.setWarna("Putih");
        sepeda2.setJmlSadel("2");
        sepeda2.setJmlGir(5);

        System.out.println("---\t DATA TRUK \t---\n");
        System.out.println("Truk 1:");
        System.out.println("- Jumlah Roda: " + truk1.getJmlRoda());
        System.out.println("- Warna: " + truk1.getWarna());
        System.out.println("- Bahan Bakar: " + truk1.getBahanBakar());
        System.out.println("- Kapasitas Mesin: " + truk1.getKapasitasMesin() + " cc");
        System.out.println("- Muatan Maksimal: " + truk1.getMuatanMaks() + " kg\n");

        System.out.println("Truk 2:");
        System.out.println("- Jumlah Roda: " + truk2.getJmlRoda());
        System.out.println("- Warna: " + truk2.getWarna());
        System.out.println("- Bahan Bakar: " + truk2.getBahanBakar());
        System.out.println("- Kapasitas Mesin: " + truk2.getKapasitasMesin() + " cc");
        System.out.println("- Muatan Maksimal: " + truk2.getMuatanMaks() + " kg\n\n");

        System.out.println("---\t DATA TAKSI \t---\n");
        System.out.println("Taksi 1:");
        System.out.println("- Jumlah Roda: " + taksi1.getJmlRoda());
        System.out.println("- Warna: " + taksi1.getWarna());
        System.out.println("- Bahan Bakar: " + taksi1.getBahanBakar());
        System.out.println("- Kapasitas Mesin: " + taksi1.getKapasitasMesin() + " cc");
        System.out.println("- Tarif Awal: Rp " + taksi1.getTarifAwal());
        System.out.println("- Tarif Per Km: Rp " + taksi1.getTarifPerKm() + "\n");

        System.out.println("Taksi 2:");
        System.out.println("- Jumlah Roda: " + taksi2.getJmlRoda());
        System.out.println("- Warna: " + taksi2.getWarna());
        System.out.println("- Bahan Bakar: " + taksi2.getBahanBakar());
        System.out.println("- Kapasitas Mesin: " + taksi2.getKapasitasMesin() + " cc");
        System.out.println("- Tarif Awal: Rp " + taksi2.getTarifAwal());
        System.out.println("- Tarif Per Km: Rp " + taksi2.getTarifPerKm() + "\n\n");

        System.out.println("---\t DATA SEPEDA \t---\n");
        System.out.println("Sepeda 1:");
        System.out.println("- Jumlah Roda: " + sepeda1.getJmlRoda());
        System.out.println("- Warna: " + sepeda1.getWarna());
        System.out.println("- Jumlah Sadel: " + sepeda1.getJmlSadel());
        System.out.println("- Jumlah Gir: " + sepeda1.getJmlGir() + "\n");

        System.out.println("Sepeda 2:");
        System.out.println("- Jumlah Roda: " + sepeda2.getJmlRoda());
        System.out.println("- Warna: " + sepeda2.getWarna());
        System.out.println("- Jumlah Sadel: " + sepeda2.getJmlSadel());
        System.out.println("- Jumlah Gir: " + sepeda2.getJmlGir());
    }
}