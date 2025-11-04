class Pegawai{
    int nip;
    String nama;

    public Pegawai(int nip_pegawai){
        this(nip_pegawai,"No Name");
    }
    
    public Pegawai(int nip_pegawai, String nama_pegawai){
        this.nip = nip_pegawai;
        this.nama = nama_pegawai;
    }
}

public class TesPegawai{
    public static void main(String[] args) {
        Pegawai pegawai1 = new Pegawai(001);
        Pegawai pegawai2 = new Pegawai(002, "Agus");

        System.out.println(pegawai1.nip + " " + pegawai1.nama);
        System.out.println(pegawai2.nip + " " + pegawai2.nama);
    }
}