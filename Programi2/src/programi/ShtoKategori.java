/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programi;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author Pc
 */
public class ShtoKategori extends javax.swing.JFrame {
    private int idPerNdryshim;
    private boolean procesiNdryshimit;
    /**
     * Creates new form ShtoKategori
     */
    public ShtoKategori() {
        initComponents();
        tabela();
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));

    }
    public void tabela(){
        TableColumnModel t = jTable1.getColumnModel();
        t.getColumn(0).setPreferredWidth(0);
        t.getColumn(1).setPreferredWidth(100);
        t.getColumn(2).setPreferredWidth(20);
        t.getColumn(3).setPreferredWidth(20);
        t.setColumnSelectionAllowed(false);
        try{
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            jTable1.getTableHeader().setResizingAllowed(true);
            JTableHeader h = jTable1.getTableHeader();
            h.setForeground(Color.DARK_GRAY);
            h.setBackground(new Color(255,255,241));
            h.setFont(new Font("Arial", Font.BOLD, 16));
            dt.setRowCount(0);
            
            Statement s = prg.con().createStatement();
            ResultSet rs = s.executeQuery("Select * from Kategoria");
            Statement s1 = prg.con().createStatement();
            while(rs.next()){
                
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                ResultSet rs1 = s1.executeQuery("Select count(*) from Produkti where KategoriaID = '"+rs.getString(1)+"'");
                while(rs1.next()){
                    v.add(rs1.getString(1));
                }
                
                dt.addRow(v);
            }
            
        }catch(Exception e){
            e.printStackTrace();
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        kategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tvshField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        alert2 = new javax.swing.JLabel();
        alert1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        alert4 = new javax.swing.JLabel();
        ndrysho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(119, 236, 145));

        jButton2.setBackground(new java.awt.Color(255, 255, 241));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programi/data/arrow.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Kategoria:");

        kategoria.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        kategoria.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("TVSH:");

        tvshField.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        tvshField.setToolTipText("");
        tvshField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tvshFieldKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Shto Kategori");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        alert2.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert2.setForeground(new java.awt.Color(255, 51, 0));

        alert1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert1.setForeground(new java.awt.Color(255, 51, 0));

        jTable1.setBackground(new java.awt.Color(255, 255, 254));
        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Emri", "TVSH", "Sasia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusCycleRoot(true);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(10);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton5.setBackground(new java.awt.Color(255, 255, 241));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programi/data/x.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));

        alert4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        alert4.setForeground(new java.awt.Color(255, 51, 0));

        ndrysho.setBackground(new java.awt.Color(255, 255, 241));
        ndrysho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ndrysho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programi/data/1064 (1).png"))); // NOI18N
        ndrysho.setBorder(null);
        ndrysho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ndrysho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ndryshoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(kategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tvshField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(alert1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addComponent(jLabel1))
                                .addGap(72, 72, 72)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(alert4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(ndrysho, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alert2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(kategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tvshField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(alert1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alert2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ndrysho, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(alert4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        Stoku s = new Stoku();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        check();
    }//GEN-LAST:event_jButton1MousePressed

    private void tvshFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tvshFieldKeyTyped
        Programi.numberCheck(evt);
    }//GEN-LAST:event_tvshFieldKeyTyped

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
         if (jTable1.getSelectionModel().isSelectionEmpty()) {
            alert4.setText("Nje Rresht Duhet Te Selektohet!");

        }else{
            int row = jTable1.getSelectedRow();
            String value = jTable1.getModel().getValueAt(row, 0).toString();
            try {
                delete(value);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ndryshoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ndryshoMousePressed
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            alert1.setText("Nje Rresht Duhet Te Selektohet!");

        }else{
            int row = jTable1.getSelectedRow();
            String id = jTable1.getModel().getValueAt(row, 0).toString();
            String emri = jTable1.getModel().getValueAt(row, 1).toString();
            String tvsh = jTable1.getModel().getValueAt(row, 2).toString();
            
                 idPerNdryshim = Integer.parseInt(id);
                 kategoria.setText(emri);
                 tvshField.setText(tvsh);
                 procesiNdryshimit = true;
                 jButton1.setText("Ndrysho");
                 
        }
    }//GEN-LAST:event_ndryshoMousePressed
    public void delete(String v) throws SQLException{
        int id = Integer.parseInt(v);
        
        if (check(id)) {                      
            alert4.setText("Egzistojn Produkte me kete Kategori!");
        }else{
            Statement s = prg.con().createStatement();
            
            s.execute("Delete from Kategoria where KategoriaID = "+id);
            tabela();
            alert4.setForeground(Color.BLUE);
            alert4.setText("Sukses!");
        }
    }
    public boolean check(int id) throws SQLException{
        boolean v = false;
        Statement s = prg.con().createStatement();
        ResultSet rs = s.executeQuery("Select KategoriaID from Produkti where Produkti.KategoriaID = "+id);
        while(rs.next()){        
            v = true;
        }
        return v;
    }
    public void check(){
        alert1.setText(" ");
        alert2.setText(" ");
        
        if (kategoria.getText() == null || kategoria.getText().trim().isEmpty()) {
            alert1.setText("!");
            return;
        }
        if (tvshField.getText() == null || tvshField.getText().trim().isEmpty()) {
            alert2.setText("!");
            return;
        }
        if (procesiNdryshimit) {
            ndryshoK();
        }else
            shtoK();
    }
    public void shtoK(){
        alert4.setText("");
        String prd = kategoria.getText();
        int tv = Integer.parseInt(tvshField.getText());
        boolean bool = false;
        try{
            Statement s = prg.con().createStatement();
            ResultSet rs = s.executeQuery("Select Emri,Tvsh from Kategoria");
            while(rs.next()){
                if (prd.equals(rs.getString(1)) && tv == rs.getInt(2)) {
                    alert4.setText("Kjo Kategori Egziston!");
                    bool = true;
                }
            }
            if (!bool) {
            Statement s1 = prg.con().createStatement();
            s1.execute("Insert into Kategoria (Emri,Tvsh) values ('"+prd+"','"+tv+"')");
            tabela();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }
    public void ndryshoK(){
        String prd = kategoria.getText();
        int tv = Integer.parseInt(tvshField.getText());
        
        try{
            Statement s = prg.con().createStatement();
            s.execute("Update Kategoria set Emri = '"+prd+"',Tvsh = '"+tv+"' where KategoriaID = '"+idPerNdryshim+"'");
            procesiNdryshimit = false;
            jButton1.setText("Shto Kategori");
            alert4.setText("Kategoria u ndryshua!");
            tabela();
        }catch(SQLException e){
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(ShtoKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShtoKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShtoKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShtoKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShtoKategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert1;
    private javax.swing.JLabel alert2;
    private javax.swing.JLabel alert4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField kategoria;
    private javax.swing.JButton ndrysho;
    private javax.swing.JTextField tvshField;
    // End of variables declaration//GEN-END:variables
}
