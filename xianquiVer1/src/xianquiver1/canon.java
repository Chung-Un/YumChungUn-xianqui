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
        int difFila = Math.abs(fila-filaInicial);
        int difCol = Math.abs(col - colInicial);
        
        if(fila==5){
           JOptionPane.showMessageDialog(null, "Te vas ahogas..", "Error", JOptionPane.ERROR_MESSAGE);
           return false;
        }
         else if ((difFila == 1 && difCol == 0) || (difFila == 0 && difCol == 1)) {
        return true;
        }
        else if ((difFila > 0 && difCol == 0) || (difFila == 0 && difCol > 0)) {
            int piezasIntermedias = 0;
            int filaInicio, filaFinal, colInicio, colFinal;

            if (difFila > 0) {
                filaInicio = Math.min(filaInicial, fila) + 1;
                filaFinal = Math.max(filaInicial, fila);
                for (int f = filaInicio; f < filaFinal; f++) {
                    if (Pieza.piezasTablero[f][col] != null) {
                        piezasIntermedias++;
                    }
                }
            }
            
        
        else {
                colInicio = Math.min(colInicial, col) + 1;
                colFinal = Math.max(colInicial, col);
                for (int c = colInicio; c < colFinal; c++) {
                    if (Pieza.piezasTablero[fila][c] != null) {
                        piezasIntermedias++;
                    }
                }
            }
             Pieza piezaFinal = Pieza.piezasTablero[fila][col];  

            if (piezasIntermedias == 0 && piezaFinal == null) {
                return true;
            }
            
            if (piezasIntermedias == 1 && piezaFinal != null && !piezaFinal.getColor().equals(pieza.getColor())) {
                return true;
            }

            JOptionPane.showMessageDialog(null, "Movimiento inválido para el cañón", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        JOptionPane.showMessageDialog(null, "Movimiento no válido", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
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
        if(piezaAComer!=null){
        if(piezaSeleccionada.getColor().equals(piezaAComer.getColor())){
            return;
        }
        else{
            piezaAComer.borrarPieza(piezaAComer);
            System.out.println( piezaSeleccionada.getTipoPieza() + " de " +manejoPartidas.getPlayerEnTurno().usuario + "se comio un " +
                    piezaAComer.getTipoPieza() + " de " + manejoPartidas.getPlayerNoEnTurno().usuario);
                    
            Users playerEnTurno = manejoPartidas.getPlayerEnTurno();
            Users playerNoEnTurno = manejoPartidas.getPlayerNoEnTurno();
            playerEnTurno.logUsuarioActual.log= "->" +piezaSeleccionada.getTipoPieza() + " de " + playerEnTurno.usuario + " se comio un " +
                    piezaAComer.getTipoPieza() + " de " + playerNoEnTurno.usuario;
            
            if(playerEnTurno.usuario.equals(XianquiVer1.player1.usuario)){
                Tablero.fieldUser1.setText(playerEnTurno.logUsuarioActual.log);
                manejoLogs.agregarLog(playerEnTurno.logUsuarioActual, XianquiVer1.player1);
            }
            else{
                Tablero.fieldUser2.setText(playerEnTurno.logUsuarioActual.log);
                manejoLogs.agregarLog(playerEnTurno.logUsuarioActual, XianquiVer1.player2);
            }
        }
    }
        
        }
       
    
    
    
}

   

