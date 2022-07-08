/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programi;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import static com.itextpdf.text.Font.FontFamily.HELVETICA;
import static com.itextpdf.text.Font.FontFamily.TIMES_ROMAN;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import static programi.pdfFatura.headerColor;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static programi.pdfFatura.rreshtat;
import static programi.pdfFatura.tableWidth;
/**
 *
 * @author Pc
 */
public class pdfShitje {
    public static int periudhaKohore;
    public static double totaliGarancionit;
    public static String nrIdentifikues;
    public static float tableWidth = 550f;
    
    public static void main(String[]args){
        shkruaj();
    }
    public static void shkruaj(){
        try{
            
            String fileName = Login.folderiGarancioneve+"\\"+nrIdentifikues+".pdf";
            Document doc  = new Document(PageSize.A4);
            
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            Font cellFont = new Font(HELVETICA, 9, Font.NORMAL);
            Font titleFont = new Font(HELVETICA, 16, Font.BOLD);
            Font importantText = new Font(HELVETICA,13,Font.BOLD);
            Font SemiImportantText = new Font(HELVETICA,13,Font.NORMAL);
            Font headerFont = new Font(TIMES_ROMAN, 12, Font.BOLD);
            
            Paragraph para = new Paragraph("Fletë Garancioni "+nrIdentifikues,titleFont);
            para.setAlignment(Element.ALIGN_CENTER);            
            para.setSpacingAfter(45f);
            doc.add(para);
            
            Chunk teksti = new Chunk("Garancioni per produktin e blerë është ",SemiImportantText);
            Chunk boldi = new Chunk(periudhaKohore+" Muaj",importantText);
            Chunk teksti2 = new Chunk(" nga data qe klienti e pranon produktin nga ne.",SemiImportantText);
            Phrase phrase = new Phrase();
            phrase.add(teksti);
            phrase.add(boldi);
            phrase.add(teksti2);
            
            Paragraph para1 = new Paragraph();
            para1.add(phrase);
            para1.setAlignment(Element.ALIGN_JUSTIFIED);
            para1.setSpacingAfter(20f);
            
            doc.add(para1);
            
            
            Paragraph para2 = new Paragraph("Ne Garancion përfshihet mbulesa e plotë përpos nëse produkti është:",importantText);
            para2.setAlignment(Element.ALIGN_JUSTIFIED);
            para2.setSpacingAfter(15f);
            doc.add(para2);
            
            shkruajKushtet(doc);
            tabela(doc);
            totaliPageses(doc);
            footeri(doc);
            doc.close();
            Desktop.getDesktop().open(new File(fileName));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void shkruajKushtet(Document doc) throws DocumentException{
            
            Font t = new Font(HELVETICA,12,Font.NORMAL);
            Font t1 = new Font(HELVETICA,12,Font.BOLD);
            Font b = new Font(FontFamily.ZAPFDINGBATS,8);
            
            Paragraph para1 = new Paragraph("• I dëmtuar nga shkarkesat e ndryshme elektrike te cilat qojne në demtime dhe mosfunksionim.",t);
            para1.setAlignment(Element.CHAPTER);
            para1.setIndentationLeft(15f);
            para1.setSpacingAfter(10f);
            doc.add(para1);
            
             Paragraph para2 = new Paragraph("• Dëmtimet fizike te cilat vijnë si pasojë e moskujdesit te klientit si psh(Dëmtimet nga përplasjet,hudhja e lëngjeve apo ujit,goditje,ndrydhjet etj.)",t);
            para2.setAlignment(Element.ALIGN_JUSTIFIED);
            para2.setIndentationLeft(15f);
            para2.setSpacingAfter(10f);
            doc.add(para2);
            
             Paragraph para3 = new Paragraph("• Në rast se aq kohë produkti është i mbrojtur me garancion tek ne,klienti dërgon këtë produkt për intervinime/servisime të ndryshme te ndonjë organizatë"
                     + " apo individë, përveq në raste kur ne e sygjerojmë për një veprim të tillë.",t);
            para3.setAlignment(Element.ALIGN_JUSTIFIED);
            para3.setIndentationLeft(15f);
            para3.setSpacingAfter(10f);
            doc.add(para3);
            
            Chunk teksti = new Chunk("• Në garancion nuk përfshihet vendosja e sistemeve operative ",t);
            Chunk boldi = new Chunk("Windows/IOS (Formatizimet)",t1);
             Paragraph para4 = new Paragraph();
            Phrase phrase = new Phrase();
            phrase.add(teksti);
            phrase.add(boldi);
             para4.add(phrase);
            para4.setAlignment(Element.ALIGN_JUSTIFIED);
            para4.setIndentationLeft(15f);
            para4.setSpacingAfter(10f);
            doc.add(para4);
            
             Paragraph para5 = new Paragraph("• Bateria garantohet sa për tu testuar në kohë-zgjatje prej 14 ditësh(Pjesa tjetër e kohës mbetet në përkujdesje të klientit)",t);
            para5.setAlignment(Element.ALIGN_JUSTIFIED);
            para5.setIndentationLeft(15f);
            para5.setSpacingAfter(10f);
            doc.add(para5);
            
            
            
    }
    public static void tabela(Document doc) throws DocumentException,SQLException{
        
        Font headerFont = new Font(TIMES_ROMAN, 12, Font.BOLD);
        Font cellFont = new Font(HELVETICA, 9, Font.NORMAL);
        
        float columnWidth[] = {40,120,220,70,70,90,90};
        
        PdfPTable tb = new PdfPTable(columnWidth);
        tb.setSpacingAfter(5f);
        tb.setSpacingBefore(20f);
        
        String headers[] = {"Nr","Produkti","Pershkrimi","Sasia","Njesia","Cmimi per   Njesi","Totali"};
        for (int i = 0; i < headers.length; i++) {
            PdfPCell c1 = new PdfPCell(new Phrase(headers[i],headerFont));
                c1.setBackgroundColor(headerColor);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                tb.addCell(c1);
        }
        
        try{
            Statement s = prg.con().createStatement();
            ResultSet rs = s.executeQuery(" Select d.nrRendor,d.produkti,d.pershkrimi,d.sasia,d.Njesia,d.cmimi,d.totali from daljetG d where d.nrIdentifikues = '"+nrIdentifikues+"'"
                    + " group by d.nrRendor,d.produkti,d.pershkrimi,d.sasia,d.Njesia,d.cmimi,d.totali");
            while(rs.next()){
                for (int i = 1; i <= 7; i++) {                       
                            tb.addCell(new PdfPCell(new Phrase(rs.getString(i),cellFont)));                       
                    }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        doc.add(tb);
    }
    public static void totaliPageses(Document doc)throws DocumentException{
        
        try{
            Statement s = prg.con().createStatement();
            ResultSet rs = s.executeQuery("Select totali from garancioni where nrIdentifikues = '"+nrIdentifikues+"'");
            while(rs.next()){
                totaliGarancionit = rs.getDouble(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        Font dataFont = new Font(HELVETICA, 12, Font.BOLD);
        float columnWidth[] = {700f,250f,50f};
        PdfPTable tb = new PdfPTable(columnWidth);
        tb.setSpacingBefore(15f);
        
         PdfPCell c1 = new PdfPCell(new Phrase(""));        
        c1.setBorder(Rectangle.NO_BORDER);
        tb.addCell(c1);
        System.out.println("Totali i garancionit : "+totaliGarancionit);
        PdfPCell c2 = new PdfPCell(new Phrase("Totali i Pagesës:"+totaliGarancionit+" €"));        
        c2.setBorder(Rectangle.BOTTOM);
        tb.addCell(c2);
        
        PdfPCell c3 = new PdfPCell(new Phrase(""));        
        c3.setBorder(Rectangle.BOTTOM);
        tb.addCell(c3);
        
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        
        doc.add(tb);
        
    }
    public static void footeri(Document doc) throws DocumentException{
        Font cellFont = new Font(HELVETICA, 9, Font.NORMAL);
        Font dataFont = new Font(HELVETICA, 12, Font.BOLD);
        
        float columnWidth[] = {200f,200f,200f,200f,200f};
        PdfPTable tb = new PdfPTable(columnWidth);
        tb.setSpacingBefore(rreshtat());
        
        for (int i = 0; i < 5; i++) {
             if (i == 0) {
                
                PdfPCell c1 = new PdfPCell(new Phrase(data(),dataFont));        
                c1.setBorder(Rectangle.NO_BORDER);
                tb.addCell(c1);
            }else{
                 PdfPCell c1 = new PdfPCell(new Phrase("",cellFont));        
                c1.setBorder(Rectangle.NO_BORDER);
                tb.addCell(c1);
             }
        }
        
        PdfPCell c1 = new PdfPCell(new Phrase("Data e Blerjes",cellFont));        
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
        
        PdfPCell c4 = new PdfPCell(new Phrase(periudhaKohore+" Muaj Garancion",cellFont));        
        c4.setBorder(Rectangle.TOP);
        tb.addCell(c4);
        
        tb.setTotalWidth(tableWidth);
        tb.setLockedWidth(true);
        
        doc.add(tb);
    }
    
    public static float rreshtat(){
        float nr = 0;
        if (rreshtat < 5) {
            nr = 150f;
        }else if(rreshtat < 10){
            nr = 100f;
        }else if(rreshtat < 15){
            nr = 75;
        }else if(rreshtat < 20){
            nr = 37;
        }
        return nr;
    }
    public static String data(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = dateObj.format(formatter);
        return date;
    }
}
