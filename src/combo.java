
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import data.koneksi;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Angga
 */
public class combo extends javax.swing.JFrame {
    private static final String Driver="com.mysql.jdbc.Driver",
            database = "jdbc:mysql://localhost:3306/project_angga",
            user="root",
            password="";
            private Connection connection;
            private String pesankoneksi;
            private String[] idkecamatan, iddesa, datakecamatan, datadesa;
            
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text,
                AttributeSet attr) throws BadLocationException {

                fb.insertString(offset, text.toUpperCase(), attr);
            }
//            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
//        str = str.toUpperCase();
//        if (str.matches("[A-Z]*")) {
//            super.insertString(offs, str, a);
//        } else {
//            // data ditolak
//        }
//    }
    /**
     * Creates new form combo
     */
            
            
            
    public combo() {
        initComponents();
        setLocationRelativeTo(null);
        setKecamatan();
        tampil_data();
    }

    
    private Connection getConn(){
        connection=null;
        pesankoneksi="";
        
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException ex) {
            pesankoneksi="Driver tidak ditemukan";
        }if (pesankoneksi.equals("")) {
            try{
            connection = (Connection) DriverManager.getConnection(database+"?user="+user+"&password"+password+"");
            }catch (SQLException ex) {
                pesankoneksi = "Koneksi ke" +database+ "gagal!\n"+ex;
            }
        }
        return connection;
    }
    
    public void tampil_data(){
         DefaultTableModel tabel = new DefaultTableModel();
            tabel.addColumn("No");
            tabel.addColumn("Nama");
            tabel.addColumn("No KTP");
            tabel.addColumn("No KK");
            tabel.addColumn("Tempat");
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
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
                jTable1.setModel(tabel);
                jTable1.enable(true);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "gagal tampil \n"+e);
        }
    }
    
    private void setKecamatan(){
        combokec.removeAllItems();
        combokec.addItem("Pilih Kecamatan");
        Connection koneksi;
        if ((koneksi = getConn()) !=null) {
            try {
                String sql = "SELECT * FROM kecamatan";
                java.sql.Statement st=koneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
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
                st.close();
                koneksi.close();
            }catch(Exception ex){
                System.out.println("error\n"+ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, pesankoneksi);
        }
    }
    
    private void setDesa(String idkec){
        combodes.removeAllItems();
        combodes.addItem("Pilih Desa");
        Connection koneksi;
        if ((koneksi = getConn()) !=null) {
            try {
                String sql = "SELECT * FROM desa where id_kecamatan='"+idkec+"'";
                java.sql.Statement st=koneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
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
                        iddesa[i] = String.valueOf(rs.getString("id_desa"));
                        datadesa[i] = String.valueOf(rs.getString("nama"));
                        combodes.addItem(datadesa[i]);
                        i++;
                    } while (rs.next());
                }
                rs.close();
                st.close();
                koneksi.close();
            }catch(Exception ex){
                System.out.println("error\n"+ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, pesankoneksi);
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

        combokec = new javax.swing.JComboBox<>();
        combodes = new javax.swing.JComboBox<>();
        combort = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combokec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kecamatan" }));
        combokec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokecActionPerformed(evt);
            }
        });

        combodes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Desa" }));
        combodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combodesActionPerformed(evt);
            }
        });

        combort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Rt/Rw" }));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combokec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(342, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(combokec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(combo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(combo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(combo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(combo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new combo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combodes;
    private javax.swing.JComboBox<String> combokec;
    private javax.swing.JComboBox<String> combort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
