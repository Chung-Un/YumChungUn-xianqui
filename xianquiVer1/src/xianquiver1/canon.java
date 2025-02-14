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

public class canon extends Pieza{
    boolean capturoPieza;
    int vecesSaltadas;
    
    public canon (String color){
    super(color);
    capturoPieza=false;
    vecesSaltadas=0;
    }

    @Override
    String getTipoPieza() {
        return "canon";
    }

    @Override
    boolean movimientoValido(int filaInicial, int colInicial, int fila , int col , Pieza pieza) {
//        int difFila = Math.abs(fila-filaInicial);
//        int difCol = Math.abs(col - colInicial);
//        
//        if(fila==5){
//           JOptionPane.showMessageDialog(null, "Te vas ahogas..", "Error", JOptionPane.ERROR_MESSAGE);
//           return false;
//        }
//        else{
//        if(difFila>0 && difCol ==0){
//            int filaInicio = Math.min(filaInicial, fila)+1;
//            int filaFinal = Math.max(filaInicial, fila);
//            for (int filaRecorrer=filaInicio; filaRecorrer<filaFinal ;filaRecorrer++ ){
//                if(Pieza.piezasTablero[filaRecorrer][col]!=null){
//                    JOptionPane.showMessageDialog(null, "Hay piezas en tu camino", "Error",JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            }
//            
//            return true;
//        }
//        else if(difFila==0 && difCol>0){
//            int colInicio = Math.min(colInicial, col);
//            int colFinal = Math.max(colInicial, col);
//            
//            for(int colRecorrer = colInicio; colRecorrer<colFinal; colRecorrer++){
//                if(Pieza.piezasTablero[fila][colRecorrer]!=null){
//                 JOptionPane.showMessageDialog(null, "Hay piezas en tu camino", "Error",JOptionPane.ERROR_MESSAGE);
//                 return false;
//                }
//            }
//              
//            return true;
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "Movimiento no valido", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }}
    return true;
    }

    @Override
    void ponerImagen( JButton btn) {
           if(color.equals("rojo")){
     try {
        String ruta = "/resources/canonRojo.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontró la imagen en (rojo)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del canon rojo.");
    }}

    else{
        try {
        String ruta = "/resources/canonNegro.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontro la imagen en (negro)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del canon negro.");
    }}

    }

    @Override
    void comer(Pieza piezaSeleccionada, Pieza piezaAComer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void saltar(){
    
    }
}
