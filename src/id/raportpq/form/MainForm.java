/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.raportpq.form;
import id.raportpq.db.DeletePengajarDB;
import id.raportpq.db.DeleteSantriDB;
import id.raportpq.db.StudentScoreDB;
import java.awt.Color;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import id.raportpq.db.StudentsDB;
import id.raportpq.db.TeachersDB;
import id.raportpq.db.DB;
import id.raportpq.dtm.PengajarDTM;
import id.raportpq.dtm.SantriDTM;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Lenovo
 */
public class MainForm extends javax.swing.JFrame {
    DB Conn = new DB();
    java.sql.Connection con = Conn.getConnection();
    StudentScoreDB Score = new StudentScoreDB();
    DeleteSantriDB DeleteDB = new DeleteSantriDB();
    DeletePengajarDB DeleteTeacher = new DeletePengajarDB ();
    StudentsDB student = new StudentsDB();
    TeachersDB teacher = new TeachersDB();
    private JFrame frame;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        PBeranda.setVisible(TRUE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(FALSE);
        jButtonHapusP.setVisible(FALSE);
        jButtonHapusL.setVisible(FALSE);
        jButtonHapusTeacher.setVisible(FALSE);
        jButtonPrintP.setVisible(FALSE);
        jButtonPrintL.setVisible(FALSE);
        jButtonPrintTeacher.setVisible(FALSE);
        updateTables();
        }
//--------------------Function-----------------------------------------
    
   public char Predikat(int i) {
        if (i >= 80) {
            return 'A';
        } else if (i >= 70) {
            return 'B';
        } else if (i >= 60) {
            return 'C';
        } else {
            return 'D';
        }}

    private void updateTables(){
        DefaultTableModel mainModel = (DefaultTableModel) mainTable.getModel();
        DefaultTableModel santriModel = (DefaultTableModel) jTableLaki.getModel();
        DefaultTableModel santriwatiModel = (DefaultTableModel) jTablePerempuan.getModel();
        DefaultTableModel pengajarModel = (DefaultTableModel) jTablePengajar.getModel();
       
      
       
        
        updateTable(mainModel, null);
        updateTable(santriModel, "Laki-Laki");
        updateTable(santriwatiModel, "Perempuan");
        updatePengajar(pengajarModel);
        updateNilai();
        updateRapot();
    }
    private void updateNilai() {
        DefaultTableModel nilaiModel = (DefaultTableModel) jTableNilai.getModel();
        nilaiModel.setRowCount(0);
        ArrayList<SantriDTM> results = student.viewStudents(null);
        
        
        for (SantriDTM result : results) {
            Object[] row = new Object[11];
            row[0] = result.getNis();
            row[1] = result.getNama();
            row[2] = result.getGender();
            row[3] = result.getKelas();
            row[4] = result.getUTS();
            row[5] = result.getUAS();
            row[6] = result.getQiroah();
            row[7] = result.getHafalan();
            row[8] = result.getSikap();
            row[9] = result.getRata();
            row[10]= result.getPredikat();
      

            nilaiModel.addRow(row);
        }
    }
    private void updateRapot() {
        DefaultTableModel nilaiModel = (DefaultTableModel) TablePrintRapot.getModel();
        nilaiModel.setRowCount(0);
        ArrayList<SantriDTM> results = student.viewStudents(null);
        
        
        for (SantriDTM result : results) {
            Object[] row = new Object[4];
            row[0] = result.getNis();
            row[1] = result.getNama();
            row[2] = result.getGender();
            row[3] = result.getKelas();
      

            nilaiModel.addRow(row);
        }
    }
    
    private void updateTable(DefaultTableModel model, String genderFilter) {
        model.setRowCount(0);
        ArrayList<SantriDTM> results = student.viewStudents(genderFilter);
        
        for (SantriDTM result : results) {
            Object[] row = new Object[15];
            row[0] = result.getNis();
            row[1] = result.getNama();
            row[2] = result.getKelas();
            row[3] = result.getGender();
            row[4] = result.getTtl();
            row[5] = result.getWali();
            row[6] = result.getStatus();
            row[7] = result.getNote();

            model.addRow(row);
        }
    }
    
    private void updatePengajar(DefaultTableModel model){
        model.setRowCount(0);
        ArrayList<PengajarDTM> results = teacher.viewTeachers();
        
        for (PengajarDTM result : results) {
            Object[] row = new Object[5];
            row[0] = result.getNama();
            row[1] = result.getGender();
            row[2] = result.getStatus();
            row[3] = result.getWaliKelas();
            row[4] = result.getTtl();

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MenuLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_main1 = new javax.swing.JPanel();
        pn_line1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_main2 = new javax.swing.JPanel();
        pn_line2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pn_main3 = new javax.swing.JPanel();
        pn_line3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pn_main4 = new javax.swing.JPanel();
        pn_line4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pn_main5 = new javax.swing.JPanel();
        pn_line5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pn_main6 = new javax.swing.JPanel();
        pn_line6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        PBeranda = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        PDataSantri = new javax.swing.JPanel();
        PanelTotalSantri = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        jButtonHapusT = new javax.swing.JButton();
        jButtonPrintT = new javax.swing.JButton();
        PanelPerempuan = new javax.swing.JScrollPane();
        jTablePerempuan = new javax.swing.JTable();
        jButtonHapusP = new javax.swing.JButton();
        jButtonPrintP = new javax.swing.JButton();
        PanelLakiLaki = new javax.swing.JScrollPane();
        jTableLaki = new javax.swing.JTable();
        jButtonHapusL = new javax.swing.JButton();
        jButtonPrintL = new javax.swing.JButton();
        PanelPengajar = new javax.swing.JScrollPane();
        jTablePengajar = new javax.swing.JTable();
        jButtonHapusTeacher = new javax.swing.JButton();
        jButtonPrintTeacher = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLaki = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPerempuan = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTotalSantri = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPengajar = new javax.swing.JLabel();
        TableName = new javax.swing.JLabel();
        PInputData = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        noteInp = new javax.swing.JTextField();
        genderInp = new javax.swing.JComboBox<>();
        jLabelTglLahir = new javax.swing.JLabel();
        jLabelCatatan = new javax.swing.JLabel();
        jComboStatus1 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        nameInp = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        ttlInp = new javax.swing.JTextField();
        jLabelKelas = new javax.swing.JLabel();
        kelasInp = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        jLabelWali = new javax.swing.JLabel();
        waliInp = new javax.swing.JTextField();
        PLaporanNilai = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNilai = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        PrintScore = new javax.swing.JButton();
        SikapInput = new javax.swing.JTextField();
        UTSInput = new javax.swing.JTextField();
        UASInput = new javax.swing.JTextField();
        QiroahInput = new javax.swing.JTextField();
        HafalanInput = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButtonINPUTNilai = new javax.swing.JButton();
        PInputNilai = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablePrintRapot = new javax.swing.JTable();
        PrintRapot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));

        MenuLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        MenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuLabel.setText("BERANDA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(MenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(MenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 970, 60));

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 920, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo kecil.png"))); // NOI18N
        jLabel1.setText("Logo");
        jLabel1.setToolTipText("");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 64, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("TPQ AL-MUJAHIDIN");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        pn_main1.setBackground(new java.awt.Color(255, 255, 255));

        pn_line1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line1Layout = new javax.swing.GroupLayout(pn_line1);
        pn_line1.setLayout(pn_line1Layout);
        pn_line1Layout.setHorizontalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        pn_line1Layout.setVerticalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Data Santri dan Pengajar");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-family-two-men-37.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main1Layout = new javax.swing.GroupLayout(pn_main1);
        pn_main1.setLayout(pn_main1Layout);
        pn_main1Layout.setHorizontalGroup(
            pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pn_main1Layout.setVerticalGroup(
            pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pn_main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 300, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Menu");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        pn_main2.setBackground(new java.awt.Color(255, 255, 255));

        pn_line2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line2Layout = new javax.swing.GroupLayout(pn_line2);
        pn_line2.setLayout(pn_line2Layout);
        pn_line2Layout.setHorizontalGroup(
            pn_line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        pn_line2Layout.setVerticalGroup(
            pn_line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-a-plus-grading-in-report-card-for-brilliant-student-35.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Cetak Rapot");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main2Layout = new javax.swing.GroupLayout(pn_main2);
        pn_main2.setLayout(pn_main2Layout);
        pn_main2Layout.setHorizontalGroup(
            pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main2Layout.setVerticalGroup(
            pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_line2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_main2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(pn_main2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 300, -1));

        pn_main3.setBackground(new java.awt.Color(255, 255, 255));

        pn_line3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line3Layout = new javax.swing.GroupLayout(pn_line3);
        pn_line3.setLayout(pn_line3Layout);
        pn_line3Layout.setHorizontalGroup(
            pn_line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        pn_line3Layout.setVerticalGroup(
            pn_line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-mosque-35.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("Beranda");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main3Layout = new javax.swing.GroupLayout(pn_main3);
        pn_main3.setLayout(pn_main3Layout);
        pn_main3Layout.setHorizontalGroup(
            pn_main3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main3Layout.setVerticalGroup(
            pn_main3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_line3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_main3Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(pn_main3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 300, -1));

        pn_main4.setBackground(new java.awt.Color(255, 255, 255));

        pn_line4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line4Layout = new javax.swing.GroupLayout(pn_line4);
        pn_line4.setLayout(pn_line4Layout);
        pn_line4Layout.setHorizontalGroup(
            pn_line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        pn_line4Layout.setVerticalGroup(
            pn_line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-user-male-34.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setText("Input Data Santri dan Pengajar");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main4Layout = new javax.swing.GroupLayout(pn_main4);
        pn_main4.setLayout(pn_main4Layout);
        pn_main4Layout.setHorizontalGroup(
            pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main4Layout.setVerticalGroup(
            pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_line4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.add(pn_main4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 300, -1));

        pn_main5.setBackground(new java.awt.Color(255, 255, 255));

        pn_line5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line5Layout = new javax.swing.GroupLayout(pn_line5);
        pn_line5.setLayout(pn_line5Layout);
        pn_line5Layout.setHorizontalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        pn_line5Layout.setVerticalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-logout-32.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setText("Logout");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main5Layout = new javax.swing.GroupLayout(pn_main5);
        pn_main5.setLayout(pn_main5Layout);
        pn_main5Layout.setHorizontalGroup(
            pn_main5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main5Layout.setVerticalGroup(
            pn_main5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_line5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_main5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(pn_main5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 300, -1));

        pn_main6.setBackground(new java.awt.Color(255, 255, 255));

        pn_line6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line6Layout = new javax.swing.GroupLayout(pn_line6);
        pn_line6.setLayout(pn_line6Layout);
        pn_line6Layout.setHorizontalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        pn_line6Layout.setVerticalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-scorecard-35.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setText("Laporan Nilai Santri");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main6Layout = new javax.swing.GroupLayout(pn_main6);
        pn_main6.setLayout(pn_main6Layout);
        pn_main6Layout.setHorizontalGroup(
            pn_main6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main6Layout.setVerticalGroup(
            pn_main6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_line6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_main6Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(pn_main6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 300, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 640));

        PBeranda.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BG.jpg"))); // NOI18N

        javax.swing.GroupLayout PBerandaLayout = new javax.swing.GroupLayout(PBeranda);
        PBeranda.setLayout(PBerandaLayout);
        PBerandaLayout.setHorizontalGroup(
            PBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PBerandaLayout.setVerticalGroup(
            PBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(PBeranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 940, 560));

        PDataSantri.setBackground(new java.awt.Color(255, 255, 255));
        PDataSantri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTotalSantri.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                PanelTotalSantriComponentHidden(evt);
            }
        });

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "Nama", "Kelas", "Jenis Kelamin", "Tempat, Tgl Lahir", "Wali Murid", "Status", "Catatan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanelTotalSantri.setViewportView(mainTable);

        PDataSantri.add(PanelTotalSantri, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 880, 270));

        jButtonHapusT.setBackground(new java.awt.Color(0, 255, 102));
        jButtonHapusT.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonHapusT.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHapusT.setText("Hapus");
        jButtonHapusT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusTActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonHapusT, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 140, 30));

        jButtonPrintT.setBackground(new java.awt.Color(0, 255, 102));
        jButtonPrintT.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonPrintT.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrintT.setText("Print");
        jButtonPrintT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintTActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonPrintT, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 100, 30));

        PanelPerempuan.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                PanelPerempuanComponentHidden(evt);
            }
        });

        jTablePerempuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "Nama", "Kelas", "Jenis Kelamin", "Tempat, Tgl Lahir", "Wali Murid", "Status", "Catatan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanelPerempuan.setViewportView(jTablePerempuan);

        PDataSantri.add(PanelPerempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 880, 270));

        jButtonHapusP.setBackground(new java.awt.Color(0, 255, 102));
        jButtonHapusP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonHapusP.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHapusP.setText("Hapus");
        jButtonHapusP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusPActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonHapusP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 140, 30));

        jButtonPrintP.setBackground(new java.awt.Color(0, 255, 102));
        jButtonPrintP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonPrintP.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrintP.setText("Print");
        jButtonPrintP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintPActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonPrintP, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 100, 30));

        PanelLakiLaki.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                PanelLakiLakiComponentHidden(evt);
            }
        });

        jTableLaki.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "Nama", "Kelas", "Jenis Kelamin", "Tempat, Tgl Lahir", "Wali Murid", "Status", "Catatan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanelLakiLaki.setViewportView(jTableLaki);

        PDataSantri.add(PanelLakiLaki, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 880, 270));

        jButtonHapusL.setBackground(new java.awt.Color(0, 255, 102));
        jButtonHapusL.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonHapusL.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHapusL.setText("Hapus");
        jButtonHapusL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusLActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonHapusL, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 140, 30));

        jButtonPrintL.setBackground(new java.awt.Color(0, 255, 102));
        jButtonPrintL.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonPrintL.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrintL.setText("Print");
        jButtonPrintL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintLActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonPrintL, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 100, 30));

        PanelPengajar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                PanelPengajarComponentHidden(evt);
            }
        });

        jTablePengajar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Jenis Kelamin", "Status", "Wali Kelas", "Tempat, Tanggal Lahir"
            }
        ));
        PanelPengajar.setViewportView(jTablePengajar);

        PDataSantri.add(PanelPengajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 880, 270));

        jButtonHapusTeacher.setBackground(new java.awt.Color(0, 255, 102));
        jButtonHapusTeacher.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonHapusTeacher.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHapusTeacher.setText("Hapus");
        jButtonHapusTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusTeacherActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonHapusTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 140, 30));

        jButtonPrintTeacher.setBackground(new java.awt.Color(0, 255, 102));
        jButtonPrintTeacher.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonPrintTeacher.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrintTeacher.setText("Print");
        jButtonPrintTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintTeacherActionPerformed(evt);
            }
        });
        PDataSantri.add(jButtonPrintTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 100, 30));

        jPanel4.setBackground(new java.awt.Color(153, 255, 102));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("LAKI-LAKI");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-male-50.png"))); // NOI18N
        jLabel24.setText("jLabel20");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        jLaki.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLaki.setForeground(new java.awt.Color(255, 255, 255));
        jLaki.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLaki.setText("0");
        jPanel4.add(jLaki, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 50, 20));

        PDataSantri.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 190, 90));

        jPanel5.setBackground(new java.awt.Color(153, 255, 102));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PEREMPUAN");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-female-50.png"))); // NOI18N
        jLabel25.setText("jLabel20");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        jPerempuan.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jPerempuan.setForeground(new java.awt.Color(255, 255, 255));
        jPerempuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPerempuan.setText("0");
        jPanel5.add(jPerempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 50, 20));

        PDataSantri.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 190, 90));

        jPanel6.setBackground(new java.awt.Color(153, 255, 102));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TOTAL SANTRI");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-family-50.png"))); // NOI18N
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        jTotalSantri.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jTotalSantri.setForeground(new java.awt.Color(255, 255, 255));
        jTotalSantri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTotalSantri.setText("0");
        jPanel6.add(jTotalSantri, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 50, 20));

        PDataSantri.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 190, 90));

        jPanel7.setBackground(new java.awt.Color(153, 255, 102));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PENGAJAR");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-teacher-50.png"))); // NOI18N
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        jPengajar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jPengajar.setForeground(new java.awt.Color(255, 255, 255));
        jPengajar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPengajar.setText("0");
        jPanel7.add(jPengajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 50, 20));

        PDataSantri.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 190, 90));

        TableName.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        TableName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TableName.setText("TOTAL SANTRI");
        PDataSantri.add(TableName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 280, 30));

        getContentPane().add(PDataSantri, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 940, 560));

        PInputData.setBackground(new java.awt.Color(255, 255, 255));
        PInputData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel20.setText("Jenis Kelamin :");
        PInputData.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        noteInp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        noteInp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteInpActionPerformed(evt);
            }
        });
        PInputData.add(noteInp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 220, 30));

        genderInp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genderInp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        genderInp.setToolTipText("");
        genderInp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderInpActionPerformed(evt);
            }
        });
        PInputData.add(genderInp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 150, 30));

        jLabelTglLahir.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelTglLahir.setText("Tempat, Tanggal Lahir :");
        PInputData.add(jLabelTglLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        jLabelCatatan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelCatatan.setText("Catatan :");
        PInputData.add(jLabelCatatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jComboStatus1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Santri", "Pengajar/Staff" }));
        jComboStatus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboStatus1MouseClicked(evt);
            }
        });
        jComboStatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboStatus1ActionPerformed(evt);
            }
        });
        PInputData.add(jComboStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 150, 30));
        PInputData.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel28.setText("Nama :");
        PInputData.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        nameInp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameInp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInpActionPerformed(evt);
            }
        });
        PInputData.add(nameInp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 220, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel29.setText("Status :");
        PInputData.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        ttlInp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ttlInp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttlInpActionPerformed(evt);
            }
        });
        PInputData.add(ttlInp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 220, 30));

        jLabelKelas.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelKelas.setText("Kelas :");
        PInputData.add(jLabelKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        kelasInp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kelasInp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sughro", "Kubro", "-" }));
        kelasInp.setToolTipText("");
        kelasInp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasInpActionPerformed(evt);
            }
        });
        PInputData.add(kelasInp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 150, 30));

        saveBtn.setBackground(new java.awt.Color(102, 255, 102));
        saveBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("SAVE");
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        PInputData.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 160, 30));

        resetBtn.setBackground(new java.awt.Color(102, 255, 102));
        resetBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("RESET");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        PInputData.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 120, 30));

        jLabelWali.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelWali.setText("Nama Wali Murid :");
        PInputData.add(jLabelWali, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        waliInp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        waliInp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waliInpActionPerformed(evt);
            }
        });
        PInputData.add(waliInp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 220, 30));

        getContentPane().add(PInputData, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 940, 560));

        PLaporanNilai.setBackground(new java.awt.Color(255, 255, 255));
        PLaporanNilai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableNilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "Nama", "Jenis Kelamin", "Kelas", "UTS", "UAS", "Qiroah", "Hafalan", "Sikap", "Rata-Rata", "Predikat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNilai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableNilai.getTableHeader().setReorderingAllowed(false);
        jTableNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNilai);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        PLaporanNilai.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 900, 380));

        jLabel21.setText("Note :");
        PLaporanNilai.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel22.setText("0 - 64     Predikat D");
        PLaporanNilai.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jLabel30.setText("85 - 100 Predikat A ");
        PLaporanNilai.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel31.setText("75 - 84   Predikat B");
        PLaporanNilai.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel32.setText("65 - 74   Predikat C");
        PLaporanNilai.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        PrintScore.setBackground(new java.awt.Color(102, 255, 102));
        PrintScore.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        PrintScore.setForeground(new java.awt.Color(255, 255, 255));
        PrintScore.setText("Print");
        PrintScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintScoreActionPerformed(evt);
            }
        });
        PLaporanNilai.add(PrintScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 190, 40));

        SikapInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SikapInputActionPerformed(evt);
            }
        });
        SikapInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SikapInputKeyPressed(evt);
            }
        });
        PLaporanNilai.add(SikapInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 110, -1));

        UTSInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UTSInputActionPerformed(evt);
            }
        });
        UTSInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UTSInputKeyPressed(evt);
            }
        });
        PLaporanNilai.add(UTSInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 110, -1));

        UASInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UASInputActionPerformed(evt);
            }
        });
        UASInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UASInputKeyPressed(evt);
            }
        });
        PLaporanNilai.add(UASInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 110, -1));

        QiroahInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QiroahInputActionPerformed(evt);
            }
        });
        QiroahInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QiroahInputKeyPressed(evt);
            }
        });
        PLaporanNilai.add(QiroahInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 110, -1));

        HafalanInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HafalanInputActionPerformed(evt);
            }
        });
        HafalanInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HafalanInputKeyPressed(evt);
            }
        });
        PLaporanNilai.add(HafalanInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 110, -1));

        jLabel33.setText("Sikap     :");
        PLaporanNilai.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, 20));

        jLabel34.setText("UTS     :");
        PLaporanNilai.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, 20));

        jLabel35.setText("UAS     :");
        PLaporanNilai.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 60, 20));

        jLabel36.setText("Qiroah  :");
        PLaporanNilai.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, 20));

        jLabel37.setText("Hafalan :");
        PLaporanNilai.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, -1, 20));

        jButtonINPUTNilai.setBackground(new java.awt.Color(102, 255, 102));
        jButtonINPUTNilai.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButtonINPUTNilai.setForeground(new java.awt.Color(255, 255, 255));
        jButtonINPUTNilai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonINPUTNilai.setLabel("Input Nilai");
        jButtonINPUTNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonINPUTNilaiActionPerformed(evt);
            }
        });
        PLaporanNilai.add(jButtonINPUTNilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 140, 40));

        getContentPane().add(PLaporanNilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 940, 560));

        PInputNilai.setBackground(new java.awt.Color(255, 255, 255));

        TablePrintRapot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "NAMA", "JENIS KELAMIN", "KELAS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablePrintRapot);

        PrintRapot.setBackground(new java.awt.Color(51, 255, 51));
        PrintRapot.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        PrintRapot.setForeground(new java.awt.Color(255, 255, 255));
        PrintRapot.setText("Print Rapot");
        PrintRapot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintRapotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PInputNilaiLayout = new javax.swing.GroupLayout(PInputNilai);
        PInputNilai.setLayout(PInputNilaiLayout);
        PInputNilaiLayout.setHorizontalGroup(
            PInputNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInputNilaiLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(PInputNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PrintRapot, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        PInputNilaiLayout.setVerticalGroup(
            PInputNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInputNilaiLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(PrintRapot, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        getContentPane().add(PInputNilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 940, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//===========================================Function================================================
    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
    pn_main1.setBackground(new Color(204,204,204));
    pn_line1.setBackground(new Color(51,204,0));
        
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
       pn_main1.setBackground(new Color(255,255,255));
       pn_line1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
    pn_main2.setBackground(new Color(204,204,204));  
    pn_line2.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
      pn_main2.setBackground(new Color(255,255,255));
       pn_line2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
      pn_main1.setBackground(new Color(204,204,204));
    pn_line1.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
       pn_main1.setBackground(new Color(255,255,255));
       pn_line1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
       pn_main2.setBackground(new Color(204,204,204));
        pn_line2.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        pn_main2.setBackground(new Color(255,255,255));
        pn_line2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
      pn_main3.setBackground(new Color(204,204,204));
        pn_line3.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
       pn_main3.setBackground(new Color(255,255,255));
        pn_line3.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
         pn_main3.setBackground(new Color(204,204,204));
        pn_line3.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
       pn_main3.setBackground(new Color(255,255,255));
        pn_line3.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        pn_main4.setBackground(new Color(204,204,204));
        pn_line4.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
         pn_main4.setBackground(new Color(255,255,255));
        pn_line4.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
       pn_main4.setBackground(new Color(204,204,204));
        pn_line4.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
         pn_main4.setBackground(new Color(255,255,255));
        pn_line4.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
          pn_main5.setBackground(new Color(204,204,204));
        pn_line5.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
         pn_main5.setBackground(new Color(255,255,255));
        pn_line5.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
         pn_main5.setBackground(new Color(204,204,204));
        pn_line5.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
         pn_main5.setBackground(new Color(255,255,255));
        pn_line5.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        MenuLabel.setText("BERANDA");
        PBeranda.setVisible(TRUE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(FALSE);                               

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        MenuLabel.setText("BERANDA");
          PBeranda.setVisible(TRUE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(FALSE);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        MenuLabel.setText("DATA SANTRI DAN PENGAJAR");
        PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(TRUE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(FALSE);
        
        //panel set
        PanelTotalSantri.setVisible(TRUE);
         mainTable.setVisible(TRUE);
        PanelPerempuan.setVisible(FALSE);
         jTablePerempuan.setVisible(FALSE);
        PanelLakiLaki.setVisible(FALSE);
         jTableLaki.setVisible(FALSE);
        PanelPengajar.setVisible(FALSE);
         jTablePengajar.setVisible(FALSE);
         
         String jumlah = String.valueOf(StudentsDB.count("all"));
         jTotalSantri.setText(jumlah);
         
         String jumlahSantri = String.valueOf(StudentsDB.count("santri"));
         jLaki.setText(jumlahSantri);
         
         String jumlahSantriwati = String.valueOf(StudentsDB.count("santriwati"));
         jPerempuan.setText(jumlahSantriwati);
         
         String jumlahPengajar = String.valueOf(TeachersDB.count());
         jPengajar.setText(jumlahPengajar);
    }//GEN-LAST:event_jLabel4MouseClicked

    
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        MenuLabel.setText("DATA SANTRI DAN PENGAJAR");
          PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(TRUE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(FALSE);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        MenuLabel.setText("INPUT DATA SANTRI DAN PENGAJAR");
        PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(TRUE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(FALSE);       
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        MenuLabel.setText("INPUT DATA SANTRI DAN PENGAJAR");
             PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(TRUE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(FALSE);    
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       MenuLabel.setText("CETAK RAPOT");
           PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(TRUE);  
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        MenuLabel.setText("CETAK RAPOT");
         PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(FALSE);
        PInputNilai.setVisible(TRUE); 
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        MenuLabel.setText("LAPORAN NILAI SANTRI");
            PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(TRUE);
        PInputNilai.setVisible(FALSE);  
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        pn_main6.setBackground(new Color(204,204,204));
        pn_line6.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        pn_main6.setBackground(new Color(255,255,255));
        pn_line6.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        MenuLabel.setText("LAPORAN NILAI SANTRI");
             PBeranda.setVisible(FALSE);
        PDataSantri.setVisible(FALSE);
        PInputData.setVisible(FALSE);
        PLaporanNilai.setVisible(TRUE);
        PInputNilai.setVisible(FALSE);    
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
       pn_main6.setBackground(new Color(204,204,204));
        pn_line6.setBackground(new Color(51,204,0));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
      pn_main6.setBackground(new Color(255,255,255));
        pn_line6.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jButtonPrintTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintTActionPerformed
    JasperReport reports;
    
    //sesuaikan path denggan lokasi file .jasper pastikan semua plugin dan library telah terinstal
    String path = "src/reports/ReportAllData.jasper";
           
   
    try {
        reports = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(reports, null, con);
        JasperViewer jviewer = new JasperViewer(jprint, false);
        jviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jviewer.setVisible(true);
        System.out.println("Masuk try");
    }   catch (JRException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_jButtonPrintTActionPerformed

    private void PanelTotalSantriComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelTotalSantriComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelTotalSantriComponentHidden

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        jPanel6.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        jPanel6.setBackground(new Color(153,255,102));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        jPanel5.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
          jPanel5.setBackground(new Color(153,255,102));
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
         jPanel4.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(new Color(153,255,102));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        jPanel7.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        jPanel7.setBackground(new Color(153,255,102));
    }//GEN-LAST:event_jPanel7MouseExited

    private void PanelPerempuanComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelPerempuanComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelPerempuanComponentHidden

    private void PanelLakiLakiComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelLakiLakiComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelLakiLakiComponentHidden

    private void PanelPengajarComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelPengajarComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelPengajarComponentHidden

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        TableName.setText("TOTAL SANTRI");
       PanelTotalSantri.setVisible(TRUE);
         mainTable.setVisible(TRUE);
       PanelPerempuan.setVisible(FALSE);  
         jTablePerempuan.setVisible(FALSE);
       PanelLakiLaki.setVisible(FALSE);
         jTableLaki.setVisible(FALSE);
       PanelPengajar.setVisible(FALSE);
         jTablePengajar.setVisible(FALSE);
           jButtonHapusT.setVisible(TRUE);
        jButtonHapusP.setVisible(FALSE);
        jButtonHapusL.setVisible(FALSE);
        jButtonHapusTeacher.setVisible(FALSE);
        jButtonPrintT.setVisible(TRUE);
        jButtonPrintP.setVisible(FALSE);
        jButtonPrintL.setVisible(FALSE);
        jButtonPrintTeacher.setVisible(FALSE);                               
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        TableName.setText("DATA SANTRIWATI");
       PanelTotalSantri.setVisible(FALSE);
         mainTable.setVisible(FALSE);
       PanelPerempuan.setVisible(TRUE);
         jTablePerempuan.setVisible(TRUE);
       PanelLakiLaki.setVisible(FALSE);
         jTableLaki.setVisible(FALSE);
       PanelPengajar.setVisible(FALSE);
         jTablePengajar.setVisible(FALSE);
        jButtonHapusT.setVisible(FALSE);
        jButtonHapusP.setVisible(TRUE);
        jButtonHapusL.setVisible(FALSE);
        jButtonHapusTeacher.setVisible(FALSE);
        jButtonPrintT.setVisible(FALSE);
        jButtonPrintP.setVisible(TRUE);
        jButtonPrintL.setVisible(FALSE);
        jButtonPrintTeacher.setVisible(FALSE);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        TableName.setText("DATA SANTRI");
       PanelTotalSantri.setVisible(FALSE);
         mainTable.setVisible(FALSE);
       PanelPerempuan.setVisible(FALSE);
         jTablePerempuan.setVisible(FALSE);
       PanelLakiLaki.setVisible(TRUE);
         jTableLaki.setVisible(TRUE);
       PanelPengajar.setVisible(FALSE);
         jTablePengajar.setVisible(FALSE);
        jButtonHapusT.setVisible(FALSE);
        jButtonHapusP.setVisible(FALSE);
        jButtonHapusL.setVisible(TRUE);
        jButtonHapusTeacher.setVisible(FALSE);
        jButtonPrintT.setVisible(FALSE);
        jButtonPrintP.setVisible(FALSE);
        jButtonPrintL.setVisible(TRUE);
        jButtonPrintTeacher.setVisible(FALSE); 
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        TableName.setText("DATA PENGAJAR");
       PanelTotalSantri.setVisible(FALSE);
         mainTable.setVisible(FALSE);
       PanelPerempuan.setVisible(FALSE);
         jTablePerempuan.setVisible(FALSE);
       PanelLakiLaki.setVisible(FALSE);
         jTableLaki.setVisible(FALSE);
       PanelPengajar.setVisible(TRUE);
         jTablePengajar.setVisible(TRUE);
         jButtonHapusT.setVisible(FALSE);
        jButtonHapusP.setVisible(FALSE);
        jButtonHapusL.setVisible(FALSE);
        jButtonHapusTeacher.setVisible(TRUE);
        jButtonPrintT.setVisible(FALSE);
        jButtonPrintP.setVisible(FALSE);
        jButtonPrintL.setVisible(FALSE);
        jButtonPrintTeacher.setVisible(TRUE);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void noteInpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteInpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteInpActionPerformed

    private void genderInpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderInpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderInpActionPerformed

    private void jComboStatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboStatus1ActionPerformed
       if (jComboStatus1.getSelectedItem().equals("Pengajar/Staff") ){
        jLabelKelas.setText("Wali Kelas");
        jLabelCatatan.setVisible(FALSE);
        noteInp.setVisible(FALSE);
        jLabelWali.setVisible(FALSE);
        waliInp.setVisible(FALSE);
        }
        
        else {
        jLabelKelas.setText("Kelas");
        jLabelCatatan.setVisible(TRUE);
        noteInp.setVisible(TRUE);
        jLabelWali.setVisible(TRUE);
        waliInp.setVisible(TRUE);}                                         
    }//GEN-LAST:event_jComboStatus1ActionPerformed

    private void nameInpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInpActionPerformed

    private void ttlInpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttlInpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttlInpActionPerformed

    private void kelasInpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasInpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelasInpActionPerformed

    private void jComboStatus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboStatus1MouseClicked
       if (jComboStatus1.getSelectedItem().equals("Pengajar/Staff") ){
        jLabelKelas.setText("Wali Kelas");
        jLabelCatatan.setVisible(FALSE);
        noteInp.setVisible(FALSE);
        jLabelWali.setVisible(FALSE);
        waliInp.setVisible(FALSE);
        }
        
        else {
        jLabelKelas.setText("Kelas");
        jLabelCatatan.setVisible(TRUE);
        noteInp.setVisible(TRUE);
        jLabelWali.setVisible(TRUE);
        waliInp.setVisible(TRUE);}           
    }//GEN-LAST:event_jComboStatus1MouseClicked

    private void waliInpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waliInpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waliInpActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String nis = student.generateNIS();
        String name = nameInp.getText();
        String kelas = (String) kelasInp.getSelectedItem();
        String gender = (String) genderInp.getSelectedItem();
        String ttl = ttlInp.getText();
        String wali = waliInp.getText();
        String note = noteInp.getText();
        String UTS = "0";
        String UAS ="0";
        String Qiroah ="0";
        String Hafalan ="0";
        String Sikap ="0";
       
        
        
       Boolean isSantri = jComboStatus1.getSelectedItem().equals("Santri");
         
       Boolean isSuccess;
       isSuccess = isSantri ? student.insert( nis, name,kelas, gender, ttl, wali, note, UTS, UAS, Qiroah, Hafalan, Sikap) : teacher.insert(name, kelas, gender, ttl);
        
        String infoHeader = isSuccess ? "Success" : "Fail";
        String msg = isSuccess ? "Input Berhasil!" : "Terdapat Masalah Saat Input";
        Integer type = isSuccess ? 1 : 0;
            
        JOptionPane.showMessageDialog(null, infoHeader, msg, type);
        if(isSuccess) resetInput();
        updateTables();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void PrintScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintScoreActionPerformed
 JasperReport reports;
    
    //sesuaikan path denggan lokasi file .jasper pastikan semua plugin dan library telah terinstal
    String path = "src/reports/ReportScore1.jasper";
           
   
    try {
        reports = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(reports, null, con);
        JasperViewer jviewer = new JasperViewer(jprint, false);
        jviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jviewer.setVisible(true);
        System.out.println("Masuk try");
    }   catch (JRException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
           
                 
    }//GEN-LAST:event_PrintScoreActionPerformed

    private void jButtonHapusTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusTActionPerformed
         DefaultTableModel model = (DefaultTableModel)mainTable.getModel();
        String nama = model.getValueAt(mainTable.getSelectedRow(), 1).toString();
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to DELETE","TPQ Al-Mujahidin", 
                JOptionPane.YES_NO_OPTION) 
                == JOptionPane.YES_NO_OPTION)
        {
        DeleteDB.Delete(nama) ;
         updateTables();
         JOptionPane.showMessageDialog(this,"DATA BERHASIL DIHAPUS"); 
        }
       
    }//GEN-LAST:event_jButtonHapusTActionPerformed

    private void jButtonINPUTNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonINPUTNilaiActionPerformed
       DefaultTableModel model = (DefaultTableModel)jTableNilai.getModel();
       if(jTableNilai.getSelectedRowCount()==1){
        String UTS = UTSInput.getText();
        String UAS = UASInput.getText();
        String Qiroah = QiroahInput.getText();
        String Hafalan = HafalanInput.getText();
        String Sikap = SikapInput.getText();
        int Rata = (Integer.valueOf(UTS)+Integer.valueOf(UAS)+Integer.valueOf(Qiroah)+Integer.valueOf(Hafalan)+Integer.valueOf(Sikap))/5;
        String Value = jTableNilai.getValueAt(jTableNilai.getSelectedRow(), 1).toString();
      
        Score.insertScore( UTS, UAS, Qiroah, Hafalan, Sikap, String.valueOf(Rata), Character.toString(Predikat(Rata)), Value) ;
        JOptionPane.showMessageDialog(this,"INPUT NILAI BERHASIL !!!"); // Set Value Tabel Nilai
        model.setValueAt(UTS,jTableNilai.getSelectedRow(), 4);
        model.setValueAt(UAS,jTableNilai.getSelectedRow(), 5);
        model.setValueAt(Qiroah,jTableNilai.getSelectedRow(), 6);
        model.setValueAt(Hafalan,jTableNilai.getSelectedRow(), 7);
        model.setValueAt(Sikap,jTableNilai.getSelectedRow(), 8);
        model.setValueAt(String.valueOf(Rata),jTableNilai.getSelectedRow(), 9);
        model.setValueAt(Character.toString(Predikat(Rata)),jTableNilai.getSelectedRow(), 10);
        
      UTSInput.setText("");
      UASInput.setText("");     
      QiroahInput.setText(""); 
      HafalanInput.setText("");
      SikapInput.setText("");
       }
    }//GEN-LAST:event_jButtonINPUTNilaiActionPerformed

    private void UTSInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UTSInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UTSInputActionPerformed

    private void QiroahInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QiroahInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QiroahInputActionPerformed

    private void HafalanInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HafalanInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HafalanInputActionPerformed

    private void SikapInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SikapInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SikapInputActionPerformed

    private void jTableNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNilaiMouseClicked
        // Untuk set nilai pada menu input nilai
        DefaultTableModel model =(DefaultTableModel)jTableNilai.getModel();
        String UTS =model.getValueAt(jTableNilai.getSelectedRow(),4).toString();
        String UAS =model.getValueAt(jTableNilai.getSelectedRow(),5).toString();
        String Qiroah =model.getValueAt(jTableNilai.getSelectedRow(),6).toString();
        String Hafalan =model.getValueAt(jTableNilai.getSelectedRow(),7).toString();
        String Sikap =model.getValueAt(jTableNilai.getSelectedRow(),8).toString();
        
        
        UTSInput.setText(UTS);
        UASInput.setText(UAS);
        QiroahInput.setText(Qiroah);
        HafalanInput.setText(Hafalan);
        SikapInput.setText(Sikap);
        
    }//GEN-LAST:event_jTableNilaiMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
          frame = new JFrame ("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","TPQ Al-Mujahidin", 
                JOptionPane.YES_NO_OPTION) 
                == JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
                                             

    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
         frame = new JFrame ("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","TPQ Al-Mujahidin", 
                JOptionPane.YES_NO_OPTION) 
                == JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void UASInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UASInputKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            QiroahInput.requestFocusInWindow();
        }
    }//GEN-LAST:event_UASInputKeyPressed

    private void UTSInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTSInputKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            UASInput.requestFocusInWindow();
        }
    }//GEN-LAST:event_UTSInputKeyPressed

    private void QiroahInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QiroahInputKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            HafalanInput.requestFocusInWindow();
        }
    }//GEN-LAST:event_QiroahInputKeyPressed

    private void HafalanInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HafalanInputKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            SikapInput.requestFocusInWindow();
        }
    }//GEN-LAST:event_HafalanInputKeyPressed

    private void SikapInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SikapInputKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            jButtonINPUTNilai.requestFocusInWindow();
        }
    }//GEN-LAST:event_SikapInputKeyPressed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetInput();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void UASInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UASInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UASInputActionPerformed

    private void jButtonHapusPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusPActionPerformed
          DefaultTableModel model = (DefaultTableModel)jTablePerempuan.getModel();
        String nama = model.getValueAt(jTablePerempuan.getSelectedRow(), 1).toString();
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to DELETE","TPQ Al-Mujahidin", 
                JOptionPane.YES_NO_OPTION) 
                == JOptionPane.YES_NO_OPTION)
        {
        DeleteDB.Delete(nama) ;
        updateTables();
        JOptionPane.showMessageDialog(this,"DATA BERHASIL DIHAPUS"); 
        }
        
       
    }//GEN-LAST:event_jButtonHapusPActionPerformed

    private void jButtonHapusLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusLActionPerformed
           DefaultTableModel model = (DefaultTableModel)jTableLaki.getModel();
        String nama = model.getValueAt(jTableLaki.getSelectedRow(), 1).toString();
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to DELETE","TPQ Al-Mujahidin", 
                JOptionPane.YES_NO_OPTION) 
                == JOptionPane.YES_NO_OPTION)
        {
        DeleteDB.Delete(nama) ;
        updateTables();
         JOptionPane.showMessageDialog(this,"DATA BERHASIL DIHAPUS"); 
        }
       
       
    }//GEN-LAST:event_jButtonHapusLActionPerformed

    private void jButtonHapusTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusTeacherActionPerformed
          DefaultTableModel model = (DefaultTableModel)jTablePengajar.getModel();
        String nama = model.getValueAt(jTablePengajar.getSelectedRow(), 0).toString();
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to DELETE","TPQ Al-Mujahidin", 
                JOptionPane.YES_NO_OPTION) 
                == JOptionPane.YES_NO_OPTION)
        {
        DeleteTeacher.Delete(nama) ;
        updateTables();
        JOptionPane.showMessageDialog(this,"DATA BERHASIL DIHAPUS"); 
        }
        
       
                                                 
    }//GEN-LAST:event_jButtonHapusTeacherActionPerformed

    private void jButtonPrintPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintPActionPerformed
       JasperReport reports;
    
    //sesuaikan path denggan lokasi file .jasper pastikan semua plugin dan library telah terinstal
    String path = "src/reports/ReportDataPerempuan.jasper";
           
   
    try {
        reports = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(reports, null, con);
        JasperViewer jviewer = new JasperViewer(jprint, false);
        jviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jviewer.setVisible(true);
        System.out.println("Masuk try");
    }   catch (JRException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPrintPActionPerformed

    private void jButtonPrintLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintLActionPerformed
       JasperReport reports;
    
    //sesuaikan path denggan lokasi file .jasper pastikan semua plugin dan library telah terinstal
    String path = "src/reports/ReportDataLakiLaki.jasper";
           
   
    try {
        reports = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(reports, null, con);
        JasperViewer jviewer = new JasperViewer(jprint, false);
        jviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jviewer.setVisible(true);
        System.out.println("Masuk try");
    }   catch (JRException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jButtonPrintLActionPerformed

    private void jButtonPrintTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintTeacherActionPerformed
          JasperReport reports;
    
   
    String path = "src/reports/ReportDataPengajar.jasper";
           
   
    try {
        reports = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(reports, null, con);
        JasperViewer jviewer = new JasperViewer(jprint, false);
        jviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jviewer.setVisible(true);
        System.out.println("Masuk try");
    }   catch (JRException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }   
    }//GEN-LAST:event_jButtonPrintTeacherActionPerformed

    private void PrintRapotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintRapotActionPerformed
   JasperReport reports;
   
    String selectedValue = TablePrintRapot.getValueAt(TablePrintRapot.getSelectedRow(), 0).toString();
    String path = "src/reports/RapotSiswa.jasper";
           
   
    try {
        reports = (JasperReport) JRLoader.loadObjectFromFile(path);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("selectedValue", selectedValue);
        JasperPrint jprint = JasperFillManager.fillReport(reports, parameters, con);
        JasperViewer jviewer = new JasperViewer(jprint, false);
        jviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jviewer.setVisible(true);
        System.out.println("Masuk try");
    }   catch (JRException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }   
    }//GEN-LAST:event_PrintRapotActionPerformed

    private void resetInput(){
        nameInp.setText("");
        ttlInp.setText("");
        waliInp.setText("");
        noteInp.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HafalanInput;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JPanel PBeranda;
    private javax.swing.JPanel PDataSantri;
    private javax.swing.JPanel PInputData;
    private javax.swing.JPanel PInputNilai;
    private javax.swing.JPanel PLaporanNilai;
    private javax.swing.JScrollPane PanelLakiLaki;
    private javax.swing.JScrollPane PanelPengajar;
    private javax.swing.JScrollPane PanelPerempuan;
    private javax.swing.JScrollPane PanelTotalSantri;
    private javax.swing.JButton PrintRapot;
    private javax.swing.JButton PrintScore;
    private javax.swing.JTextField QiroahInput;
    private javax.swing.JTextField SikapInput;
    private javax.swing.JLabel TableName;
    private javax.swing.JTable TablePrintRapot;
    private javax.swing.JTextField UASInput;
    private javax.swing.JTextField UTSInput;
    private javax.swing.JComboBox<String> genderInp;
    private javax.swing.JButton jButtonHapusL;
    private javax.swing.JButton jButtonHapusP;
    private javax.swing.JButton jButtonHapusT;
    private javax.swing.JButton jButtonHapusTeacher;
    private javax.swing.JButton jButtonINPUTNilai;
    private javax.swing.JButton jButtonPrintL;
    private javax.swing.JButton jButtonPrintP;
    private javax.swing.JButton jButtonPrintT;
    private javax.swing.JButton jButtonPrintTeacher;
    private javax.swing.JComboBox<String> jComboStatus1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCatatan;
    private javax.swing.JLabel jLabelKelas;
    private javax.swing.JLabel jLabelTglLahir;
    private javax.swing.JLabel jLabelWali;
    private javax.swing.JLabel jLaki;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jPengajar;
    private javax.swing.JLabel jPerempuan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableLaki;
    private javax.swing.JTable jTableNilai;
    private javax.swing.JTable jTablePengajar;
    private javax.swing.JTable jTablePerempuan;
    private javax.swing.JLabel jTotalSantri;
    private javax.swing.JComboBox<String> kelasInp;
    private javax.swing.JTable mainTable;
    private javax.swing.JTextField nameInp;
    private javax.swing.JTextField noteInp;
    private javax.swing.JPanel pn_line1;
    private javax.swing.JPanel pn_line2;
    private javax.swing.JPanel pn_line3;
    private javax.swing.JPanel pn_line4;
    private javax.swing.JPanel pn_line5;
    private javax.swing.JPanel pn_line6;
    private javax.swing.JPanel pn_main1;
    private javax.swing.JPanel pn_main2;
    private javax.swing.JPanel pn_main3;
    private javax.swing.JPanel pn_main4;
    private javax.swing.JPanel pn_main5;
    private javax.swing.JPanel pn_main6;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField ttlInp;
    private javax.swing.JTextField waliInp;
    // End of variables declaration//GEN-END:variables

  
}
