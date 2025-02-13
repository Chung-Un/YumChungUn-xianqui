/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xianquiver1;

/**
 *
 * @author chung
 */
public class XianquiVer1 {

    /**
     * @param args the command line arguments
     */
    public static Users player1;
    public static Logs logsPlayer1 = new Logs(""); 
    public static Logs logsPlayer2 = new Logs("");
    public static Logs[] logsJuego;
    public static Users player2;
    public static Partidas partidaActual;
    
    public static void main(String[] args) {
        Gui gui = new Gui();
        
        gui.pantallaInicio();
//        if (player1!=null && player2!=null){
//        Tablero.mostrarTablero();}
//        gui.menuPrincipal();
       
        // TODO code application logic here
    }
    
}
