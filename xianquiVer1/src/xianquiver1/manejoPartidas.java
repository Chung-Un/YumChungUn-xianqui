/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import javax.swing.JOptionPane;

/**
 *
 * @author chung
 */
public class manejoPartidas implements Almacenamiento<Partidas>{
    static Partidas[] partidas =new Partidas[100];
    static int numPartidas;
    Users playerGanador;

    static Gui gui = new Gui();
    
    @Override
    public void crear(Partidas partidaActual) {
        if (numPartidas>=partidas.length){
            resize(partidas);}
        else{
            partidas[numPartidas] = partidaActual;
            numPartidas++;
        }
      
    }

    public void borrar(Partidas partida) {
         for (int index = 0; index < numPartidas; index++) {
            if (partidas[index] != null && (partidas[index].ganador.equals(XianquiVer1.player1) || partidas[index].perdedor.equals(XianquiVer1.player1))) {
                partidas[index] = partidas[numPartidas - 1];
                partidas[numPartidas - 1] = null;
                numPartidas--;
            break;
        }
    }
    }

   
    public static void limpiarPiezas(){
        
        for (int fila=0; fila<11; fila++){
           for(int col=0;col<9; col++){
           Pieza.piezasTablero[fila][col] =null;
           }
        }
    
    }
    
    @Override
    public void resize(Partidas[] item) {
        Partidas[] partidasResized= new Partidas[partidas.length*2];
        System.arraycopy(partidas, 0, partidasResized, 0, partidas.length);
        partidas= partidasResized;    }
    
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
    
    public static boolean ganar(Pieza pieza, Pieza piezaComida){
        boolean ganar = piezaComida.getTipoPieza().equals("general");
        Users playerEnTurno = manejoPartidas.getPlayerEnTurno();
        Users playerNoEnTurno = manejoPartidas.getPlayerNoEnTurno();
        
        if(ganar){
            JOptionPane.showMessageDialog(null, playerEnTurno.usuario +  " VENCIO A " + playerNoEnTurno.usuario + " FELICIDADES HAS GANADO 3 PUNTOS!!!",
                    "**Fin de Partida**", JOptionPane.INFORMATION_MESSAGE);
            
            String nombrePerdedor = playerEnTurno.usuario;
            String nombreGanador = playerNoEnTurno.usuario;

            String logPerdedor = "-> " + nombrePerdedor + " ha sido vencido porque " + playerEnTurno.usuario + " se comio a su general";
            String logGanador = "-> " + nombreGanador + " ha ganado porque su" + pieza.getTipoPieza() + " se comio al general de " + playerNoEnTurno.usuario;

            manejoLogs.agregarLogFinal(new Logs(logPerdedor), playerEnTurno);
            manejoLogs.agregarLogFinal(new Logs(logGanador), playerNoEnTurno);
        
            playerEnTurno.partidasGanadas+=1;
            playerNoEnTurno.partidasPerdidas+=1;
            playerEnTurno.puntos+=3;
            XianquiVer1.partidaActual.ganador = playerEnTurno;
            XianquiVer1.partidaActual.perdedor = playerNoEnTurno;
            
            limpiarPiezas();
    
            }
            
        return ganar;
    }
 
    public static void retirar(){
        Users playerEnTurno = manejoPartidas.getPlayerEnTurno();
        Users playerNoEnTurno = manejoPartidas.getPlayerNoEnTurno();
        
        JOptionPane.showMessageDialog(null, playerEnTurno.usuario +  " SE HA RETIRADO, FELICIDADES " + playerNoEnTurno.usuario + " HAS GANADO 3 PUNTOS!!!",
                    "**Fin de Partida**", JOptionPane.INFORMATION_MESSAGE);
        
        String nombrePerdedor = playerEnTurno.usuario;
        String nombreGanador = playerNoEnTurno.usuario;

        String logPerdedor = "-> " + nombrePerdedor + " ha perdido contra " + nombreGanador + " al retirarse.";
        String logGanador = "-> " + nombreGanador + " ha ganado porque " + nombrePerdedor + " se retiró de la partida.";

        manejoLogs.agregarLogFinal(new Logs(logPerdedor), playerEnTurno);
        manejoLogs.agregarLogFinal(new Logs(logGanador), playerNoEnTurno);
        
        playerEnTurno.partidasPerdidas+=1;
        playerNoEnTurno.partidasGanadas+=1;
        playerNoEnTurno.puntos+=3;
        XianquiVer1.partidaActual.ganador = playerNoEnTurno;
        XianquiVer1.partidaActual.perdedor = playerEnTurno;
    
        XianquiVer1.player2 =null;
        
        limpiarPiezas();
        
        Tablero.panelContenedor.removeAll();
        Tablero.panelGestionJuego.removeAll();
        Tablero.panelJuego.removeAll();
        Tablero.panelLetras.removeAll();
        Tablero.panelNumeros.removeAll();
        Tablero.panelTablero.removeAll();
        Tablero.frameTablero.setVisible(false);
        Gui.menuPrincipal();
        Gui.panelPrincipal.setVisible(true);
            
    }
    }
    

