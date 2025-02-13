/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

/**
 *
 * @author chung
 */
public class manejoPartidas implements Almacenamiento<Partidas>{
    
    static Partidas[] partidas =new Partidas[100];
    int numPartidas;

    @Override
    public void crear(Partidas partidaActual) {
       if (numPartidas > partidas.length){
       resize();
       }
       else{
       partidas[numPartidas++] = partidaActual;
       }
    }

    @Override
    public void borrar(Partidas partidas) {
    }

    public void resize() {
        Partidas[] partidasResized= new Partidas[partidas.length*2];
        System.arraycopy(partidas, 0, partidasResized, 0, partidas.length);
        partidas= partidasResized;
    }

    @Override
    public void resize(Partidas[] item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void cambiarTurnos(Partidas partidaActual){
        if(partidaActual.turno == true){
            partidaActual.turno =false;
            Tablero.labelTurnos.setText("Turno de: " + XianquiVer1.player2.usuario);
        }
        else{
            partidaActual.turno = true;
            Tablero.labelTurnos.setText("Turno de: " + XianquiVer1.player1.usuario);
        }
    }
    
    public static Users getPlayerEnTurno(){
        if(XianquiVer1.partidaActual.turno ==true){
            return XianquiVer1.player1;
        }
        else{
            return XianquiVer1.player2;
        }
    }
    
    public static Users getPlayerNoEnTurno (){
        if(XianquiVer1.partidaActual.turno ==true){
            return XianquiVer1.player2;
        }
        else{
            return XianquiVer1.player1;
        }
        
    }
    }
    

