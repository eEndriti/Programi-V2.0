/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programi;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import static com.itextpdf.text.Font.FontFamily.HELVETICA;
import static com.itextpdf.text.Font.FontFamily.TIMES_ROMAN;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import com.itextpdf.text.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.sql.*;
import java.util.Vector;




/**
 *
 * @author Pc
 */
public class pdfFatura {
    public static float tableWidth = 550f;
    static BaseColor headerColor = new BaseColor(233,233,233);
    public static String klienti,lloji,pagesa,adresa,nrBiznesit,nrFiskal,nrTelefonit,data,nrIdentifikues,komenti;
    public static int rreshtat = 0;
    
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {

      shkruaj();
    }
    
    public static void shkruaj(){
         try{
              String fileName = null;
             if (lloji.equals("Faturë")) {
                  fileName = Login.folderiFaturave+"\\"+klienti+" #"+nrIdentifikues+".pdf";
             }else if(lloji.equals("Ofertë")){
                  fileName = Login.folderiOfertave+"\\"+klienti+" #"+nrIdentifikues+".pdf";
             }
            Document doc  = new Document(PageSize.A4);
            
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            Font cellFont = new Font(HELVETICA, 9, Font.NORMAL);
            Font headerFont = new Font(TIMES_ROMAN, 12, Font.BOLD);
            //Paragraph para = new Paragraph("This is a paragraph");
            //doc.add(para);
            shtoTeDhenatFirmes(doc);
            shtoTeDhenatKlientit(doc);
            PdfPTable tb = new PdfPTable(9);
           //shtohet header i tabeles
            tb.setWidths(new int[]{1, 3, 6,2,2,3,3,3,3});
            String[] tableHeaders = {"Nr","Produkti","Pershkrimi","Sasia","Njesia","Cmimi pa TVSH","TVSH %","Cmimi me TVSH","Vlera me TVSH"};
          
            for (int i = 0; i < 9; i++) {
                PdfPCell c1 = new PdfPCell(new Phrase(tableHeaders[i],headerFont));
                c1.setBackgroundColor(headerColor);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                tb.addCell(c1);
            }
            
            // shtohen te dhenat ne tabele
            double sum = 0,tmt = 0;
            DecimalFormat df = new DecimalFormat("0.00");
             df.format(sum);
             df.format(tmt);
            try{
                Statement s = prg.con().createStatement();
                ResultSet rs = s.executeQuery("Select d.nrRendor,d.produkti,d.pershkrimi,d.sasia,d.njesia,d.cmimiPerNjesi,d.tvsh,d.cmimiMeTvsh,d.vleraMeTvsh from daljetFaturore d,fatura f where d.nrIdentifikues = '"+nrIdentifikues+"'\n" +
                                              "group by d.nrRendor,d.produkti,d.pershkrimi,d.sasia,d.njesia,d.cmimiPerNjesi,d.tvsh,d.cmimiMeTvsh,d.vleraMeTvsh");              
                while(rs.next()){
                    for (int i = 1; i <= 9; i++) {
                        
                            tb.addCell(new PdfPCell(new Phrase(rs.getString(i),cellFont)));
                        
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            tb.setSpacingAfter(15f); 
            
            tb.setTotalWidth(tableWidth);
            tb.setLockedWidth(true);    
           
            doc.add(tb);
           
            llogaritjaTotalit(doc);
            komenti(doc);
            nenshkrimi(doc);
            doc.close();
            Desktop.getDesktop().open(new File(fileName));
            
            
        }catch(Exception e){
            System.out.println("Errorrr Creating PDF!");
            e.printStackTrace();
        }
    }
    public static void shtoTeDhenatFirmes(Document doc) throws DocumentException, IOException{
        float col = 280f;
        float columnWidth[] = {480,360};
        PdfPTable tb = new PdfPTable(columnWidth);
        tb.setSpacingAfter(5f);
        // shto logon e firmes
        Image img = Image.getInstance("C:\\Users\\Pc\\Documents\\NetBeansProjects\\Programi\\Programi-main\\Programi2\\src\\programi\\data\\blogo-removebg-preview (1).png");
        PdfPCell c1 = new PdfPCell(img);
        c1.setBorder(Rectangle.BOTTOM);
        
        tb.addCell(c1);
        
        PdfPCell c2 = new PdfPCell(new Phrase(" Emri: "+prg.emriFirmes+" \n Nr.Biznesit: "+prg.nrBiznesit+" \n Nr.Fiskal: "+prg.nrFiskal+" \n Adresa: "+prg.adresa+" \n Nr.Telefonit: "+prg.nrTelefonit));
        c2.setBorder(Rectangle.BOTTOM);
        tb.addCell(c2);
          
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        doc.add(tb);
    }
    public static void shtoTeDhenatKlientit(Document doc) throws DocumentException{
        Paragraph p = new Paragraph("Te Dhenat e Klientit:");
        p.setPaddingTop(10f);
        p.setSpacingAfter(3f);
        float col = 120f;
        float columnWidth[] = {680f,120f,170f};
        PdfPTable tb = new PdfPTable(columnWidth);
        
        PdfPCell c1 = new PdfPCell(new Phrase("Emri:              "+klienti+" \nNr i Biznesit:  "+nrBiznesit+" \nAdresa:          "+adresa+" \nNr Fiskal:       "+nrFiskal+" \nNr i Telefonit: "+nrTelefonit));
        c1.setBorder(Rectangle.BOTTOM);
        c1.setPadding(10f);
        tb.addCell(c1);
        
        String l = null;
        if (lloji.equals("Faturë")) {
            l = "Nr.Faturës:";
        }else if(lloji.equals("Ofertë")){
            l = "Nr.Ofertës:";
        }
        
        PdfPCell c2 = new PdfPCell(new Phrase(" Data: \n "+l));
        c2.setBorder(Rectangle.BOTTOM);
        tb.addCell(c2);
        
        PdfPCell c3 = new PdfPCell(new Phrase( data+" \n "+nrIdentifikues));
        c3.setBorder(Rectangle.BOTTOM);
        tb.addCell(c3);
        
        tb.setSpacingAfter(10f);
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        doc.add(p);
        doc.add(tb);
        
    }
    public static void llogaritjaTotalit(Document doc) throws DocumentException{  //1 ; Hp ; I5Gen6/8GbRAM/255Gb SSD ; 1  ; c ; 220.00 € ; 18% ; 259.6 ; 259.6 € ;
        double totaliPaTvsh = 0, tvsh = 0,totaliMeTvsh = 0;
        String pagesa = null;
        
        try{
            Statement s = prg.con().createStatement();
            ResultSet rs = s.executeQuery("Select cmimiPaTvsh,Tvsh,cmimiMeTvsh,pagesa from fatura where nrIdentifikues = '"+nrIdentifikues+"'");
            while(rs.next()){
                totaliPaTvsh = rs.getDouble(1);
                tvsh = rs.getDouble(2);
                totaliMeTvsh = rs.getDouble(3);
                pagesa = rs.getString(4);
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        shkruajTotalin(totaliPaTvsh,tvsh,totaliMeTvsh,pagesa,doc);
    }
    public static void shkruajTotalin(double totaliPaTvsh,double tvsh,double totaliMeTvsh,String pagesa,Document doc) throws DocumentException{
        float columnWidth[] = {400f,300f,300f};
        PdfPTable tb = new PdfPTable(columnWidth);
        Vector v = new Vector();
        if (pagesa.trim().equals("Cash")) {
            PdfPCell c1 = new PdfPCell(new Phrase(" Mënyra e Pageses: "+pagesa));
            c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            c1.setPadding(10f);
            tb.addCell(c1);
        }else if(pagesa.trim().equals("Bankarë")){
            try{
                Statement s = prg.con().createStatement();
                ResultSet rs = s.executeQuery("Select Xhirollogaria from xhirot where userId = '"+ prg.idPerdoruesi+"'");
                while(rs.next()){
                    v.add(rs.getString(1));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }                                 
            
            
            PdfPCell c1 = new PdfPCell(new Phrase(" Mënyra e Pageses: Bankarë"+xhirot(v)));
            c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            c1.setPadding(15f);
            tb.addCell(c1);
            
           
        }
        
        PdfPCell c2 = new PdfPCell(new Phrase(""));
        c2.setBorder(Rectangle.BOTTOM);
        c2.setPaddingLeft(10f);
        tb.addCell(c2);
        
        PdfPCell c3 = new PdfPCell(new Phrase("Totali Pa TVSH: "+totaliPaTvsh+"\nTotali i TVSH: "+tvsh+"\nTotali Me TVSH: "+totaliMeTvsh));
        c3.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
        //c2.setPaddingLeft(10f);
        c3.setPadding(10f);
        tb.addCell(c3);                               
               
        
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        doc.add(tb);
    }
    public static String xhirot(Vector v){
        String a = " ";
        for (int i = 0; i < v.size(); i++) {
            a += "\n "+v.get(i);
        }
        return a;
    }
    public static void komenti(Document doc) throws DocumentException{
        float columnWidth[] = {550f,450f};
        PdfPTable tb = new PdfPTable(columnWidth);
        tb.setSpacingBefore(10f);
        
        PdfPCell c1 = new PdfPCell(new Phrase(komenti));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setPadding(10f);
        tb.addCell(c1);
        
        PdfPCell c2 = new PdfPCell(new Phrase(""));        
        c2.setBorder(Rectangle.NO_BORDER);
        tb.addCell(c2);
        
        
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        doc.add(tb);
    }
    public static void nenshkrimi(Document doc) throws DocumentException{
        
        Font cellFont = new Font(HELVETICA, 5, Font.NORMAL);
        
        float columnWidth[] = {200f,200f,200f,200f,200f};
        PdfPTable tb = new PdfPTable(columnWidth);
        tb.setSpacingBefore(rreshtat());
        
        PdfPCell c1 = new PdfPCell(new Phrase("Dorzoi",cellFont));        
        c1.setBorder(Rectangle.TOP);
        tb.addCell(c1);
        
        PdfPCell c2 = new PdfPCell(new Phrase(""));        
        c2.setBorder(Rectangle.NO_BORDER);
        tb.addCell(c2);
        
        PdfPCell c3 = new PdfPCell(new Phrase(""));        
        c3.setBorder(Rectangle.NO_BORDER);
        tb.addCell(c3);
        
        PdfPCell c33 = new PdfPCell(new Phrase(""));        
        c33.setBorder(Rectangle.NO_BORDER);
        tb.addCell(c33);
        
        PdfPCell c4 = new PdfPCell(new Phrase("Pranoi",cellFont));        
        c4.setBorder(Rectangle.TOP);
        tb.addCell(c4);
        
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        doc.add(tb);
    }
    
    public static float rreshtat(){
        float nr = 0;
        if (rreshtat < 5) {
            nr = 300f;
        }else if(rreshtat < 10){
            nr = 200f;
        }else if(rreshtat < 15){
            nr = 150;
        }else if(rreshtat < 20){
            nr = 75;
        }
        return nr;
    }
}
