/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import javax.swing.*;

/**
 *
 * @author chung
 */
public abstract class Pieza extends JButton{
    protected String color;
    
    
    public Pieza(String color){
    this.color = color;
    }
    
    public String getColor(){
    return color;
    }
    
    abstract String getTipoPieza();
    abstract boolean movimientoValido(int row, int column);
    abstract void ponerImagen(String color, JButton btn);
    
}
