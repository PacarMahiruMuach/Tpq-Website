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
import id.raportpq.dtm.SantriDTM;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author HP820
 */
public class StudentsDB {

    public StudentsDB() {
    }
    private static final String URL = "jdbc:mysql://localhost:3306/tpq_almujahidin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public String generateNIS() {
        int nextNumber = 1;
        int year = LocalDate.now().getYear();

        String sql = "SELECT MAX(nis) AS last_nis FROM santri WHERE nis LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, year + "%");
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getString("last_nis") != null) {
                String lastNIS = rs.getString("last_nis");
                int lastNumber = Integer.parseInt(lastNIS.substring(4));
                nextNumber = lastNumber + 1;
            }

            return year + String.format("%03d", nextNumber);

        } catch (SQLException e) {
            System.err.println("Error saat menghasilkan NIS! Error: " + e.getMessage());
            throw new RuntimeException("Terdapat masalah", e);
        }
    }

    public boolean insert(String Nis, String name, String kelas, String gender, String ttl, String wali, String note, String UTS, String UAS, String Qiroah, String Hafalan, String Sikap) {
        String nis = generateNIS();
        String sql = "INSERT INTO santri (id, nis, nama, kelas, gender, ttl, wali, note, UTS, UAS, Qiroah, Hafalan, Sikap) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nis);
            stmt.setString(2, name);
            stmt.setString(3, kelas);
            stmt.setString(4, gender);
            stmt.setString(5, ttl);
            stmt.setString(6, wali);
            stmt.setString(7, note);
            stmt.setString(8, UTS);
            stmt.setString(9, UAS);
            stmt.setString(10, Qiroah);
            stmt.setString(11, Hafalan);
            stmt.setString(12, Sikap);
           

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error saat menyimpan data santri! Error: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<SantriDTM> viewStudents(String genderFilter) {    // Param: "Laki-Laki" atau "Perempuan"
        String sql = "SELECT * FROM santri";
        if (genderFilter != null) {
            sql += " WHERE gender = ?";
        }

        ArrayList<SantriDTM> result = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (genderFilter != null) {
                stmt.setString(1, genderFilter);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nis = rs.getString("nis");
                    String name = rs.getString("nama");
                    String kelas = rs.getString("kelas");
                    String gender = rs.getString("gender");
                    String ttl = rs.getString("ttl");
                    String wali = rs.getString("wali");
                    String note = rs.getString("note");
                    String UTS = rs.getString("UTS");
                    String UAS = rs.getString("UAS");
                    String Qiroah = rs.getString("Qiroah");
                    String Hafalan = rs.getString("Hafalan");
                    String Sikap = rs.getString("Sikap");
                    String Rata = rs.getString("Rata");
                    String Predikat = rs.getString("Predikat");
                    
                   

                    SantriDTM student = new SantriDTM(nis, name, kelas, gender, ttl, wali, note,UTS, UAS, Qiroah, Hafalan, Sikap, Rata, Predikat);
                    result.add(student);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat mengambil data santri! Error: " + e.getMessage());
        }

        return result;
    }

    public static int count(String type) {
        String query;

        if (type.equals("all")) {
            query = "SELECT COUNT(*) FROM santri";
        } else if (type.equals("santri")) {
            query = "SELECT COUNT(*) FROM santri WHERE gender = 'Laki-Laki'";
        } else if (type.equals("santriwati")) {
            query = "SELECT COUNT(*) FROM santri WHERE gender = 'Perempuan'";
        } else {
            throw new IllegalArgumentException("Invalid type: " + type);
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }}

   