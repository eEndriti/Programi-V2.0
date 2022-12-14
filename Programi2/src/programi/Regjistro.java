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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author Pc
 */
public class Regjistro extends javax.swing.JFrame {

    /**
     * Creates new form Regjistro
     */
    public Regjistro() {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
        buttonGroup1.add(f);
        buttonGroup1.add(k);
        tabela();
    }
    public void tabela(){
        TableColumnModel t = jTable1.getColumnModel();
    t.getColumn(0).setPreferredWidth(0);
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
            ResultSet rs = s.executeQuery("select * from Klienti");
            
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(7));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
               
                
                dt.addRow(v);
            }
            
        }catch(Exception e){
            
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emri = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        f = new javax.swing.JRadioButton();
        k = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        nrb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nrf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nrt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        alert2 = new javax.swing.JLabel();
        alert3 = new javax.swing.JLabel();
        alert4 = new javax.swing.JLabel();
        alert5 = new javax.swing.JLabel();
        alert6 = new javax.swing.JLabel();
        alert1 = new javax.swing.JLabel();
        hiqe = new javax.swing.JButton();
        ndrysho = new javax.swing.JButton();
        alert = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(119, 236, 145));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Emri:");

        emri.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        emri.setToolTipText("");

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

        f.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        f.setText("Furnitor");
        f.setContentAreaFilled(false);
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        k.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        k.setText("Klient");
        k.setContentAreaFilled(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("NrBiznesit:");

        nrb.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        nrb.setToolTipText("");
        nrb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nrbKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Adresa:");

        ad.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        ad.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("NrFiskal:");

        nrf.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        nrf.setToolTipText("");
        nrf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nrfKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("NrTelefonit:");

        nrt.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        nrt.setToolTipText("");
        nrt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nrtKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Regjistro");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 255, 254));
        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Emri", "Lloji", "Nr i Biznesit", "Adresa", "NrFiskal", "NrTelefonit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setToolTipText("");

        alert2.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert2.setForeground(new java.awt.Color(255, 51, 0));
        alert2.setToolTipText("");

        alert3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert3.setForeground(new java.awt.Color(255, 51, 0));
        alert3.setToolTipText("");

        alert4.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert4.setForeground(new java.awt.Color(255, 51, 0));
        alert4.setToolTipText("");

        alert5.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert5.setForeground(new java.awt.Color(255, 51, 0));
        alert5.setToolTipText("");

        alert6.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert6.setForeground(new java.awt.Color(255, 51, 0));
        alert6.setToolTipText("");

        alert1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        alert1.setForeground(new java.awt.Color(255, 51, 0));
        alert1.setToolTipText("");

        hiqe.setBackground(new java.awt.Color(255, 255, 241));
        hiqe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hiqe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programi/data/x.png"))); // NOI18N
        hiqe.setBorder(null);
        hiqe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hiqe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hiqeMousePressed(evt);
            }
        });

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

        alert.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nrb, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nrf, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nrt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alert3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alert4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alert5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alert6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(k))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emri, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alert2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alert1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ndrysho, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hiqe, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(alert1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emri, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(f)
                                    .addComponent(k)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(alert2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nrb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(alert3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(alert4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nrf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alert5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alert6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nrt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ndrysho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(hiqe, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        Fillimi f = new Fillimi();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2MousePressed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        check();
    }//GEN-LAST:event_jButton1MousePressed

    private void hiqeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hiqeMousePressed
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            alert.setText("Nje Rresht Duhet Te Selektohet!");

        }else{
            int row = jTable1.getSelectedRow();
            String value = jTable1.getModel().getValueAt(row, 0).toString();
            try {
                delete(value);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_hiqeMousePressed
    public void delete(String v) throws SQLException{
        int id = Integer.parseInt(v);
        
        Statement s = prg.con().createStatement();
        
        s.execute("Delete from Klienti where KlientiID = "+id);
        alert.setForeground(Color.BLUE);
        alert.setText("Sukses!");
        tabela();
    }
    private void ndryshoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ndryshoMousePressed
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            alert.setText("Nje Rresht Duhet Te Selektohet!");

        }else{
            int row = jTable1.getSelectedRow();
            String value = jTable1.getModel().getValueAt(row, 0).toString();
            try {
                int v = Integer.parseInt(value);
                NdryshoRegjister.id = v;
                NdryshoRegjister n = new NdryshoRegjister();           
                n.setVisible(true);
                n.data();

                dispose();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_ndryshoMousePressed

    private void nrbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nrbKeyTyped
        Programi.numberCheck(evt);
    }//GEN-LAST:event_nrbKeyTyped

    private void nrfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nrfKeyTyped
        Programi.numberCheck(evt);
    }//GEN-LAST:event_nrfKeyTyped

    private void nrtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nrtKeyTyped
        Programi.numberCheck(evt);
    }//GEN-LAST:event_nrtKeyTyped
    public void check(){
        alert1.setText(" ");
        alert2.setText(" ");
        alert3.setText(" ");
        alert4.setText(" ");
        alert5.setText(" ");
        alert6.setText(" ");
        
        if (emri.getText() == null || emri.getText().trim().isEmpty()) {
            alert1.setText("!");
            return;
        }
        if (buttonGroup1.getSelection() == null) {
            alert2.setText("!");
            return;
        }
        if (nrb.getText() == null || nrb.getText().trim().isEmpty()) {
            alert3.setText("!");
            return;
        }
        if (ad.getText() == null || ad.getText().trim().isEmpty()) {
            alert4.setText("!");
            return;
        }
        if (nrf.getText() == null || nrf.getText().trim().isEmpty()) {
            alert5.setText("!");
            return;
        }
        if (nrt.getText() == null || nrt.getText().trim().isEmpty()) {
            alert6.setText("!");
            return;
        }
        
        Regjistro();
    }
    public void Regjistro(){
        String em = emri.getText();
        String nrbiznesit = nrb.getText();
        String adresa = ad.getText();
        String nrFiskal = nrf.getText();
        String nrTelefonit = nrt.getText();
        String roli = null;
        
        if (f.isSelected()) {
            roli = "Furnitor";
        }else
            roli = "Klient";
        
        try{
            Statement s = prg.con().createStatement();
            s.execute("Insert into Klienti (Emri,Roli,NrBiznesit,Adresa,NrFiskal,NrTelefonit) values ('"+em+"','"+roli+"','"+nrbiznesit+"','"+adresa+"','"+nrFiskal+"','"+nrTelefonit+"')");
            alert.setText("Sukses!");
            alert.setForeground(Color.BLUE);
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
            java.util.logging.Logger.getLogger(Regjistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Regjistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Regjistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Regjistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Regjistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad;
    private javax.swing.JLabel alert;
    private javax.swing.JLabel alert1;
    private javax.swing.JLabel alert2;
    private javax.swing.JLabel alert3;
    private javax.swing.JLabel alert4;
    private javax.swing.JLabel alert5;
    private javax.swing.JLabel alert6;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField emri;
    private javax.swing.JRadioButton f;
    private javax.swing.JButton hiqe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton k;
    private javax.swing.JButton ndrysho;
    private javax.swing.JTextField nrb;
    private javax.swing.JTextField nrf;
    private javax.swing.JTextField nrt;
    // End of variables declaration//GEN-END:variables
}
