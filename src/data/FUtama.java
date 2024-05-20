package data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import com.sun.source.tree.IfTree;
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
import com.mysql.jdbc.Connection;
/**
 *
 * @author Angga
 */
public class FUtama extends javax.swing.JFrame {
    public String tgl_lahir;
//    private static final String Driver="com.mysql.jdbc.Driver",
//            database = "jdbc:mysql://172.16.1.230:3306/project_angga",
//            user="root",
//            password="";
//            private com.mysql.jdbc.Connection connection;
//            private String pesankoneksi;
            public static String[] idkecamatan, iddesa, datakecamatan, datadesa;
            DefaultTableModel tabelModel;

    /**
     * Creates new form FUtama
     */
    public FUtama() {
        initComponents();
        tampil_data();
        setLocationRelativeTo(null);
        setKecamatan();
        waktu();
        lebarKolom();
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
    }
    
    
//    private com.mysql.jdbc.Connection getConn(){
//        connection=null;
//        pesankoneksi="";
//        
//        try {
//            Class.forName(Driver);
//        } catch (ClassNotFoundException ex) {
//            pesankoneksi="Driver tidak ditemukan";
//        }if (pesankoneksi.equals("")) {
//            try{
//            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(database+"?user="+user+"&password"+password+"");
//            }catch (SQLException ex) {
//                pesankoneksi = "Koneksi ke" +database+ "gagal!\n"+ex;
//            }
//        }
//        return connection;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prakerja");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Form Data");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(545, 545, 545)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnkembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnedit)
                                .addGap(18, 18, 18)
                                .addComponent(btnhapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnbatal)
                                .addGap(494, 494, 494))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(35, 35, 35))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
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
                                    .addComponent(nama)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dusun, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kampung, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combodes, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combokec, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(provinsi, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(email)
                                        .addComponent(comboagama, 0, 130, Short.MAX_VALUE)
                                        .addComponent(rt)
                                        .addComponent(rw))
                                    .addComponent(no_wa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel24)
                            .addComponent(jLabel6)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(no_rek)
                            .addComponent(tps)
                            .addComponent(penanggung)
                            .addComponent(tgl_input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combonamabank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(79, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsimpan)
                            .addComponent(btnedit)
                            .addComponent(btnhapus)
                            .addComponent(btnbatal)
                            .addComponent(btnkembali)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel26))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(provinsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(6, 6, 6)
                                .addComponent(combokec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(combodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17)
                                            .addComponent(warga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(no_kk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel21)
                                                    .addComponent(comboagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(tempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(combonamabank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(no_rek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(penanggung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(umur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel19)
                                    .addComponent(dusun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnhitung)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7)
                                    .addComponent(no_wa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rblaki)
                                        .addComponent(rbperempuan)
                                        .addComponent(jLabel20)
                                        .addComponent(kampung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22)
                                        .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 191, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(FUtama.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

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
                    + "email, nama_bank, no_rek, tps, penanggung, admin, jenis_pelatihan, tgl_input) values('"
                    +nik.getText()+"','"
                    +nama.getText().replace("'","''")+"','"
                    +no_kk.getText()+"','"
                    +tempat.getText()+"','"
                    +tglKel+"','"
                    +umur.getText()+"','"
                    +JenKel+"','"
                    +warga.getText()+"','"
                    +provinsi.getText()+"','"
                    +combokec.getSelectedItem()+"','"
                    +combodes.getSelectedItem()+"','"
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
                    +jenis.getSelectedItem()+"','"
                    +tglInput+"')";
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
        combokec.setSelectedItem(rs.getString(10));
        combodes.setSelectedItem(rs.getString(11));
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
        jenis.setSelectedItem(rs.getString(25));
        tgl_input.setDate(rs.getDate(26));
        
        JOptionPane.showMessageDialog(null,"Data : "
        + txtcari.getText() + " ditemukan, Apakah Anda Ingin Mengedit atau Menghapus?");
    }
} catch (Exception e){
JOptionPane.showMessageDialog(null, "Data tidak ada!");
            System.out.println(e.getMessage());
}
btncari.requestFocus();

    }//GEN-LAST:event_btncariActionPerformed

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
                     "', kecamatan = '" + combokec.getSelectedItem()+
                     "', desa = '" + combodes.getSelectedItem()+
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
//                     "', admin = '" + txtadmin.getText()+
                     "', jenis_pelatihan = '" + jenis.getSelectedItem()+
                     "', tgl_input = '" + tglInput +
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
        combokec.setSelectedItem("Pilih Kecamatan");
        combodes.setSelectedItem("Pilih Desa");
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

    private void combokecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokecActionPerformed
        // TODO add your handling code here:
        int datapilih = combokec.getSelectedIndex();
        try {
          String id = String.valueOf(idkecamatan[datapilih]);
            setDesa(id);
        }catch(Exception ex){}
    }//GEN-LAST:event_combokecActionPerformed

    private void combodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combodesActionPerformed
        // TODO add your handling code here:
//        int datapilih = combodes.getSelectedIndex();
//        try {
//          String id = String.valueOf(iddesa[datapilih]);
//            setDesa(id);
//        }catch(Exception ex){}
    }//GEN-LAST:event_combodesActionPerformed

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

    private void namaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyReleased
        // TODO add your handling code here:
        int position = nama.getCaretPosition();
        nama.setText(nama.getText().toUpperCase());
        nama.setCaretPosition(position);
    }//GEN-LAST:event_namaKeyReleased

    private void tempatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tempatKeyReleased
        // TODO add your handling code here:
        int position = tempat.getCaretPosition();
        tempat.setText(tempat.getText().toUpperCase());
        tempat.setCaretPosition(position);
    }//GEN-LAST:event_tempatKeyReleased

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

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_emailKeyReleased

    private void tpsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpsKeyReleased
        // TODO add your handling code here:
        int position = tps.getCaretPosition();
        tps.setText(tps.getText().toUpperCase());
        tps.setCaretPosition(position);
    }//GEN-LAST:event_tpsKeyReleased

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        // TODO add your handling code here:
        int position = txtcari.getCaretPosition();
        txtcari.setText(txtcari.getText().toUpperCase());
        txtcari.setCaretPosition(position);
    }//GEN-LAST:event_txtcariKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tampil_data();
        lebarKolom();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void penanggungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penanggungKeyReleased
        // TODO add your handling code here:int position = email.getCaretPosition();
        int position = penanggung.getCaretPosition();
        penanggung.setText(penanggung.getText().toUpperCase());
        penanggung.setCaretPosition(position);
    }//GEN-LAST:event_penanggungKeyReleased

    private void no_telpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_telpKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_no_telpKeyReleased

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
        combokec.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString());
        combodes.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString());
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
        jenis.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 25).toString());
        Date tglinput = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRowIndex, 26).toString());
        tgl_input.setDate(tglinput);
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

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void txtmasterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmasterKeyReleased
        // TODO add your handling code here:
        int posisi = txtmaster.getCaretPosition();
        txtmaster.setText(txtmaster.getText().toUpperCase());
        txtmaster.setCaretPosition(posisi);
    }//GEN-LAST:event_txtmasterKeyReleased

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

    private void txtadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadminActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        // TODO add your handling code here:
        new FSearch().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void combokecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combokecKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combokecKeyReleased

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
        combokec.setSelectedItem("Pilih Kecamatan");
        combodes.setSelectedItem("Pilih Desa");
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
        jenis.setSelectedItem("");
        Date tanggal_input = new Date();
        tgl_input.setDate(tanggal_input);
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
            tabel.addColumn("Jenis Pelatiah");
            tabel.addColumn("Tanggal Input");
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
                    rs.getString(26)
                });
                jTable1.setModel(tabel);
                jTable1.enable(true);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "gagal tampil \n"+e);
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
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static final javax.swing.JComboBox<String> jenis = new javax.swing.JComboBox<>();
    public static final javax.swing.JTextField kampung = new javax.swing.JTextField();
    public static final javax.swing.JTextField nama = new javax.swing.JTextField();
    public static final javax.swing.JTextField nik = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_kk = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_rek = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_telp = new javax.swing.JTextField();
    public static final javax.swing.JTextField no_wa = new javax.swing.JTextField();
    public static final javax.swing.JTextField penanggung = new javax.swing.JTextField();
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
