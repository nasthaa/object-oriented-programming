package app;

import java.util.List;
import java.util.Scanner;

public class AppMain {

    private static Scanner scanner = new Scanner(System.in);
    private static MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
    private static NilaiDAO nilaiDAO = new NilaiDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MENU CRUD ===");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit Program");
            System.out.print("Pilihan Anda (1-5): ");

            int pilihan = inputAngkaMenu(1, 5);

            switch (pilihan) {
                case 1 -> menuCreate();
                case 2 -> menuRead();
                case 3 -> menuUpdate();
                case 4 -> menuDelete();
                case 5 -> {
                    System.out.println("Program selesai.");
                    return;
                }
            }
        }
    }

    // ================================================================
    //  MENU CREATE
    // ================================================================
    private static void menuCreate() {
        System.out.println("\n=== MENU CREATE ===");
        System.out.println("1. Data Baru");
        System.out.println("2. Semester Baru");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda (1-3): ");

        int pilihan = inputAngkaMenu(1, 3);

        switch (pilihan) {
            case 1 -> createDataMahasiswa();
            case 2 -> createSemesterBaru();
            case 3 -> {}
        }
    }

    private static void createDataMahasiswa() {
        System.out.println("\n=== Tambah Data Mahasiswa Baru ===");

        // Input Departemen
        System.out.println("Masukkan Departemen:");
        System.out.println("1. Teknik Elektronika");
        System.out.println("2. Teknik Informatika dan Komputer");
        System.out.println("3. Teknik Multimedia Kreatif");
        System.out.println("4. Teknik Mekanika Energi");
        System.out.print("Pilihan Anda (1-4): ");
        int kodeDepartemen = inputAngkaMenu(1, 4);

        String departemen = switch (kodeDepartemen) {
            case 1 -> "Teknik Elektronika";
            case 2 -> "Teknik Informatika dan Komputer";
            case 3 -> "Teknik Multimedia Kreatif";
            default -> "Teknik Mekanika Energi";
        };

        // Input Program Studi
        String programStudi = pilihProgramStudi(kodeDepartemen);

        // Input data mahasiswa
        System.out.print("Masukkan NRP: ");
        String nrp = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        int semester = inputSemester();

        // Input nilai
        Nilai nilai = inputNilai(nrp, semester);

        System.out.println("Menyimpan data...");

        try {
            mahasiswaDAO.insert(new Mahasiswa(departemen, programStudi, nrp, nama));
            nilaiDAO.insert(nilai);
            System.out.println("Data berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Data gagal ditambahkan! Error: " + e.getMessage());
        }
    }

    private static void createSemesterBaru() {
        System.out.println("\n=== Tambah Semester Baru ===");

        System.out.print("Masukkan NRP: ");
        String nrp = scanner.nextLine();

        Mahasiswa mahasiswa = mahasiswaDAO.getByNrp(nrp);
        if (mahasiswa == null) {
            System.out.println("NRP tidak ditemukan!");
            return;
        }

        System.out.println("Nama: " + mahasiswa.getNama());

        int semester = inputSemester();

        Nilai nilai = inputNilai(nrp, semester);

        try {
            nilaiDAO.insert(nilai);
            System.out.println("Data berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Data gagal ditambahkan! Error: " + e.getMessage());
        }
    }

    // ================================================================
    //  MENU READ
    // ================================================================
    private static void menuRead() {
        if (!adaData()) {
            System.out.println("Belum ada data! Silakan menambahkan data terlebih dahulu!");
            return;
        }

        System.out.println("\n=== MENU READ ===");
        System.out.println("1. Keseluruhan Data");
        System.out.println("2. Salah Satu Data");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda (1-3): ");

        int pilihan = inputAngkaMenu(1, 3);

        switch (pilihan) {
            case 1 -> tampilkanSemuaData();
            case 2 -> tampilkanSatuMahasiswa();
            case 3 -> {}
        }
    }

    private static void tampilkanSemuaData() {
        List<Nilai> daftarNilai = nilaiDAO.getAll();

        int currentSemester = -1;

        for (Nilai n : daftarNilai) {
            if (n.getSemester() != currentSemester) {
                currentSemester = n.getSemester();
                Mahasiswa m = mahasiswaDAO.getByNrp(n.getNrp());

                System.out.println("\nDepartemen: " + m.getDepartemen());
                System.out.println("Program Studi: " + m.getProgramStudi());
                System.out.println("Semester: " + n.getSemester());
                System.out.println("NRP\tNama\tT1\tT2\tT3\tT4\tUTS\tUAS\tIPS");
            }

            Mahasiswa m = mahasiswaDAO.getByNrp(n.getNrp());
            System.out.println(m.getNrp() + "\t" +
                    m.getNama() + "\t" +
                    n.getTugas1() + "\t" +
                    n.getTugas2() + "\t" +
                    n.getTugas3() + "\t" +
                    n.getTugas4() + "\t" +
                    n.getUts() + "\t" +
                    n.getUas() + "\t" +
                    n.hitungIPS());
        }
    }

    private static void tampilkanSatuMahasiswa() {
        System.out.print("Masukkan NRP: ");
        String nrp = scanner.nextLine();

        Mahasiswa m = mahasiswaDAO.getByNrp(nrp);
        if (m == null) {
            System.out.print("NRP tidak ditemukan! \nSilakan masukkan NRP lagi: ");
            return;
        }

        List<Nilai> daftarNilai = nilaiDAO.getByNrp(nrp);

        double totalIPS = 0;
        for (Nilai n : daftarNilai) totalIPS += n.hitungIPS();

        double ipk = daftarNilai.isEmpty() ? 0 : totalIPS / daftarNilai.size();

        System.out.println("\nNRP: " + m.getNrp());
        System.out.println("Nama: " + m.getNama());
        System.out.println("Departemen: " + m.getDepartemen());
        System.out.println("Program Studi: " + m.getProgramStudi());
        System.out.println("IPK: " + ipk);

        System.out.println("\nSemester\tT1\tT2\tT3\tT4\tUTS\tUAS\tIPS");
        for (Nilai n : daftarNilai) {
            System.out.println(n.getSemester() + "\t\t" +
                    n.getTugas1() + "\t" +
                    n.getTugas2() + "\t" +
                    n.getTugas3() + "\t" +
                    n.getTugas4() + "\t" +
                    n.getUts() + "\t" +
                    n.getUas() + "\t" +
                    n.hitungIPS());
        }
    }

    // ================================================================
    //  MENU UPDATE
    // ================================================================
    private static void menuUpdate() {

        if (!adaData()) {
            System.out.println("Belum ada data! Silakan menambahkan data terlebih dahulu!");
            return;
        }

        System.out.println("\n=== MENU UPDATE ===");
        System.out.print("Masukkan NRP: ");
        String nrp = scanner.nextLine();

        Mahasiswa mahasiswa = mahasiswaDAO.getByNrp(nrp);

        if (mahasiswa == null) {
            System.out.println("NRP tidak ditemukan!");
            return;
        }

        tampilkanSatuMahasiswa(nrp);

        System.out.println("\nData yang ingin diubah:");
        System.out.println("1. Data Mahasiswa");
        System.out.println("2. Data Nilai");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda (1-3): ");

        int pilih = inputAngkaMenu(1, 3);

        switch (pilih) {
            case 1 -> updateDataMahasiswa(mahasiswa);
            case 2 -> updateDataNilai(nrp);
            case 3 -> {}
        }
    }

    private static void updateDataMahasiswa(Mahasiswa m) {
        System.out.println("\nUbah Data Mahasiswa:");
        System.out.println("1. Departemen");
        System.out.println("2. Program Studi");
        System.out.println("3. NRP");
        System.out.println("4. Nama");
        System.out.println("5. Kembali");
        System.out.print("Pilihan Anda (1-5): ");

        int pilih = inputAngkaMenu(1, 5);

        switch (pilih) {
            case 1 -> {
                int depart = pilihDepartemen();
                m.setDepartemen(getNamaDepartemen(depart));
                m.setProgramStudi(pilihProgramStudi(depart));
            }
            case 2 -> {
                int depart = pilihDepartemen();
                m.setProgramStudi(pilihProgramStudi(depart));
            }
            case 3 -> {
                System.out.print("Masukkan NRP Baru: ");
                m.setNrp(scanner.nextLine());
            }
            case 4 -> {
                System.out.print("Masukkan Nama Baru: ");
                m.setNama(scanner.nextLine());
            }
            case 5 -> {
                return;
            }
        }

        mahasiswaDAO.update(m);
        System.out.println("Data berhasil diupdate!");
    }

    private static void updateDataNilai(String nrp) {
        System.out.print("Semester yang ingin diubah: ");
        int semester = inputAngka();

        Nilai nilai = nilaiDAO.getByNrpSemester(nrp, semester);

        if (nilai == null) {
            System.out.println("Semester tidak ditemukan!");
            return;
        }

        System.out.println("\nUbah data nilai:");
        System.out.println("1. Tugas 1");
        System.out.println("2. Tugas 2");
        System.out.println("3. Tugas 3");
        System.out.println("4. Tugas 4");
        System.out.println("5. UTS");
        System.out.println("6. UAS");
        System.out.println("7. Kembali");
        System.out.print("Pilihan Anda (1-7): ");

        int pilih = inputAngkaMenu(1, 7);

        switch (pilih) {
            case 1 -> {
                System.out.print("Tugas 1: ");
                nilai.setTugas1(inputNilai());
            }
            case 2 -> {
                System.out.print("Tugas 2: ");
                nilai.setTugas2(inputNilai());
            }
            case 3 -> {
                System.out.print("Tugas 3: ");
                nilai.setTugas3(inputNilai());
            }
            case 4 -> {
                System.out.print("Tugas 4: ");
                nilai.setTugas4(inputNilai());
            }
            case 5 -> {
                System.out.print("UTS: ");
                nilai.setUts(inputNilai());
            }
            case 6 -> {
                System.out.print("UAS: ");
                nilai.setUas(inputNilai());
            }
            case 7 -> {
                return;
            }
        }

        nilaiDAO.update(nilai);
        System.out.println("Data nilai berhasil diupdate!");
        tampilkanSatuMahasiswa(nrp);
    }

    // ================================================================
    //  MENU DELETE
    // ================================================================
    private static void menuDelete() {

        if (!adaData()) {
            System.out.println("Belum ada data! Silakan menambahkan data terlebih dahulu!");
            return;
        }

        System.out.println("\n=== MENU DELETE ===");

        System.out.print("Masukkan NRP: ");
        String nrp = scanner.nextLine();

        Mahasiswa mahasiswa = mahasiswaDAO.getByNrp(nrp);

        if (mahasiswa == null) {
            System.out.println("NRP tidak ditemukan!");
            return;
        }

        tampilkanSatuMahasiswa(nrp);

        System.out.println("\nData yang ingin dihapus:");
        System.out.println("1. Data Mahasiswa");
        System.out.println("2. Data Nilai");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda (1-3): ");

        int pilih = inputAngkaMenu(1, 3);

        switch (pilih) {
            case 1 -> hapusMahasiswa(nrp);
            case 2 -> hapusNilai(nrp);
            case 3 -> {}
        }
    }

    private static void hapusMahasiswa(String nrp) {
        System.out.print("Yakin ingin menghapus seluruh data? (Y/N): ");
        String yakin = scanner.nextLine().toUpperCase();

        if (yakin.equals("Y")) {
            nilaiDAO.deleteByNrp(nrp);
            mahasiswaDAO.delete(nrp);
            System.out.println("Data berhasil dihapus!");
        }
    }

    private static void hapusNilai(String nrp) {
        System.out.print("Semester yang ingin dihapus: ");
        int semester = inputAngka();

        System.out.print("Yakin ingin menghapus? (Y/N): ");
        String yakin = scanner.nextLine().toUpperCase();

        if (yakin.equals("Y")) {
            nilaiDAO.deleteByNrpSemester(nrp, semester);
            System.out.println("Semester berhasil dihapus!");
        }
    }

    // ================================================================
    //  FUNGSI UTIL
    // ================================================================
    private static boolean adaData() {
        return !mahasiswaDAO.getAll().isEmpty();
    }

    private static int inputAngkaMenu(int min, int max) {
        while (true) {
            try {
                int angka = Integer.parseInt(scanner.nextLine());
                if (angka < min || angka > max)
                    throw new Exception();
                return angka;
            } catch (Exception e) {
                System.out.print("Pilihan tidak tersedia! Silakan memilih lagi (" + min + "-" + max + "): ");
            }
        }
    }

    private static int inputAngka() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }

    private static double inputNilai() {
        while (true) {
            try {
                double angka = Double.parseDouble(scanner.nextLine());
                if (angka < 0 || angka > 100)
                    throw new Exception();
                return angka;
            } catch (Exception e) {
                System.out.print("Masukkan angka yang valid (0-100): ");
            }
        }
    }

    private static int inputSemester() {
        System.out.print("Masukkan Semester: ");
        return inputAngka();
    }

    private static Nilai inputNilai(String nrp, int semester) {
        System.out.println("Masukkan Nilai Mahasiswa (0-100):");

        System.out.print("Tugas 1: ");
        double t1 = inputNilai();

        System.out.print("Tugas 2: ");
        double t2 = inputNilai();

        System.out.print("Tugas 3: ");
        double t3 = inputNilai();

        System.out.print("Tugas 4: ");
        double t4 = inputNilai();

        System.out.print("UTS: ");
        double uts = inputNilai();

        System.out.print("UAS: ");
        double uas = inputNilai();

        return new Nilai(nrp, semester, t1, t2, t3, t4, uts, uas);
    }

    private static int pilihDepartemen() {
        System.out.println("\nPilih Departemen:");
        System.out.println("1. Teknik Elektronika");
        System.out.println("2. Teknik Informatika dan Komputer");
        System.out.println("3. Teknik Multimedia Kreatif");
        System.out.println("4. Teknik Mekanika Energi");
        System.out.print("Pilihan Anda (1-4): ");
        return inputAngkaMenu(1, 4);
    }

    private static String getNamaDepartemen(int kode) {
        return switch (kode) {
            case 1 -> "Teknik Elektronika";
            case 2 -> "Teknik Informatika dan Komputer";
            case 3 -> "Teknik Multimedia Kreatif";
            default -> "Teknik Mekanika Energi";
        };
    }

    private static String pilihProgramStudi(int departemen) {
        System.out.println("\nMasukkan Program Studi:");

        return switch (departemen) {
            case 1 -> pilihDariMenu(new String[]{
                    "D3 Teknik Elektronika",
                    "D3 Teknik Telekomunikasi",
                    "D3 Teknik Elektro Industri",
                    "S.Tr. Teknik Elektronika",
                    "S.Tr. Teknik Telekomunikasi",
                    "S.Tr. Teknik Elektro Industri",
                    "S.Tr. Teknologi Rekayasa Internet"
            });

            case 2 -> pilihDariMenu(new String[]{
                    "D3 Teknik Informatika",
                    "S.Tr. Teknik Informatika",
                    "S.Tr. Teknik Komputer",
                    "S.Tr. Sains Data Terapan"
            });

            case 3 -> pilihDariMenu(new String[]{
                    "D3 Multimedia Broadcasting",
                    "S.Tr. Teknologi Game",
                    "S.Tr. Teknologi Rekayasa Multimedia"
            });

            default -> pilihDariMenu(new String[]{
                    "S.Tr. Teknik Mekatronika",
                    "S.Tr. Sistem Pembangkit Energi"
            });
        };
    }

    private static String pilihDariMenu(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }

        System.out.print("Pilihan Anda (1-" + list.length + "): ");
        int pilih = inputAngkaMenu(1, list.length);

        return list[pilih - 1];
    }

    private static void tampilkanSatuMahasiswa(String nrp) {
        Mahasiswa m = mahasiswaDAO.getByNrp(nrp);
        List<Nilai> daftarNilai = nilaiDAO.getByNrp(nrp);

        double totalIPS = 0;
        for (Nilai n : daftarNilai) totalIPS += n.hitungIPS();
        double ipk = daftarNilai.isEmpty() ? 0 : totalIPS / daftarNilai.size();

        System.out.println("\nNRP: " + m.getNrp());
        System.out.println("Nama: " + m.getNama());
        System.out.println("Departemen: " + m.getDepartemen());
        System.out.println("Program Studi: " + m.getProgramStudi());
        System.out.println("IPK: " + ipk);

        System.out.println("\nSemester\tT1\tT2\tT3\tT4\tUTS\tUAS\tIPS");
        for (Nilai n : daftarNilai) {
            System.out.println(n.getSemester() + "\t\t" +
                    n.getTugas1() + "\t" +
                    n.getTugas2() + "\t" +
                    n.getTugas3() + "\t" +
                    n.getTugas4() + "\t" +
                    n.getUts() + "\t" +
                    n.getUas() + "\t" +
                    n.hitungIPS());
        }
    }
}
