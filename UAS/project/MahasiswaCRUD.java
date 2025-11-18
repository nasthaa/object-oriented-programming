import java.util.ArrayList;
import java.util.Scanner;

public class MahasiswaCRUD {
    private DataManager dataManager;
    private DepartemenData departemenData;
    private InputValidator validator;
    private Scanner scanner;

    public MahasiswaCRUD(DataManager dataManager, DepartemenData departemenData, InputValidator validator) {
        this.dataManager = dataManager;
        this.departemenData = departemenData;
        this.validator = validator;
        this.scanner = new Scanner(System.in);
    }

    public void menuCreate() {
        while (true) {
            System.out.println("\nMenu create yang ingin digunakan:");
            System.out.println("1. Entry data mahasiswa (baru)");
            System.out.println("2. Tambahkan data nilai semester");
            System.out.println("3. Kembali ke menu utama");
            int pilihan = validator.validasiMenu(scanner, 1, 3, "Masukkan pilihan Anda (1-3): ");
            if (pilihan == 1) {
                buatDataMahasiswaBaru();
            } else if (pilihan == 2) {
                tambahSemesterKeMahasiswa();
            } else {
                break;
            }
        }
    }

    private void buatDataMahasiswaBaru() {
        System.out.println("\nPilih departemen:");
        ArrayList<Departemen> deps = departemenData.getDaftarDepartemen();
        for (int i = 0; i < deps.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, deps.get(i).getNamaDepartemen());
        }
        System.out.printf("%d. Kembali ke menu create\n", deps.size() + 1);
        int pilihDept = validator.validasiMenu(scanner, 1, deps.size() + 1, "Masukkan pilihan Anda (1-" + (deps.size() + 1) + "): ");
        if (pilihDept == deps.size() + 1) return;

        Departemen pilihanDepartemen = deps.get(pilihDept - 1);
        ArrayList<ProgramStudi> prodis = pilihanDepartemen.getDaftarProdi();
        System.out.println("\nPilih program studi:");
        for (int i = 0; i < prodis.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, prodis.get(i).getNamaProdi());
        }
        System.out.printf("%d. Kembali ke menu create\n", prodis.size() + 1);
        int pilihProdi = validator.validasiMenu(scanner, 1, prodis.size() + 1, "Masukkan pilihan Anda (1-" + (prodis.size() + 1) + "): ");
        if (pilihProdi == prodis.size() + 1) return;

        ProgramStudi pilihanProdi = prodis.get(pilihProdi - 1);

        System.out.println("\nMasukkan data Mahasiswa:");
        System.out.print("NRP\t: ");
        String nrp = scanner.nextLine().trim();
        if (nrp.isEmpty()) {
            System.out.println("NRP tidak boleh kosong!");
            return;
        }
        if (dataManager.cariMahasiswaByNrp(nrp) != null) {
            System.out.println("NRP sudah ada! Data tidak ditambahkan.");
            return;
        }

        System.out.print("Nama\t: ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong!");
            return;
        }

        System.out.println("\nMasukkan data nilai:");
        int semester = validator.validasiInt(scanner, "Semester: ");

        System.out.println("\nMasukkan nilai Mahasiswa (0-100):");
        double tugas1 = validator.validasiDouble(scanner, "Tugas 1\t: ");
        double tugas2 = validator.validasiDouble(scanner, "Tugas 2\t: ");
        double tugas3 = validator.validasiDouble(scanner, "Tugas 3\t: ");
        double tugas4 = validator.validasiDouble(scanner, "Tugas 4\t: ");
        double uts = validator.validasiDouble(scanner, "UTS\t: ");
        double uas = validator.validasiDouble(scanner, "UAS\t: ");

        Nilai nilai = new Nilai(tugas1, tugas2, tugas3, tugas4, uts, uas);
        SemesterNilai semesterNilai = new SemesterNilai(semester, nilai);
        Mahasiswa mahasiswa = new Mahasiswa(nrp, nama, pilihanDepartemen.getNamaDepartemen(), pilihanProdi.getNamaProdi());
        boolean tambahSemester = mahasiswa.tambahSemester(semesterNilai);
        // if (!tambahSemester) {
        //     System.out.println("Semester sudah ada untuk mahasiswa ini. Data semester tidak ditambahkan.");
        //     return;
        // }
        boolean sukses = dataManager.tambahMahasiswa(mahasiswa);
        if (sukses) {
            System.out.println("Data berhasil ditambahkan!");
        }
        // else {
        //     System.out.println("Data gagal ditambahkan! NRP sudah ada.");
        // }
    }

    private void tambahSemesterKeMahasiswa() {
        System.out.print("\nMasukkan NRP\t\t: ");
        String nrp = scanner.nextLine().trim();
        Mahasiswa m = dataManager.cariMahasiswaByNrp(nrp);
        if (m == null) {
            System.out.println("NRP tidak ditemukan!");
            return;
        }
        int semester = validator.validasiInt(scanner, "Masukkan semester\t: ");
        System.out.println("Masukkan nilai Mahasiswa (0-100):");
        double tugas1 = validator.validasiDouble(scanner, "Tugas 1\t: ");
        double tugas2 = validator.validasiDouble(scanner, "Tugas 2\t: ");
        double tugas3 = validator.validasiDouble(scanner, "Tugas 3\t: ");
        double tugas4 = validator.validasiDouble(scanner, "Tugas 4\t: ");
        double uts = validator.validasiDouble(scanner, "UTS\t: ");
        double uas = validator.validasiDouble(scanner, "UAS\t: ");
        Nilai nilai = new Nilai(tugas1, tugas2, tugas3, tugas4, uts, uas);
        SemesterNilai semesterNilai = new SemesterNilai(semester, nilai);
        boolean sukses = m.tambahSemester(semesterNilai);
        if (sukses) {
            System.out.println("Data semester berhasil ditambahkan!");
        } else {
            System.out.println("Semester tersebut sudah ada. Data gagal ditambahkan.");
        }
    }

    public void menuRead() {
        if (dataManager.getAllMahasiswa().isEmpty()) {
            System.out.println("Belum ada data! Silakan menambahkan data terlebih dahulu!");
            return;
        }
        while (true) {
            System.out.println("\nMenu tampilan yang ingin digunakan:");
            System.out.println("1. Tampilkan seluruh data");
            System.out.println("2. Cari dan tampilkan berdasarkan NRP");
            System.out.println("3. Kembali ke halaman utama");
            int pilihan = validator.validasiMenu(scanner, 1, 3, "Masukkan pilihan Anda (1-3): ");
            if (pilihan == 1) {
                tampilkanKeseluruhan();
            } else if (pilihan == 2) {
                tampilkanSatuMahasiswa();
            } else {
                break;
            }
        }
    }

    private void tampilkanKeseluruhan() {
        ArrayList<Mahasiswa> list = dataManager.getAllMahasiswa();
        System.out.println();
        // Kelompokkan per departemen, prodi, semester
        for (Mahasiswa m : list) {
            System.out.println("Departemen\t: " + m.getDepartemen());
            System.out.println("Program Studi\t: " + m.getProgramStudi());
            System.out.printf("NRP\t\t: " + m.getNrp() + "\n");
            System.out.printf("Nama\t\t: " + m.getNama() + "\n");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| Semester\t| Tugas 1\t| Tugas 2\t| Tugas 3\t| Tugas 4\t| UTS\t\t| UAS\t\t| IPS\t\t|");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            for (SemesterNilai s : m.getSemesterList()) {
                Nilai n = s.getNilai();
                System.out.printf("| %d\t\t| %.1f\t\t| %.1f\t\t| %.1f\t\t| %.1f\t\t| %.1f\t\t| %.1f\t\t| %.2f\t\t|\n",
                        s.getSemester(),
                        n.getTugas1(), n.getTugas2(), n.getTugas3(), n.getTugas4(), n.getUts(), n.getUas(),
                        s.hitungIPS());
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        }
    }

    private void tampilkanSatuMahasiswa() {
        System.out.print("\nMasukkan NRP: ");
        String nrp = scanner.nextLine().trim();
        Mahasiswa m = dataManager.cariMahasiswaByNrp(nrp);
        if (m == null) {
            System.out.println("NRP tidak ditemukan! Kembali ke menu utama.");
            return;
        }
        System.out.println();
        m.tampilkanInfo();
        System.err.println();
        System.out.println("Semester\tTugas 1\tTugas 2\tTugas 3\tTugas 4\tUTS\tUAS\tIPS");
        for (SemesterNilai s : m.getSemesterList()) {
            Nilai n = s.getNilai();
            System.out.printf("%d\t\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.2f\n",
                    s.getSemester(),
                    n.getTugas1(), n.getTugas2(), n.getTugas3(), n.getTugas4(), n.getUts(), n.getUas(),
                    s.hitungIPS());
        }
    }

    public void menuUpdate() {
        if (dataManager.getAllMahasiswa().isEmpty()) {
            System.out.println("Belum ada data! Silakan menambahkan data terlebih dahulu!");
            return;
        }
        System.out.print("\nMasukkan NRP: ");
        String nrp = scanner.nextLine().trim();
        Mahasiswa m = dataManager.cariMahasiswaByNrp(nrp);
        if (m == null) {
            System.out.println("NRP tidak ditemukan! Silakan masukkan NRP lagi pada operasi berikutnya.");
            return;
        }
        // tampilkan info awal
        System.out.println("Data saat ini:");
        m.tampilkanInfo();

        while (true) {
            System.out.println("\nData yang ingin diubah:");
            System.out.println("1. Data Mahasiswa");
            System.out.println("2. Data Nilai");
            System.out.println("3. Kembali ke halaman utama");
            int pilihan = validator.validasiMenu(scanner, 1, 3, "Masukkan pilihan Anda (1-3): ");
            if (pilihan == 1) {
                updateDataMahasiswa(m);
            } else if (pilihan == 2) {
                updateDataNilai(m);
            } else break;
        }
    }

    private void updateDataMahasiswa(Mahasiswa m) {
        System.out.println("\nUbah Data Mahasiswa");
        System.out.println("1. Departemen");
        System.out.println("2. Jurusan");
        System.out.println("3. NRP");
        System.out.println("4. Nama");
        System.out.println("5. Kembali");
        int pilihan = validator.validasiMenu(scanner, 1, 5, "Masukkan pilihan Anda (1-5): ");
        if (pilihan == 1) {
            System.out.println("\nPilih departemen baru:");
            ArrayList<Departemen> deps = departemenData.getDaftarDepartemen();
            for (int i = 0; i < deps.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, deps.get(i).getNamaDepartemen());
            }
            int idx = validator.validasiMenu(scanner, 1, deps.size(), "Masukkan plihan Anda: ");
            Departemen d = deps.get(idx - 1);
            m.setDepartemen(d.getNamaDepartemen());
            System.out.println("Departemen diubah.");

            System.out.println("\nKarena departemen berubah, silakan pilih program studi baru:");
            ArrayList<ProgramStudi> newProdiList = d.getDaftarProdi();

            for (int i = 0; i < newProdiList.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, newProdiList.get(i).getNamaProdi());
            }

            int pilihProdiBaru = validator.validasiMenu(scanner, 1, newProdiList.size(),
                    "Masukkan pilihan program studi: ");

            m.setProgramStudi(newProdiList.get(pilihProdiBaru - 1).getNamaProdi());
            System.out.println("Program studi otomatis diperbarui sesuai departemen baru.");
        } else if (pilihan == 2) {
            System.out.println("\nPilih jurusan baru (dari departemen saat ini):");
            ArrayList<Departemen> deps = departemenData.getDaftarDepartemen();
            Departemen current = null;
            for (Departemen dep : deps) if (dep.getNamaDepartemen().equalsIgnoreCase(m.getDepartemen())) current = dep;
            if (current == null) current = deps.get(0);
            ArrayList<ProgramStudi> prodis = current.getDaftarProdi();
            for (int i = 0; i < prodis.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, prodis.get(i).getNamaProdi());
            }
            int idx = validator.validasiMenu(scanner, 1, prodis.size(), "Masukkan plihan Anda: ");
            m.setProgramStudi(prodis.get(idx - 1).getNamaProdi());
            System.out.println("Program studi diubah.");
        } else if (pilihan == 3) {
            System.out.print("\nMasukkan NRP baru: ");
            String nrpBaru = scanner.nextLine().trim();
            if (nrpBaru.isEmpty()) {
                System.out.println("NRP tidak boleh kosong.");
            } else if (dataManager.cariMahasiswaByNrp(nrpBaru) != null) {
                System.out.println("NRP sudah ada. Tidak bisa mengganti.");
            } else {
                // update: hapus dari dataManager, ubah nrp, tambah kembali
                dataManager.hapusMahasiswa(m.getNrp());
                // refleksi: Mahasiswa tidak punya setter nrp, buat objek baru
                Mahasiswa updated = new Mahasiswa(nrpBaru, m.getNama(), m.getDepartemen(), m.getProgramStudi());
                for (SemesterNilai s : m.getSemesterList()) updated.tambahSemester(s);
                dataManager.tambahMahasiswa(updated);
                System.out.println("NRP diubah.");
            }
        } else if (pilihan == 4) {
            System.out.print("\nMasukkan nama baru: ");
            String namaBaru = scanner.nextLine().trim();
            m.setNama(namaBaru);
            System.out.println("Nama diubah.");
        }
    }

    private void updateDataNilai(Mahasiswa m) {
        int semester = validator.validasiInt(scanner, "\nSemester yang ingin diubah: ");
        SemesterNilai s = m.cariSemester(semester);
        if (s == null) {
            System.out.println("Semester tidak ditemukan untuk mahasiswa ini.");
            return;
        }
        while (true) {
            System.out.println("\nUbah data nilai:");
            System.out.println("1. Tugas 1");
            System.out.println("2. Tugas 2");
            System.out.println("3. Tugas 3");
            System.out.println("4. Tugas 4");
            System.out.println("5. UTS");
            System.out.println("6. UAS");
            System.out.println("7. Kembali");
            int pilihan = validator.validasiMenu(scanner, 1, 7, "Masukkan pilihan Anda (1-7): ");
            if (pilihan == 7) break;
            double nilaiBaru = validator.validasiDouble(scanner, "\nMasukkan nilai baru (0-100): ");
            s.getNilai().setNilaiByIndex(pilihan, nilaiBaru);
            System.out.println("Nilai berhasil diubah.");
            // show updated semester info briefly
            Nilai n = s.getNilai();
            System.out.printf("\nSemester %d updated: \nTugas 1\t: %.1f \nTugas 2\t: %.1f \nTugas 3\t: %.1f \nTugas 4\t: %.1f \nUTS\t: %.1f \nUAS\t: %.1f \nIPS\t: %.2f\n",
                    s.getSemester(), n.getTugas1(), n.getTugas2(), n.getTugas3(), n.getTugas4(), n.getUts(), n.getUas(), s.hitungIPS());
        }
    }

    public void menuDelete() {
        if (dataManager.getAllMahasiswa().isEmpty()) {
            System.out.println("Belum ada data! Silakan menambahkan data terlebih dahulu!");
            return;
        }
        System.out.print("\nMasukkan NRP: ");
        String nrp = scanner.nextLine().trim();
        Mahasiswa m = dataManager.cariMahasiswaByNrp(nrp);
        if (m == null) {
            System.out.println("NRP tidak ditemukan!");
            return;
        }
        System.out.println("\nData yang ingin dihapus:");
        System.out.println("1. Data mahasiswa");
        System.out.println("2. Data nilai");
        System.out.println("3. Kembali ke halaman utama");
        int pilihan = validator.validasiMenu(scanner, 1, 3, "Masukkan pilihan Anda (1-3): ");
        if (pilihan == 1) {
            System.out.print("\nData ini berisikan nilai sekaligus. Yakin ingin menghapus? Data yang dihapus tidak dapat dikembalikan! Y/N: ");
            String confirm = scanner.nextLine().trim();
            if (confirm.equalsIgnoreCase("Y")) {
                boolean hapus = dataManager.hapusMahasiswa(nrp);
                System.out.println(hapus ? "Data mahasiswa berhasil dihapus." : "Gagal menghapus data.");
            } else {
                System.out.println("Hapus dibatalkan.");
            }
        } else if (pilihan == 2) {
            int semester = validator.validasiInt(scanner, "\nPilih semester yang ingin dihapus: ");
            SemesterNilai s = m.cariSemester(semester);
            if (s == null) {
                System.out.println("Semester tidak ditemukan!");
                return;
            }
            System.out.print("Yakin ingin menghapus? Data yang dihapus tidak dapat dikembalikan! Y/N: ");
            String confirm = scanner.nextLine().trim();
            if (confirm.equalsIgnoreCase("Y")) {
                m.getSemesterList().remove(s);
                System.out.println("Semester berhasil dihapus.");
            } else {
                System.out.println("Hapus semester dibatalkan.");
            }
        } else {
            // kembali
        }
    }
}
