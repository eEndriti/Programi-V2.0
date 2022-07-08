/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programi;

import java.io.File;
import java.sql.*;

/**
 *
 * @author Pc
 */
public class prg {
    public static String emriPerdoruesit,emriFirmes,nrBiznesit,adresa,nrFiskal,nrTelefonit;
    public static int idPerdoruesi,idXhiro;

    public static Connection con()throws SQLException{
                     
      try{
        // "jdbc:sqlserver://localhost:1433;databaseName=Programi;IntegratedSecurity = true;encrypt=true;trustServerCertificate=true"
        String url = Login.sqlPath; 
        Connection con = DriverManager.getConnection(url);
        
        return con;
          
        
          
      }catch(SQLException e){
         e.printStackTrace();
      }
     return null;   
    }
    public static File path(){
        final File f = new File(Login.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        return f;
    }
    
        
}
