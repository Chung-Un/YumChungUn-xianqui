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
    boolean movimientoValido(int filaInicial, int colInicial, int fila, int col, Pieza pieza) {
        int difFila = Math.abs(fila-filaInicial);
        int difCol = Math.abs(col-colInicial);
        
        if(difFila==1 && difCol == 2){
           return true; 
        }
        else if(difFila ==2 && difCol==1){
            return true;
        }
        else if(fila==5){
            JOptionPane.showConfirmDialog(null, "Te vas a ahogar", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Movmiento no valido" ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    void ponerImagen( JButton btn) {
           if(color.equals("rojo")){
     try {
        String ruta = "/resources/caballoRojo.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontró la imagen en (rojo)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del caballo rojo.");
    }}

    else{
        try {
        String ruta = "/resources/caballoNegro.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontró la imagen en (negro)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del caballo negro.");
    }}

    }
    
}
