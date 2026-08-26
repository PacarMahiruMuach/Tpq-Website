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

/**
 *
 * @author HP820
 */
public class DatabaseConnection {
    // Informasi database
    private static final String url = "jdbc:mysql://localhost:3306/tpq_almujahidin";
    private static final String user = "root";
    private static final String password = "";
    
    public void conn(){
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke database berhasil!");

            conn.close();
            System.out.println("Koneksi ditutup.");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal! Error: " + e.getMessage());
        }
    }
    
//    login mengembalikan nilai true jika berhasil dan false sebaliknya
    public static boolean login(String username, String passwd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean loggedIn = false;

        try {
            conn = DriverManager.getConnection(url, user, password);

            // Query untuk mencari username dan password
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, passwd);
            rs = stmt.executeQuery();

            // Jika query menghasilkan hasil, maka login berhasil
            if (rs.next()) {
                loggedIn = true;
            }

        } catch (SQLException e) {
            System.out.println("Error saat login! Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error saat menutup koneksi! Error: " + e.getMessage());
            }
        }

        return loggedIn;
    }
}
