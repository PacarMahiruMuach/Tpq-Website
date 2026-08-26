/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package id.raportpq.db;

import id.raportpq.db.DatabaseConnection;
import id.raportpq.db.StudentsDB;
import id.raportpq.db.TeachersDB;
import java.util.ArrayList;
import id.raportpq.dtm.SantriDTM;
/**
 *
 * @author HP820
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        StudentsDB santri = new StudentsDB();
        TeachersDB pengajar = new TeachersDB();
        
        System.out.println(pengajar.viewTeachers().get(0).getStatus());
    }
    
}
