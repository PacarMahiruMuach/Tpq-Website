/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.raportpq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import id.raportpq.dtm.PengajarDTM;
import java.sql.Statement;

/**
 *
 * @author HP820
 */
public class TeachersDB {
    private static final String URL = "jdbc:mysql://localhost:3306/tpq_almujahidin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean insert(String name, String kelas, String gender, String ttl) {
        String sql = "INSERT INTO pengajar (id, nama, gender, wali_kelas, ttl) VALUES (NULL, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setString(3, kelas);
            stmt.setString(4, ttl);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error saat menyimpan data pengajar! Error: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<PengajarDTM> viewTeachers() {
        String sql = "SELECT * FROM pengajar";
        ArrayList<PengajarDTM> result = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("nama");
                    String kelas = rs.getString("wali_kelas");
                    String gender = rs.getString("gender");
                    String ttl = rs.getString("ttl");

                    PengajarDTM teacher = new PengajarDTM(name, gender, ttl, kelas);
                    result.add(teacher);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat mengambil data pengajar! Error: " + e.getMessage());
        }

        return result;
    }

    public static int count() {
        String query = "SELECT COUNT(*) FROM pengajar";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
