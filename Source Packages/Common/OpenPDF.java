/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author vladg
 */
public class OpenPDF {
    public static void openById(String Id) {
        try{
            if(new File("D:\\" + Id + ".pdf").exists()) {
                Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\" + Id + ".pdf");
            }else {
                JOptionPane.showMessageDialog(null, "File doesn't exists!");
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
