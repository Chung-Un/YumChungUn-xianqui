/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import com.sun.tools.javac.Main;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author chung
 */
public class carroGuerra extends Pieza {
    public carroGuerra(String color){
    super(color);
    }
    
    @Override
    String getTipoPieza() {
        return "carroGuerra";
    }

    @Override
    boolean movimientoValido(int filaInicial, int colInicial, int fila , int col , Pieza pieza) {
        int difFila = Math.abs(fila-filaInicial);
        int difCol = Math.abs(col - colInicial);
        
        if(difFila==1 && difCol ==0){
            return true;
        }
        else if(difFila==0 && difCol==1){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Movimiento no valido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    void ponerImagen(JButton btn){
        if(color.equals("rojo")){
     try {
        String ruta = "/resources/carroGuerraRojo.png"; 
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontró la imagen en (rojo)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del carro guerra rojo.");
    }}

    else{
        try {
        String ruta = "/resources/carroGuerraNegro.png";  
        InputStream imgIcon = getClass().getResourceAsStream(ruta);

        if (imgIcon == null) {
            System.out.println("Error: No se encontró la imagen en (negro)" + ruta);
            return;
        }

        BufferedImage imgOg = ImageIO.read(imgIcon);
        Image imgResize = imgOg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(imgResize));

    } catch (IOException ex) {
        System.out.println("Error al cargar la imagen del carro guerra negro.");
    }}

    }}

    
