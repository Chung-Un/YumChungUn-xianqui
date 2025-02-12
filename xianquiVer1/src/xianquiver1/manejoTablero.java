/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author chung
 */
public class manejoTablero {
    
    public static String piezaAColocar(int fila,int col){
    
        switch (fila) {
            case 1:
                if(col ==1 || col == 9){
                    return"carroGuerraNegro";
                }
                else if(col ==2 || col == 8){
                    return"caballoNegro";
                }
                else if(col == 3 ||col == 7){
                   return"elefanteNegro";
                }
                else if(col ==5){
                    return "generalNegro";
                }
                else if(col == 4 || col == 6){
                    return "oficialNegro";
                }   break;
            case 3:
                if(col ==2 || col ==8){
                   return "canonNegro";
                }   break;
            case 4:
                if(col == 1 || col == 3 || col == 5 || col == 7 || col == 9){
                    return"soldadoNegro";
                }   break;
                
            case 8:
                if(col ==1 || col ==3 || col == 5 || col == 7 || col == 9){
                    return "soldadoRojo";
                } break;
                
            case 9:
                if(col == 2 || col == 8){
                   return "canonRojo";
                } break;
                
            case 11:
                if(col == 1 || col == 9){
                    return "carroGuerraRojo";
                }
                else if(col == 2 || col == 8){
                    return"caballoRojo";
                }
                
                else if(col == 3 || col == 7){
                    return"elefanteRojo";
                }
                else if(col == 4|| col == 6){
                    return "oficialRojo";
                }
                else if(col == 5){
                    return"generalRojo";
                }break;
             
        }
        return "";
        
    }
    public static Pieza colocarPieza(JButton btn, int row, int col){
        String piezaPorColocar = piezaAColocar(row,col);
        
        switch (piezaPorColocar) {
            case "carroGuerraNegro":
                    Pieza carroGuerraNegro = new carroGuerra("negro");
                    carroGuerraNegro.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = carroGuerraNegro;
                    return carroGuerraNegro;
               
            case "caballoNegro":
                    Pieza caballoNegro = new caballo("negro");
                    caballoNegro.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = caballoNegro;
                    return caballoNegro;
            
            case"elefanteNegro":
                    Pieza elefanteNegro = new elefante("negro");
                    elefanteNegro.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = elefanteNegro;
                    return elefanteNegro;
                
            case "generalNegro":
                    Pieza generalNegro = new general("negro");
                    generalNegro.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = generalNegro;
                    return generalNegro;
                    
            case "oficialNegro":
                    Pieza oficialNegro = new oficial("negro");
                    oficialNegro.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = oficialNegro;
                    return oficialNegro;
                    
            case "canonNegro":
                    Pieza canonNegro = new canon ("negro");
                    canonNegro.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = canonNegro;
                    return canonNegro;
                    
            case "soldadoNegro":
                    Pieza soldadoNegro = new soldado("negro");
                    soldadoNegro.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = soldadoNegro;
                    return soldadoNegro;
                
            case "soldadoRojo":
                    Pieza soldadoRojo = new soldado("rojo");
                    soldadoRojo.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = soldadoRojo;
                    return soldadoRojo;
                
            case "canonRojo":
                    Pieza canonRojo = new canon("rojo");
                    canonRojo.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = canonRojo;
                    return canonRojo;
                
            case "carroGuerraRojo":
                    Pieza carroGuerraRojo =new carroGuerra("rojo");
                    carroGuerraRojo.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = carroGuerraRojo;
                    return carroGuerraRojo;

            case "caballoRojo":
                    Pieza caballoRojo = new caballo("rojo");
                    caballoRojo.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = caballoRojo;
                    return caballoRojo;
                
            case "elefanteRojo":
                    Pieza elefanteRojo = new elefante("rojo");
                    Tablero.piezasTablero[row - 1][col - 1] = elefanteRojo;
                    elefanteRojo.ponerImagen(btn);
                    return elefanteRojo;
            
            case "oficialRojo" :
                    Pieza oficialRojo = new oficial("rojo");
                    oficialRojo.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = oficialRojo;
                    return oficialRojo;
                
            case "generalRojo":
                    Pieza generalRojo = new general("rojo");
                    generalRojo.ponerImagen(btn);
                    Tablero.piezasTablero[row - 1][col - 1] = generalRojo;
                    return generalRojo;
           
        }
    return null;
    }
    
    
 public static void hacerBotones(){ 
    for (int filas=0;filas<11;filas++){
        for(int columnas=0;columnas<9; columnas++){
            if (filas==5){ 

                JLabel labelRio = new JLabel("");
                labelRio.setOpaque(true);
                labelRio.setBackground(new Color(71,197,209)); 
                Tablero.panelTablero.add(labelRio);
            } 
            else{
               JButton btn = new JButton(); btn.setPreferredSize(new Dimension(60,60)); btn.setBackground(calcularColor(filas,columnas));
               colocarPieza(btn, filas+1, columnas+1);
               btn.setFocusable(false); 
               Tablero.panelTablero.add(btn); 
               Tablero.botonesTablero[filas][columnas]=btn; 
               final int f= filas; 
               final int c = columnas;
                
                btn.addActionListener(new ActionListener (){
                @Override public void actionPerformed(ActionEvent e){
                botonPresionado(f,c); } }); }
             } } 


             }
           


    public static void botonPresionado(int f, int c){

    if (Tablero.filaOrigen==-1 && Tablero.columnaOrigen ==-1){
    //primera vez presionado
        if(Tablero.botonesTablero[f][c].getIcon() == null){
        JOptionPane.showMessageDialog(null,"La celda presionada no contiene ninguna pieza", "Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
        Tablero.filaOrigen=f;
        Tablero.columnaOrigen = c;
        Tablero.piezaSeleccionada = Tablero.piezasTablero[f][c];
        Tablero.botonesTablero[f][c].setBackground(Color.red);
        System.out.println("boton que se quiere mover de fila: " + (Tablero.filaOrigen+1) + " columna: " + (Tablero.columnaOrigen+1));
        }
    
    }else {
    //segunda vez presionado
    
    if (Tablero.piezaSeleccionada!=null ){
        Pieza pieza = Tablero.piezaSeleccionada;
            if(pieza.movimientoValido(Tablero.filaOrigen, Tablero.columnaOrigen, f, c, pieza)){
                Tablero.botonesTablero[f][c].setIcon(Tablero.botonesTablero[Tablero.filaOrigen][Tablero.columnaOrigen].getIcon());
                Tablero.botonesTablero[Tablero.filaOrigen][Tablero.columnaOrigen].setIcon(null);

                Tablero.piezasTablero[f][c] = pieza;
                Tablero.piezasTablero[Tablero.filaOrigen][Tablero.columnaOrigen] = null;

                System.out.println("Pieza movida a fila: " + (f + 1) + " columna: " + (c + 1));
            } 
    
    Tablero.botonesTablero[Tablero.filaOrigen][Tablero.columnaOrigen].setBackground(calcularColor(Tablero.filaOrigen, Tablero.columnaOrigen));

    
    Tablero.filaOrigen=-1;
    Tablero.columnaOrigen=-1;
   }
    

}}

public static Color calcularColor(int fila, int columna){
    
 if ((fila + columna) % 2 == 0) {
 return esPalacio(fila + 1, columna + 1) ? new Color(180, 104, 255) : new Color(251, 165, 24); 
} else {
 return esPalacio(fila + 1, columna + 1) ? new Color(210, 164, 255) : new Color(249, 203, 67); } }


public static boolean esPalacio (int filas, int columnas){

    if(filas==11 || filas ==10 || filas == 9 || filas ==1 || filas == 2 || filas ==3){
        if (columnas==4 || columnas ==6 ||columnas ==5 ){
        return true;
        }
        else
        return false;

        }
    return false;   
    }

public static void agregarLetras(){
    String[] letras = {"a","b","c","d","e","f","g","h","i"};

    for (int index=0;index<letras.length;index++){
    JLabel labelLetras = new JLabel(letras[index]);
    labelLetras.setFont(new Font("Arial",Font.PLAIN,16));
    labelLetras.setForeground(new Color(251, 165, 24));
    Tablero.panelLetras.add(labelLetras);
}}

public static void agregarNumeros(){
    for (int index=1; index<=10; index++){
    JLabel labelNumeros = new JLabel(String.valueOf(index));
    labelNumeros.setFont(new Font("Arial", Font.PLAIN,16));
    labelNumeros.setForeground(new Color(251,165,24));
    Tablero.panelNumeros.add(labelNumeros);
    }}
    
}
