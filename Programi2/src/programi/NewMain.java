/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     try{
        String Login = "jdbc:sqlserver://localhost:1433;databaseName=programi;IntegratedSecurity = true;encrypt=true;trustServerCertificate=true";
        String url = Login; 
        Connection con = DriverManager.getConnection(url);
        
         System.out.println("Done");
          
        
          
      }catch(SQLException e){
         e.printStackTrace();
      }
        
    }
    
}
