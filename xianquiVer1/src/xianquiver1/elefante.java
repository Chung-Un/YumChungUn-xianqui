/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import com.sun.tools.javac.Main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;



/**
 *
 * @author chung
 */
public class elefante extends Pieza {

    public elefante(String color){
    super(color);
    
    }
    
    @Override
    String getTipoPieza() {
        return "elefante";
    }

    @Override
    boolean movimientoValido(int filaInicial, int colInicial, int fila, int col, Pieza pieza) {
        int difFila = Math.abs(fila-filaInicial);
        int difCol = Math.abs(col-colInicial);
        
        if((difFila==2 && difCol ==2)&& fila!=5){
            return true;
        }
        else if(fila==5){
            JOptionPane.showMessageDialog(null, "Te vas ahogar..." , "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            JOptionPane.showMessageDialog(null, "Movimiento no valido" , "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }

    @Override
    void ponerImagen(JButton btn) {
         if(color.equals("rojo")){
     try {
        String ruta = "/resources/elefanteRojo.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontró la imagen en (rojo)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del elefante rojo.");
    }}

    else{
        try {
        String ruta = "/resources/elefanteNegro.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontro la imagen en (negro)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del elefante negro.");
    }}

    }

    @Override
    void comer(Pieza piezaSeleccionada, Pieza piezaAComer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
