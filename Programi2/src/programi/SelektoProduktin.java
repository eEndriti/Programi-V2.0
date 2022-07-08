/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programi;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Pc
 */
public class SelektoProduktin extends javax.swing.JFrame {
    public static String thirrja = null;
    /**
     * Creates new form SelektoProduktin
     */
    public SelektoProduktin() {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
        tabela();
        buttonGroup1.add(produkti);
        buttonGroup1.add(pershkrimi);
        buttonGroup1.add(fatura);
        buttonGroup1.add(furnitori);
        buttonGroup1.add(data);
        buttonGroup1.add(kategoria);
        search();
        
    }
    public void search(){
        
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        TableRowSorter sorter = new TableRowSorter<>(dt);
        jTable1.setRowSorter(sorter);
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent e) {
            search(searchField.getText());
         }
         @Override
         public void removeUpdate(DocumentEvent e) {
            search(searchField.getText());
         }
         @Override
         public void changedUpdate(DocumentEvent e) {
            search(searchField.getText());
         }
         public void search(String str) {
            if (str.length() == 0) {
               sorter.setRowFilter(null);
            } else {
                if (produkti.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,1));
                }else if (pershkrimi.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,2));
                }else if (furnitori.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,5));
                }else if (fatura.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,6));
                }else if (data.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,7));
                }else if (kategoria.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,8));
                }else
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
            }
         }
      });
    }
    public void tabela(){
        
    TableColumnModel t = jTable1.getColumnModel();
    t.getColumn(0).setPreferredWidth(0);
    t.getColumn(2).setPreferredWidth(400);
    t.getColumn(3).setPreferredWidth(20);
    t.getColumn(4).setPreferredWidth(0);
    t.getColumn(5).setPreferredWidth(0);
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
            ResultSet rs = s.executeQuery("select p.*, k.Emri from Produkti p, Kategoria k where p.KategoriaID = k.KategoriaID");
            
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5)+" €");
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(11));
                
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        selektoProduktin = new javax.swing.JButton();
        alert1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        produkti = new javax.swing.JRadioButton();
        pershkrimi = new javax.swing.JRadioButton();
        furnitori = new javax.swing.JRadioButton();
        fatura = new javax.swing.JRadioButton();
        data = new javax.swing.JRadioButton();
        kategoria = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(119, 236, 145));

        jTable1.setBackground(new java.awt.Color(255, 255, 254));
        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Produkti", "Përshkrimi", "Sasia", "Cmimi Shitjes", "Furnitori", "Fatura", "Data", "Kategoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        selektoProduktin.setBackground(new java.awt.Color(0, 102, 102));
        selektoProduktin.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        selektoProduktin.setForeground(new java.awt.Color(255, 255, 255));
        selektoProduktin.setText("Selekto Produktin");
        selektoProduktin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selektoProduktin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selektoProduktinMousePressed(evt);
            }
        });

        alert1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        alert1.setForeground(new java.awt.Color(255, 51, 0));

        searchField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        produkti.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        produkti.setText("Produkti");
        produkti.setContentAreaFilled(false);

        pershkrimi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pershkrimi.setText("Pershkrimi");
        pershkrimi.setContentAreaFilled(false);

        furnitori.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        furnitori.setText("Furnitori");
        furnitori.setContentAreaFilled(false);

        fatura.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fatura.setText("Fatura");
        fatura.setContentAreaFilled(false);

        data.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        data.setText("Data");
        data.setContentAreaFilled(false);

        kategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kategoria.setText("Kategoria");
        kategoria.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(produkti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pershkrimi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(furnitori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(alert1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                        .addComponent(selektoProduktin, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                .addComponent(selektoProduktin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(produkti)
                        .addComponent(pershkrimi)
                        .addComponent(furnitori)
                        .addComponent(fatura)
                        .addComponent(kategoria)
                        .addComponent(data))
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alert1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(64, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selektoProduktinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selektoProduktinMousePressed
                
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            alert1.setText("Nje Rresht Duhet Te Selektohet!");

        }else if(thirrja.equals("Faturo")){
           faturo();
        }else if(thirrja.equals("Shitje")){
            shitje();
        }
        
    }//GEN-LAST:event_selektoProduktinMousePressed
    public void faturo(){
        
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             int row = jTable1.getSelectedRow();
             int modelRow = jTable1.convertRowIndexToModel(row);        
            
            Faturo.produkti = jTable1.getModel().getValueAt(modelRow, 1).toString();
            Faturo.pershkrimi = jTable1.getModel().getValueAt(modelRow, 2).toString();
            Faturo.sasiaNeStok = jTable1.getModel().getValueAt(modelRow, 3).toString();
            Faturo.cmimi = jTable1.getModel().getValueAt(modelRow, 4).toString();           
            Faturo.idProduktit = Integer.parseInt(jTable1.getModel().getValueAt(modelRow, 0).toString());
            
            String kategoriaEProduktit = jTable1.getModel().getValueAt(modelRow, 8).toString();
            int tvsh = 0;
            try{ 
                Statement s = prg.con().createStatement();
                ResultSet rs = s.executeQuery("Select Tvsh from Kategoria where Emri = '"+kategoriaEProduktit+"'");
                while(rs.next()){
                    tvsh = rs.getInt(1);
                    System.out.println(tvsh);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            Faturo.tvsh = tvsh;
            alert1.setText(" ");
            
          Faturo.loadData();
            dispose();
            
    }
    public void shitje(){
        
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        int modelRow = jTable1.convertRowIndexToModel(row);     
        Shitje.idProduktit = Integer.parseInt(jTable1.getModel().getValueAt(modelRow, 0).toString());
        Shitje.produkti = String.valueOf(jTable1.getModel().getValueAt(modelRow, 1));
        Shitje.pershkrimi = jTable1.getModel().getValueAt(modelRow, 2).toString();
        String cm = String.valueOf(jTable1.getModel().getValueAt(modelRow, 4));
        String heqjaEuro = cm.substring(0,cm.length()-1);
        Shitje.cmimiShitjes = Double.parseDouble(heqjaEuro);
        Shitje.sasia = Integer.parseInt(jTable1.getModel().getValueAt(modelRow,3).toString());
        Shitje.shtoData();
        dispose();
    }
    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        
        dispose();
    }//GEN-LAST:event_jButton2MousePressed

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
            java.util.logging.Logger.getLogger(SelektoProduktin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelektoProduktin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelektoProduktin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelektoProduktin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelektoProduktin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton data;
    private javax.swing.JRadioButton fatura;
    private javax.swing.JRadioButton furnitori;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton kategoria;
    private javax.swing.JRadioButton pershkrimi;
    private javax.swing.JRadioButton produkti;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton selektoProduktin;
    // End of variables declaration//GEN-END:variables
}