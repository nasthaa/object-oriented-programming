package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {
    // Create mahasiswa
    public boolean tambahMahasiswa(String departemen, String programStudi, String nrp, String nama) {
        String sql = "INSERT INTO mahasiswa (departemen, programstudi, nrp, nama) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, departemen);
            pstmt.setString(2, programStudi);
            pstmt.setString(3, nrp);
            pstmt.setString(4, nama);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error tambahMahasiswa: " + ex.getMessage());
            return false;
        }
    }

    // Read all mahasiswa
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> hasil = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String departemenNama = rs.getString("departemen");
                String programNama = rs.getString("programstudi");
                String nrp = rs.getString("nrp");
                String nama = rs.getString("nama");

                Departemen departemen = new Departemen(departemenNama);
                ProgramStudi programStudi = new ProgramStudi(programNama);
                Mahasiswa m = new Mahasiswa(nrp, nama, departemen, programStudi);
                hasil.add(m);
            }
        } catch (SQLException ex) {
            System.err.println("Error getAllMahasiswa: " + ex.getMessage());
        }
        return hasil;
    }

    // Find by NRP
    public Mahasiswa cariMahasiswa(String nrp) {
        String sql = "SELECT * FROM mahasiswa WHERE nrp = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nrp);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String departemenNama = rs.getString("departemen");
                String programNama = rs.getString("programstudi");
                String nama = rs.getString("nama");
                Departemen departemen = new Departemen(departemenNama);
                ProgramStudi programStudi = new ProgramStudi(programNama);
                return new Mahasiswa(nrp, nama, departemen, programStudi);
            }
        } catch (SQLException ex) {
            System.err.println("Error cariMahasiswa: " + ex.getMessage());
        }
        return null;
    }

    // Update mahasiswa (nama, nrp, departemen, programstudi)
    public boolean updateMahasiswa(String originalNrp, String newDepartemen, String newProgramStudi, String newNrp, String newNama) {
        String sql = "UPDATE mahasiswa SET departemen = ?, programstudi = ?, nrp = ?, nama = ? WHERE nrp = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newDepartemen);
            pstmt.setString(2, newProgramStudi);
            pstmt.setString(3, newNrp);
            pstmt.setString(4, newNama);
            pstmt.setString(5, originalNrp);
            int updated = pstmt.executeUpdate();
            return updated > 0;
        } catch (SQLException ex) {
            System.err.println("Error updateMahasiswa: " + ex.getMessage());
            return false;
        }
    }

    // Delete mahasiswa (cascades nilai)
    public boolean hapusMahasiswa(String nrp) {
        String sql = "DELETE FROM mahasiswa WHERE nrp = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nrp);
            int deleted = pstmt.executeUpdate();
            return deleted > 0;
        } catch (SQLException ex) {
            System.err.println("Error hapusMahasiswa: " + ex.getMessage());
            return false;
        }
    }
}
