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
    static Pieza[][] piezasTablero = new Pieza[11][9];
    protected String color;
    static int numPiezas=0;

    
    public Pieza(String color){
    this.color = color;
    }
    
    public String getColor(){
    return color;
    }
    
    abstract String getTipoPieza();
    abstract boolean movimientoValido(int filaInicial, int colInicial, int fila, int col, Pieza pieza);
    abstract void ponerImagen( JButton btn);
    abstract void comer(Pieza piezaSeleccionada,Pieza piezaAComer);
    
    public final void borrarPieza( Pieza piezaABorrar){
        for (int fila = 0; fila < 11; fila++) {
            for (int col = 0; col <9 ; col++)
            if (piezasTablero[fila][col]== piezaABorrar) {
                piezasTablero[fila][col] = null;
                numPiezas--;
                return;
        }
    }
    }
    
    
    
    
   
}
