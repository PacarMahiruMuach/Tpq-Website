/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.raportpq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class EditDB {
     private static final String URL = "jdbc:mysql://localhost:3306/tpq_almujahidin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } 
    public boolean UpdateStudent(String nama, String kelas, String gender, String ttl, String wali, String note) {
        String sql = "UPDATE santri SET nama=?, kelas=?, gender=?, ttl=?, wali=?, note=?, WHERE nama=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.setString(2, kelas);
            stmt.setString(3, gender);
            stmt.setString(4, ttl);
            stmt.setString(5, wali);
            stmt.setString(6, note);          

            int rowsUpdated= stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.err.println("Error saat mengupdate data santri! Error: " + e.getMessage());
            return false;
        }
    }  
    public boolean UpdateTeacher(String nama, String kelas, String gender, String ttl) {
        String sql = "UPDATE santri SET nama=?, gender=?, wali_kelas=?, ttl=?) WHERE nama=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nama);
            stmt.setString(2, gender);
            stmt.setString(3, kelas);
            stmt.setString(4, ttl);

            int rowsAfected = stmt.executeUpdate();
            return rowsAfected > 0;

        } catch (SQLException e) {
            System.err.println("Error saat menupdate data pengajar! Error: " + e.getMessage());
            return false;
        }
    }
}

    
    

