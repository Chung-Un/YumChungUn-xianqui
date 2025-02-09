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
public class funcionesGenerales {
    
    public static void colocarPieza(JButton btn, int row, int col){
    
        switch (row) {
            case 1:
                if(col ==1 || col == 9){
                    Pieza carroGuerraNegro = new carroGuerra("negro");
                    ((carroGuerra)carroGuerraNegro).ponerImagen(btn);
                }
                else if(col ==2 || col == 8){
                    Pieza caballoNegro = new caballo("negro");
                    ((caballo)caballoNegro).ponerImagen(btn);
                }
                else if(col == 3 ||col == 7){
                    Pieza elefanteNegro = new elefante("negro");
                    ((elefante)elefanteNegro).ponerImagen(btn);
                }
                else if(col ==5){
                    Pieza generalNegro = new general("negro");
                    ((general)generalNegro).ponerImagen(btn);
                }
                else if(col == 4 || col == 6){
                    Pieza oficialNegro = new oficial("negro");
                    ((oficial)oficialNegro).ponerImagen(btn);
                }   break;
            case 3:
                if(col ==2 || col ==8){
                    Pieza canonNegro = new canon ("negro");
                    ((canon)canonNegro).ponerImagen(btn);
                }   break;
            case 4:
                if(col == 1 || col == 3 || col == 5 || col == 7 || col == 9){
                    Pieza soldadoNegro = new soldado("negro");
                    ((soldado)soldadoNegro).ponerImagen(btn);
                }   break;
                
            case 8:
                if(col ==1 || col ==3 || col == 5 || col == 7 || col == 9){
                    Pieza soldadoRojo = new soldado("rojo");
                    ((soldado)soldadoRojo).ponerImagen(btn);
                } break;
                
            case 9:
                if(col == 2 || col == 8){
                    Pieza canonRojo = new canon("rojo");
                    ((canon)canonRojo).ponerImagen(btn);
                } break;
                
            case 11:
                if(col == 1 || col == 9){
                    Pieza carroGuerraRojo =new carroGuerra("rojo");
                    ((carroGuerra)carroGuerraRojo).ponerImagen(btn);
                }
                else if(col == 2 || col == 8){
                    Pieza caballoRojo = new caballo("rojo");
                    ((caballo)caballoRojo).ponerImagen(btn);
                }
                
                else if(col == 3 || col == 7){
                    Pieza elefanteRojo = new elefante("rojo");
                    ((elefante)elefanteRojo).ponerImagen(btn);
                }
                else if(col == 4|| col == 6){
                    Pieza oficialRojo = new oficial("rojo");
                    ((oficial)oficialRojo).ponerImagen(btn);
                }
                else if(col == 5){
                    Pieza generalRojo = new general("rojo");
                    ((general)generalRojo).ponerImagen(btn);
                }break;
                
            default:
                break;
        }
    
    }
    
}
