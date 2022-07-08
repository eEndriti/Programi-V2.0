/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programi;

import com.itextpdf.text.PageSize;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import static com.itextpdf.text.Font.FontFamily.HELVETICA;
import static com.itextpdf.text.Font.FontFamily.TIMES_ROMAN;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import static programi.pdfFatura.headerColor;
import static programi.pdfFatura.nrIdentifikues;
import static programi.pdfFatura.tableWidth;

/**
 *
 * @author BERDYNA
 */
public class Stoku extends javax.swing.JFrame {
    private int totaliProdukteve = 0;
    /**
     * Creates new form Stoku
     */
    public Stoku() {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
        table();
        sasiaProdukteve();
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
                    dt.fireTableDataChanged();
                }else if (pershkrimi.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,2));
                }else if (furnitori.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,6));
                }else if (fatura.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,7));
                }else if (data.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,8));
                }else if (kategoria.isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str,9));
                }else
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                sorter.setSortsOnUpdates(true);
            }
         }
      });
    }
    public void sasiaProdukteve(){
        
        try{
            Statement s = prg.con().createStatement();
            ResultSet rs = s.executeQuery("Select Count(*) from Produkti");
            while(rs.next()){
                totaliProdukteve = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        sasiaProdukteve.setText(totaliProdukteve+" Produkte");
    }
public void table(){
    TableColumnModel t = jTable1.getColumnModel();
    t.getColumn(0).setPreferredWidth(0);
    t.getColumn(2).setPreferredWidth(400);
    t.getColumn(3).setPreferredWidth(20);
    t.setColumnSelectionAllowed(false);
    try{
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            jTable1.getTableHeader().setResizingAllowed(true);
            JTableHeader h = jTable1.getTableHeader();
            h.setOpaque(false);
            h.setBackground(Color.red);
            h.setForeground(Color.DARK_GRAY);
           
            h.setFont(new Font("Arial", Font.BOLD, 18));
            dt.setRowCount(0);
            
            Statement s = prg.con().createStatement();
            ResultSet rs = s.executeQuery("select p.*, k.Emri from Produkti p, Kategoria k where p.KategoriaID = k.KategoriaID");
            
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(10)+" €");
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ndrysho = new javax.swing.JButton();
        hiqe = new javax.swing.JButton();
        alert1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sasiaProdukteve = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        printoStokin = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        produkti = new javax.swing.JRadioButton();
        pershkrimi = new javax.swing.JRadioButton();
        furnitori = new javax.swing.JRadioButton();
        fatura = new javax.swing.JRadioButton();
        kategoria = new javax.swing.JRadioButton();
        data = new javax.swing.JRadioButton();

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

        jButton1.setBackground(new java.awt.Color(255, 255, 241));
        jButton1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton1.setText("Shto Produktin");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 241));
        jButton3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton3.setText("Shto Kategori");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 255, 254));
        jTable1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Produkti", "Përshkrimi", "Sasia", "CmimiF", "CmimiS", "Furnitori", "Fatura", "Data", "Kategoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(10);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

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

        alert1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        alert1.setForeground(new java.awt.Color(255, 51, 0));

        searchField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        printoStokin.setBackground(new java.awt.Color(255, 255, 241));
        printoStokin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        printoStokin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programi/data/print.png"))); // NOI18N
        printoStokin.setBorder(null);
        printoStokin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printoStokin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printoStokinMousePressed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 241));
        jButton4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton4.setText("Shto Faturë");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

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

        kategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kategoria.setText("Kategoria");
        kategoria.setContentAreaFilled(false);

        data.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        data.setText("Data");
        data.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(sasiaProdukteve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                        .addComponent(kategoria))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(ndrysho, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(hiqe, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)
                            .addComponent(alert1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(printoStokin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produkti)
                    .addComponent(pershkrimi)
                    .addComponent(furnitori)
                    .addComponent(fatura)
                    .addComponent(kategoria)
                    .addComponent(data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ndrysho, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(hiqe, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(alert1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printoStokin, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sasiaProdukteve, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void ndryshoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ndryshoMousePressed
         if (jTable1.getSelectionModel().isSelectionEmpty()) {
            alert1.setText("Nje Rresht Duhet Te Selektohet!");

        }else{
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             int row = jTable1.getSelectedRow();
             int modelRow = jTable1.convertRowIndexToModel(row);            
             String value = String.valueOf(model.getValueAt(modelRow, 0));
            try {
                int v = Integer.parseInt(value);
                NdryshoStokun n = new NdryshoStokun();
                NdryshoStokun.id = v;

                n.setVisible(true);
                n.data();
                
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_ndryshoMousePressed

    private void hiqeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hiqeMousePressed
        
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            alert1.setText("Nje Rresht Duhet Te Selektohet!");

        }else{
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             int row = jTable1.getSelectedRow();
             int modelRow = jTable1.convertRowIndexToModel(row);            
             String value = String.valueOf(model.getValueAt(modelRow, 0));
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
        System.out.println(id);
        s.execute("Delete from Produkti where ProduktiID = "+id);
        alert1.setForeground(Color.BLUE);
        alert1.setText("Sukses!");
        table();
    }
    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        StokuShto s = new StokuShto();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
       ShtoKategori s = new ShtoKategori();
       s.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton3MousePressed

    private void printoStokinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printoStokinMousePressed
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        int nRow = dt.getRowCount(),nCol = dt.getColumnCount();
        try{
            String fileName = Login.folderiFaturave+"//Stoki "+date()+".pdf";
            Document doc = new Document(PageSize.A4) {};
             PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            com.itextpdf.text.Font cellFont = new com.itextpdf.text.Font(HELVETICA, 9, com.itextpdf.text.Font.NORMAL);
            com.itextpdf.text.Font headerFont = new com.itextpdf.text.Font(TIMES_ROMAN, 11, com.itextpdf.text.Font.BOLD);
            Paragraph para = new Paragraph("Evidenca e Stokit me daten:"+date());
            para.setSpacingAfter(25f);
            doc.add(para);
            
            PdfPTable tb = new PdfPTable(10);
            tb.setWidths(new int[]{2, 3, 4,2,2,2,3,3,3,3});
            String[] tableHeaders = {"ID","Produkti","Pershkrimi","Sasia","CmimiF","CmimiS","Furnitori","Fatura","Data","Kategoria"};
          
            for (int i = 0; i < 10; i++) {
                PdfPCell c1 = new PdfPCell(new Phrase(tableHeaders[i],headerFont));
                c1.setBackgroundColor(headerColor);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                tb.addCell(c1);
            }
            
            
            for (int i = 1; i <= nRow; i++) {
                 for (int j = 0; j < 10; j++) {
                     i--;
                    String a = String.valueOf(dt.getValueAt(i, j));
                    tb.addCell(new PdfPCell(new Phrase(a,cellFont)));
                    i++;
                }                       
            }    
            Paragraph para2 = new Paragraph("Totali i Produkteve ne Stok eshte:"+totaliProdukteve);
            para2.setSpacingBefore(25f);
            
            tb.setTotalWidth(tableWidth);
            tb.setLockedWidth(true);    
           
            doc.add(tb);
            doc.add(para2);
            doc.close();
            Desktop.getDesktop().open(new File(fileName));
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_printoStokinMousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        regjistroFaturen r = new regjistroFaturen();
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4MousePressed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
       
    }//GEN-LAST:event_searchFieldKeyPressed
        public String date(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
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
            java.util.logging.Logger.getLogger(Stoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stoku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton data;
    private javax.swing.JRadioButton fatura;
    private javax.swing.JRadioButton furnitori;
    private javax.swing.JButton hiqe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton kategoria;
    private javax.swing.JButton ndrysho;
    private javax.swing.JRadioButton pershkrimi;
    private javax.swing.JButton printoStokin;
    private javax.swing.JRadioButton produkti;
    private javax.swing.JLabel sasiaProdukteve;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
