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

public class soldado extends Pieza{
    int movimientosParaRio;
    
    public soldado(String color){
    super(color);
    movimientosParaRio=1;
    }

    @Override
    String getTipoPieza() {
        return "soldado";
    }

    @Override
    boolean movimientoValido( int filaInicial, int colInicial, int fila, int col , Pieza pieza) {
       int difFila= (fila-filaInicial);
       int difCol = Math.abs(col-colInicial);
       
       
       if(pieza.color.equals("rojo")){
        if(difFila == -1 && difCol ==0 &&(movimientosParaRio >=1)){

          System.out.println("no ha pasado el rio");
          movimientosParaRio--;
          return true;
         }

        else if ((filaInicial==4 && fila==6) || (filaInicial == 6 && fila == 4)){
            if( difCol==0){
                System.out.println("quiere pasar el rio");
                return true;
            }
            else{
            return false;
            }
        }

        else if(movimientosParaRio==0 && difFila ==-1 && difCol == 0){
            System.out.println("ya paso el rio");
            return true;
        }
        else if(movimientosParaRio==0 && difFila==0 && difCol==1){
            System.out.println("ya paso el rio");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Movimiento no valido" , "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }  

       }
       else if(pieza.color.equals("negro")){
        if(difFila == 1 && difCol ==0 &&(movimientosParaRio >=1)){

           System.out.println("no ha pasado el rio");
           movimientosParaRio--;
           return true;
          }

         else if ((filaInicial==4 && fila==6) || (filaInicial == 4 && fila == 6)){
             if( difCol==0){
                 System.out.println("quiere pasar el rio");
                 return true;
             }
             else{
             return false;
             }
         }

         else if(movimientosParaRio==0 && difFila ==1 && difCol == 0){
             System.out.println("ya paso el rio");
             return true;
         }
         else if(movimientosParaRio==0 && difFila==0 && difCol==1){
             System.out.println("ya paso el rio");
             return true;
         }
         else{
             JOptionPane.showMessageDialog(null, "Movimiento no valido" , "Error", JOptionPane.ERROR_MESSAGE);
             return false;
         }  
       }
       else{
        System.out.println("no cumplio ningun requisito");
        return false;
       }
      
    }

    @Override
    void ponerImagen( JButton btn) {
          if(color.equals("rojo")){
     try {
        String ruta = "/resources/soldadoRojo.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontró la imagen en (rojo)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del soldado rojo.");
    }}

    else{
        try {
        String ruta = "/resources/soldadoNegro.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontro la imagen en (negro)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del soldado negro.");
    }}

    }

    @Override
    void comer(Pieza piezaSeleccionada,Pieza piezaAComer) {
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
