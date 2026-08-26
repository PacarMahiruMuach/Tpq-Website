/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.raportpq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StudentScoreDB {
    private static final String URL = "jdbc:mysql://localhost:3306/tpq_almujahidin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * @param UTS
     * @param UAS
     * @param Qiroah
     * @param Hafalan
     * @param Sikap
     * @param Rata
     * @param Predikat
     * @return
     */
    public boolean insertScore (String UTS, String UAS, String Qiroah, String Hafalan, String Sikap, String Rata, String Predikat,String nama) {

        String sql = "UPDATE santri SET UTS=?, UAS=?, Qiroah=?, Hafalan=?, Sikap=?, Rata=?, Predikat=? WHERE nama=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, UTS);
            stmt.setString(2, UAS);
            stmt.setString(3, Qiroah);
            stmt.setString(4, Hafalan);
            stmt.setString(5, Sikap);
            stmt.setString(6, Rata);
            stmt.setString(7, Predikat);
            stmt.setString(8, nama);
            
            
            
           

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted == 0;

        } catch (SQLException e) {
            System.err.println("Error saat menyimpan data santri! Error: " + e.getMessage());
            return false;
        }
        
    }
}

   
    

