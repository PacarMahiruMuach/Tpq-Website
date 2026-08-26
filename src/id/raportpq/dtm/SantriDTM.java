/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.raportpq.dtm;

/**
 *
 * @author HP820
 */
public class SantriDTM {
    private String nis, nama, kelas, gender, ttl, wali, note,UTS, UAS, Qiroah, Hafalan, Sikap, Rata, Predikat;
    
    public SantriDTM(String nis, String nama, String kelas, String kelamin, String ttl, String wali, String note,String UTS, String UAS, String Qiroah, String Hafalan, String Sikap, String Rata, String Predikat){
        this.nis = nis;
        this.nama = nama;
        this.gender = kelamin;
        this.kelas = kelas;
        this.ttl = ttl;
        this.wali = wali;
        this.note = note;
        this.UTS = UTS;
        this.UAS = UAS;
        this.Qiroah = Qiroah;
        this.Hafalan = Hafalan;
        this.Sikap = Sikap;
        this.Rata = Rata;
        this.Predikat = Predikat;
     
    }
    
    // Getter NIS
    public String getNis() {
        return nis;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk kelas
    public String getKelas() {
        return kelas;
    }

    // Getter untuk gender
    public String getGender() {
        return gender;
    }

    // Getter untuk ttl
    public String getTtl() {
        return ttl;
    }

    // Getter untuk wali
    public String getWali() {
        return wali;
    }
    
    public String getStatus(){
        String status = gender.equals("Perempuan") ? "Santriwati" : "Santri";
        return status;
    }

    // Getter untuk note
    public String getNote() {
        return note;
    }
    public String getUTS() {
        return UTS;
    }
     public String getUAS() {
        return UAS;
    }
    public String getQiroah() {
        return Qiroah;
    }
     public String getHafalan() {
        return Hafalan;
    }
    public String getSikap() {
        return Sikap;
    }
   public String getRata() {
        return Rata;
    }
    public String getPredikat() {
        return Predikat;
    }
}