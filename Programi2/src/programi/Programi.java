/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programi;
import java.sql.*;
/**
 *
 * @author BERDYNA
 */
public class Programi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }
     public static void numberCheck(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if(Character.isLetter(c) && !evt.isAltDown()){
            evt.consume();
        }
     }
    
}
