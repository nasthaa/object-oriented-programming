package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NilaiDAO {
    public boolean tambahNilai(NilaiSemester nilai) {
        String sql = "INSERT INTO nilai (nrp, semester, tugas1, tugas2, tugas3, tugas4, uts, uas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nilai.getNrp());
            pstmt.setInt(2, nilai.getSemester());
            pstmt.setDouble(3, nilai.getTugas1());
            pstmt.setDouble(4, nilai.getTugas2());
            pstmt.setDouble(5, nilai.getTugas3());
            pstmt.setDouble(6, nilai.getTugas4());
            pstmt.setDouble(7, nilai.getUts());
            pstmt.setDouble(8, nilai.getUas());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error tambahNilai: " + ex.getMessage());
            return false;
        }
    }

    public List<NilaiSemester> getNilaiByNrp(String nrp) {
        List<NilaiSemester> hasil = new ArrayList<>();
        String sql = "SELECT * FROM nilai WHERE nrp = ? ORDER BY semester";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nrp);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                NilaiSemester ns = new NilaiSemester(
                    rs.getString("nrp"),
                    rs.getInt("semester"),
                    rs.getDouble("tugas1"),
                    rs.getDouble("tugas2"),
                    rs.getDouble("tugas3"),
                    rs.getDouble("tugas4"),
                    rs.getDouble("uts"),
                    rs.getDouble("uas")
                );
                hasil.add(ns);
            }
        } catch (SQLException ex) {
            System.err.println("Error getNilaiByNrp: " + ex.getMessage());
        }
        return hasil;
    }

    public NilaiSemester getNilaiByNrpAndSemester(String nrp, int semester) {
        String sql = "SELECT * FROM nilai WHERE nrp = ? AND semester = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nrp);
            pstmt.setInt(2, semester);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new NilaiSemester(
                    rs.getString("nrp"),
                    rs.getInt("semester"),
                    rs.getDouble("tugas1"),
                    rs.getDouble("tugas2"),
                    rs.getDouble("tugas3"),
                    rs.getDouble("tugas4"),
                    rs.getDouble("uts"),
                    rs.getDouble("uas")
                );
            }
        } catch (SQLException ex) {
            System.err.println("Error getNilaiByNrpAndSemester: " + ex.getMessage());
        }
        return null;
    }

    public boolean updateNilai(String nrp, int semester, int fieldChoice, double newValue) {
        String column = null;
        switch (fieldChoice) {
            case 1: column = "tugas1"; break;
            case 2: column = "tugas2"; break;
            case 3: column = "tugas3"; break;
            case 4: column = "tugas4"; break;
            case 5: column = "uts"; break;
            case 6: column = "uas"; break;
            default: return false;
        }
        String sql = "UPDATE nilai SET " + column + " = ? WHERE nrp = ? AND semester = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newValue);
            pstmt.setString(2, nrp);
            pstmt.setInt(3, semester);
            int updated = pstmt.executeUpdate();
            return updated > 0;
        } catch (SQLException ex) {
            System.err.println("Error updateNilai: " + ex.getMessage());
            return false;
        }
    }

    public boolean hapusNilaiByNrp(String nrp) {
        String sql = "DELETE FROM nilai WHERE nrp = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nrp);
            int deleted = pstmt.executeUpdate();
            return deleted > 0;
        } catch (SQLException ex) {
            System.err.println("Error hapusNilaiByNrp: " + ex.getMessage());
            return false;
        }
    }

    public boolean hapusNilaiByNrpAndSemester(String nrp, int semester) {
        String sql = "DELETE FROM nilai WHERE nrp = ? AND semester = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nrp);
            pstmt.setInt(2, semester);
            int deleted = pstmt.executeUpdate();
            return deleted > 0;
        } catch (SQLException ex) {
            System.err.println("Error hapusNilaiByNrpAndSemester: " + ex.getMessage());
            return false;
        }
    }
}
