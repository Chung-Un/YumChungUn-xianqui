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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class canon extends Pieza{
    int filaInicial, colInicial, fila, col;
    public canon (String color){
    super(color);
    
    }

    @Override
    String getTipoPieza() {
        return "canon";
    }
@Override
boolean movimientoValido(int filaInicial, int colInicial, int fila, int col, Pieza pieza) {
    int difFila = Math.abs(fila - filaInicial);
    int difCol = Math.abs(col - colInicial);

    int piezasIntermedias = contarPiezasIntermedias(filaInicial, colInicial, fila, col);
    if ((difFila > 0 && difCol == 0) || (difFila == 0 && difCol > 0)) {
        Pieza piezaFinal = Pieza.piezasTablero[fila][col];

        if (piezasIntermedias == 0 ) {
            return true;
        }

        else if (piezasIntermedias == 1 ) {
            return true;
        }
        

    }

    JOptionPane.showMessageDialog(null, "Movimiento no valido", "Error", JOptionPane.ERROR_MESSAGE);
    return false;
}



    @Override
    void ponerImagen( JButton btn) {
           if(color.equals("rojo")){
     try {
        String ruta = "/resources/canonRojo.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
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
        piezaAComer.borrarPieza(piezaAComer);
       
        Users playerEnTurno = manejoPartidas.getPlayerEnTurno();
        playerEnTurno.logUsuarioActual.log = "->" + piezaSeleccionada.getTipoPieza() + " de " +
                playerEnTurno.usuario + " se comió un " + piezaAComer.getTipoPieza() + " de " +
                manejoPartidas.getPlayerNoEnTurno().usuario;

        if (playerEnTurno.usuario.equals(XianquiVer1.player1.usuario)) {
            Tablero.fieldUser1.setText(playerEnTurno.logUsuarioActual.log);
            manejoLogs.agregarLog(playerEnTurno.logUsuarioActual, XianquiVer1.player1);
        } else {
            Tablero.fieldUser2.setText(playerEnTurno.logUsuarioActual.log);
            manejoLogs.agregarLog(playerEnTurno.logUsuarioActual, XianquiVer1.player2);
        }
}

int contarPiezasIntermedias(int filaInicial, int colInicial, int filaFinal, int colFinal) {
    int piezasIntermedias = 0;

    if (filaInicial == filaFinal) {
        int colInicio = Math.min(colInicial, colFinal) + 1; 
        int colFin = Math.max(colInicial, colFinal); 

        for (int c = colInicio; c < colFin; c++) {
            if (Pieza.piezasTablero[filaInicial][c] != null) {
                piezasIntermedias++;
            }
        }
    }
    else if (colInicial == colFinal) {
        int filaInicio = Math.min(filaInicial, filaFinal) + 1; 
        int filaFin = Math.max(filaInicial, filaFinal); 

        for (int f = filaInicio; f < filaFin; f++) {
            if (Pieza.piezasTablero[f][colInicial] != null) {
                piezasIntermedias++;
            }
        }
    }

   return piezasIntermedias;
}

       
    
    
    
}

   

