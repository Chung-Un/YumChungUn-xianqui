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

public class caballo extends Pieza{
    
    public caballo(String color){
    super(color);
    }

    @Override
    String getTipoPieza() {
        return "caballo";
    }

    @Override
    boolean movimientoValido(int row, int column) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void ponerImagen(String color, JButton btn) {
        if(color.equals("rojo")){
            
            try {
                InputStream imgIcon = Main.class.getResourceAsStream("/resources/caballoRojo.png");
                BufferedImage imgOg = ImageIO.read(imgIcon);
                Image imgResize = imgOg.getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(imgResize));

            } catch (IOException ex) {
                System.out.println("Caballo rojo no se pudo cargar");
            }
            
        
        }else{
            try {
                InputStream imgIcon = Main.class.getResourceAsStream("/resources/caballoNegro.png");
                BufferedImage imgOg = ImageIO.read(imgIcon);
                Image imgResize = imgOg.getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(imgResize));

            } catch (IOException ex) {
                System.out.println("Caballo negro no se pudo cargar");
            }
            
        
        }
    }
    
}
