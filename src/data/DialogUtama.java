/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package data;


import com.sun.source.tree.IfTree;
import java.awt.Desktop;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.sql.Connection;
import jnafilechooser.api.JnaFileChooser;
import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentListener;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Angga
 */
public class DialogUtama extends javax.swing.JDialog {
//    private servicePrakerja servis = new PrakerjaDAO();

    public String tgl_lahir;
            public static String[] idkecamatan, iddesa, datakecamatan, datadesa;
            DefaultTableModel tabelModel;
          
  
    /**
     * Creates new form DialogUtama
     */
    public DialogUtama(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tampil_data();
        setLocationRelativeTo(null);
        setKecamatan();
        waktu();
        lebarKolom();
//        loadData();
    }

    
    public void lebarKolom(){ 
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(40);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(2); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(80);
        column = jTable1.getColumnModel().getColumn(5); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(6); 
        column.setPreferredWidth(50); 
        column = jTable1.getColumnModel().getColumn(7); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(8); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(9); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(10); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(11); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(12); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(13); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(14); 
        column.setPreferredWidth(50); 
        column = jTable1.getColumnModel().getColumn(15); 
        column.setPreferredWidth(50);  
        column = jTable1.getColumnModel().getColumn(16); 
        column.setPreferredWidth(75);
        column = jTable1.getColumnModel().getColumn(17); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(18); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(19); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(20); 
        column.setPreferredWidth(80);
        column = jTable1.getColumnModel().getColumn(21); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(22); 
        column.setPreferredWidth(70); 
        column = jTable1.getColumnModel().getColumn(23); 
        column.setPreferredWidth(130);  
        column = jTable1.getColumnModel().getColumn(24); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(25); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(26); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(27); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(28); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(29); 
        column.setPreferredWidth(100);
        column = jTable1.getColumnModel().getColumn(30); 
        column.setPreferredWidth(100);
    }
    
    
//    public void loadData(){
//        DefaultTableModel model = new DefaultTableModel();
//        
//            model.addColumn("No");
//            model.addColumn("Nama");
//            model.addColumn("No KTP");
//            model.addColumn("No KK");
//            model.addColumn("Tempat");
//            model.addColumn("Tanggal Lahir");
//            model.addColumn("Umur");
//            model.addColumn("Jenis Kelamin");
//            model.addColumn("Warga Negara");
//            model.addColumn("Provinsi");
//            model.addColumn("Kecamatan");
//            model.addColumn("Desa");
//            model.addColumn("Dusun");
//            model.addColumn("Kampung");
//            model.addColumn("RW");
//            model.addColumn("RT");
//            model.addColumn("Agama");
//            model.addColumn("No Telepon");
//            model.addColumn("No WA");
//            model.addColumn("Email");
//            model.addColumn("Nama Bank");
//            model.addColumn("No Rek");
//            model.addColumn("TPS");
//            model.addColumn("Penanggung Jawab");
//            model.addColumn("Admin");
//            model.addColumn("Jenis Pelatiah");
//            model.addColumn("Tanggal Input");
//            model.addColumn("Program");
//        
//        servis.getData(model);
//        jTable1.setModel(model);
//    }
    
    public void waktu(){
        Date tanggal_input = new Date();
        tgl_input.setDate(tanggal_input);
    }
    
    public void setKecamatan(){
        combokec.removeAllItems();
        combokec.addItem("Pilih Kecamatan");
//        com.mysql.jdbc.Connection koneksi;
//        if ((koneksi = getConn()) !=null) {
            try {
                String sql = "SELECT * FROM kecamatan";
                java.sql.Connection conn=(com.mysql.jdbc.Connection)koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
                
//                java.sql.Statement st=koneksi.createStatement();
//                java.sql.ResultSet rs = st.executeQuery(sql);
                rs.next();
                rs.last();
                
                idkecamatan = new String[rs.getRow()+1];
                datakecamatan = new String[rs.getRow()+1];
                if (rs.getRow()>0) {
                    rs.first();
                    idkecamatan[0]="";
                    datakecamatan[0]="";
                    int i=1;
                    do {                        
                        idkecamatan[i] = String.valueOf(rs.getString("id_kecamatan"));
                        datakecamatan[i] = String.valueOf(rs.getString("nama"));
                        combokec.addItem(datakecamatan[i]);
                        i++;
                    } while (rs.next());
                }
                rs.close();
                pst.close();
//                koneksi.close();
            }catch(Exception ex){
                System.out.println("error\n"+ex);
            }
        }
//            JOptionPane.showMessageDialog(null, pesankoneksi);
        
    
    
    public void setDesa(String idkec){
        combodes.removeAllItems();
        combodes.addItem("Pilih Desa");
//        if ((koneksi = getConn()) !=null) {
            try {
                String sql = "SELECT * FROM desa where id_kecamatan='"+idkec+"'";
                java.sql.Connection conn=(com.mysql.jdbc.Connection)koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
                rs.next();
                rs.last();
                
                iddesa = new String[rs.getRow()+1];
                datadesa = new String[rs.getRow()+1];
                if (rs.getRow()>0) {
                    rs.first();
                    iddesa[0]="";
                    datadesa[0]="";
                    int i=1;
                    do {                        
                        iddesa[i] = String.valueOf(rs.getString("id_kecamatan"));
                        datadesa[i] = String.valueOf(rs.getString("nama"));
                        combodes.addItem(datadesa[i]);
                        i++;
                    } while (rs.next());
                }
                rs.close();
                pst.close();
            }catch(Exception ex){
                System.out.println("error\n"+ex);
            }
        }
    
    public void username(String user){
        txtadmin.setText(user);
    }
    public void kosong_data(){
        nik.setText("");
        nama.setText("");
        no_kk.setText("");
        tempat.setText("");
        tgl.setDate(null);
        umur.setText("");
        buttonGroup1.clearSelection();
        warga.setText("INDONESIA");
        provinsi.setText("JAWA TENGAH");
        kecamatan.setText("");
        desa.setText("");
        dusun.setText("");
        kampung.setText("");
        rw.setText("");
        rt.setText("");
        comboagama.setSelectedItem("ISLAM");
        no_telp.setText("");
        no_wa.setText("");
        email.setText("");
        combonamabank.setSelectedItem("BNI");
        no_rek.setText("");
        tps.setText("");
//        txtadmin.setText("");
        penanggung.setText("");
        pl.setText("");
        jenis.setSelectedItem("");
        Date tanggal_input = new Date();
        tgl_input.setDate(tanggal_input);
        areaketerangan.setText("");
        txtcari.setText("");
        txtmaster.setText("");
        nik.requestFocus();
    }
    
     public void tampil_data(){
         DefaultTableModel tabel = new DefaultTableModel();
            tabel.addColumn("No");
            tabel.addColumn("Nama");
            tabel.addColumn("No KTP");
            tabel.addColumn("No KK");
            tabel.addColumn("Tempat");
            tabel.addColumn("Tanggal Lahir");
            tabel.addColumn("Umur");
            tabel.addColumn("Jenis Kelamin");
            tabel.addColumn("Warga Negara");
            tabel.addColumn("Provinsi");
            tabel.addColumn("Kecamatan");
            tabel.addColumn("Desa");
            tabel.addColumn("Dusun");
            tabel.addColumn("Kampung");
            tabel.addColumn("RW");
            tabel.addColumn("RT");
            tabel.addColumn("Agama");
            tabel.addColumn("No Telepon");
            tabel.addColumn("No WA");
            tabel.addColumn("Email");
            tabel.addColumn("Nama Bank");
            tabel.addColumn("No Rek");
            tabel.addColumn("TPS");
            tabel.addColumn("Penanggung Jawab");
            tabel.addColumn("Admin");
            tabel.addColumn("PL");
            tabel.addColumn("Jenis Pelatiah");
            tabel.addColumn("Waktu");
            tabel.addColumn("Tanggal Input");
            tabel.addColumn("Program Kerja");
            tabel.addColumn("Keterangan");
            int no =1;
            try {
                java.sql.Connection conn=(Connection)koneksi.configDB();
                String sql = "SELECT * FROM data";
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                java.sql.ResultSet rs= pst.executeQuery(sql);
              while(rs.next())
                {
                tabel.addRow(new Object[]{
                    no++,
//                    rs.getString(2),
//                    rs.getString(3),
//                    rs.getString(4),
//                    rs.getString(5),
//                    rs.getString(6),
//                    rs.getString(7),
//                    rs.getString(8),
//                    rs.getString(9),
//                    rs.getString(10),
//                    rs.getString(11),
//                    rs.getString(12),
//                    rs.getString(13),
//                    rs.getString(14),
//                    rs.getString(15),
//                    rs.getString(16),
//                    rs.getString(17),
//                    rs.getString(18),
//                    rs.getString(19),
//                    rs.getString(20),
//                    rs.getString(21),
//                    rs.getString(22),
//                    rs.getString(23),
//                    rs.getString(24),
//                    rs.getString(25),
//                    rs.getString(26),
//                    rs.getString(27)
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15),
                    rs.getString(16),
                    rs.getString(17),
                    rs.getString(18),
                    rs.getString(19),
                    rs.getString(20),
                    rs.getString(21),
                    rs.getString(22),
                    rs.getString(23),
                    rs.getString(24),
                    rs.getString(25),
                    rs.getString(26),
                    rs.getString(27),
                    rs.getString(28),
                    rs.getString(29),
                    rs.getString(30)
                });
                jTable1.setModel(tabel);
                jTable1.enable(true);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "gagal tampil \n"+e);
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

        btnmaster = new javax.swing.JButton();
        txtmaster = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btnexport = new javax.swing.JButton();
        keterangan = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tgl_input = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        btnkembali = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        combowaktu = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        btneksport = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        pl = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaketerangan = new javax.swing.JTextArea();

        combokec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kecamatan" }));
        combokec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokecActionPerformed(evt);
            }
        });
        combokec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combokecKeyReleased(evt);
            }
        });

        combodes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Desa" }));
        combodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combodesActionPerformed(evt);
            }
        });

        btnmaster.setText("CARI");
        btnmaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasterActionPerformed(evt);
            }
        });

        txtmaster.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmasterKeyReleased(evt);
            }
        });

        btnexport.setText("EXPORT");
        btnexport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportActionPerformed(evt);
            }
        });

        keterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keteranganKeyReleased(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRAKERJA");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("PRAKERJA");

        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("NAMA");

        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("NIK");

        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("NO KK");

        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("NAMA BANK");

        jLabel7.setForeground(new java.awt.Color(255, 255, 51));
        jLabel7.setText("NO WA");

        jLabel8.setForeground(new java.awt.Color(255, 255, 51));
        jLabel8.setText("EMAIL");

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namaKeyReleased(evt);
            }
        });

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 51));
        jLabel9.setText("KECAMATAN");

        jLabel10.setForeground(new java.awt.Color(255, 255, 51));
        jLabel10.setText("DESA");

        jLabel11.setForeground(new java.awt.Color(255, 255, 51));
        jLabel11.setText("RW");

        jLabel12.setForeground(new java.awt.Color(255, 255, 51));
        jLabel12.setText("TPS");

        jLabel13.setForeground(new java.awt.Color(255, 255, 51));
        jLabel13.setText("PENANGGUNG JAWAB");

        jLabel14.setForeground(new java.awt.Color(255, 255, 51));
        jLabel14.setText("ADMIN");

        tps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tpsKeyReleased(evt);
            }
        });

        penanggung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                penanggungKeyReleased(evt);
            }
        });

        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbatal.setText("BATAL");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        btncari.setText("CARI");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "No KTP", "No KK", "Tempat", "Tanggal Lahir", "Umur", "Jenis Kelamin", "Warga", "Provinsi", "Kecamatan", "Desa", "Dusun", "Kampung", "RW", "RT", "Agama", "No WA", "Email", "Nama Bank", "No Rek", "TPS", "Penanggung Jawab", "Admin", "Jenis Pelatihan", "Tanggal Input"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("TEMPAT / TANGGAL LAHIR");

        tempat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tempatKeyReleased(evt);
            }
        });

        tgl.setDateFormatString("dd-MM-yyyy");
        tgl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglPropertyChange(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 51));
        jLabel15.setText("UMUR");

        buttonGroup1.add(rblaki);
        rblaki.setForeground(new java.awt.Color(255, 255, 51));
        rblaki.setText("LAKI-LAKI");
        rblaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rblakiActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 51));
        jLabel16.setText("JENIS KELAMIN");

        buttonGroup1.add(rbperempuan);
        rbperempuan.setForeground(new java.awt.Color(255, 255, 51));
        rbperempuan.setText("PEREMPUAN");

        jLabel17.setForeground(new java.awt.Color(255, 255, 51));
        jLabel17.setText("WARGA NEGARA");

        warga.setText("INDONESIA");

        jLabel18.setForeground(new java.awt.Color(255, 255, 51));
        jLabel18.setText("PROVINSI");

        provinsi.setText("JAWA TENGAH");

        jLabel19.setForeground(new java.awt.Color(255, 255, 51));
        jLabel19.setText("DUSUN");

        jLabel20.setForeground(new java.awt.Color(255, 255, 51));
        jLabel20.setText("KAMPUNG / JALAN");

        dusun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dusunKeyReleased(evt);
            }
        });

        kampung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kampungActionPerformed(evt);
            }
        });
        kampung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kampungKeyReleased(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(255, 255, 51));
        jLabel21.setText("AGAMA");

        jLabel22.setForeground(new java.awt.Color(255, 255, 51));
        jLabel22.setText("JENIS PELATIHAN");

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ONLINE", "OFFLINE" }));

        comboagama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISLAM", "KRISTEN", "KATOLIK", "HINDU", "BUDDHA", "KHONGHUCU" }));

        jLabel23.setForeground(new java.awt.Color(255, 255, 51));
        jLabel23.setText("RT");

        combonamabank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BCA", "BNI" }));
        combonamabank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonamabankActionPerformed(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(255, 255, 51));
        jLabel24.setText("NO REK");

        jLabel25.setForeground(new java.awt.Color(255, 255, 51));
        jLabel25.setText("TANGGAL INPUT");

        tgl_input.setDateFormatString("dd-MM-yyyy");

        btnhitung.setText("Hitung Umur");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SA (1).png"))); // NOI18N
        jLabel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray));

        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(255, 255, 51));
        jLabel27.setText("NO TELEPON");

        no_telp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_telpKeyReleased(evt);
            }
        });

        txtadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadminActionPerformed(evt);
            }
        });

        btnkembali.setText("KEMBALI");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });

        kecamatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kecamatanActionPerformed(evt);
            }
        });
        kecamatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kecamatanKeyReleased(evt);
            }
        });

        desa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desaKeyReleased(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(255, 255, 51));
        jLabel28.setText("PROGRAM KERJA");

        program.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REGULER", "KIP", "PRAKERJA" }));

        jLabel29.setForeground(new java.awt.Color(255, 255, 51));
        jLabel29.setText("WAKTU");

        combowaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "PAGI", "SIANG", "MALAM" }));

        jLabel30.setForeground(new java.awt.Color(255, 255, 51));
        jLabel30.setText("KETERANGAN");

        btneksport.setText("EKSPOR");
        btneksport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneksportActionPerformed(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(255, 255, 51));
        jLabel31.setText("PL");

        pl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                plKeyReleased(evt);
            }
        });

        areaketerangan.setColumns(20);
        areaketerangan.setRows(5);
        areaketerangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaketeranganKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(areaketerangan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rblaki)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbperempuan))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(umur, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnhitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tempat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(nik)
                                    .addComponent(no_kk, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nama)
                                    .addComponent(warga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel19))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(desa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(provinsi, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                .addComponent(kecamatan)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dusun, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(109, 109, 109)
                                        .addComponent(rt, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(kampung, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                            .addComponent(rw))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tps, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboagama, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(no_rek)
                                    .addComponent(combonamabank, 0, 130, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(email)
                                    .addComponent(no_wa, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(penanggung)
                                .addComponent(tgl_input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtadmin, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(program, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combowaktu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pl))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btneksport))
                            .addComponent(btnkembali))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcari)
                                .addGap(18, 18, 18)
                                .addComponent(btncari))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnedit)
                                .addGap(18, 18, 18)
                                .addComponent(btnhapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnbatal)))
                        .addGap(542, 542, 542))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(545, 545, 545)
                        .addComponent(jLabel2)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel26))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(provinsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)
                                    .addComponent(comboagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(penanggung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(kecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel27)
                                    .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(desa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(no_kk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(dusun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(no_wa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31)
                                    .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(umur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(btnhitung)
                            .addComponent(jLabel20)
                            .addComponent(kampung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(combonamabank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(combowaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rblaki)
                                .addComponent(rbperempuan)
                                .addComponent(jLabel11)
                                .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)
                                .addComponent(no_rek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(warga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)
                                .addComponent(jLabel12)
                                .addComponent(tps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)
                                .addComponent(program, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsimpan)
                            .addComponent(btnedit)
                            .addComponent(btnhapus)
                            .addComponent(btnbatal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncari)
                            .addComponent(btnkembali)
                            .addComponent(btneksport)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(279, 279, 279))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void namaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyReleased
        // TODO add your handling code here:
        int position = nama.getCaretPosition();
        nama.setText(nama.getText().toUpperCase());
        nama.setCaretPosition(position);
    }//GEN-LAST:event_namaKeyReleased

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_emailKeyReleased

    private void combokecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokecActionPerformed
        // TODO add your handling code here:
        int datapilih = combokec.getSelectedIndex();
        try {
            String id = String.valueOf(idkecamatan[datapilih]);
            setDesa(id);
        }catch(Exception ex){}
    }//GEN-LAST:event_combokecActionPerformed

    private void combokecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combokecKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combokecKeyReleased

    private void combodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combodesActionPerformed
        // TODO add your handling code here:
        //        int datapilih = combodes.getSelectedIndex();
        //        try {
            //          String id = String.valueOf(iddesa[datapilih]);
            //            setDesa(id);
            //        }catch(Exception ex){}
    }//GEN-LAST:event_combodesActionPerformed

    private void tpsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpsKeyReleased
        // TODO add your handling code here:
        int position = tps.getCaretPosition();
        tps.setText(tps.getText().toUpperCase());
        tps.setCaretPosition(position);
    }//GEN-LAST:event_tpsKeyReleased

    private void penanggungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penanggungKeyReleased
        // TODO add your handling code here:int position = email.getCaretPosition();
        int position = penanggung.getCaretPosition();
        penanggung.setText(penanggung.getText().toUpperCase());
        penanggung.setCaretPosition(position);
    }//GEN-LAST:event_penanggungKeyReleased

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        String JenKel=null;
        if (rblaki.isSelected()){
            JenKel = "LAKI-LAKI";
        }else if(rbperempuan.isSelected()){
            JenKel = "PEREMPUAN";
        }else{
            JOptionPane.showMessageDialog(null, "Pilih Jenis Kelamin");
        }
        if (nama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Wajib Di isi");
        } else if(nik.getText().equals("")){
            JOptionPane.showMessageDialog(null, "NIK Wajib Di isi");
        }else if(no_kk.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No KK Wajib Di isi");
        }else if(tempat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tempat Wajib Di isi");
        }else if(tgl.getDate().equals("")){
            JOptionPane.showMessageDialog(null, "Tanggal Lahir Wajib Di isi");
        }else if(umur.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Umur Wajib Di isi");
        }else if(warga.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Warga Negara Wajib Di isi");
        }else if(provinsi.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Provinsi Wajib Di isi");
            //        }else if(combokec.getSelectedItem().equals("Pilih Kecamatan")){
            //            JOptionPane.showMessageDialog(null, "Kecamatan Wajib Di isi");
            //        }else if(combodes.getSelectedItem().equals("Pilih Desa")){
            //            JOptionPane.showMessageDialog(null, "Desa Wajib Di isi");
        }else if(rw.getText().equals("")){
            JOptionPane.showMessageDialog(null, "RW Wajib Di isi");
        }else if(rt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "RT Wajib Di isi");
        }else if(comboagama.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Agama Wajib Di isi");
        }else if(no_telp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No Telfon Wajib Di isi");
        }else if(no_wa.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No WA Wajib Di isi");
        }else if(email.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Email Wajib Di isi");
        }else if(combonamabank.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Bank Wajib Di isi");
        }else if(no_rek.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No Rek Wajib Di isi");
        }else if(tps.getText().equals("")){
            JOptionPane.showMessageDialog(null, "TPS Wajib Di isi");
        }else if(penanggung.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Penanggung Jawab Wajib Di isi");
        }else if(pl.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Petugas Lapangan Wajib Di isi");
        }else if(jenis.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Jenis Pelatihan Wajib Di isi");
        }else if(tgl_input.getDate().equals("")){
            JOptionPane.showMessageDialog(null, "Tanggal Input Wajib Di isi");
        }

        if (rblaki.isSelected()){
            JenKel = "LAKI-LAKI";
        }else if(rbperempuan.isSelected()){
            JenKel = "PEREMPUAN";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("y-MM-dd");
        String tglKel = sdf.format(tgl.getDate());
        String tglInput = sdf.format(tgl_input.getDate());
        try{
            String sql="insert into data (nik, nama, no_kk, tempat, tanggal, umur, jk, warga, "
            + "provinsi, kecamatan, desa, dusun, kampung, rw, rt, agama, no_telp, no_wa, "
            + "email, nama_bank, no_rek, tps, penanggung, admin, pl, jenis_pelatihan, waktu, tgl_input, program, keterangan) values('"
            +nik.getText()+"','"
            +nama.getText().replace("'","''")+"','"
            +no_kk.getText()+"','"
            +tempat.getText()+"','"
            +tglKel+"','"
            +umur.getText()+"','"
            +JenKel+"','"
            +warga.getText()+"','"
            +provinsi.getText()+"','"
            +kecamatan.getText()+"','"
            +desa.getText()+"','"
            +dusun.getText()+"','"
            +kampung.getText()+"','"
            +rw.getText()+"','"
            +rt.getText()+"','"
            +comboagama.getSelectedItem()+"','"
            +no_telp.getText()+"','"
            +no_wa.getText()+"','"
            +email.getText()+"','"
            +combonamabank.getSelectedItem()+"','"
            +no_rek.getText()+"','"
            +tps.getText()+"','"
            +penanggung.getText()+"','"
            +txtadmin.getText()+"','"
            +pl.getText()+"','"
            +jenis.getSelectedItem()+"','"
            +combowaktu.getSelectedItem()+"','"
            +tglInput+"','"
            +program.getSelectedItem()+"','"
            +areaketerangan.getText()+"')";
            java.sql.Connection conn=(java.sql.Connection)koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            tampil_data();
            kosong_data();
            lebarKolom();
            new FSearch().setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal disimpan");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        String JenKel=null;
        if (rblaki.isSelected()){
            JenKel = "LAKI-LAKI";
        }else if(rbperempuan.isSelected()){
            JenKel = "PEREMPUAN";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("y-MM-dd");
        String tglKel = sdf.format(tgl.getDate());
        String tglInput = sdf.format(tgl_input.getDate());
        try{
            String sql = "update data SET nik = '" + nik.getText() +
            "', nama = '" + nama.getText().replace("'","''") +
            "', no_kk = '" + no_kk.getText() +
            "', tempat = '" + tempat.getText() +
            "', tanggal = '" + tglKel +
            "', umur = '" + umur.getText() +
            "', jk = '" + JenKel+
            "', warga = '" + warga.getText()+
            "', provinsi = '" + provinsi.getText() +
            "', kecamatan = '" + kecamatan.getText()+
            "', desa = '" + desa.getText()+
            "', dusun = '" + dusun.getText() +
            "', kampung = '" + kampung.getText() +
            "', rw = '" + rw.getText() +
            "', rt = '" + rt.getText() +
            "', agama = '" + comboagama.getSelectedItem()+
            "', no_telp = '" + no_telp.getText() +
            "', no_wa = '" + no_wa.getText() +
            "', email = '" + email.getText() +
            "', nama_bank = '" + combonamabank.getSelectedItem()+
            "', no_rek = '" + no_rek.getText() +
            "', tps = '" + tps.getText() +
            "', penanggung = '" + penanggung.getText() +
            "', pl = '" + pl.getText() +
                                 "', admin = '" + txtadmin.getText()+
            "', jenis_pelatihan = '" + jenis.getSelectedItem()+
            "', waktu = '" + combowaktu.getSelectedItem()+
            "', tgl_input = '" + tglInput +
            "', program = '" + program.getSelectedItem()+
            "', keterangan = '" + areaketerangan.getText() +
            "' WHERE data.nik = '" + nik.getText() + "'";
            java.sql.Connection conn=(java.sql.Connection)koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");
            tampil_data();
            kosong_data();
            lebarKolom();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal diupdate");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try{
            java.sql.Connection conn=(java.sql.Connection)koneksi.configDB();
            String sql = "delete from data where nik='"+nik.getText()+"' ";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data berhasil di hapus");
            tampil_data();
            kosong_data();
            lebarKolom();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Proses Penghapusan Gagal");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        nik.setText("");
        nama.setText("");
        no_kk.setText("");
        tempat.setText("");
        tgl.setDate(null);
        umur.setText("");
        buttonGroup1.clearSelection();
        warga.setText("INDONESIA");
        provinsi.setText("JAWA TENGAH");
        kecamatan.setText("");
        desa.setText("");
        dusun.setText("");
        kampung.setText("");
        rw.setText("");
        rt.setText("");
        comboagama.setSelectedItem("Islam");
        no_telp.setText("");
        no_wa.setText("");
        email.setText("");
        combonamabank.setSelectedItem("Islam");
        no_rek.setText("");
        tps.setText("");
        penanggung.setText("");
        //        txtadmin.setText("");
        pl.setText("");
        jenis.setSelectedItem("");
        Date tanggal_input = new Date();
        tgl_input.setDate(tanggal_input);
        txtcari.setText("");
        txtmaster.setText("");
        nik.requestFocus();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        // TODO add your handling code here:
        int position = txtcari.getCaretPosition();
        txtcari.setText(txtcari.getText().toUpperCase());
        txtcari.setCaretPosition(position);
    }//GEN-LAST:event_txtcariKeyReleased

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Connection conn=(java.sql.Connection)koneksi.configDB();
            String sql = "select * from data where nik='"+txtcari.getText()+"' or nama='"+txtcari.getText()+"'";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            //    String JenKel=null;
            //        if (rblaki.isSelected()){
                //            JenKel = "Laki-Laki";
                //        }else if(rbperempuan.isSelected()){
                //            JenKel = "Perempuan";
                //        }
            if (rs.next()){
                nama.setText(rs.getString(1));
                nik.setText(rs.getString(2));
                no_kk.setText(rs.getString(3));
                tgl.setDate(rs.getDate(5));
                tempat.setText(rs.getString(4));
                umur.setText(rs.getString(6));
                if ("PEREMPUAN".equals(rs.getString(7))) {
                    rbperempuan.setSelected(true);
                } else{
                    rblaki.setSelected(true);
                }
                warga.setText(rs.getString(8));
                provinsi.setText(rs.getString(9));
                kecamatan.setText(rs.getString(10));
                desa.setText(rs.getString(11));
                dusun.setText(rs.getString(12));
                kampung.setText(rs.getString(13));
                rw.setText(rs.getString(14));
                rt.setText(rs.getString(15));
                comboagama.setSelectedItem(rs.getString(16));
                no_telp.setText(rs.getString(17));
                no_wa.setText(rs.getString(18));
                email.setText(rs.getString(19));
                combonamabank.setSelectedItem(rs.getString(20));
                no_rek.setText(rs.getString(21));
                tps.setText(rs.getString(22));
                penanggung.setText(rs.getString(23));
                //        txtadmin.setText(rs.getString(24));
                pl.setText(rs.getString(25));
                jenis.setSelectedItem(rs.getString(26));
                combowaktu.setSelectedItem(rs.getString(27));
                tgl_input.setDate(rs.getDate(28));
                program.setSelectedItem(rs.getString(29));
                areaketerangan.setText(rs.getString(30));

                JOptionPane.showMessageDialog(null,"Data : "
                    + txtcari.getText() + " ditemukan, Apakah Anda Ingin Mengedit atau Menghapus?");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data tidak ada!");
            System.out.println(e.getMessage());
        }
        btncari.requestFocus();
    }//GEN-LAST:event_btncariActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedRowIndex = jTable1.getSelectedRow();
            //    String JenKel=null;
            //        if (rblaki.isSelected()){
                //            JenKel = "Laki-Laki";
                //        }else if(rbperempuan.isSelected()){
                //            JenKel = "Perempuan";
                //        }
            nama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            nik.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            no_kk.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRowIndex, 5).toString());
            tgl.setDate(date);
            tempat.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            umur.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            if ("PEREMPUAN".equals(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString())) {
                rbperempuan.setSelected(true);
            } else{
                rblaki.setSelected(true);
            }
            warga.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
            provinsi.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString());
            //        jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString());
            //        jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString());
            kecamatan.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString());
            desa.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString());
            dusun.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 12).toString());
            kampung.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 13).toString());
            rw.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 14).toString());
            rt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 15).toString());
            comboagama.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 16).toString());
            no_telp.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 17).toString());
            no_wa.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 18).toString());
            email.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 19).toString());
            combonamabank.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 20).toString());
            no_rek.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 21).toString());
            tps.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 22).toString());
            penanggung.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 23).toString());
            //        txtadmin.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 24).toString());
            pl.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 25).toString());
            jenis.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 26).toString());
            combowaktu.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 27).toString());
            Date tglinput = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRowIndex, 28).toString());
            tgl_input.setDate(tglinput);
            program.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 29).toString());
            areaketerangan.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 30).toString());
        }
        catch (Exception e){}
        //       try {
            //                java.sql.Connection conn=(Connection)koneksi.configDB();
            //                String sql = "SELECT * FROM data";
            //                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            //                java.sql.ResultSet rs= pst.executeQuery(sql);
            //              while(rs.next())
            //                {
                //        nama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        nik.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        no_kk.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        tempat.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        tgl.setDate(rs.getDate());
                //        umur.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        buttonGroup1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        warga.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        provinsi.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        combokec.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        combodes.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        dusun.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        kampung.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        rw.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        rt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        comboagama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        no_telp.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        no_wa.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        email.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        combonamabank.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        no_rek.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        tps.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        penanggung.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        txtadmin.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        jenis.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //        tgl_input.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                //                }
            //       }
    }//GEN-LAST:event_jTable1MouseClicked

    private void tempatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tempatKeyReleased
        // TODO add your handling code here:
        int position = tempat.getCaretPosition();
        tempat.setText(tempat.getText().toUpperCase());
        tempat.setCaretPosition(position);
    }//GEN-LAST:event_tempatKeyReleased

    private void tglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglPropertyChange
        // TODO add your handling code here:
        if (tgl.getDate()!=null){
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tgl_lahir=format.format (tgl.getDate());
        }
    }//GEN-LAST:event_tglPropertyChange

    private void rblakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rblakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rblakiActionPerformed

    private void dusunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dusunKeyReleased
        // TODO add your handling code here:
        int position = dusun.getCaretPosition();
        dusun.setText(dusun.getText().toUpperCase());
        dusun.setCaretPosition(position);
    }//GEN-LAST:event_dusunKeyReleased

    private void kampungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kampungKeyReleased
        // TODO add your handling code here:
        int position = kampung.getCaretPosition();
        kampung.setText(kampung.getText().toUpperCase());
        kampung.setCaretPosition(position);
    }//GEN-LAST:event_kampungKeyReleased

    private void combonamabankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonamabankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combonamabankActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        Date lahir = tgl.getDate();
        Date kini = new Date();
        int usia = kini.getYear()-lahir.getYear();
        this.umur.setText(String.valueOf(usia));
    }//GEN-LAST:event_btnhitungActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tampil_data();
        lebarKolom();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void no_telpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_telpKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_no_telpKeyReleased

    private void txtadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadminActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        // TODO add your handling code here:
        new FSearch().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnmasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasterActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Connection conn=(java.sql.Connection)koneksi.configDB();
            String sql = "select * from masterdata where nik='"+txtmaster.getText()+"'";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()){
                nama.setText(rs.getString(2));
                nik.setText(rs.getString(3));
                no_kk.setText(rs.getString(4));
                tgl.setDate(rs.getDate(6));
                tempat.setText(rs.getString(5));
                umur.setText(rs.getString(7));
                if ("PEREMPUAN".equals(rs.getString(8))) {
                    rbperempuan.setSelected(true);
                } else{
                    rblaki.setSelected(true);
                }
                warga.setText(rs.getString(9));
                provinsi.setText(rs.getString(10));
                combokec.setSelectedItem(rs.getString(11));
                combodes.setSelectedItem(rs.getString(12));
                dusun.setText(rs.getString(13));
                kampung.setText(rs.getString(14));
                rw.setText(rs.getString(15));
                rt.setText(rs.getString(16));
                comboagama.setSelectedItem(rs.getString(17));
                no_telp.setText(rs.getString(18));
                no_wa.setText(rs.getString(19));
                email.setText(rs.getString(20));
                combonamabank.setSelectedItem(rs.getString(21));
                no_rek.setText(rs.getString(22));
                tps.setText(rs.getString(23));
                penanggung.setText(rs.getString(24));
                //        txtadmin.setText(rs.getString(24));
                jenis.setSelectedItem(rs.getString(26));

                JOptionPane.showMessageDialog(null,"Data : "
                    + txtmaster.getText() + " ditemukan");
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak Ada");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data tidak ada!");
            System.out.println(e.getMessage());
        }
        btnmaster.requestFocus();
    }//GEN-LAST:event_btnmasterActionPerformed

    private void txtmasterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmasterKeyReleased
        // TODO add your handling code here:
        int posisi = txtmaster.getCaretPosition();
        txtmaster.setText(txtmaster.getText().toUpperCase());
        txtmaster.setCaretPosition(posisi);
    }//GEN-LAST:event_txtmasterKeyReleased

    private void kecamatanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kecamatanKeyReleased
        // TODO add your handling code here:
        int position = kecamatan.getCaretPosition();
        kecamatan.setText(kecamatan.getText().toUpperCase());
        kecamatan.setCaretPosition(position);
    }//GEN-LAST:event_kecamatanKeyReleased

    private void desaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desaKeyReleased
        // TODO add your handling code here:
        int position = desa.getCaretPosition();
        desa.setText(desa.getText().toUpperCase());
        desa.setCaretPosition(position);
    }//GEN-LAST:event_desaKeyReleased

    private void btnexportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportActionPerformed
        // TODO add your handling code here:
        eksporexcel();
//        JnaFileChooser filechooser = new JnaFileChooser();
//        Window window = null;
//        boolean action = filechooser.showSaveDialog(window);
//        if (action) {
//            String fileString = filechooser.getSelectedFile().getAbsolutePath() + ".xlsx";
//            servis.exportToexcel(jTable1, fileString);
//        }
    }//GEN-LAST:event_btnexportActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void kampungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kampungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kampungActionPerformed

    private void kecamatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kecamatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kecamatanActionPerformed

    private void keteranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keteranganKeyReleased
        // TODO add your handling code here:
        int position = keterangan.getCaretPosition();
        keterangan.setText(keterangan.getText().toUpperCase());
        keterangan.setCaretPosition(position);
    }//GEN-LAST:event_keteranganKeyReleased

    private void btneksportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneksportActionPerformed
        // TODO add your handling code here:
        try {
            String filename = "D:/data.xlsx";//Create a Filename and path
            XSSFWorkbook workbook = new XSSFWorkbook(); //Create a new Excel Workbook Use HSSFWorkbook if the version of your excel is 2003
            XSSFSheet sheet = workbook.createSheet("new Sheet"); //create a new excel sheet
            float empatpuluhcolumnwidth = 40f;//columnwidth for ID
            float dualimacolumnwidth = 25f;//column width for names
            float sepuluhcolumnwidth = 10f;//column width for department
            float duapuluhcolumnwidth = 20f;//columnwidth for birthday
            float seratuscolumnwidth = 100f;//columnwidth for birthday

//set columnwidth of cell
            int empatpuluhwidth = (int) Math.floor((empatpuluhcolumnwidth * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
            int dualimawidth = (int) Math.floor((dualimacolumnwidth * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
            int sepuluhwidth = (int) Math.floor((sepuluhcolumnwidth * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
            int duapuluhwidth = (int) Math.floor((duapuluhcolumnwidth * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
            int seratuswidth = (int) Math.floor((seratuscolumnwidth * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
            sheet.setColumnWidth(0, empatpuluhwidth);//nama
            sheet.setColumnWidth(1, dualimawidth);//nik
            sheet.setColumnWidth(2, dualimawidth);//kk
            sheet.setColumnWidth(3, dualimawidth);//tempat
            sheet.setColumnWidth(4, dualimawidth);//tanggal
            sheet.setColumnWidth(5, sepuluhwidth);//umur
            sheet.setColumnWidth(6, dualimawidth);//jk
            sheet.setColumnWidth(7, dualimawidth);//warga
            sheet.setColumnWidth(8, duapuluhwidth);//provinsi
            sheet.setColumnWidth(9, duapuluhwidth);//kecamatan
            sheet.setColumnWidth(10, duapuluhwidth);//desa
            sheet.setColumnWidth(11, dualimawidth);//dusun
            sheet.setColumnWidth(12, dualimawidth);//kampung
            sheet.setColumnWidth(13, sepuluhwidth);//rw
            sheet.setColumnWidth(14, sepuluhwidth);//rt
            sheet.setColumnWidth(15, sepuluhwidth);//agama
            sheet.setColumnWidth(16, duapuluhwidth);//noTelp
            sheet.setColumnWidth(17, duapuluhwidth);//noWa
            sheet.setColumnWidth(18, empatpuluhwidth);//email
            sheet.setColumnWidth(19, duapuluhwidth);//namaBank
            sheet.setColumnWidth(20, dualimawidth);//noRek
            sheet.setColumnWidth(21, sepuluhwidth);//tps
            sheet.setColumnWidth(22, empatpuluhwidth);//penanggung
            sheet.setColumnWidth(23, empatpuluhwidth);//admin
            sheet.setColumnWidth(24, empatpuluhwidth);//pl
            sheet.setColumnWidth(25, dualimawidth);//jenis
            sheet.setColumnWidth(26, sepuluhwidth);//waktu
            sheet.setColumnWidth(27, dualimawidth);//tglInput
            sheet.setColumnWidth(28, duapuluhwidth);//program
            sheet.setColumnWidth(29, seratuswidth);//keterangan
            XSSFCellStyle style = workbook.createCellStyle();//cell style for header
            XSSFCellStyle style2 = workbook.createCellStyle();//cell style for result
            style.setAlignment(HorizontalAlignment.CENTER);//center align
            style.setBorderBottom(BorderStyle.THICK);//border bottom
            style.setBorderTop(BorderStyle.THICK);//border top
            style.setBorderLeft(BorderStyle.THICK);//border left
            style.setBorderRight(BorderStyle.THICK);//border right
            style2.setBorderBottom(BorderStyle.THIN);//border bottom
            style2.setBorderTop(BorderStyle.THIN);//border top
            style2.setBorderLeft(BorderStyle.THIN);//border left
            style2.setBorderRight(BorderStyle.THIN);//border right
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            XSSFFont font = workbook.createFont();//style for header
            XSSFFont font2 = workbook.createFont();//style for result
            font.setBold(true);
            font.setFontName("Tahoma");
            font.setFontHeightInPoints((short)12);
            font2.setFontName("Cambria");
            font2.setFontHeightInPoints((short)12);
            style.setFont(font);//font style for header
            style2.setFont(font2);//font style for result
                        
            XSSFRow header = sheet.createRow((short) 0);//create a row header. 0 means row 1
            header.createCell((short) 0).setCellValue("NAMA");//Create a header for IDnumber
            header.createCell((short) 1).setCellValue("NIK");//Create a header for Last Name
            header.createCell((short) 2).setCellValue("NO KK");//Create a header for First Name
            header.createCell((short) 3).setCellValue("TEMPAT");//Create a header for Middle Name
            header.createCell((short) 4).setCellValue("TANGGAL LAHIR");//Create a header for Department Name
            header.createCell((short) 5).setCellValue("UMUR");//Create a header for Birthday
            header.createCell((short) 6).setCellValue("JENIS KELAMIN");//Create a header for IDnumber
            header.createCell((short) 7).setCellValue("WARGA NEGARA");//Create a header for Last Name
            header.createCell((short) 8).setCellValue("PROVINSI");//Create a header for First Name
            header.createCell((short) 9).setCellValue("KECAMATAN");//Create a header for Middle Name
            header.createCell((short) 10).setCellValue("DESA");//Create a header for Department Name
            header.createCell((short) 11).setCellValue("DUSUN");//Create a header for Birthday
            header.createCell((short) 12).setCellValue("KAMPUNG");//Create a header for IDnumber
            header.createCell((short) 13).setCellValue("RW");//Create a header for Last Name
            header.createCell((short) 14).setCellValue("RT");//Create a header for First Name
            header.createCell((short) 15).setCellValue("AGAMA");//Create a header for Middle Name
            header.createCell((short) 16).setCellValue("NO TELPON");//Create a header for Department Name
            header.createCell((short) 17).setCellValue("NO WA");//Create a header for Birthday
            header.createCell((short) 18).setCellValue("EMAIL");//Create a header for IDnumber
            header.createCell((short) 19).setCellValue("NAMA BANK");//Create a header for Last Name
            header.createCell((short) 20).setCellValue("NO REKENING");//Create a header for First Name
            header.createCell((short) 21).setCellValue("TPS");//Create a header for Middle Name
            header.createCell((short) 22).setCellValue("PENANGGUNG JAWAB");//Create a header for Department Name
            header.createCell((short) 23).setCellValue("ADMIN");//Create a header for Birthday
            header.createCell((short) 24).setCellValue("PL");//Create a header for Birthday
            header.createCell((short) 25).setCellValue("JENIS PELATIHAN");//Create a header for Last Name
            header.createCell((short) 26).setCellValue("WAKTU");//Create a header for First Name
            header.createCell((short) 27).setCellValue("TANGGAL INPUT");//Create a header for Middle Name
            header.createCell((short) 28).setCellValue("PROGRAM");//Create a header for Department Name
            header.createCell((short) 29).setCellValue("KETERANGAN");//Create a header for Birthday
            header.getCell(0).setCellStyle(style);//aplly style to header
            header.getCell(1).setCellStyle(style);
            header.getCell(2).setCellStyle(style);
            header.getCell(3).setCellStyle(style);
            header.getCell(4).setCellStyle(style);
            header.getCell(5).setCellStyle(style);
            header.getCell(6).setCellStyle(style);
            header.getCell(7).setCellStyle(style);
            header.getCell(8).setCellStyle(style);
            header.getCell(9).setCellStyle(style);
            header.getCell(10).setCellStyle(style);
            header.getCell(11).setCellStyle(style);
            header.getCell(12).setCellStyle(style);
            header.getCell(13).setCellStyle(style);
            header.getCell(14).setCellStyle(style);
            header.getCell(15).setCellStyle(style);
            header.getCell(16).setCellStyle(style);
            header.getCell(17).setCellStyle(style);
            header.getCell(18).setCellStyle(style);
            header.getCell(19).setCellStyle(style);
            header.getCell(20).setCellStyle(style);
            header.getCell(21).setCellStyle(style);
            header.getCell(22).setCellStyle(style);
            header.getCell(23).setCellStyle(style);
            header.getCell(24).setCellStyle(style);
            header.getCell(25).setCellStyle(style);
            header.getCell(26).setCellStyle(style);
            header.getCell(27).setCellStyle(style);
            header.getCell(28).setCellStyle(style);
            header.getCell(29).setCellStyle(style);
            

            //Export data from Mysql to Excel
            Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://103.133.25.99:3306/gogonet_separe?zeroDateTimeBehavior=convertToNull", "gogonet_separe", "1YMVTLOjzW3S");
            //root is the Mysql connection username and 1234 is the password
//            Connection kon = DriverManager.getConnection("jdbc:mysql://192.168.43.1:3306/project_angga?zeroDateTimeBehavior=convertToNull", "angga", "Athabeef123.");
            //create a query to write the result in excel
            String query = "SELECT * FROM data";
            PreparedStatement pst = kon.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            int i = 1;
            while (result.next()) {
                XSSFRow resultrow = sheet.createRow((short) i);
                resultrow.createCell((short) 0).setCellValue(result.getString(1)); //data from column IDNumber
                resultrow.createCell((short) 1).setCellValue(result.getString(2));//data from column lastname
                resultrow.createCell((short) 2).setCellValue(result.getString(3));//firstname
                resultrow.createCell((short) 3).setCellValue(result.getString(4));//middlename
                resultrow.createCell((short) 4).setCellValue(result.getString(5));//department
                resultrow.createCell((short) 5).setCellValue(result.getString(6));//birthdate
                resultrow.createCell((short) 6).setCellValue(result.getString(7)); //data from column IDNumber
                resultrow.createCell((short) 7).setCellValue(result.getString(8));//data from column lastname
                resultrow.createCell((short) 8).setCellValue(result.getString(9));//firstname
                resultrow.createCell((short) 9).setCellValue(result.getString(10));//middlename
                resultrow.createCell((short) 10).setCellValue(result.getString(11));//department
                resultrow.createCell((short) 11).setCellValue(result.getString(12));//birthdate
                resultrow.createCell((short) 12).setCellValue(result.getString(13)); //data from column IDNumber
                resultrow.createCell((short) 13).setCellValue(result.getString(14));//data from column lastname
                resultrow.createCell((short) 14).setCellValue(result.getString(15));//firstname
                resultrow.createCell((short) 15).setCellValue(result.getString(16));//middlename
                resultrow.createCell((short) 16).setCellValue(result.getString(17));//department
                resultrow.createCell((short) 17).setCellValue(result.getString(18));//birthdate
                resultrow.createCell((short) 18).setCellValue(result.getString(19)); //data from column IDNumber
                resultrow.createCell((short) 19).setCellValue(result.getString(20));//data from column lastname
                resultrow.createCell((short) 20).setCellValue(result.getString(21));//firstname
                resultrow.createCell((short) 21).setCellValue(result.getString(22));//middlename
                resultrow.createCell((short) 22).setCellValue(result.getString(23));//department
                resultrow.createCell((short) 23).setCellValue(result.getString(24));//birthdate
                resultrow.createCell((short) 24).setCellValue(result.getString(25)); //data from column IDNumber
                resultrow.createCell((short) 25).setCellValue(result.getString(26));//data from column lastname
                resultrow.createCell((short) 26).setCellValue(result.getString(27));//firstname
                resultrow.createCell((short) 27).setCellValue(result.getString(28));//middlename
                resultrow.createCell((short) 28).setCellValue(result.getString(29));//department
                resultrow.createCell((short) 29).setCellValue(result.getString(30));//department
                resultrow.getCell(0).setCellStyle(style2);
                resultrow.getCell(1).setCellStyle(style2);
                resultrow.getCell(2).setCellStyle(style2);
                resultrow.getCell(3).setCellStyle(style2);
                resultrow.getCell(4).setCellStyle(style2);
                resultrow.getCell(5).setCellStyle(style2);
                resultrow.getCell(6).setCellStyle(style2);
                resultrow.getCell(7).setCellStyle(style2);
                resultrow.getCell(8).setCellStyle(style2);
                resultrow.getCell(9).setCellStyle(style2);
                resultrow.getCell(10).setCellStyle(style2);
                resultrow.getCell(11).setCellStyle(style2);
                resultrow.getCell(12).setCellStyle(style2);
                resultrow.getCell(13).setCellStyle(style2);
                resultrow.getCell(14).setCellStyle(style2);
                resultrow.getCell(15).setCellStyle(style2);
                resultrow.getCell(16).setCellStyle(style2);
                resultrow.getCell(17).setCellStyle(style2);
                resultrow.getCell(18).setCellStyle(style2);
                resultrow.getCell(19).setCellStyle(style2);
                resultrow.getCell(20).setCellStyle(style2);
                resultrow.getCell(21).setCellStyle(style2);
                resultrow.getCell(22).setCellStyle(style2);
                resultrow.getCell(23).setCellStyle(style2);
                resultrow.getCell(24).setCellStyle(style2);
                resultrow.getCell(25).setCellStyle(style2);
                resultrow.getCell(26).setCellStyle(style2);
                resultrow.getCell(27).setCellStyle(style2);
                resultrow.getCell(28).setCellStyle(style2);
                resultrow.getCell(29).setCellStyle(style2);
                i++;

            }

            try {
                FileOutputStream fileout = new FileOutputStream(filename);
                workbook.write(fileout);
                JOptionPane.showMessageDialog(null, "Excel File has been exported, lokasi file D:/data.xls");
                Desktop.getDesktop().open(new File((filename)));//automatically open after exporting
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_btneksportActionPerformed

    private void plKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plKeyReleased
        // TODO add your handling code here:
        int position = pl.getCaretPosition();
        pl.setText(pl.getText().toUpperCase());
        pl.setCaretPosition(position);
    }//GEN-LAST:event_plKeyReleased

    private void areaketeranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaketeranganKeyReleased
        // TODO add your handling code here:
        int position = areaketerangan.getCaretPosition();
        areaketerangan.setText(areaketerangan.getText().toUpperCase());
        areaketerangan.setCaretPosition(position);
    }//GEN-LAST:event_areaketeranganKeyReleased

    public void eksporexcel(){
        FileWriter fileWriter;
        JnaFileChooser chooser = new JnaFileChooser();
//        chooser.setCurrentDirectory(new File("[B]export_output/excel[/B]"));
        boolean retrival = chooser.showSaveDialog(null);
        if (retrival) {
            try{
                TableModel tModel = jTable1.getModel();
                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".csv"));           
            // write header
                for(int i = 0; i < tModel.getColumnCount(); i++){
                fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");
            }
                fileWriter.write("\n");
            // write record
                for(int i=0; i < tModel.getRowCount(); i++) {
                for(int j=0; j < tModel.getColumnCount(); j++) {
                fileWriter.write(tModel.getValueAt(i,j).toString() + "\t");
            }
                fileWriter.write("\n");
            }
                fileWriter.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
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
            java.util.logging.Logger.getLogger(DialogUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogUtama dialog = new DialogUtama(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaketerangan;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btneksport;
    private javax.swing.JButton btnexport;
    private javax.swing.JButton btnhapus;
    public static final javax.swing.JButton btnhitung = new javax.swing.JButton();
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btnmaster;
    private javax.swing.JButton btnsimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    public static final javax.swing.JComboBox<String> comboagama = new javax.swing.JComboBox<>();
    public static final javax.swing.JComboBox<String> combodes = new javax.swing.JComboBox<>();
    public static final javax.swing.JComboBox<String> combokec = new javax.swing.JComboBox<>();
    public static final javax.swing.JComboBox<String> combonamabank = new javax.swing.JComboBox<>();
    private javax.swing.JComboBox<String> combowaktu;
    public static final javax.swing.JTextField desa = new javax.swing.JTextField();
    public static final javax.swing.JTextField dusun = new javax.swing.JTextField();
    public static final javax.swing.JTextField email = new javax.swing.JTextField();
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static final javax.swing.JComboBox<String> jenis = new javax.swing.JComboBox<>();
    public static final javax.swing.JTextField kampung = new javax.swing.JTextField();
    public static final javax.swing.JTextField kecamatan = new javax.swing.JTextField();
    private javax.swing.JTextField keterangan;
    public static final javax.swing.JTextField nama = new javax.swing.JTextField();
    public static final javax.swing.JTextField nik = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_kk = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_rek = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_telp = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_wa = new javax.swing.JTextField();
    public static final javax.swing.JTextField penanggung = new javax.swing.JTextField();
    private javax.swing.JTextField pl;
    public static final javax.swing.JComboBox<String> program = new javax.swing.JComboBox<>();
    public static final javax.swing.JTextField provinsi = new javax.swing.JTextField();
    public static final javax.swing.JRadioButton rblaki = new javax.swing.JRadioButton();
    public static final javax.swing.JRadioButton rbperempuan = new javax.swing.JRadioButton();
    public static final javax.swing.JTextField rt = new javax.swing.JTextField();
    public static final javax.swing.JTextField rw = new javax.swing.JTextField();
    public static final javax.swing.JTextField tempat = new javax.swing.JTextField();
    public static final com.toedter.calendar.JDateChooser tgl = new com.toedter.calendar.JDateChooser();
    private com.toedter.calendar.JDateChooser tgl_input;
    public static final javax.swing.JTextField tps = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtadmin = new javax.swing.JTextField();
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtmaster;
    public static final javax.swing.JTextField umur = new javax.swing.JTextField();
    public static final javax.swing.JTextField warga = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
