/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import javax.swing.JButton;

/**
 *
 * @author chung
 */
import com.sun.tools.javac.Main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class oficial extends Pieza {

    public oficial(String color){
    super(color);
    }
    
    @Override
    String getTipoPieza() {
        return "oficial";
    }

    @Override
    boolean movimientoValido(int row, int column) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void ponerImagen(String color, JButton btn) {
       if(color.equals("rojo")){
            
            try {
                InputStream imgIcon = Main.class.getResourceAsStream("/resources/oficialRojo.png");
                BufferedImage imgOg = ImageIO.read(imgIcon);
                Image imgResize = imgOg.getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(imgResize));

            } catch (IOException ex) {
                System.out.println("Oficial rojo no se pudo cargar");
            }
            
        
        }else{
            try {
                InputStream imgIcon = Main.class.getResourceAsStream("/resources/oficialNegro.png");
                BufferedImage imgOg = ImageIO.read(imgIcon);
                Image imgResize = imgOg.getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(imgResize));

            } catch (IOException ex) {
                System.out.println("Oficial negro no se pudo cargar");
            }
            
        
        }
    }
    
}
